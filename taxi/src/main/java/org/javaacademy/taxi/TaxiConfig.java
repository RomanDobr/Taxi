package org.javaacademy.taxi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Configuration
public class TaxiConfig {

    @Scope("prototype")
    public CarTaxi car() {
        return new CarTaxi();
    }

    @Bean
    @Profile("luna")
    public Taxi lunataxi() {
        return new Taxi(List.of(new CarTaxi(), new CarTaxi(), new CarTaxi()));
    }

    @Bean
    @Profile("bluz")
    public Taxi bluztaxi() {
        return new Taxi(List.of(new CarTaxi(), new CarTaxi()));
    }


}
