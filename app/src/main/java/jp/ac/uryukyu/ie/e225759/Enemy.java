package jp.ac.uryukyu.ie.e225759;

/**
 * 敵クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Enemy extends LiveThing {
    public void setName(String monstername){
        this.name = monstername;
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

    public Enemy (String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
        setName(name);
        setHitPoint(maximumHP);
        setAttack(attack);
        setDead(false);
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", super.getName(), getHitPoint(), getAttack());
    }

    /**
     * Heroへ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
     * @param hero 攻撃対象
     */
    public void attack(Hero hero){
        int damage = (int)(Math.random() * attack);
        System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, hero.name, damage);
        hero.wounded(damage);
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        int hp = getHitPoint() - damage;
        setHitPoint(hp);
        if(getHitPoint() < 0 ) {
            setDead(true);
            System.out.printf("モンスター%sは倒れた。\n", getName());
        }
    }

}