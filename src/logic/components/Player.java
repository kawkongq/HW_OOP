package logic.components;

import java.util.ArrayList;

public class Player {
    private String name ;
    private Status status ;
    private int energy ;
    private int money ;
    private ArrayList<Food> foods ;
    private ArrayList<Potion> potions ;
    private ArrayList<Ore> ores ;

    public Player(String name, Status status) {
        this.name = name;
        this.status = status;
    }

    public Player(String name, Status status, int energy, int money) {
        this.name = name;
        this.status = status;
        this.energy = energy;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public ArrayList<Potion> getPotions() {
        return potions;
    }

    public void setPotions(ArrayList<Potion> potions) {
        this.potions = potions;
    }

    public ArrayList<Ore> getOres() {
        return ores;
    }

    public void setOres(ArrayList<Ore> ores) {
        this.ores = ores;
    }
}
