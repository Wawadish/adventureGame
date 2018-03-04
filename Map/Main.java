package com.company;

public class Main {

    public static void main(String[] args) {
        Map map = new Map();  //creating the map
        map.generate();  //generating the map
        map.draw();  //displaying the map

        Player player = new Player();

        player.moveDown();
        player.moveRight();
        player.setPlayerPosition(3,5);
        map.setGeneratedMap(player.changeMap(map));
        map.draw();
    }
}
