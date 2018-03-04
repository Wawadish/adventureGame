package com.company;

import java.util.ArrayList;

public class Map {

    public static final String top = " ___ ";
    public static final String block = "|___|";    //I seperated blocks into tops and blocks, it was easier to deal with.

    public static ArrayList<ArrayList<String>> generatedMap = new ArrayList<>();  //this is the two dimensional array list from which the map is drawn.

    public void generate() {                                           //this method the generates map
        for (int y = 0; y < Math.random() * 11 + 4; y++) {  //from 4 to 15 rows (horizontal)
            generatedMap.add(new ArrayList<String>());
            for (int x = 0; x < Math.random() * 15 + 5; x++) { //and from 5 to 15 columns (vertical), changes these values (rows and columns) however you like.
                generatedMap.get(y).add(block);
            }
        }
        ArrayList<String> tops = new ArrayList<>();          //adding tops to the top row, this is the first line of the arraylist and should be IGNORED when it comes to movement, u cant move to genereatedMap.get(0) !!!!!!
        int t = getRow(0, generatedMap).size();
        for (int i = 0; i < t; i++) {
            tops.add(top);
        }
        generatedMap.add(0, tops);
        int columnsCount = 0;                 //a variable I use to display the amount of maximum column in the map.

        for (int i = 1; i < generatedMap.size(); i++) {
            if (generatedMap.get(i).size() > generatedMap.get(i - 1).size()) {
                int difference = generatedMap.get(i).size() - generatedMap.get(i - 1).size();
                int count = 0;
                for (int p = 0; p < difference; p++) {                                           //this whole block of code adds tops to blocks who didnt have one.
                    count++;
                    generatedMap.get(i - 1).add(top);
                    if (columnsCount < generatedMap.get(i).size()) {
                        columnsCount++;
                    }
                }
            }
        }

        System.out.println("The number of rows starting from 0 : " + generatedMap.size());    //displaying the amount of rows and columns, use this for development only, I will delete after.
        System.out.println("The number of columns starting from 0 : " + columnsCount);
    }

    public static void draw() {
        for (int i = 0; i < generatedMap.size(); i++) {                              //this method draws the map in the console.
            for (int column = 0; column < getRow(i, generatedMap).size(); column++) {
                if (column != getRow(i, generatedMap).size() - 1) {
                    System.out.print(getRow(i, generatedMap).get(column));
                } else {
                    System.out.print(getRow(i, generatedMap).get(column) + "\n");
                }
            }
        }
    }

    public static ArrayList<String> getRow(int rowNumber, ArrayList<ArrayList<String>> tempMap) {  //this method uses the two dimensional arraylist (the map), and return the arraylist at the i position, for practical use only.
        ArrayList<String> a = tempMap.get(rowNumber);
        return a;
    }

    public void setGeneratedMap(ArrayList<ArrayList<String>> generatedMap){
        this.generatedMap = generatedMap;
    }

    public ArrayList<ArrayList<String>> getGeneratedMap(){
        return this.generatedMap;
    }
}
