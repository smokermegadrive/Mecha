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
public class BarrierDefense implements IDefense {
    @Override
    public int defend(int damage) {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 100 + 1);
        
        if (randomNum <= 2) {
            System.out.println("Barrera absorbio el ataque");
            return 0;
        }
        
        return Math.max(0, damage - this.def());
    }

    @Override
    public int def() {
        return 10;
    }
    
    @Override
    public String toString() {
        return "Barrera";
    }
}
