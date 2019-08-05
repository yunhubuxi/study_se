package spi.impl;

import spi.Robot;

public class OptimusPrime implements Robot {
    @Override
    public void sayHello() {
        System.out.println("Hello, I am OptimusPrime.");
    }
}
