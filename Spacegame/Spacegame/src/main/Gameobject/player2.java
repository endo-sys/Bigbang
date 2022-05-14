
package main.Gameobject;

import processing.core.PApplet;
import processing.core.PImage;

public class player2 extends Player{
   public player2(PApplet parent, PImage img,float x,float y,float speed)
    {
        super(parent,img,"tag",x,y,speed);
    }

    public void render() {
        super.render();
    }
    public void hareketet(){
super.move();
    }
}
