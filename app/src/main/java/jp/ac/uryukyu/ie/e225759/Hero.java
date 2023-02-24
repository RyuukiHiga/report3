package jp.ac.uryukyu.ie.e225759;

/**
 * ヒーロークラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Hero extends LiveThing{
        /**
     * ヒーローの名前を変更するメソッド。
     * 引数をヒーロークラスの名前に入れる
     * @param heroname 設定したいヒーローの名前
     * @return ヒーローの名前
     */
    public void setName(String heroname){
        this.name = heroname;
    }
    /**
     * ヒーローのhpを取得するメソッド。
     * setHitPointで入れたhpが出力される
     * @return ヒーローのhp
     */
    public int getHitPoint(){
        return this.hitPoint;
    }
    /**
     * ヒーローのhpを変更するメソッド。
     * 引数をヒーロークラスのhitPointに入れる
     * @param maximumHP 設定したいヒーローのhp
     * @return ヒーローのhp
     */
    public void setHitPoint(int maximumHP){
        this.hitPoint = maximumHP;
    }
    /**
     * ヒーローの攻撃力を取得するメソッド。
     * setAttackで入れた攻撃力が出力される
     * @return ヒーローの攻撃力
     */
    public int getAttack(){
        return this.attack;
    }
    /**
     * ヒーローの攻撃力を変更するメソッド。
     * 引数をヒーロークラスのattackに入れる
     * @param attack 設定したいヒーローの攻撃力
     * @return ヒーローの攻撃力
     */
    public void setAttack(int attack){
        this.attack = attack;
    }

    /**
     * ヒーローの生死状態を変更するメソッド。
     * 引数を敵クラスのdeadに入れる
     * @param dead ヒーローの生死状態がどんなか
     * @return ヒーローの生死状態
     */
    public void setDead(boolean dead){
        this.dead = dead;
    }

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name ヒーロー名
     * @param maximumHP ヒーローのHP
     * @param attack ヒーローの攻撃力
     */
    public Hero (String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
        setName(name);
        setHitPoint(maximumHP);
        setAttack(attack);
        setDead(false);
        //this.name = name;
        //this.hitPoint = maximumHP;
        //this.attack = attack;
        //this.dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n",super.getName(), getHitPoint(), attack);
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
        

        if( getHitPoint() < 0 ) {
            setDead(true);
            System.out.printf("勇者%sは道半ばで力尽きてしまった。\n",super.getName());
        }
    }
}