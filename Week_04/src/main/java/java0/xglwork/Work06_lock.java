package java0.xglwork;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

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
 * 实现逻辑----------但是主线程有可能先wait子线程，在notify，也就是说，如果子线程在主线程wait前，调用了notify，
 * 会导致主线程无限等待，所以这个思路还是有一定漏洞
 */
public class Work06_lock {
    public static void main(String[] args) throws Exception {

        long start=System.currentTimeMillis();

        AtomicInteger result = new AtomicInteger();

        Object lock = new Object();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // 异步执行 下面方法
                result.set(sum()); //这是得到的返回值
                synchronized (lock) {
                    lock.notify();
                }

            }
        });

        thread.start();
        synchronized (lock) {
            lock.wait();
        }

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
        // 然后退出main线程
        Thread.currentThread().interrupt();
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
