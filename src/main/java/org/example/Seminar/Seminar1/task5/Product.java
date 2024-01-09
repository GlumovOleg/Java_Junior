package org.example.Seminar.Seminar1.task5;

public class Product {

    private final String name;
    private double cost;
    private String category;

    public Product(String name, double cost, String category) {
        this.name = name;
        this.cost = cost;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public String getCategory() {
        return category;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return String.format("[%s] (coast = %s category = %s)", name, cost, category);
    }

}
