package com.company;

public class Main {

    public static void main(String[] args) {
        Map map = new Map();  //creating the map
        map.generate();  //generating the map
        map.draw();  //displaying the map

        Player player = new Player();
        player.changeMap(Map.generatedMap);
        map.draw();

        Controller controller = new Controller(player);
    }
}
