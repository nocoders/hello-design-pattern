package com.hello.designPattern.BuilderPattern.director;

import com.hello.designPattern.BuilderPattern.interfaces.MacBookBuilder;
import com.hello.designPattern.BuilderPattern.model.MacBook;

public class Director {
    private MacBookBuilder macBookBuilder;

    public Director(MacBookBuilder macBookBuilder) {
        this.macBookBuilder = macBookBuilder;
    }

    public MacBook construct(){
        return macBookBuilder.buildMemory().buildDisk().buildCpu().buildSlug().build();
    }
}
