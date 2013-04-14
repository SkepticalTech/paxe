/*
 * Copyright (C) 2013 Skeptical_Tech
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * Contains an array list and the logic for outputting xml
 * Used for section tags
 */

package helpers;

import helpers.*;
import java.util.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ComplexList<T> extends ArrayList<T> implements IOutputtable {
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
