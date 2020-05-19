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
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       /* Mecha sword = new Sword(new Base());
        sword.equip();
        System.out.println(" ");
        
        Mecha fullpower = new SuperDekka(new Sword(new Wings(new Base())));
        fullpower.equip();*/
       Mecha mecha = MechaFactory.createMecha("SCOPEDOG");
       Mecha mecha2 = MechaFactory.createMecha("NINJA");
       while (mecha.estasVivo() && mecha2.estasVivo()) {
        mecha.atacar(mecha2);
        System.out.println(mecha2.getName() + " Hp: " + mecha2.getHp());
        
        if (mecha2.estasVivo()) {
            mecha2.atacar(mecha);
            System.out.println(mecha.getName() + " Hp: " + mecha.getHp());
        }
        }
       
       if (!mecha.estasVivo()) {
           System.out.println(mecha.getName() + " derrotado");
       }
       
       if (!mecha2.estasVivo()) {
           System.out.println(mecha2.getName() + " derrotado");
       }
    }
    
}
