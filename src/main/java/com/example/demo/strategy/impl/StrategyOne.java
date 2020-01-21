package com.example.demo.strategy.impl;

import com.example.demo.strategy.Strategy;
import org.springframework.stereotype.Component;

/**
 * 实现
 */
@Component("8.0.0")
public class StrategyOne implements Strategy {
    @Override
    public String doOperation() {
        return "8.0.0";
    }
}