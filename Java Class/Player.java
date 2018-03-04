package com.company;
import java.lang.IllegalArgumentException;

import java.util.ArrayList;

public class Player {                                   //mova up/down by 2, L/R by
    private int playerX;
    private int playerY;

    public Player() {
        this.playerX = 0;
        this.playerY = 1;
    }

    public Player(int playerX, int playerY) {           //generate a player at playerX, playerY
        this.playerX = playerX;
        this.playerY = playerY;
    }

    public void move(MoveEnum m){
        switch(m){
            case UP:
                if (!(Map.generatedMap.get(playerY - 1).get(playerX).equals(Map.top))){
                    playerY -= 1;
                    playerDraw();
                }
            break;
            case DOWN:
                if(playerY != Map.generatedMap.size()){
                    if (Map.generatedMap.get(playerY + 1).get(playerX).equals(Map.block)) {
                        playerY += 1;
                        playerDraw();
                    }
            }
            break;
            case LEFT:
                if(playerX != 0) {
                    if (Map.generatedMap.get(playerY).get(playerX - 1).equals(Map.block)){
                        playerX -= 1;
                        playerDraw();
                    }
                }
            break;
            case RIGHT: if(playerX != Map.generatedMap.get(playerY).size()) {
                if (Map.generatedMap.get(playerY).get(playerX + 1).equals(Map.block)){
                    playerX += 1;
                    playerDraw();
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

    public void setPlayerPosition(int x,int y) {        //set player Postion to entered x,y, ex: (1,2) will put the player in the 1st column for left, 2nd row from top
       try {                                            //don't enter the index of string, enter the nubmer of block
           if (x <= 0 || y <= 0) throw new IllegalArgumentException();
           playerX = x-1;
           playerY = y;
       }catch(IllegalArgumentException e) {
           System.out.println("value entered must be an int bigger to 0");
       }catch(Exception e) {
            e.printStackTrace();
       }
    }

    public ArrayList<ArrayList<String>> changeMap(ArrayList<ArrayList<String>> listMap){
        listMap.get(playerY).set(playerX, "|_X_|");

        return listMap;
    }

    public void playerDraw(){
        Main.clear();
        changeMap(Map.generatedMap);
        Map.draw();
        Map.generatedMap.get(playerY).set(playerX, "|___|");
    }
}
