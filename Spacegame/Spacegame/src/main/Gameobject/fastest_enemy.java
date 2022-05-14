package main.Gameobject;

import main.Spacegame;
import processing.core.PApplet;
import processing.core.PImage;

public class fastest_enemy extends  gameobject {
    private float speed;


    public fastest_enemy(PApplet parent, PImage img,String tag, float x, float y, float speed) {
        super(parent, img,tag, x, y);
        this.speed = speed;

    }

    public void render() {
        super.render();
    }

    public void act() {

        }


    public void update() {

    }

}