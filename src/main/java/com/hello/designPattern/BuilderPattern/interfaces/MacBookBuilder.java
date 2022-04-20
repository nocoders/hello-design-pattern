package com.hello.designPattern.BuilderPattern.interfaces;

import com.hello.designPattern.BuilderPattern.model.MacBook;

public interface MacBookBuilder {
     MacBook buildMemory();
     MacBook buildSlug();
     MacBook buildCpu();
     MacBook buildDisk();
}
