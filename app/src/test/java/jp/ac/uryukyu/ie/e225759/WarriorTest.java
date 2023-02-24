package jp.ac.uryukyu.ie.e225759;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {
    @Test 
    void warriorTest() {
        int defaultWarriorHp = 100;
        Warrior demoWarrior = new Warrior("デモ勇者", defaultWarriorHp, 100);
        Enemy slime = new Enemy("スライムもどき", 450, 100);
        int attackWithWeponSkillTime = 0;

        for(int count=0; count<3; count++){
            
            demoWarrior.attackWithWeponSkill(slime); // over kill
            attackWithWeponSkillTime = attackWithWeponSkillTime + 1;
            
        }

        assertEquals(defaultWarriorHp, demoWarrior.getHitPoint());
        assertEquals(3,attackWithWeponSkillTime);
        assertEquals(0,slime.hitPoint);
    }
}