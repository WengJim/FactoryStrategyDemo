package com.example.demo.factory;

import com.example.demo.strategy.Strategy;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 工厂策略模式
 */
@Service
@Log4j2
public class FactoryForStrategy {


    @Autowired
    Map<String, Strategy> strategys = new ConcurrentHashMap<>(3);

    public Strategy getStrategy(String version) throws Exception {
        Strategy strategy = strategys.get(version);

        if (strategy == null) {
            strategy = strategyGet(version);
            if (strategy != null) {
                return strategy;
            }
            throw new RuntimeException("no strategy defined");
        }
        return strategy;
    }

    public Strategy strategyGet(String version) {
        List<Map.Entry<String, Strategy>> list = new ArrayList(strategys.entrySet());
        Comparator<Map.Entry<String, Strategy>> ageComparator = Comparator.comparing(Map.Entry::getKey);
        list.sort(ageComparator.reversed());

        for (Map.Entry<String, Strategy> strategyEntry :
                list) {
            //比当前版本高 则跳过
            if (version.compareTo(strategyEntry.getKey()) > 0) {
                log.info(strategyEntry.getKey());
                System.out.println();
                if (strategys.get(strategyEntry.getKey()) == null) {
                    return strategyGet(strategyEntry.getKey());
                }
                return strategys.get(strategyEntry.getKey());
            }

        }
        return null;
    }
}
