/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package info;

import helpers.TNode;
import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Item {     protected String name;
    protected String visiblename;
//Does not implement IOutputtable, because it needs the slot # passed to it's output routine
    protected String lore;
    protected int damage;
    protected int amount = 1;
    public ArrayList<Enchantment> enchantments = new ArrayList<Enchantment>();
    
    public Item(String name){
        setName(name);
    }
    
    public Element output(Document doc, int slot){
        TNode main = new TNode("item", getName(), doc);
        main.setAttribute("slot", String.valueOf(slot));
        if(getVisiblename() != null){
            main.setAttribute("name", getVisiblename());
        }
        if(getLore() != null){
            main.setAttribute("lore", getLore());
        }
        if(getAmount() > 1){
            main.setAttribute("amount", String.valueOf(getAmount()));
        }
        if (!enchantments.isEmpty()){
            String enchstr = "";
            for(int i = 0; i < enchantments.size() - 1; i++){
                //Build string first
                enchstr += enchantments.get(i).output() + ";";
            }
            //Add last enchantment with no semicolon
            enchstr += enchantments.get(enchantments.size() - 1).output();
            main.setAttribute("enchantment", enchstr);
        }
        
        return main.tag;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the visiblename
     */
    public String getVisiblename() {
        return visiblename;
    }

    /**
     * @return the lore
     */
    public String getLore() {
        return lore;
    }

    /**
     * @param lore the lore to set
     */
    public void setLore(String lore) {
        this.lore = lore;
    }

    /**
     * @return the damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * @param damage the damage to set
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set, will set negative or 0 values to 1
     */
    public void setAmount(int amount) {
        if(amount <= 1){
            this.amount = 1;
        }
        else {
            this.amount = amount;
        }
    }
    
}
