package com.hello.designPattern.singletonPattern;

import com.hello.designPattern.BuilderPattern.builder.HighMacBookBuilder;
import com.hello.designPattern.BuilderPattern.director.Director;
import com.hello.designPattern.BuilderPattern.model.MacBook;
import org.junit.Test;

public class BuilderPatternTest {

    @Test
    public void builderPatternTest(){
        Director director = new Director(new HighMacBookBuilder());
        MacBook macBook = director.construct();
        System.out.println(macBook.toString());
    }
}
