package com.kelton;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {

        System.out.print("Name your hero: ");
        String name = scanner.nextLine();

        Player player = new Player(name, 1, 5, 5, 5, 5, 5, 5);

        while (true) {
            if(player.location == Location.TOWN) {
                System.out.println("You are in the Town, you can rest here and upgrade your character");
                System.out.format("Level: %d\tHP: %d MP: %d\tGold: %d", player.level, player.hp, player.mp, player.gold);
                System.out.println("What are going to do?\n[1]Rest [2]Upgrade [3]Fields");
            }
            if(player.location == Location.FIELD) {
                System.out.println("You are in the Field, you can hunt monsters or go to the Dungeon");
                System.out.format("Level: %d\tHP: %d MP: %d\tGold: %d", player.level, player.hp, player.mp, player.gold);
                System.out.println("What are going to do?\n[1]Hunt [2]Dungeon [3]Town");
            }
            if(player.location == Location.DUNGEON) {
                System.out.println("You are in the Dungeon, great danger waits, as well as great treasures");
                System.out.format("Level: %d\tHP: %d MP: %d\tGold: %d", player.level, player.hp, player.mp, player.gold);
                System.out.println("What are going to do?\n[1]Hunt [2]Dungeon [3]Town");
            }

            Thread.sleep(100);
        }
    }
}
