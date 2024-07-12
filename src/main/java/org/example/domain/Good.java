package org.example.domain;

public class Good extends EntityBase<Integer> {
    private String name;
    private int price;

    public Good(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Good(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
