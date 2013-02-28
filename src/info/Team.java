/*
 * Used for both authors and contributors, as the information is the same
 */
package info;

import helpers.IOutputtable;
import helpers.TNode;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Team implements IOutputtable {

    protected String name;
    protected String color;
    protected int max = 50; //default is 50 players

   public Team(String name, String color, int max){
       setName(name);
       setColor(color);
       setMax(max);
   }
    
    //Generates xml
    public Element output(Document doc) {
        TNode main;

        main = new TNode("team", name, doc);
        main.setAttribute("color", color);
        main.setAttribute("max", String.valueOf(max));
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
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the max
     */
    public int getMax() {
        return max;
    }

    /**
     * @param max the max to set
     */
    public void setMax(int max) {
        this.max = max;
    }
}
