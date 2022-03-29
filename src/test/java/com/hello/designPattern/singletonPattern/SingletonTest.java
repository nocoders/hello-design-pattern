package com.hello.designPattern.singletonPattern;

import com.hello.designPattern.SingletonPattern.EagerSingleton;
import com.hello.designPattern.SingletonPattern.EnumSingleton;
import com.hello.designPattern.SingletonPattern.LazySingleton;
import com.hello.designPattern.SingletonPattern.StaticNestSingleton;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 单例模式破坏：
 *
 * @author linmeng
 * @version 1.0
 * @date 2022年3月28日 16:51
 */
public class SingletonTest {

    /**
     * 并发单例破坏
     *
     * @author linmeng
     * @date 2022年3月29日 09:58
     * @return void
     */
    @Test
    public void concurrentDestroy() throws InterruptedException, ExecutionException {
        // 定长线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        // 使得多个线程同一时刻启动
        CountDownLatch countDownLatch = new CountDownLatch(5);
        // 1:饿汉式
        System.out.println("饿汉式地址打印");
        List<Future<EagerSingleton>> eagerSingletonFutureList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Future<EagerSingleton> future = executorService.submit(() -> {
                countDownLatch.countDown();
                return EagerSingleton.getInstance();
            });
            eagerSingletonFutureList.add(future);
        }
        countDownLatch.await();
        // 对象地址打印
        print(eagerSingletonFutureList);
        // 2:懒汉式
        System.out.println("懒汉式地址打印");
        List<Future<LazySingleton>> lazySingletonFutureList = new ArrayList<>();
        CountDownLatch countDownLatch1 = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            Future<LazySingleton> future = executorService.submit(() -> {
                countDownLatch1.countDown();
                return LazySingleton.getInstance();
            });
            lazySingletonFutureList.add(future);
        }
        countDownLatch1.await();
        // 对象地址打印
        print(lazySingletonFutureList);
        // 3:内部类
        System.out.println("内部类地址打印");
        List<Future<StaticNestSingleton>> staticNestSingletonFutureList = new ArrayList<>();
        CountDownLatch countDownLatch2 = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            Future<StaticNestSingleton> future = executorService.submit(() -> {
                countDownLatch2.countDown();
                return StaticNestSingleton.getInstance();
            });
            staticNestSingletonFutureList.add(future);
        }
        countDownLatch2.await();
        // 对象地址打印
        print(staticNestSingletonFutureList);
        // 4:枚举
        System.out.println("枚举相等判断");
        List<Future<EnumSingleton>> enumSingletonFutureList = new ArrayList<>();
        CountDownLatch countDownLatch3 = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            Future<EnumSingleton> future = executorService.submit(() -> {
                countDownLatch3.countDown();
                return EnumSingleton.INSTANCE;
            });
            enumSingletonFutureList.add(future);
        }
        countDownLatch3.await();
        // 对象地址判断
        System.out.println((enumSingletonFutureList.get(0).get()==enumSingletonFutureList.get(1).get())&&
                (enumSingletonFutureList.get(0).get()==enumSingletonFutureList.get(1).get()) &&
                (enumSingletonFutureList.get(1).get()==enumSingletonFutureList.get(2).get()) &&
                (enumSingletonFutureList.get(2).get()==enumSingletonFutureList.get(3).get()) &&
                (enumSingletonFutureList.get(3).get()==enumSingletonFutureList.get(4).get()));
    }

    <T> void print(@org.jetbrains.annotations.NotNull List<Future<T>> list){
        list.forEach(s ->{
            try {
                System.out.println(s.get().toString());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }
}
