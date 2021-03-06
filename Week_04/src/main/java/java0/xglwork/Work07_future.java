package java0.xglwork;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program java0.xglwork
 * @description 作业
 * @auther Mr.Xiong
 * @create 2021-02-01 09:25
 *
 * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 * 写出你的方法，越多越好，提交到github。
 *
 * 实现逻辑----------Future 通过线程池创建线程，线程池提交线程返回Future。future.get()会同步等待结果，最后shutdown()退出主线程
 */
public class Work07_future {
    public static void main(String[] args) throws Exception {

        long start=System.currentTimeMillis();

        AtomicInteger result = new AtomicInteger();

        ExecutorService es = Executors.newFixedThreadPool(1);

        Thread thread = new Thread(() -> {
                // 异步执行 下面方法
                result.set(sum()); //这是得到的返回值
        });

        Future future = es.submit(thread);

        future.get();

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
        es.shutdown();
    }

    private static int sum() {
        return fibo(1);
    }

    private static int fibo(int a) {
        System.out.println("传入参数a------" + a);
        if ( a < 2) {
            return 1;
        }
        return fibo(a-1) + fibo(a-2);
    }

}
