package com.kelton;

public class Player extends Character {

    private int gold;

    public Player(String name, int hp, int attack, int defense) {
        super(name, hp, attack, defense);
        this.gold = 0;
    }

    public int getGold() {
        return gold;
    }

    public void rest() {
        this.hp = 100;
    }
}
