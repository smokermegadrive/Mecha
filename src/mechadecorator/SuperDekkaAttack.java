/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mechadecorator;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Smoker
 */
public class SuperDekkaAttack implements IAttack {
    int attk = 20;
    
    @Override
    public void attack(Mecha enemigo) {
        System.out.println("Super Dekka Shoot");
        if (enemigo.hp <= 45) {
          enemigo.defender((int) Math.round(this.atk() * 2));
        } else {
          enemigo.defender(this.atk());
        }
    }
    @Override
       public int atk() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 100 + 1);
        
        if (randomNum <= 25) {
            System.out.println("Critical Hit");
            return attk * 2;
        }
        
        return attk;
    }
    
    @Override
    public String toString() {
        return "Super Deka";
    }
    
}
