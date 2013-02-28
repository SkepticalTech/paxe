/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spawn;

import info.Armor;
import helpers.IOutputtable;
import info.Item;
import info.Potion;
import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Kit implements IOutputtable {

    protected String name = "spawn"; //default name
    protected Item[] inventory = new Item[35]; //Ok to use array here, fixed size inventory
    protected Armor helmet, chestplate, leggings, boots;
    protected ArrayList<Potion> potions = new ArrayList<Potion>();
    protected ArrayList<Kit> parents = new ArrayList<Kit>(); // list of parent kits

    public Kit() {
    }

    public Kit(String name) {
        setName(name);
    }

    public Element output(Document doc) {
        Element main = doc.createElement("kit");
        main.setAttribute("name", name);
        if (!parents.isEmpty()) {
            String parent_string = "";
            for (int i = 0; i < parents.size() - 1; i++) {
                parent_string += parents.get(i).getName() + ";";
            }
            parent_string += parents.get(parents.size() - 1).getName();
            main.setAttribute("parents", parent_string);
        }
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null) {
                main.appendChild(inventory[i].output(doc, i));
            }
        }
        if (helmet != null) {
            main.appendChild(helmet.output(doc, "helmet"));
        }
        if (chestplate != null) {
            main.appendChild(chestplate.output(doc, "chestplate"));
        }
        if (leggings != null) {
            main.appendChild(leggings.output(doc, "leggings"));
        }
        if (boots != null) {
            main.appendChild(boots.output(doc, "boots"));
        }
        if (!potions.isEmpty()) {
            for (Potion pot : potions) {
                main.appendChild(pot.output(doc));
            }
        }
        return main;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to setItem
     */
    public void setName(String name) {
        this.name = name;
    }
     public void addParent(Kit parent) {
        parents.add(parent);
    }
     
    public void setParent(int slot, Kit Parent){
        parents.set(slot, Parent);
    }

    public void removeParent(int slot) {
        parents.remove(slot);
    }

    public Kit getParent(int slot) {
        return parents.get(slot);
    }

    public void setItem(int slot, Item item) {
        inventory[slot] = item;
    }

    public void removeItem(int slot) {
        inventory[slot] = null;
    }

    public Item getItem(int slot) {
        return inventory[slot];
    }

    public void addPotion(Potion pot) {
        potions.add(pot);
    }

    public void setPotion(int slot, Potion pot) {
        potions.set(slot, pot);
    }

    public void removePotion(int slot) {
        potions.remove(slot);
    }

    public Potion getPotion(int slot) {
        return potions.get(slot);
    }

    /**
     * @return the helmet
     */
    public Armor getHelmet() {
        return helmet;
    }

    /**
     * @param helmet the helmet to setItem
     */
    public void setHelmet(Armor helmet) {
        this.helmet = helmet;
    }

    /**
     * @return the chestplate
     */
    public Armor getChestplate() {
        return chestplate;
    }

    /**
     * @param chestplate the chestplate to setItem
     */
    public void setChestplate(Armor chestplate) {
        this.chestplate = chestplate;
    }

    /**
     * @return the leggings
     */
    public Armor getLeggings() {
        return leggings;
    }

    /**
     * @param leggings the leggings to setItem
     */
    public void setLeggings(Armor leggings) {
        this.leggings = leggings;
    }

    /**
     * @return the boots
     */
    public Armor getBoots() {
        return boots;
    }

    /**
     * @param boots the boots to setItem
     */
    public void setBoots(Armor boots) {
        this.boots = boots;
    }
}
