package logic.components;

import java.util.Objects;

public class Ore {
    private String name;
    private int cost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = Math.max(cost,1);
    }

    public Ore(String name, int cost) {
        this.setName(name);
        this.setCost(cost);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ore ore = (Ore) o;
        return cost == ore.cost && Objects.equals(name, ore.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cost);
    }
}
