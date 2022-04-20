package com.hello.designPattern.BuilderPattern.builder;

import com.hello.designPattern.BuilderPattern.interfaces.MacBookBuilder;
import com.hello.designPattern.BuilderPattern.model.MacBook;

public class LowMacBookBuilder implements MacBookBuilder {

    private MacBook macBook;

    @Override
    public MacBook buildMemory() {
        macBook.setMemory("安装16G运行内存");
        return macBook;
    }

    @Override
    public MacBook buildSlug() {
        macBook.setSlug("安装M1Pro芯片");
        return macBook;
    }

    @Override
    public MacBook buildCpu() {
        macBook.setCpu("安装10核中央处理器");
        return macBook;
    }

    @Override
    public MacBook buildDisk() {
        macBook.setDisk("安装512G固态硬盘");
        return macBook;
    }

    public LowMacBookBuilder(MacBook macBook) {
        this.macBook = macBook;
    }
}
