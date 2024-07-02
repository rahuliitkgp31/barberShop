package org.example;

import java.util.LinkedList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Customer customer1 = new Customer("raghav");
        Customer customer2 = new Customer("rahul");
        Barber barber = new Barber();
        BarberShop barberShop = new BarberShop();

        barberShop.setMaxQueueSize(5);
        barberShop.setBarber(barber);
        barberShop.setCustomerQueue(new LinkedList<>());

        barber.setBarberShop(barberShop);

        customer2.setBarberShop(barberShop);
        customer1.setBarberShop(barberShop);

        barber.start();
        customer1.start();
        customer2.start();
    }
}