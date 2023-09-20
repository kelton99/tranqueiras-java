package com.kelton;

public abstract class Character {

    private int level;
    private int hp;
    private int mp;

    public int strength;
    public int endurance;
    public int intelligence;
    public int dexterity;
    public int agility;
    public int luck;

    public Character(int level, int strength, int endurance, int intelligence, int dexterity, int agility, int luck) {
        this.level = level;
        this.hp = endurance * 10;
        this.mp = intelligence * 10;
        this.endurance = endurance;
        this.strength = strength;
        this.intelligence = intelligence;
        this.dexterity = dexterity;
        this.agility = agility;
        this.luck = luck;
    }
}
