package logic.components;

import exception.BadStatusException;

public class Monster {
    private String name ;
    private Status status ;
    private Food food ;
    private Potion potion ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) throws BadStatusException{
        this.status = status ;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Potion getPotion() {
        return potion;
    }

    public void setPotion(Potion potion) {
        this.potion = potion;
    }

    public Monster(String name, Status status) throws BadStatusException{
        this.setName(name);
        this.setStatus(status);
        this.status.setHp(Math.max(status.getHp() , 1));
    }

    public void attack(Player player) throws BadStatusException {
        int dm =  Math.max(this.status.getAttack() - player.getStatus().getDurability() , 0);
        player.getStatus().setHp(Math.max(player.getStatus().getHp() - dm , 0));
    }

    public void magicAttack(Player player) throws BadStatusException {
        player.getStatus().setHp(Math.max(player.getStatus().getHp() - this.status.getMagic() , 0));
    }
}
