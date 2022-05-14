package main;

import main.Gameobject.bomberenemy;
import main.Gameobject.player2;
import main.Gameobject.Player;
import main.Gameobject.laser;
import main.Gameobject.enemy;
import processing.core.PApplet;
import processing.core.PImage;
import main.Gameobject.bomb;

import java.util.ArrayList;

public class Spacegame extends PApplet {
    public static void main(String []args){
        PApplet.main(new String[]{Spacegame.class.getName()});
    }

    public static PImage bg, oyuncuresmi,laserresmi,düşmanlazeri,düşmanresmi,bombacıresmi,player2resim,bombaresmi;

    public static Player p1;
    public static  player2 p2;
    public static enemy em1;
    public static bomberenemy bm1;

    public static ArrayList<laser> lasers;
    public static ArrayList<enemy> emenies;
    public static ArrayList<bomb> bombs;
    public static final String tagplayer="player";
    public static final String tagenemy ="enemy";
    public static float deltatime;
    public void settings(){
        size(1280,720);
        bg = loadImage("res/space.jpg");
        oyuncuresmi =loadImage("res/playership.png");
        player2resim= loadImage("res/player2.png");
        bombaresmi= loadImage("res/bomb.png");
        laserresmi= loadImage("res/laser.png");

        düşmanresmi = loadImage("res/enemyRed2.png");
        bombacıresmi= loadImage("res/bombacı.png");
        p1 = new Player(this,oyuncuresmi,tagplayer,width/2-oyuncuresmi.width/2,height-oyuncuresmi.height,1.5f);
        p2 = new player2(this,player2resim,0,0,2);
        em1 = new enemy(this, düşmanresmi, tagenemy,width/2-düşmanresmi.width/2, düşmanresmi.height, 2f);
        bm1= new bomberenemy(this,"bomber",bombacıresmi,0,0,1.5f);
        lasers = new ArrayList<laser>();
        bombs = new ArrayList<bomb>();
        emenies= new ArrayList<enemy>();
        emenies.add(em1);

        time1 = millis();
        System.out.println(p1.getScore());


    }

    float time1,time2;
   public void draw() {
        background(0);
        time2 = millis();
        deltatime=time2-time1;
        wrap(bg,0,0,width,height);
        for(laser l:lasers)
            l.render();


       for(enemy e:emenies)
           em1.render();
       p1.render();


        for (int i=emenies.size()-1;i>=0;i--){
            if (emenies.get(i).getCanhakkı()<=0){
                emenies.remove(i);

            }
            else {
                emenies.get(i).act();
            }
        }
       for (int i=lasers.size()-1;i>=0;i--){
           if (lasers.get(i).getHealth()<=0){
               lasers.remove(i);
           }
           else {
               lasers.get(i).hareket();
           }
       }





        p1.move();


       bm1.render();
       bm1.yerleştir();
       bm1.update();
        time1=millis();
        if (p1.getScore()>100){
            p2.render();
            p2.hareketet();}


        }
            









    public void wrap(PImage img,float x1,float y1,float x2,float y2){
        for(float x = x1;x<x2;x+=img.width){
            for (float y =y1;y<y2;y+=img.height){
                image(img,x,y); }}}

    public static boolean[] keys = new boolean[5]; // W/UP, A/LEFT, S/DOWN, D/RIGHT, SPACE

    public void keyPressed(){
        if(key == 'w' || key == 'W' || keyCode == UP) keys[0] = true;
        if(key == 'a' || key == 'A' || keyCode == LEFT) keys[1] = true;
        if(key == 's' || key == 'S' || keyCode == DOWN) keys[2] = true;
        if(key == 'd' || key == 'D' || keyCode == RIGHT) keys[3] = true;
        if(key == ' ') keys[4] = true;
    }

    public void keyReleased(){
        if(key == 'w' || key == 'W' || keyCode == UP) keys[0] = false;
        if(key == 'a' || key == 'A' || keyCode == LEFT) keys[1] = false;
        if(key == 's' || key == 'S' || keyCode == DOWN) keys[2] = false;
        if(key == 'd' || key == 'D' || keyCode == RIGHT) keys[3] = false;
        if(key == ' ') keys[4] = false;
    }

    public static float getDeltatime() {
        return deltatime;
    }

    public static void setDeltatime(float deltatime) {
        Spacegame.deltatime = deltatime;
    }
}
