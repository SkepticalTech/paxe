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
 * Used for both authors and contributors, as the information is the same
 */
package info;

import helpers.IOutputtable;
import helpers.TNode;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Author implements IOutputtable{

    private String name;
    private String contribution;
    private Boolean contributor = false; //True if contributor, false if author

    //If contributor boolean is ommited, assume it's an author
    public Author(String name, String contribution) {
        setName(name);
        setContribution(contribution);
    }

    public Author(String name, String contribution, Boolean contributor) {
        this(name, contribution);
        setContributor(contributor);
    }
    
    public Author(String name) {
        setName(name);
    }

    public Author(String name, Boolean contributor) {
        this(name);
        setContributor(contributor);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContribution() {
        return contribution;
    }

    public void setContribution(String contribution) {
        this.contribution = contribution;
    }

    public Boolean isContributor() {
        return contributor;
    }

    public void setContributor(Boolean contributor) {
        this.contributor = contributor;
    }
    //Generates xml and tacks it on to elem
    public Element output(Document doc){
        TNode main;
        String elemname;
        
        //is this an author or contributor
        elemname = (isContributor()) ? "contributor" : "author";
        main = new TNode(elemname, name, doc);
        if(contribution != null){
            main.tag.setAttribute("Contribution", contribution);
        }
        return main.tag;
        
    }
}
