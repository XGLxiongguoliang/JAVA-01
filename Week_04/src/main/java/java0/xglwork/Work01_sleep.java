package java0.xglwork;

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
 * 实现逻辑----------通过将主线程睡眠一秒，来等待子线程结束，然后继续主线程
 */
public class Work01_sleep {
    public static void main(String[] args) {

        long start=System.currentTimeMillis();
        AtomicInteger result = new AtomicInteger();

        //创建一个线程或线程池，
        new Thread(() -> {
            // 异步执行 下面方法
            result.set(sum()); //这是得到的返回值
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
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
        System.out.println("a----" + a);
        if ( a < 2) {
            return 1;
        }
        return fibo(a-1) + fibo(a-2);
    }

}
