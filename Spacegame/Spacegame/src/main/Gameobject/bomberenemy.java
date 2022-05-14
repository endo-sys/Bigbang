package main.Gameobject;

import main.Boxcollider.collisionbox;
import main.Spacegame;
import processing.core.PApplet;
import processing.core.PImage;
import main.Boxcollider.collisionbox;
import processing.core.PVector;

import static main.Spacegame.bombaresmi;
import static main.Spacegame.bombs;

public class bomberenemy extends gameobject{
    private float speed;
    private float cooldown= 60f;
    private float kalanzman;
    private float health;
    private collisionbox collisionbox1;
    public bomberenemy(PApplet parent,String tag, PImage image,float x, float y,float speed){
        super(parent,image,tag,x,y);
        this.speed=speed;
        this.kalanzman=0;
        this.health=200;
        collisionbox1= new collisionbox(parent,pos,new PVector(image.width,image.height));


    }

    @Override
    public void render() {
        super.render();
    }
    public void yerleştir() {
        if (pos.y < parent.height / 2) {
            pos.y += speed * Spacegame.deltatime;
            if (pos.y > parent.height / 2)
                pos.y = parent.height / 2;}}
public void update(){
collisionbox1.show_collation();
    pos.y+=speed;
    collisionbox1.movecollationsdecettor(pos);

    if (pos.y>=parent.height/3){
        bombaat();
    }
    }

public void bombaat(){
bomb bomb1 = new bomb(parent, Spacegame.bombaresmi,pos.x+image.width/2-Spacegame.bombacıresmi.width/2,pos.y-Spacegame.bombacıresmi.height*0.75f);
    bombs.add(bomb1);
    }
}

