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
public class ShieldDefense implements IDefense {
    @Override
    public int defend(int damage) {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 100 + 1);
        
        if (randomNum <= 5) {
            System.out.println("Se ha cubierto rapidamente con el escudo y recibe la mitad de daño");
            return Math.max(0, (damage - this.def()) / 2);
        }
        
        return Math.max(0, damage - this.def());
    }

    @Override
    public int def() {
        return 5;
    }
}
