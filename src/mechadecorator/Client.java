/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mechadecorator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Smoker
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
       /* Mecha sword = new Sword(new Base());
        sword.equip();
        System.out.println(" ");
        
        Mecha fullpower = new SuperDekka(new Sword(new Wings(new Base())));
        fullpower.equip();*/
       String [] arr = {"SCOPEDOG", "NINJA", "HEAVY"};
       Random random = new Random();
       int select = random.nextInt(arr.length);
       
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       System.out.println("Escriba tipo de mecha");
       String tipo = br.readLine();
       
       while (tipo.equals("") || !Arrays.asList(arr).contains(tipo)) {
           System.out.println("Seleccione un tipo valido");
           tipo = br.readLine();
       }
       
       Mecha mecha = MechaFactory.createMecha(tipo);
       Mecha mecha2 = MechaFactory.createMecha(arr[select]);
       
       System.out.println("Escriba su nombre");
       String nombre = br.readLine();
       mecha.setName(nombre);
       
       while (mecha.estasVivo() && mecha2.estasVivo()) {
        mecha.atacar(mecha2);
        System.out.println(mecha2.getName() + " Hp: " + mecha2.getHp());
        
        if (mecha2.estasVivo()) {
            mecha2.atacar(mecha);
            System.out.println(nombre + " Hp: " + mecha.getHp());
        }
        }
       
       if (!mecha.estasVivo()) {
           System.out.println(nombre + " derrotado");
       }
       
       if (!mecha2.estasVivo()) {
           System.out.println(mecha2.getName() + " derrotado");
       }
    }
    
}
