package com.example.task1;

public abstract class Handler {
    public int money;
    private Handler next;

    public Handler(int money){
        this.money = money;
    }

    public void setNext(Handler next){
        this.next = next;
    }

    public void process(int amount) throws IllegalArgumentException{
        if (next != null){
            next.process(amount%money);
        } else if (amount%money>0){
            throw new IllegalArgumentException();
        }
        System.out.println(money + " * " + amount/money);
    }
}
