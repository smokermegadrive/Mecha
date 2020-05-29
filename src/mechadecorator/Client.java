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

        Mecha mecha = createPlayerMecha();
        Mecha mecha2 = createEnemyMecha();

        while (mecha.estasVivo() && mecha2.estasVivo()) {
            menu(mecha);
            if (!mecha.estasVivo()) {
                continue;
            }
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

    private static Mecha createPlayerMecha() throws IOException {
        String[] arr = { "1", "2", "3" };
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Seleccione un tipo de Mecha: 1-Heavy, 2-Ninja, 3-Scopedog");
        String tipo = br.readLine();

        while (tipo.equals("") || !Arrays.asList(arr).contains(tipo)) {
            System.out.println("Seleccione un tipo valido");
            tipo = br.readLine();
        }
        Mecha mecha = MechaFactory.createMecha(tipo);

        System.out.println("Escriba su nombre");
        String nombre = br.readLine();

        while (nombre.equals("")) {
            System.out.println("Escribi un Nombre conchudo");
            nombre = br.readLine();
        }
        mecha.setName(nombre);

        return mecha;
    }

    private static Mecha createEnemyMecha() {
        String[] arr = { "SCOPEDOG", "NINJA", "HEAVY" };
        Random random = new Random();
        int select = random.nextInt(arr.length);

        return MechaFactory.createMecha(arr[select]);
    }
    
    private static void seleccionarAtaque(Mecha mecha) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Seleccione Ataque: 1-Punch, 2-Sword, 3-Super Deka");
        String ataque = br.readLine();
        
        while (!(ataque.equals("1") || ataque.equals("2") || ataque.equals("3"))) {
            System.out.println("Seleccione un comando valido del 1 al 4");
            ataque = br.readLine();
        }
                            
        switch (ataque) {
            case "1":
                mecha.setAttack(new PunchAttack());
                break;
            case "2":
                mecha.setAttack(new SwordAttack());
                break;
            case "3":
                mecha.setAttack(new SuperDekkaAttack());
                break;
            }
    }  
    
    private static void status(Mecha mecha) {
        System.out.println("HP: " + mecha.getHp());
        System.out.println("Ataque: " + mecha.getAttack());
        System.out.println("Defensa: " + mecha.getDefense());
    }
    
    private static void menu(Mecha mecha) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Seleccione comando 1-Atacar, 2-Cambiar ataque, 3-Status, 4-Rendirse");
            String comm = br.readLine();

            while (!(comm.equals("1") || comm.equals("2") || comm.equals("3") || comm.equals("4"))) {
                System.out.println("Seleccione un comando valido del 1 al 4");
                comm = br.readLine();
            }
            switch (comm) {
                case "1":
                    return;
                case "2":
                    seleccionarAtaque(mecha);
                    break;
                case "3":
                    status(mecha);
                    break;
                case "4":
                    mecha.setHp(0);
                    return;
                }
        }
    }
}
