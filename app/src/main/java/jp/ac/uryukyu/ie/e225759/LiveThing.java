package jp.ac.uryukyu.ie.e225759;

public class LiveThing {
    public String name;
    public int hitPoint;
    public int attack;
    public boolean dead;

    public String getName(){
        return this.name;
    }

    public boolean isDead(){
        return this.dead;
    }

    public LiveThing(String name, int hitPoint ,int attack){
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", getName(), hitPoint, attack);
    }
    public void attack(LiveThing opponent){
        if (isDead() == false){
        int damage = (int)(Math.random() * attack);
        System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
        opponent.wounded(damage);
        }
    }
    public void wounded(int damage){
        hitPoint -= damage;
        

        if(hitPoint < 0 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", getName());
        }
    }
}