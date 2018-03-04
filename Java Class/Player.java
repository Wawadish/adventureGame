package com.company;
import java.lang.IllegalArgumentException;

import java.util.ArrayList;

public class Player {                                   //mova up/down by 2, L/R by
    private int playerX;
    private int playerY;

    public Player() {
        this.playerX = 0;
        this.playerY = 1;
        playerDraw();
    }

    public Player(int playerX, int playerY) {           //generate a player at playerX, playerY
        this.playerX = playerX;
        this.playerY = playerY;
        changeMap(Map.generatedMap);
        playerDraw();
    }
    public static boolean didMove = false;
    public void move(MoveEnum m){
        switch(m){
            case UP:
                if (!(Map.generatedMap.get(playerY - 1).get(playerX).equals(Map.top))){
                    playerY--;
                    playerDraw();
                    didMove = true;
                }
                if(checkBattle()){
                    System.exit(0);
                }
            break;
            case DOWN:
                if(playerY != Map.generatedMap.size() - 1) {
                    try {
                        if (Map.generatedMap.get(playerY + 1).get(playerX).equals(Map.block)) {
                            playerY++;
                            playerDraw();
                            didMove = true;
                        }
                        if(checkBattle()){
                            System.exit(0);
                        }
                    }catch(Exception e){

                    }
                }
            break;
            case LEFT:
                if(playerX != 0) {
                    if (Map.generatedMap.get(playerY).get(playerX - 1).equals(Map.block)){
                        playerX--;
                        playerDraw();
                        didMove = true;
                    }
                    if(checkBattle()){
                        System.exit(0);
                    }
                }
            break;
            case RIGHT:
                if(playerX != Map.generatedMap.get(playerY).size()-1) {
                    if (Map.generatedMap.get(playerY).get(playerX + 1).equals(Map.block)){
                        playerX++;
                        playerDraw();
                        didMove = true;
                    }
                    if(checkBattle()){
                        System.exit(0);
                    }
                }
            break;
        }
    }
    public int getPlayerX() {                           //get PlayerX
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public ArrayList<ArrayList<String>> changeMap(ArrayList<ArrayList<String>> listMap){
        listMap.get(playerY).set(playerX, "|_X_|");
        for (int i = 0; i < Main.enemyList.size(); i++) {
            Map.generatedMap.get(Main.enemyList.get(i).getEnemyY()).set(Main.enemyList.get(i).getEnemyX(), "|_E_|");
        }
        return listMap;
    }


    public void playerDraw(){
        Main.clear();
        changeMap(Map.generatedMap);
        Map.draw();
        Map.generatedMap.get(playerY).set(playerX, "|___|");
        for (int i = 0; i < Main.enemyList.size(); i++) {
            Map.generatedMap.get(Main.enemyList.get(i).getEnemyY()).set(Main.enemyList.get(i).getEnemyX(), "|___|");
        }
        didMove=true;
    }

    public boolean checkBattle() {
        for (int i = 0; i < Main.enemyList.size(); i++) {
            if ((playerX == Main.enemyList.get(i).enemyX)&&(playerY == Main.enemyList.get(i).enemyY)) {
                System.out.println("Battle initiated.");
                return true;
            }
        }
        if ((mapPosition(1, 0) == Map.enemy)) {
            System.out.println("Battle initiated");
            return true;
        } else if ((mapPosition(-1, 0) == Map.enemy)) {
            System.out.println("Battle initiated");
            return true;
        } else if ((mapPosition(0, 1) == Map.enemy)) {
            System.out.println("Battle initiated");
            return true;
        } else if ((mapPosition(0, -1) == Map.enemy)) {
            System.out.println("Battle initiated");
            return true;
        } else {
            return false;
        }
    }

    public String mapPosition(int incrementY, int incrementX){
        try {
            return Map.generatedMap.get(playerY + incrementY).get(playerX + incrementX);
        }catch (Exception e){
            return "a random string";
        }
    }
}
