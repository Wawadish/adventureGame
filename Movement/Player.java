package com.company;
import java.lang.IllegalArgumentException;

public class Player {                                   //mova up/down by 2, L/R by
    private int playerX;
    private int playerY;

    public Player(int playerX, int playerY) {           //generate a player at playerX, playerY
        this.playerX = playerX;
        this.playerY = playerY;
    }

    public  void moveUp() {                             //every time this is used, playerY reduces by 1, player go up
        playerY -= 1;
    }

    public  void moveDown() {                           //every time this is used, playerY increases by 1, player go down
        playerY += 1;
    }

    public  void moveLeft() {                           //every time this is used, playerX reduces by 4, player go left
        playerX -= 4;
    }

    public  void moveRight() {                          //every time this is used, playerX increases by 4, player go right
        playerX += 4;
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
           playerX = 3+(x-1)*4;
           playerY = y;
       }catch(IllegalArgumentException e) {
           System.out.println("value entered must be an int bigger to 0");
       }catch(Exception e) {
            e.printStackTrace();
       }
    }
}