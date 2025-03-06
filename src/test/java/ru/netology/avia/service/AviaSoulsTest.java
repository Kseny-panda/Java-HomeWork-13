package ru.netology.avia.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class AviaSoulsTest {

    AviaSouls manager = new AviaSouls();

    Ticket ticket1 = new Ticket("Moscow", "Kaliningrad", 12_645, 10, 12);
    Ticket ticket2 = new Ticket("Moscow", "Kazan", 4_759, 19, 21);
    Ticket ticket3 = new Ticket("Moscow", "Murmansk", 8_430, 11, 14);
    Ticket ticket4 = new Ticket("Moscow", "Ufa", 4_759, 16, 20);
    Ticket ticket5 = new Ticket("Moscow", "Ufa", 4_314, 7, 12);
    Ticket ticket6 = new Ticket("Kazan", "Moscow", 4_900, 22, 24);

    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
    }

    // Пустой репозиторий
    @Test
    public void shouldEmptyRepository() {
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, manager.findAll());
    }

    // Добавление билета
    @Test
    public void shouldAddedTicket() {
        manager.add(ticket1);
        Ticket[] expected = {ticket1};
        Assertions.assertArrayEquals(expected, manager.findAll());
    }

    // Сравнение билетов через CompareTo
    @Test
    public void shouldCompareToObject() {
        Assertions.assertEquals(1, ticket1.compareTo(ticket2)); // первый больше второго
        Assertions.assertEquals(-1, ticket2.compareTo(ticket3));// первый меньше второго
        Assertions.assertEquals(0, ticket4.compareTo(ticket2)); // билеты равны
    }

    // Вывод массива в порядке увеличения стоимости билета
    @Test
    public void shouldSortTicketPrice() {
        Ticket[] tickets = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        Arrays.sort(tickets);

        Ticket[] expected = {ticket5, ticket2, ticket4, ticket6, ticket3, ticket1};
        Assertions.assertArrayEquals(expected, tickets);
    }

    // Вывод поиска одного билета через search
    @Test
    public void shouldSearchOneTicket(){
        setup();

        Ticket[] expected = {ticket3};
        Assertions.assertArrayEquals(expected, manager.search("Moscow", "Murmansk"));
    }

    // Вывод поиска нескольких билетов по маршруту по умолчанию в порядке увеличения стоимости билетов через search
    @Test
    public void shouldSearchAndSortOfDefault() {
        setup();

        Ticket[] expected = {ticket5, ticket4};
        Assertions.assertArrayEquals(expected, manager.search("Moscow", "Ufa"));
    }

    //Вывод отсутствия совпадений
    @Test
    public void shouldSearchNotFound(){
        setup();

        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, manager.search("Kazan", "Ufa"));
    }

    // Сравнение билетов через Compare
    @Test
    public void shouldCompareObject() {
        Assertions.assertEquals(-1, manager.compare(ticket3, ticket5)); // время в пути у первого билета меньше, чем у второго
        Assertions.assertEquals(1, manager.compare(ticket4, ticket3));  // время в пути у первого билета больше, чем у второго
        Assertions.assertEquals(0, manager.compare(ticket1, ticket2));  // время в пути одинаковое
    }

    // Вывод поиска одного билета с сортировкой
    @Test
    public void shouldSearchAndSortByOneTicket(){
        setup();
        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket1};
        Assertions.assertArrayEquals(expected, manager.searchAndSortBy("Moscow", "Kaliningrad", comparator));
    }

    // Вывод поиска и сортировки нескольких билетов
    @Test
    public void souldSearchAndSortBy() {
        setup();
        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket4, ticket5};
        Assertions.assertArrayEquals(expected, manager.searchAndSortBy("Moscow", "Ufa", comparator));
    }

    // Вывод отсутствия совпадений при поиске с сортировкой
    @Test
    public void souldSearchAndSortNotFound() {
        setup();
        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, manager.searchAndSortBy("Kazan", "Ufa", comparator));
    }
}