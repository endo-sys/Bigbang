package main.Boxcollider;

import processing.core.PApplet;
import processing.core.PVector;

public class collisionbox {
    private PApplet parent;
    private PVector pos;
    private PVector size;

    public collisionbox(PApplet parent,PVector pos,PVector size){
        this.parent=parent;
        this.pos=pos;
        this.size=size;
    }
    public boolean collationsdecettor(collisionbox a){
        return (pos.x <a.pos.x +a.size.x&&pos.x+size.x>a.pos.x&&pos.y<a.pos.y+a.size.y&&pos.y+size.y>a.pos.y);
    }
    public void movecollationsdecettor(PVector a){
        this.pos= a;

    }
    public void show_collation(){
        parent.push();
        parent.stroke(0,255,0);
        parent.noFill();
        parent.rect(pos.x,pos.y,size.x,size.y);
        parent.pop();
    }
}


