package org.example;

public class Barber extends Thread{

    BarberShop barberShop;

    public BarberShop getBarberShop() {
        return barberShop;
    }

    public void setBarberShop(BarberShop barberShop) {
        this.barberShop = barberShop;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Customer customer = barberShop.getNextCustomer();
                customer.cutHair();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
