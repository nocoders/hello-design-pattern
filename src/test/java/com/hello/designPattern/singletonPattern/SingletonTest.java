package com.hello.designPattern.singletonPattern;

import com.hello.designPattern.SingletonPattern.EagerSingleton;
import com.hello.designPattern.SingletonPattern.EnumSingleton;
import com.hello.designPattern.SingletonPattern.LazySingleton;
import com.hello.designPattern.SingletonPattern.StaticNestSingleton;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
     * 并发单例破坏：创建定长线程池，使用countDownLatch使得多个线程同时执行，
     * 判断获取实例是否是同一个
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

    /**
     * 反射单例破坏
     * https://blog.csdn.net/liuyingming910/article/details/42457265
     * @author linmeng
     * @date 2022年3月29日 11:13
     * @return void
     */
    @Test
    public void reflectDestroy() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println("饿汉式单例反射测试");
        EagerSingleton eagerSingleton1 = EagerSingleton.getInstance();
        Constructor<EagerSingleton> declaredConstructor = EagerSingleton.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        EagerSingleton eagerSingleton = declaredConstructor.newInstance();
        System.out.println(eagerSingleton);
        System.out.println(eagerSingleton1);
        System.out.println(eagerSingleton == eagerSingleton1);
        System.out.println("懒汉式单例反射测试");
        LazySingleton lazySingleton1 = LazySingleton.getInstance();
        Constructor<LazySingleton> lazySingletonConstructor = LazySingleton.class.getDeclaredConstructor();
        lazySingletonConstructor.setAccessible(true);
        LazySingleton lazySingleton = lazySingletonConstructor.newInstance();
        System.out.println(lazySingleton1);
        System.out.println(lazySingleton);
        System.out.println(lazySingleton1 == lazySingleton);
        System.out.println("内部类单例测试");
        Class<StaticNestSingleton> staticNestSingletonClass = StaticNestSingleton.class;
        Constructor<StaticNestSingleton> staticNestSingletonConstructor = staticNestSingletonClass.getDeclaredConstructor();
        staticNestSingletonConstructor.setAccessible(true);
        StaticNestSingleton staticNestSingleton = staticNestSingletonConstructor.newInstance();
        StaticNestSingleton staticNestSingleton1 = StaticNestSingleton.getInstance();
        System.out.println(staticNestSingleton);
        System.out.println(staticNestSingleton1);
        System.out.println(staticNestSingleton1 == staticNestSingleton);

        System.out.println("枚举单例测试");
        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        Constructor<EnumSingleton> enumSingletonConstructor = EnumSingleton.class.getDeclaredConstructor();
        enumSingletonConstructor.setAccessible(true);
        EnumSingleton enumSingleton1 = enumSingletonConstructor.newInstance();
        System.out.println(enumSingleton == enumSingleton1);
    }

    /**
     *
     * 序列化破坏单例
     * @author linmeng
     * @date 2022年3月30日 15:07
     * @return void
     */
    @Test
    public void serializeDestroy(){
        System.out.println("饿汉式模式");
        EagerSingleton eagerSingleton = EagerSingleton.getInstance();
        EagerSingleton deserializeEagerSingleton = serializeAndDeserialize(eagerSingleton);
        System.out.println(eagerSingleton);
        System.out.println(deserializeEagerSingleton);
        System.out.println("懒汉式模式");
        LazySingleton lazySingleton = LazySingleton.getInstance();
        LazySingleton deserializeLazySingleton = serializeAndDeserialize(lazySingleton);
        System.out.println(lazySingleton);
        System.out.println(deserializeLazySingleton);
        System.out.println("内部类模式");
        StaticNestSingleton staticNestSingleton = StaticNestSingleton.getInstance();
        StaticNestSingleton serializeAndDeserializeStaticNestSingleton = serializeAndDeserialize(staticNestSingleton);
        System.out.println(staticNestSingleton);
        System.out.println(serializeAndDeserializeStaticNestSingleton);
        System.out.println("枚举式单例");
        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        EnumSingleton serializeAndDeserializeEnumSingleton = serializeAndDeserialize(enumSingleton);
        System.out.println(enumSingleton == serializeAndDeserializeEnumSingleton);
    }

    private <T extends Serializable> T serializeAndDeserialize(T singleton) {
        byte[] eagerSingletonSerializeBytes = SerializationUtils.serialize(singleton);
        return SerializationUtils.deserialize(eagerSingletonSerializeBytes);
    }

    /**
     * 打印对象
     * @param list
     * @param <T>
     */
    <T> void print(List<Future<T>> list){
        list.forEach(s ->{
            try {
                System.out.println(s.get().toString());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }
}
