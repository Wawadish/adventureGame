package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Map map = new Map();  //creating the map
        map.generate();  //generating the map
        BattleEntity player = new BattleEntity(20, 5, 5, 10, 5, true);
        BattleEntity enemy1 = new BattleEntity(player);
        map.draw();  //displaying the map
        player.battle(enemy1);
    }
}
