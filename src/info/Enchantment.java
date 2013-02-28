/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package info;

public class Enchantment { //does not implement IOutputtable, as it is not
    //a separate tag, just an attribute
    protected String name;
    protected int level;
    
    public Enchantment(){
        
    }
    public Enchantment(String name, int level){
        setName(name);
        setLevel(level);
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
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }
    //Returns a formatted string for inclusion in an attribute
    public String output(){
        return name + ":" + level;
    }

}
