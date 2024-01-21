package logic.components;

import java.util.Objects;

public class Potion {
    private String name ;
    private int price ;
    private Status  increasingStatus ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = Math.max(price , 1);
    }

    public Status getIncreasingStatus() {
        return increasingStatus;
    }

    public void setIncreasingStatus(Status increasingStatus) {
        this.increasingStatus = increasingStatus;
    }

    public Potion(String name, int price, Status increasingStatus) {
        this.setName(name);
        this.setPrice(price);
        this.setIncreasingStatus(increasingStatus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Potion potion = (Potion) o;
        return price == potion.price && Objects.equals(name, potion.name) && Objects.equals(increasingStatus, potion.increasingStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, increasingStatus);
    }
}
