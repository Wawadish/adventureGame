package com.company;

import java.util.ArrayList;
import java.util.Scanner;

import com.company.MoveEnum;

import static com.company.MoveEnum.DOWN;

public class Main {

    public static ArrayList<Enemy> enemyList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Map map = new Map();
        System.out.println("Map object created");
        map.generate();
        System.out.println("Map generated");
        enemyList.add(new Enemy());
        System.out.println("Enemy added to arraylist");
        Player player1 = new Player();
        System.out.println("Player Object created");
        Controller controller = new Controller(player1, enemyList);
        System.out.println("Controller initialized");

    }

    public static void clear() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
}
