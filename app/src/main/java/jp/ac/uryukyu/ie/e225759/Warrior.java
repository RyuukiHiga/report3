package jp.ac.uryukyu.ie.e225759;

public class Warrior extends LiveThing{
    public void setName(String heroname){
        this.name = heroname;
    }

    public int getHitPoint(){
        return this.hitPoint;
    }

    public void setHitPoint(int maximumHP){
        this.hitPoint = maximumHP;
    }


    public int getAttack(){
        return this.attack;
    }

    public void setAttack(int attack){
        this.attack = attack;
    }

    public void setDead(boolean dead){
        this.dead = dead;
    }


    public Warrior(String name,int hitPoint,int attack){
        super(name, hitPoint, attack);
        setName(name);
        setHitPoint(hitPoint);
        setAttack(attack);
        setDead(false);


    }


    public void attackWithWeponSkill(LiveThing LiveThing){
        if (isDead() == false){
            int damage = (int)((double)1.5 * attack);
            System.out.printf("%sの攻撃！ウェポンスキルを発動！%sに%dのダメージを与えた！！\n", getName(),LiveThing.getName(), damage);
            LiveThing.wounded(damage);
            }
        }
        
    
}