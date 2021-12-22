package ru.netology.manager;

import lombok.Data;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

@Data
public class TicketManager {

    private TicketRepository ticketRepository;

    public TicketManager(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }


    public void addFilm(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    public Ticket[] findAll(String depAir, String arrAir) {
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

    public Ticket findById(int id) {
        return ticketRepository.findById(id);
    }

    public void removeById(int id) {
        ticketRepository.removeById(id);
    }

}
