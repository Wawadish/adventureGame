package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import com.company.MoveEnum;

import static com.company.MoveEnum.DOWN;

public class Main {

    public static ArrayList<Enemy> enemyList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Map map = new Map();  //creating the map
        System.out.println("Map object created");
        map.generate();  //generating the map
        System.out.println("Map generated");

        /*BattleEntity playerBattle = new BattleEntity(20, 5, 5, 10, 5, true);
        System.out.println("Player Battle Entity Created # for test only");
        BattleEntity enemy1 = new BattleEntity(playerBattle);
        System.out.println("Enemy Battle Entity Created # for test only");
        playerBattle.battle(enemy1);
        System.out.println("Battle against enemy initiated");*/
        enemyList.add(new Enemy());
        System.out.println("Enemy added to arraylist");
        Player player1 = new Player();
        System.out.println("Player Object created");
        Controller controller = new Controller(player1, enemyList);
        System.out.println("Controller initialized");
    }
    public static void clear(){
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
}
