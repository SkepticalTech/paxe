/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package region;

import helpers.IOutputtable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Circle extends Region implements IOutputtable {

    protected Point center = new Point(false);
    protected int radius = 0;

    public Circle(String name){
        super(name);
    }
    
    public Circle(String name, int center_x, int center_z, int radius) {
        this(name);
        setCenter(center_x, center_z);
        setRadius(radius);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    public void setCenter(int center_x, int center_z){
        center.setX(center_x);
        center.setZ(center_z);
    }

    public Element output(Document doc) {
        Element main = doc.createElement("circle");
        main.setAttribute("name", name);
        main.setAttribute("center", center.toString());
        main.setAttribute("radius", String.valueOf(radius));
        return main;
    }
}
