/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Smoker
 */
public class Decorator implements Mecha {
    protected Mecha mecha;
    
    public Decorator(Mecha m){
        this.mecha = m;
    }
    
    @Override
    public void equip(){
        this.mecha.equip();
    }
}
