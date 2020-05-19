/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Smoker
 */
public class SuperDekka extends Decorator {
    public SuperDekka(Mecha m) {
        super(m);
    }
    
    @Override
    public void equip() {
        super.equip();
        System.out.print("Super Dekka Equipped. ");
    }
}
