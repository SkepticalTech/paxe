/*
 * Contains an array list and the logic for outputting xml
 * Used for section tags
 */

package core;

import helpers.IOutputtable;
import java.util.ArrayList;
import java.util.Iterator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ComplexList extends ArrayList implements IOutputtable {
    protected String tagname;
    
    public ComplexList(){
        super();
    }
    
    public ComplexList(String tagname){
        super();
        this.tagname = tagname;
    }
    
    public Element output(Document doc){
        Element main = doc.createElement(tagname);
        //Muahahahaha, foreach loop + polymorphism = I can be lazy
        for(Object obj : this){
           // IOutputtable out = (IOutputtable)obj;
            main.appendChild(((IOutputtable)obj).output(doc));
        } 
        return main;
    }

    /**
     * @return the tagname
     */
    public String getTagName() {
        return tagname;
    }

    /**
     * @param tagname the tagname to set
     */
    public void setTagName(String tagname) {
        this.tagname = tagname;
    }
}
