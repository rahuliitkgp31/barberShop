package org.example;

public class Customer extends Thread{
    private String customerName;

    private BarberShop barberShop;

    public Customer(String name) {
        this.customerName = name;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BarberShop getBarberShop() {
        return barberShop;
    }

    public void setBarberShop(BarberShop barberShop) {
        this.barberShop = barberShop;
    }

    public void cutHair() {
        System.out.println("cutting hair of customer "+ customerName);
    }

    @Override
    public void run() {
        try {
            if(barberShop.addCustomerToQueue(this)) {
                synchronized (this) {
                    wait();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
