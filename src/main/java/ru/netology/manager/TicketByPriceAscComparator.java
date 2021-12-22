package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Comparator;

public class TicketByPriceAscComparator implements Comparator<Ticket> {

    private TicketRepository ticketRepository;

    public TicketByPriceAscComparator(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket[] findAll(String depAir, String arrAir, Comparator<Ticket> comparator) {
        Ticket[] tickets = ticketRepository.findAll();
        Ticket[] result = new Ticket[tickets.length];
        int index = 0;
        for (Ticket ticket : tickets) {
            if (depAir.equals(ticket.getDepAir()) && arrAir.equals(ticket.getArrAir())) {
                result[index] = ticket;
                index++;
            }
        }
        Ticket[] tmp = new Ticket[index];
        System.arraycopy(result, 0, tmp, 0, tmp.length);
        return tmp;
    }

    @Override
    public int compare(Ticket o1, Ticket o2) {
        return o1.getFlightTimeMin() - o2.getFlightTimeMin();
    }
}
