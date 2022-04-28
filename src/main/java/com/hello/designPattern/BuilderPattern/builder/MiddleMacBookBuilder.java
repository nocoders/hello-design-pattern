package com.hello.designPattern.BuilderPattern.builder;

import com.hello.designPattern.BuilderPattern.interfaces.MacBookBuilder;
import com.hello.designPattern.BuilderPattern.model.MacBook;

public class MiddleMacBookBuilder implements MacBookBuilder {
    private MacBook macBook;

    @Override
    public MacBookBuilder buildMemory() {
        macBook.setMemory("安装16G运行内存");
        return this;
    }

    @Override
    public MacBookBuilder buildSlug() {
        macBook.setSlug("安装M1Pro芯片");
        return this;
    }

    @Override
    public MacBookBuilder buildCpu() {
        macBook.setCpu("安装10核中央处理器");
        return this;
    }

    @Override
    public MacBookBuilder buildDisk() {
        macBook.setDisk("安装1TB固态硬盘");
        return this;
    }

    public MacBook build(){
        return macBook;
    }
}
