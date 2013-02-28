/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package region;

import helpers.IOutputtable;
import helpers.TNode;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Region implements IOutputtable {

    protected String name;

    
    public Region(String name){
        setName(name);
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

    public Element output(Document doc) {
        return outputRef(doc);
    }
    //Just return the <region name="..." for all child objects when 
    //a reference is needed
    public Element outputRef(Document doc){
        Element main = doc.createElement("region");
        main.setAttribute("name", name);
        return main;
    }
}
