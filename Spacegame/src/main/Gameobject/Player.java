package main.Gameobject;

import main.Boxcollider.collisionbox;
import main.Spacegame;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

import static main.Spacegame.lasers;

public class Player extends gameobject{
    private collisionbox collisionbox1;
   private float  speed;
   private double canhakkı;
    private int score;
    int cooldown=30;
    int kalanzaman;

    public Player(PApplet parent,PImage image,String tag,float x,float y,float speed){
        super(parent,image,tag,x,y);

        this.speed= speed;
        this.canhakkı = 30;
        this.score = 0;
        this.kalanzaman=0;
        collisionbox1 = new collisionbox(parent,pos, new PVector(image.width,image.height));

    }
    public void render(){
        super.render();
    }
    public void move(){
collisionbox1.show_collation();
        if(kalanzaman>0)kalanzaman--;

        if (Spacegame.keys[0])pos.y -= speed* Spacegame.getDeltatime();
        if (Spacegame.keys[2])pos.y += speed*Spacegame.getDeltatime();
        if (Spacegame.keys[1])pos.x -= speed*Spacegame.getDeltatime();
        if (Spacegame.keys[3]) pos.x += speed*Spacegame.getDeltatime();



        if(Spacegame.keys[4])
            ateşet();
        collisionbox1.movecollationsdecettor(pos);
        for(laser l: lasers){
            if (l.tag==tag==false&&collisionbox1.collationsdecettor(l.collisionbox1)){
                canhakkı-=l.damage;
                l.health-=10;
            }
        }

    }
    void ateşet(){
        if(kalanzaman<=0){
            laser laser1 = new laser(parent,Spacegame.laserresmi,tag,pos.x+image.width/2-Spacegame.laserresmi.width/2,pos.y-Spacegame.laserresmi.height*0.75f,-10f,10);
            lasers.add(laser1);
            kalanzaman=cooldown;
        }
    }

    public int getScore() {
        return score;
    }
}

