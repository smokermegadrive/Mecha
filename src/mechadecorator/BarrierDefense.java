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
public class BarrierDefense implements IDefense {
    @Override
    public int defend(int damage) {
        return Math.max(0, damage - this.def());
    }

    @Override
    public int def() {
        return 10;
    }
}
