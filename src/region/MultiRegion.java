/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package region;

import helpers.IOutputtable;
import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class MultiRegion extends ArrayList<Region> implements IOutputtable {

    protected String name; 
    protected String type = "union"; //Type = union, complement, intersect

    public MultiRegion(String name, String type) {
        setName(name);
        setType(type);
    }

    //Single inheritance only, so have to rewrite this, worth it for ArrayList features
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Element output(Document doc) {
        Element main = doc.createElement(type);
        if (!isEmpty()) {
            for (Region reg : this) {
                main.appendChild(reg.outputRef(doc));
            }
        }
        return main;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
