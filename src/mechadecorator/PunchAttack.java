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
public class PunchAttack implements IAttack {
    
    @Override
    public void attack(Mecha enemigo) {
        System.out.println("Vardios Punch");
        enemigo.defender(this.atk());
    }
   
    @Override
    public int atk() {
        return 10;
    }
    @Override
    public String toString() {
        return "Vardios Punch";
    }
}
