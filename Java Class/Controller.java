package com.company;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    public Controller(Player player) {
        JFrame frame = new JFrame("frame");
        frame.setVisible(true);
        frame.setSize(300,120);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JButton Bup = new JButton("up");
        Bup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.move(MoveEnum.UP);
            }
        });
        JButton Bdown = new JButton("down");
        Bdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.move(MoveEnum.DOWN);
            }
        });
        JButton Bleft = new JButton("left");
        Bleft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.move(MoveEnum.LEFT);
            }
        });
        JButton Bright = new JButton("right");
        Bright.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.move(MoveEnum.RIGHT);
            }
        });

        panel.add(Bup);
        panel.add(Bdown);
        panel.add(Bleft);
        panel.add(Bright);

        frame.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
