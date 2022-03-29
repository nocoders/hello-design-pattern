package com.hello.designPattern.SingletonPattern;

import java.util.Objects;

/**
 * 懒汉式单例：私有构造方法，双重非空校验，创建对象时加锁，volatile关键字禁止指令重排保证创建对象这一步骤的线程安全
 *
 * @author linmeng
 * @version 1.0
 * @date 2022年3月28日 16:42
 */
public class LazySingleton {
    private static volatile LazySingleton lazySingleton;

    private LazySingleton(){}

    public static LazySingleton getInstance(){
        if (Objects.isNull(lazySingleton)) {
            synchronized (LazySingleton.class){
                if (Objects.isNull(lazySingleton)) {
                    lazySingleton = new LazySingleton();
                }
            }
        }

        return lazySingleton;
    }
}
