package org.javaacademy.taxi;

import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Getter
public class Taxi {
    @Value("${taxi.name}")
    private String name;
    private BigDecimal totalSum = BigDecimal.ZERO;

    private CarProperties carProperties;

    private List<CarTaxi> taxiList = new ArrayList<>();
    private int currentCar = 0;
    private boolean isNight;

    public Taxi(List<CarTaxi> taxiList) {
        this.taxiList = taxiList;
    }

    @PreDestroy
    private void preDestroy() {
        report();
        System.out.println("Таксопарк закрыт");
    }

    public void takeOrder(Client client, boolean isNight) {
        System.out.printf("Клиент заказал машину по адресу: %s\n", client.getAddress());
            totalSum = totalSum.add(taxiList.get(0).takeOrder(client, isNight));
            System.out.println("Мы приехали.");
            currentCar++;
            if (currentCar >= taxiList.size()) {
                currentCar = 0;
            }
    }

    private void report() {
        System.out.printf("""
                Итог.
                Таксопарк: %s.
                Заработано: %s
                """, name, totalSum);
        taxiList.forEach(car -> System.out.printf("Водитель машины %s заработал: %s\n",
                car.getNumber(), car.getResultMoneyDriver()));
    }
}
