package ru.netology.avia.service;

import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
        int t1 = o1.getTimeTo() - o1.getTimeFrom();
        int t2 = o2.getTimeTo() - o2.getTimeFrom();

        if (t1 < t2) {
            return -1;
        }
        if (t1 > t2) {
            return 1;
        } else {
            return 0;
        }
    }
}
