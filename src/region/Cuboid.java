/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package region;

import helpers.IOutputtable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Cuboid extends Rectangle implements IOutputtable {

    protected Point min = new Point(true);
    protected Point max = new Point(true);
    
    public Cuboid(String name, int min_x, int min_y, int min_z, int max_x, int max_y, int max_z) {
        super(name);
        setMin(min_x, min_y, min_z);
        setMax(max_x, max_y, min_z);
    }
    
    public void setMin(int min_x, int min_y, int min_z){
        super.setMin(min_x, min_z);
        min.setY(min_y);
    }
    
    public void setMax(int max_x, int max_y, int max_z){
        super.setMin(max_x, max_y);
        max.setY(max_y);
    }
    
    public Element output(Document doc) {
        Element main = super.output(doc);
        doc.renameNode(main, null, "cuboid"); //easier to make and rename
        return main;
    }
    
}
