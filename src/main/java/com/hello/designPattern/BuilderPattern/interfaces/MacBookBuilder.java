package com.hello.designPattern.BuilderPattern.interfaces;

import com.hello.designPattern.BuilderPattern.model.MacBook;

public interface MacBookBuilder {

     MacBookBuilder buildMemory();
     MacBookBuilder buildSlug();
     MacBookBuilder buildCpu();
     MacBookBuilder buildDisk();


      MacBook build();
}
