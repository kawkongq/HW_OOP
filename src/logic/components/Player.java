package logic.components;

import exception.BadStatusException;

import java.util.ArrayList;

public class Player {
    private String name ;
    private Status status ;
    private int energy ;
    private int money ;
    private ArrayList<Food> foods ;
    private ArrayList<Potion> potions ;
    private ArrayList<Ore> ores ;

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
        this.energy = Math.max(energy , 0);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = Math.max(money , 0);
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

    public Player(String name, Status status) throws BadStatusException {
        this.setName(name);
        this.setStatus(status);
        this.getStatus().setHp(Math.max(status.getHp() , 1));
        this.setEnergy(10);
        this.setMoney(100);
        this.foods = new ArrayList<Food>() ;
        this.potions = new ArrayList<Potion>() ;
        this.ores = new ArrayList<Ore>() ;
    }

    public Player(String name, Status status, int energy, int money) throws BadStatusException{
        this.setName(name);
        this.setStatus(status);
        this.getStatus().setHp(Math.max(status.getHp() , 1));
        this.setEnergy(energy);
        this.setMoney(money);
        this.foods = new ArrayList<Food>() ;
        this.potions = new ArrayList<Potion>() ;
        this.ores = new ArrayList<Ore>() ;
    }

    public boolean buyOre(Ore ore) {
        if (this.money >= ore.getCost()) {
            this.setMoney(this.getMoney() - ore.getCost());
            this.ores.add(ore) ;
            return true ;
        }
        else {
            return false ;
        }
    }

    public void drinkPotion(int index) throws BadStatusException {
        if(this.potions.size() > index && index >= 0) {
            this.status.addStatus(this.potions.get(index).getIncreasingStatus());
            this.potions.remove(index) ;
        }
    }

    public void eatFood(int index) {
        if(this.foods.size() > index && index >= 0) {
            this.setEnergy(this.energy + this.foods.get(index).getEnergy());
            this.foods.remove(index) ;
        }
    }

    public void sellFood(int index) {
        if (this.foods.size() > index && index >= 0) {
            this.setMoney(this.getMoney() + this.foods.get(index).getPrice());
            this.foods.remove(index) ;
        }
    }

    public void sellPotion(int index) {
        if (this.potions.size() > index && index >= 0) {
            this.setMoney(this.getMoney() + this.potions.get(index).getPrice());
            this.potions.remove(index) ;
        }
    }

    public void attack(Monster monster) throws BadStatusException{
        int dm =  Math.max(this.status.getAttack() - monster.getStatus().getDurability() , 0);
        monster.getStatus().setHp(Math.max(monster.getStatus().getHp() - dm , 0));
    }

    public void magicAttack(Monster monster) throws BadStatusException{
        monster.getStatus().setHp(Math.max(monster.getStatus().getHp() - this.status.getMagic() , 0));
    }
}
