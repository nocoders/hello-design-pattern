package com.hello.designPattern.SingletonPattern;
/**
 * https://www.cnblogs.com/happy4java/p/11206105.html
 * https://blog.csdn.net/weixin_48358336/article/details/120499442
 * @author linmeng
 * @date 2022年3月28日 17:09
 * @return
 */
public enum EnumSingleton {
    INSTANCE;
    public void doSomething(){
        System.out.println("do something");
    }
}