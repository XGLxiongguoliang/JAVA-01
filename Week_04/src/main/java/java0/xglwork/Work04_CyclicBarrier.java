package java0.xglwork;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
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
 * 实现逻辑----------通过CyclicBarrier，让主线程等待子线程结束后执行
 */
public class Work04_CyclicBarrier {
    public static void main(String[] args) throws Exception {

        long start=System.currentTimeMillis();

        AtomicInteger result = new AtomicInteger();

        final CyclicBarrier cyclicBarrier = new CyclicBarrier(1, new Runnable() {
            @Override
            public void run() {
                try {
                    // 异步执行 下面方法
                    result.set(sum()); //这是得到的返回值
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        cyclicBarrier.await();

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
