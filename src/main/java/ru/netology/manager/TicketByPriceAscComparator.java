package ru.netology.manager;

import ru.netology.domain.Ticket;

import java.util.Comparator;

public class TicketByPriceAscComparator implements Comparator<Ticket> {


    @Override
    public int compare(Ticket o1, Ticket o2) {
        return o1.getFlightTimeMin() - o2.getFlightTimeMin();
    }
}
