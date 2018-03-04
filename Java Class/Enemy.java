package com.company;

import java.lang.IllegalArgumentException;

import java.util.ArrayList;

public class Enemy {                                   //mova up/down by 2, L/R by
    public int enemyX;
    public int enemyY;
    public boolean canGoRight = true;
    public boolean canGoLeft = true;
    public boolean canGoUp = true;
    public boolean canGoDown = true;

    public Enemy() {
        this.enemyX = 1;
        this.enemyY = 1;
        playerDraw();
    }

    public Enemy(int playerX, int playerY) {           //generate a player at playerX, playerY
        this.enemyX = playerX;
        this.enemyY = playerY;
        playerDraw();
    }

    public void move(MoveEnum m){
        switch(m){
            case UP:
                if (!(Map.generatedMap.get(enemyY - 1).get(enemyX).equals(Map.top))){
                    enemyY--;
                    playerDraw();
                    canGoUp = true;
                }else{
                    canGoUp = false;
                }
                break;
            case DOWN:
                if(enemyY != Map.generatedMap.size() - 1) {
                    try {
                        if (Map.generatedMap.get(enemyY + 1).get(enemyX).equals(Map.block)) {
                            enemyY++;
                            playerDraw();
                            canGoDown = true;
                        }
                    }catch(Exception e){
                        canGoDown = false;
                    }
                }else{
                    canGoDown = false;
                }
                break;
            case LEFT:
                if(enemyX != 0) {
                    if (Map.generatedMap.get(enemyY).get(enemyX - 1).equals(Map.block)){
                        enemyX--;
                        playerDraw();
                        canGoLeft = true;
                    }else{
                        canGoLeft =false;
                    }
                }else{
                    canGoLeft =false;
                }
                break;

            case RIGHT:
                if(enemyX != Map.generatedMap.get(enemyY).size()-1) {
                    if (Map.generatedMap.get(enemyY).get(enemyX + 1).equals(Map.block)){
                        enemyX++;
                        playerDraw();
                        canGoRight = true;
                    }else{
                        canGoRight =false;
                    }
                }else{
                    canGoRight =false;
                }
                break;
        }
    }
    public int getEnemyX() {                           //get PlayerX
        return enemyX;
    }

    public int getEnemyY() {
        return enemyY;
    }


    public ArrayList<ArrayList<String>> changeMap(ArrayList<ArrayList<String>> listMap){
        listMap.get(enemyY).set(enemyX, "|_E_|");

        return listMap;
    }

    public void playerDraw(){
        changeMap(Map.generatedMap);
    }

}

