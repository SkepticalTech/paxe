/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

import helpers.TNode;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Potion {

    protected String name;
    protected int duration, amplifier;

    public Potion(String name, int duration, int amplifier) {
        setName(name);
        setDuration(duration);
        setAmplifier(amplifier);
    }

    //slot = helmet, leggings, etc
    public Element output(Document doc) {
        TNode main = new TNode("potion", getName(), doc);
        main.setAttribute("duration", String.valueOf(duration));
        main.setAttribute("amplifier", String.valueOf(amplifier));
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
     * @return the duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * @return the amplifier
     */
    public int getAmplifier() {
        return amplifier;
    }

    /**
     * @param amplifier the amplifier to set
     */
    public void setAmplifier(int amplifier) {
        this.amplifier = amplifier;
    }
}
