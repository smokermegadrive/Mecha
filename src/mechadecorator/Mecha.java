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
public class Mecha {
    
    String name;
    IAttack attack;
    IDefense defense;
    int hp;
    
    public Mecha(String name, IAttack attack, IDefense defense, int hp){
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.hp = hp;
    }
    
    public boolean estasVivo(){
        return this.hp > 0;
    }
    
    public void atacar(Mecha target) {
        System.out.println(this.name + " " + "Attack!");
        this.attack.attack(target);
    }
    
    public void defender(int damage) {
        //this.defense.defend(damage);
        int damaje = this.defense.defend(damage);
        this.setHp(this.hp - damaje);
        System.out.println(this.name + " recibio: " + damaje);
    }
    
    //--------------------------------------------------------------------------
    //get y set
    
    public IAttack getAttack() {
        return attack;
    }

    public void setAttack(IAttack attack) {
        this.attack = attack;
    }

    public IDefense getDefense() {
        return defense;
    }

    public void setDefense(IDefense defense) {
        this.defense = defense;
    }
    
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
