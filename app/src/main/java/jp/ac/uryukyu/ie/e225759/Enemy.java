package jp.ac.uryukyu.ie.e225759;

/**
 * 敵クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Enemy extends LiveThing{

    /**
     * 敵の名前を変更するメソッド。
     * 引数を敵クラスの名前に入れる
     * @param monstername 設定する敵の名前
     * @return 敵の名前
     */
    public void setName(String monstername){
        this.name = monstername;
    }
    /**
     * 敵のhpを取得するメソッド。
     * setHitPointで入れたhpが出力される
     * @return 敵のhp
     */
    public int getHitPoint(){
        return this.hitPoint;
    }
    /**
     * 敵のhpを変更するメソッド。
     * 引数を敵クラスのhitPointに入れる
     * @param maximumHP 設定する敵のhp
     * @return 敵のhp
     */
    public void setHitPoint(int maximumHP){
        this.hitPoint = maximumHP;
    }
    /**
     * 敵の攻撃力を取得するメソッド。
     * setAttackで入れた攻撃力が出力される
     * @return 敵の攻撃力
     */
    public int getAttack(){
        return this.attack;
    }
    /**
     * 敵の攻撃力を変更するメソッド。
     * 引数を敵クラスのattackに入れる
     * @param attack 設定する敵の攻撃力
     * @return 敵の攻撃力
     */
    public void setAttack(int attack){
        this.attack = attack;
    }

    /**
     * 敵の生死状態を変更するメソッド。
     * 引数を敵クラスのdeadに入れる
     * @param dead 敵の生死状態がどうか
     * @return 敵の生死状態
     */
    public void setDead(boolean dead){
        this.dead = dead;
    }

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name モンスター名
     * @param maximumHP モンスターのHP
     * @param attack モンスターの攻撃力
     */
    public Enemy (String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
        setName(name);
        setHitPoint(maximumHP);
        setAttack(attack);
        setDead(false);
        //this.setName = name;
        //this.setHitPoint = maximumHP;
        //this.setAttack = attack;
        //this.isDead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n",super.getName(), getHitPoint(), getAttack());
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    @Override
    public void wounded(int damage){
        
        int hp = getHitPoint() - damage;
        setHitPoint(hp);
        if(getHitPoint() < 0 ) {
            setDead(true);
            System.out.printf("モンスター%sは倒れた。\n", getName());
        }
    }
}