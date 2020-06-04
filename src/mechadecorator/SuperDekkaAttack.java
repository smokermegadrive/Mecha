/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mechadecorator;
/**
 *
 * @author Smoker
 */
public class SuperDekkaAttack implements IAttack {
    
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
        return 17;
    }
    
    @Override
    public String toString() {
        return "Super Dekka";
    }
    
}
