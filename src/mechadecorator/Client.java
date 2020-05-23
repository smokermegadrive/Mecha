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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Mecha mecha = createPlayerMecha();
        Mecha mecha2 = createEnemyMecha();

        while (mecha.estasVivo() && mecha2.estasVivo()) {
            mecha.atacar(mecha2);
            System.out.println(mecha2.getName() + " Hp: " + mecha2.getHp());

            if (mecha2.estasVivo()) {
                mecha2.atacar(mecha);
                System.out.println(mecha.getName() + " Hp: " + mecha.getHp());
                }
            
            if (mecha.estasVivo() && mecha2.estasVivo()) {
                System.out.println("Seleccione Ataque: 1-Punch, 2-Sword, 3-Super Deka");
                String ataque = br.readLine();

                boolean lel = false;

                do {
                    switch (ataque) {
                        case "1":
                            mecha.setAttack(new PunchAttack());
                            lel = true;
                            break;
                        case "2":
                            mecha.setAttack(new SwordAttack());
                            lel = true;
                            break;
                        case "3":
                            mecha.setAttack(new SuperDekkaAttack());
                            lel = true;
                            break;
                        default:
                            System.out.println("Escriba del 1 al 3, Seleccione ataque valido");
                            ataque = br.readLine();
                    }
                } while (lel == false);
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

}
