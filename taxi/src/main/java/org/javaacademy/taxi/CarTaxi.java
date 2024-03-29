package org.javaacademy.taxi;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Random;
@Slf4j
@Getter
public class CarTaxi {
    @Setter
    private String number;
    private BigDecimal resultMoneyDriver = BigDecimal.ZERO;
    @Value("${taxi.rate.daily}")
    private int dailyRate;
    @Value("${taxi.rate.night}")
    private int nightRate;
    @Autowired
    private CarProperties carProperties;
    @Autowired
    private Client client;


    @PostConstruct
   private void init() {
       number = String.format("A%sBB16", (int) (Math.random() * 100));
   }

    public BigDecimal takeOrder (Client client, boolean isNight) {
        double resultMoney = 0;
        int length = carProperties.getLength(client.getAddress().getAddress());
        if (isNight) {
            resultMoney += length * this.nightRate * 0.5;
        } else {
            resultMoney += length * this.dailyRate * 0.5;
        }
        resultMoneyDriver.add(BigDecimal.valueOf(resultMoney));
        return BigDecimal.valueOf(resultMoney);
    }
}
