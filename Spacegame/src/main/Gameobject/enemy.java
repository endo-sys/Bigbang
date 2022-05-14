package main.Gameobject;

import main.Boxcollider.collisionbox;
import main.Spacegame;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

import static main.Spacegame.lasers;


public class enemy extends gameobject{
    collisionbox collisionbox1;
    float  speed;
    float canhakkı;

    public float getCanhakkı() {
        return canhakkı;
    }

    float kalanzaman;
    float cooldownMax = 300.0f;
    float cooldownMin = 100.0f;
    public enemy(PApplet parent, PImage image, String tag,float x, float y, float speed){
        super(parent,image,tag,x,y);
        this.canhakkı=20;
        this.speed=speed;
        collisionbox1 = new collisionbox(parent,pos,new PVector(image.width,image.height));
        kalanzaman= parent.random(cooldownMin, cooldownMax);
    }
    public void act(){
        if (canhakkı<=0){
            Spacegame.emenies.remove(this);


        }

        kalanzaman -= Spacegame.deltatime;
        if (pos.y < parent.height / 2) {
            pos.y += speed * Spacegame.deltatime;
            if (pos.y > parent.height / 2)
                pos.y = parent.height / 2;
            collisionbox1.movecollationsdecettor(pos);

        }
        ateş();
        collisionbox1.show_collation();
        for(laser l: lasers){
            if (l.tag==tag==false&&collisionbox1.collationsdecettor(l.collisionbox1)){
                canhakkı-=l.damage;
                l.health-=l.damage;
            }}
    }
    public void ateş() {
        if (kalanzaman <= 0) {
            laser laser = new laser(parent, Spacegame.laserresmi,tag,
                    pos.x + image.width / 2 -Spacegame.laserresmi.width / 2,
                    pos.y + Spacegame.laserresmi.height * 0.75f, 2,10);
            Spacegame.lasers.add(laser);


            kalanzaman = parent.random(cooldownMin, cooldownMax);


    }
}}
