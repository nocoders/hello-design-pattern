package com.hello.designPattern.SingletonPattern;

import java.io.Serializable;

/**
 * 饿汉式单例：static关键字使得变量在类加载时就初始化，final关键字使得变量不可被修改
 * @author linmeng
 * @version 1.0
 * @date 2022年3月28日 16:55
 */
public class EagerSingleton implements Serializable {
    private static final EagerSingleton eagerSingleton;

    static {
        eagerSingleton = new EagerSingleton();
    }

    private EagerSingleton() {
        if (eagerSingleton !=null){
            throw new RuntimeException();
        }
    }

    /**
     *
     * 直接返回
     * @author linmeng
     * @date 2021年11月9日 21:44
     * @return com.sword.www.designPattern.singleton.EagerSingleton
     */
    public static EagerSingleton getInstance(){

        return eagerSingleton;
    }

    /**
     * 防止序列化破坏单例
     * @date 2022年4月1日 11:16
     * @return java.lang.Object
     */
    public Object readResolve(){
        return eagerSingleton;
    }
}
