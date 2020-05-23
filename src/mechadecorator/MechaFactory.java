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
public class MechaFactory {
    public static Mecha createMecha(String criteria) {
        if (criteria.equalsIgnoreCase("1") || criteria.equalsIgnoreCase("HEAVY")) {
            return new Mecha(criteria ,new SuperDekkaAttack(), new BarrierDefense(), 125);
        }
        else if (criteria.equalsIgnoreCase("2") || criteria.equalsIgnoreCase("NINJA")) {
            return new Mecha(criteria ,new SwordAttack(), new NoDefense(), 90); 
        }
        else if (criteria.equalsIgnoreCase("3") || criteria.equalsIgnoreCase("SCOPEDOG")) {
            return new Mecha(criteria, new PunchAttack(), new ShieldDefense(), 100);
        }
        return null;
    }
}
