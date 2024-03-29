package org.javaacademy.taxi;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
@Getter
@ToString
@Slf4j
public class CarProperties {

    @Value("#{${route}}")
    private Map<String, Integer> distances = new HashMap<>();

    public Integer getLength(String address) {
        if (distances.containsKey(address)) {
            Integer length = distances.get(address);
            return length;
        }

        log.error("Такой улицы нету");
        return 0;
    }
}
