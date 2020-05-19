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
public class NoDefense implements IDefense {
    @Override
    public int defend(int damage) {
        return damage - this.def();
    }
    @Override
    public int def() {
        return 5;
    }
}
