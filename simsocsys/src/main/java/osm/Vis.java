package osm;

import processing.core.PApplet;
import simulation.Network;
import simulation.Walls;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bsmoehring on 17/10/17.
 */
public class Vis extends PApplet {

    private static final int WIDTH = 1500;
    private static final int HEIGHT = 600;

    private int x = 0;
    private int y = 0;

    private double phi = 0;
    private final Network net;
    private final Walls walls;

    public Vis(Network net, Walls walls) {
        this.net = net;
        this.walls = walls;
        JFrame fr = new JFrame();
        fr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fr.setSize(WIDTH, HEIGHT);
        JPanel panel = new JPanel();
        panel.setLayout(new OverlayLayout(panel));

        fr.add(panel, BorderLayout.CENTER);

        panel.add(this);
        panel.setEnabled(true);
        panel.setVisible(true);

        this.init();
        frameRate(90);

        fr.setVisible(true);

        size(WIDTH, HEIGHT);
        background(255);

    }

    @Override
    public void draw() {
        background(255); // eraser

        net.draw(this);
        walls.draw(this);

//        synchronized (this.vehs) {
//            for (VehicleInfo v : this.vehs) {
//                v.draw(this);
//            }
//        }
    }

}
