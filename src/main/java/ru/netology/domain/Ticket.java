package ru.netology.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Ticket implements Comparable<Ticket>{

    public Ticket(int id, int price, String depAir, String arrAir, int flightTimeMin) {
        this.id = id;
        this.price = price;
        this.depAir = depAir;
        this.arrAir = arrAir;
        this.flightTimeMin = flightTimeMin;
    }

    private int id;
    private int price;
    private String depAir;
    private String arrAir;
    private int flightTimeMin;

    @Override
    public int compareTo(Ticket t) {
        return this.price - t.price;
    }
}
