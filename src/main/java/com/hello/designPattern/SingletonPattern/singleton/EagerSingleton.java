package com.hello.designPattern.SingletonPattern.singleton;

/**
 * 饿汉式单例：static关键字使得变量在类加载时就初始化，final关键字使得变量不可被修改
 * @author linmeng
 * @version 1.0
 * @date 2022年3月28日 16:55
 */
public class EagerSingleton {
    private static final EagerSingleton eagerSingleton = new EagerSingleton();

    private EagerSingleton(){}

    /**
     *
     * 直接返回
     * @author linmeng
     * @date 2021年11月9日 21:44
     * @return com.sword.www.designPattern.singleton.EagerSingleton
     */
    public static EagerSingleton getEagerInstance(){

        return eagerSingleton;
    }
}
