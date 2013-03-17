/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package region;

import helpers.IOutputtable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Cylinder extends Circle implements IOutputtable {
    protected int height = 0;
    
    public Cylinder(String name, int center_x, int center_y, int center_z, int radius, int height) {
        super(name);
        setCenter(center_x, center_y, center_z);
        setRadius(radius);
        setHeight(height);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    public void setCenter(int center_x, int center_y, int center_z){
        super.setCenter(center_x, center_z);
        center.setY(center_y);
    }
    
    public Element output(Document doc) {
        Element main = super.output(doc);
        main.setAttribute("height", String.valueOf(height));
        doc.renameNode(main, null, "cylinder"); //easier to make and rename
        return main;
    }
}
