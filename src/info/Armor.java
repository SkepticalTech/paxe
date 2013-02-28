/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

import helpers.TNode;
import java.util.ArrayList;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Armor {

    protected String name;
    protected String visiblename;
//Does not implement IOutputtable, because it needs the slot # passed to it's output routine
    protected String lore;
    protected int duration;
    public ArrayList<Enchantment> enchantments = new ArrayList<Enchantment>();

    public Armor(String name) {
        setName(name);
    }

    //slot = helmet, leggings, etc
    public Element output(Document doc, String slot) {
        String realslot = slot.toLowerCase();
        TNode main = new TNode(realslot, getName(), doc);
        if (realslot == "helmet" || realslot == "chestplate" || realslot == "leggings" || realslot == "boots") {
            if (getVisiblename() != null) {
                main.setAttribute("name", getVisiblename());
            }
            if (getLore() != null) {
                main.setAttribute("lore", getLore());
            }
            if (!enchantments.isEmpty()) {
                String enchstr = "";
                for (int i = 0; i < enchantments.size() - 1; i++) {
                    //Build string first
                    enchstr += enchantments.get(i).output() + ";";
                }
                //Add last enchantment with no semicolon
                enchstr += enchantments.get(enchantments.size() - 1).output();
                main.setAttribute("enchantment", enchstr);
            }

            return main.tag;
        }
        //If invalid, return tag to say so
        //TODO: Proper error handling
        Comment com = doc.createComment(realslot + " is not a type of armor");
        main.tag.appendChild(com);
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
     * @return the duration
     */
    public int getDamage() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDamage(int damage) {
        this.duration = damage;
    }
}
