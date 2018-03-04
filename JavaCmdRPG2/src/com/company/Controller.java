package com.company;

import javax.swing.*;

import java.awt.event.*;
import java.util.ArrayList;

import static com.company.MoveEnum.*;

public class Controller implements ActionListener{

    public Player player;
    public ArrayList<Enemy> enemyList;

    public Controller(Player player, ArrayList<Enemy> enemyList) {
        this.player = player;
        this.enemyList = enemyList;

        KeyListener listener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                int key = e.getKeyCode();

                if (key == KeyEvent.VK_LEFT) {
                    player.move(LEFT);
                    moveEnemies(Player.didMove, enemyList);
                    Player.didMove = false;
                }

                if (key == KeyEvent.VK_RIGHT) {
                    player.move(MoveEnum.RIGHT);
                    moveEnemies(Player.didMove, enemyList);
                    Player.didMove = false;
                }

                if (key == KeyEvent.VK_UP) {
                    player.move(UP);
                    moveEnemies(Player.didMove, enemyList);
                    Player.didMove = false;
                }

                if (key == KeyEvent.VK_DOWN) {
                    player.move(DOWN);
                    moveEnemies(Player.didMove, enemyList);
                    Player.didMove = false;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };

        JFrame frame = new JFrame("frame");
        frame.setVisible(true);
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JButton Bup = new JButton("up");
        Bup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.move(UP);
                moveEnemies(Player.didMove, enemyList);
                Player.didMove = false;
            }
        });

        JButton Bdown = new JButton("down");
        Bdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.move(DOWN);
                moveEnemies(Player.didMove, enemyList);
                Player.didMove = false;
            }
        });

        JButton Bleft = new JButton("left");
        Bleft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.move(LEFT);
                moveEnemies(Player.didMove, enemyList);
                Player.didMove = false;
            }
        });

        JButton Bright = new JButton("right");
        Bright.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.move(MoveEnum.RIGHT);
                moveEnemies(Player.didMove, enemyList);
                Player.didMove = false;
            }
        });

        panel.add(Bup);
        panel.add(Bdown);
        panel.add(Bleft);
        panel.add(Bright);

        frame.add(panel);
        frame.addKeyListener(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


    public void moveEnemies(boolean b, ArrayList<Enemy> enemies){
        boolean repeat = false;
        int counter = 0;
        if(b){
            for (int i = 0; i < enemies.size(); i++) {
                do {
                    int x = (int) (Math.random() * 4 + 1);
                    MoveEnum m;
                    switch (x) {
                        case 1:
                            m = UP;
                            System.out.println("Moving up");
                            enemies.get(i).move(m);
                            if (enemies.get(i).canGoUp == false){
                                repeat = true;
                            }else{
                                repeat = false;
                            }
                            break;
                        case 2:
                            m = DOWN;
                            System.out.println("Moving down");
                            enemies.get(i).move(m);
                            if (enemies.get(i).canGoDown == false){
                                repeat = true;
                            }else{
                                repeat = false;
                            }
                            break;
                        case 3:
                            m = LEFT;
                            System.out.println("Moving left");
                            enemies.get(i).move(m);
                            if (enemies.get(i).canGoLeft == false){
                                repeat = true;
                            }else{
                                repeat = false;
                            }
                            break;
                        case 4:
                            m = RIGHT;
                            System.out.println("Moving right");
                            enemies.get(i).move(m);
                            if (enemies.get(i).canGoRight == false){
                                repeat = true;
                            }else{
                                repeat = false;
                            }
                            break;
                        default:
                            m = NULL;
                            System.out.println("ERROR NOT MOVING");
                            enemies.get(i).move(m);
                            repeat = true;
                            break;
                    }
                    counter++;
                    if(counter > 10){
                        System.exit(0);
                    }
                }while(repeat);
            }
        }
    }
}
