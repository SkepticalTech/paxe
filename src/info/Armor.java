/*
 * Copyright (C) 2013 Skeptical_Tech
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
