package io.github.kimmking.gateway.router;

import java.util.*;

public class RandomHttpEndpointRouter implements HttpEndpointRouter {
    private int roundRibbonIndex = 0;
    private static Integer pos = 0;

    @Override
    public String routeRandom(List<String> urls) {
        int size = urls.size();
        Random random = new Random(System.currentTimeMillis());
        return urls.get(random.nextInt(size));
    }

    @Override
    public String roundRibbon(List<String> urls) {
        roundRibbonIndex = roundRibbonIndex + 1;
        int Index = (roundRibbonIndex + 1) % urls.size();
        System.out.println("本次调用次数是-----------------" + roundRibbonIndex + "本次索引是-----------------" + Index);
        return urls.get(Index);
    }

    @Override
    public String routeLoad(List<String> urls) {
        return null;
    }

    @Override
    public String roundWeight(List<String> urls) {
        Map<String, Integer> urlMap = new HashMap<>();
        urls.forEach(n -> {
            urlMap.put(n, urls.indexOf(n) + 1);
        });

        // 重建一个Map，避免服务器的上下线导致的并发问题
        Map<String, Integer> serverMap = new HashMap<>();
        serverMap.putAll(urlMap);

        // 取得Ip地址List
        Set<String> keySet = serverMap.keySet();
        Iterator<String> iterator = keySet.iterator();

        List<String> serverList = new ArrayList<>();
        while (iterator.hasNext())
        {
            String server = iterator.next();
            int weight = serverMap.get(server);
            for (int i = 0; i < weight; i++) {
                serverList.add(server);
            }
        }

        String server;
        synchronized (pos)
        {
            if (pos > keySet.size()) {
                pos = 0;
            }
            server = serverList.get(pos);
            pos ++;
        }

        return server;
    }


}
