package model;

/**
 *货物信息类
 */

public class Good {
    private String name;
    private double price;
    private int quantity;
    public Good(){
        name="";
        price=0;
        quantity=0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(final double price){
        this.price=price;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
