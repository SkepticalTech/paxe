/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package region;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Circle extends Region {

    protected Point center;
    protected int radius;

    public Circle(String name, int base_x, int base_y, int radius) {
        super(name);
        center = new Point(base_x, base_y);
        setRadius(radius);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Element output(Document doc) {
        Element main = doc.createElement("circle");
        main.setAttribute("name", name);
        main.setAttribute("base", center.toString());
        main.setAttribute("radius", String.valueOf(radius));
        return main;
    }
}
