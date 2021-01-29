package io.github.kimmking.gateway.router;

import java.util.List;

public interface HttpEndpointRouter {

    /**
     * 随机路由
     * @param endpoints
     * @return
     */
    String routeRandom(List<String> endpoints);

    /**
     * 负载路由
     */
    String routeLoad(List<String> endpoints);

    /**
     * 轮训路由
     * @param endpoints
     * @return
     */
    String roundRibbon(List<String> endpoints);

    /**
     * 权重路由
     * @param endpoints
     * @return
     */
    String roundWeight(List<String> endpoints);
}
