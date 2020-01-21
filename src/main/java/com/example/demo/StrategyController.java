package com.example.demo;

import com.example.demo.factory.FactoryForStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jimw
 * demo
 */
@RestController
public class StrategyController {

    @Autowired
    FactoryForStrategy factoryForStrategy;

    @PostMapping("/strategy")
    @ResponseBody
    public String strategy(@RequestParam("key") String key) {
        String result;
        try {
            result = factoryForStrategy.getStrategy(key).doOperation();
        } catch (Exception e) {
            result = e.getMessage();
        }
        return result;
    }
}
