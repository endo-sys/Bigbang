package main.Gameobject;

import main.Spacegame;
import processing.core.PApplet;
import processing.core.PImage;

public class bomberenemy extends gameobject{
    private float speed;
    private float cooldown= 60f;
    private float kalanzman;
    public bomberenemy(PApplet parent, PImage image,float x, float y,float speed){
        super(parent,image,x,y);
        this.speed=speed;
        this.kalanzman=0;
    }

    @Override
    public void render() {
        super.render();
    }
    public void hareketet()  {
        if (pos.y < parent.height / 2) {
            pos.y += speed * Spacegame.deltatime;
            if (pos.y > parent.height / 2)
                pos.y = parent.height / 2;
while (pos.y<(parent.height-parent.height/4)){
    pos.y+=speed;


}
}

}


    public void bombaat(){

    }
}
