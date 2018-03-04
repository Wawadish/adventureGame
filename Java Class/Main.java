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
        Player player1 = new Player();
        Controller controller = new Controller(player1);
    }
    public static void clear(){
        for(int i = 0; i < 50; i++){
            System.out.println();
        }
    }
}
