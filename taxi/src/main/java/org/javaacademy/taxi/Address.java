package org.javaacademy.taxi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Getter
public enum Address {
    BIRCH_GROVE("Березовая роща"),
    CANDICLE("Кандикюля"),
    BUILDER("Строитель"),
    LOMONOSOV("Ломоносов");
    private String address;
}
