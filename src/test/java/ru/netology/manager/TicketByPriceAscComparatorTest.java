package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

class TicketByPriceAscComparatorTest {

    private TicketRepository ticketRepository = Mockito.mock(TicketRepository.class);
    private TicketByPriceAscComparator comparator = new TicketByPriceAscComparator(ticketRepository);


    private Ticket ticket1 = new Ticket(1, 1500, "DME", "JFK", 620);
    private Ticket ticket2 = new Ticket(2, 2200, "DME", "JFK", 780);
    private Ticket ticket3 = new Ticket(3, 2500, "DME", "JFK", 450);
    private Ticket ticket4 = new Ticket(4, 2700, "VKO", "LVS", 450);
    private Ticket ticket5 = new Ticket(5, 3400, "JFK", "LVS", 240);

    @Test
    void shouldFindAllTicketsLessTime() {
        Ticket[] returned = {ticket1, ticket3, ticket2, ticket5, ticket4};
        doReturn(returned).when(ticketRepository).findAll();

        Ticket[] expected = {ticket3, ticket1, ticket2};
        Ticket[] actual = comparator.findAll("DME", "JFK", comparator);

        Arrays.sort(actual, comparator);

        assertArrayEquals(expected, actual);

        verify(ticketRepository).findAll();
    }

    @Test
    void shouldFindAllNoTicketsSortTime() {
        Ticket[] returned = {ticket1, ticket3, ticket2, ticket5, ticket4};
        doReturn(returned).when(ticketRepository).findAll();

        Ticket[] expected = {};
        Ticket[] actual = comparator.findAll("DME", "LVS", comparator);

        Arrays.sort(actual, comparator);

        assertArrayEquals(expected, actual);

        verify(ticketRepository).findAll();
    }

}