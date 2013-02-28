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
