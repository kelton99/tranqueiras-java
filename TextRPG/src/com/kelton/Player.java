package com.kelton;


public class Player extends Character {
    String name;
    Location location;
    int xpToUp;
    int currentXp;

    int gold;


    public Player(String name, int level, int strength, int endurance, int intelligence, int dexterity, int agility, int luck) {
        this.name = name;
        location = Location.TOWN;
        this.xpToUp = 100;
        this.currentXp = 0;
        this.gold = 0;
    }
}
