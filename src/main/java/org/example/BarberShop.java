package org.example;

import java.util.Queue;

public class BarberShop {
    private Barber barber;
    private Queue<Customer> customerQueue;
    int maxQueueSize;

    public Barber getBarber() {
        return barber;
    }

    public void setBarber(Barber barber) {
        this.barber = barber;
    }

    public Queue<Customer> getCustomerQueue() {
        return customerQueue;
    }

    public void setCustomerQueue(Queue<Customer> customerQueue) {
        this.customerQueue = customerQueue;
    }

    public int getMaxQueueSize() {
        return maxQueueSize;
    }

    public void setMaxQueueSize(int maxQueueSize) {
        this.maxQueueSize = maxQueueSize;
    }

    public boolean addCustomerToQueue(Customer customer) throws InterruptedException {
        synchronized (this) {
            if(customerQueue.size()!=maxQueueSize) {
                customerQueue.add(customer);
                notify();
                return true;
            } else{
                return false;
            }
        }
    }

    public Customer getNextCustomer() throws InterruptedException {
        synchronized (this) {
            while(customerQueue.isEmpty()){
                wait();
            }
            return customerQueue.poll();
        }
    }

}
