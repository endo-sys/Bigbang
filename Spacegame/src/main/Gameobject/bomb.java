package main.Gameobject;
import main.Spacegame;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class bomb {
    PApplet parent;
    PVector pos;
    float speed;
    PImage picture;
    float damage;
    public bomb(PApplet parent, PImage picture, float x, float y){
        this.parent=parent;
        this.speed=speed;
        pos = new PVector(x,y);
        this.picture=picture;
        this.damage=100;
    }
    public void render(){
        parent.image(picture,pos.x,pos.y);
}
public void act(){
pos.x+=speed;
}
}

