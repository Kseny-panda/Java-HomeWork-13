package ru.netology.avia.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    Ticket ticket1 = new Ticket("Moscow", "Kaliningrad", 12_645, 10, 12);
    Ticket ticket2 = new Ticket("Moscow", "Kazan", 4_759, 19, 21);
    Ticket ticket3 = new Ticket("Moscow", "Murmansk", 8_430, 11, 14);
    Ticket ticket4 = new Ticket("Moscow", "Ufa", 4_759, 16, 20);
    Ticket ticket5;
    int ticketPrice;

    // Вывод пункта вылета
    @Test
    public void shouldShowDeparturePoint() {
        Assertions.assertEquals("Moscow", ticket1.getFrom());
    }

    // Вывод пункта прилета
    @Test
    public void shouldPointArrivalSpecified() {
        Assertions.assertEquals("Kazan", ticket2.getTo());
    }

    // Вывод времени вылета
    @Test
    public void shouldSpecifiedTimeDeparture() {
        Assertions.assertEquals(11, ticket3.getTimeFrom());
    }

    // Вывод времени прилета
    @Test
    public void shouldSpecifiedTimeArrival() {
        Assertions.assertEquals(14, ticket3.getTimeTo());
    }

    // Вывод стоимости билета
    @Test
    public void TicketPrice() {
        Assertions.assertEquals(4_759, ticket4.getPrice());
    }

    @Test
    public void shouldEquals() {
        Assertions.assertEquals(true, ticket1.equals(ticket1)); // один объект
        Assertions.assertEquals(false, ticket1.equals(ticket2)); // разные объекты
        Assertions.assertEquals(false, ticket1.equals(ticket5)); // разные объекты, один из которых пуст
        Assertions.assertEquals(false, ticket1.equals(ticketPrice)); // разные виды объектов
        //System.out.println(ticket1.equals(ticket1));// разные виды объектов
    }

    @Test
    public void shouldHashCode() {
        int expected = ticket1.hashCode();
        Assertions.assertEquals(expected, ticket1.hashCode());
        //System.out.println(ticket1.hashCode());
    }
}