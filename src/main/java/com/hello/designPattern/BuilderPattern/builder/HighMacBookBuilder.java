package com.hello.designPattern.BuilderPattern.builder;

import com.hello.designPattern.BuilderPattern.interfaces.MacBookBuilder;
import com.hello.designPattern.BuilderPattern.model.MacBook;

public class HighMacBookBuilder implements MacBookBuilder {

    private MacBook macBook;

    @Override
    public MacBookBuilder buildMemory() {
        macBook.setMemory("安装32G运行内存");
        return this;
    }

    @Override
    public MacBookBuilder buildSlug() {
        macBook.setSlug("安装M1X芯片");
        return this;
    }

    @Override
    public MacBookBuilder buildCpu() {
        macBook.setCpu("安装10核中央处理器");
        return this;
    }

    @Override
    public MacBookBuilder buildDisk() {
        macBook.setDisk("1TB");
        return this;
    }

    public HighMacBookBuilder(MacBook macBook) {
        this.macBook = macBook;
    }
}
