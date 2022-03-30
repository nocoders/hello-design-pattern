package com.hello.designPattern.SingletonPattern;

import java.io.Serializable;

/**
 * 静态内部类单例：外部类加载时不会加载内部类，只有在使用到内部类的时候虚拟机才会加载内部类
 *      保证了线程安全，单例的唯一性，延迟了类的实例化
 *      https://blog.csdn.net/mnb65482/article/details/80458571
 *      https://juejin.cn/post/6871497501732519949
 * @author linmeng
 * @version 1.0
 * @date 2022年3月28日 17:00
 */
public class StaticNestSingleton  implements Serializable {

    private StaticNestSingleton(){}

    private static class SingletonHolder{
        private static final StaticNestSingleton SINGLETON = new StaticNestSingleton();
    }
    /**
     *
     * 直接返回
     * @author linmeng
     * @date 2021年11月9日 21:44
     * @return com.sword.www.designPattern.singleton.EagerSingleton
     */
    public static StaticNestSingleton getInstance(){

        return SingletonHolder.SINGLETON;
    }
}
