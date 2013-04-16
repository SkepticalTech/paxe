package info;

import helpers.*;
import org.w3c.dom.*;

/**
 * Describes an author/contributor. Stores the name and contribution (if
 * available). Uses a boolean value to determine whether the object is an author
 * or a contributor.
 *
 * @author Skeptical_Tech
 * @license Gnu Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Author implements IOutputtable {

    private String name;
    private String contribution;
    private Boolean contributor = false; //True if contributor, false if author

    /**
     * Creates an Author object with no contribution information listed. The
     * type is author and not contributor, since no boolean is supplied.
     *
     * @param name the name of the author
     */
    public Author(String name) {
        setName(name);
    }

    /**
     * Creates an Author or Contributor object with no contribution information
     * listed.
     *
     * @param name the name of the author
     * @param contributor <code>true</code> for a
     * contributor, <code>false</code> for an author
     */
    public Author(String name, Boolean contributor) {
        this(name);
        setContributor(contributor);
    }

    /**
     * Creates an Author object with contribution information. Object is an
     * author, because no boolean is supplied.
     *
     * @param name the name of the author
     * @param contribution the contribution of the author
     */
    public Author(String name, String contribution) {
        setName(name);
        setContribution(contribution);
    }

    /**
     * Creates an Author or Contributor object with contribution information.
     *
     * @param name the name of the author
     * @param contribution the contribution of the author
     * @param contributor <code>true</code> for a
     * contributor, <code>false</code> for an author
     */
    public Author(String name, String contribution, Boolean contributor) {
        this(name, contribution);
        setContributor(contributor);
    }

    /**
     * Returns the name of the Author/Contributor
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Author/Contributor
     * 
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the Author's/Contributor's contribution
     * 
     * @return the contribution
     */
    public String getContribution() {
        return contribution;
    }

    /**
     * Sets the Author's/Contributor's contribution
     * 
     * @param contribution the contribution to set
     */
    public void setContribution(String contribution) {
        this.contribution = contribution;
    }

    /**
     * Returns whether or not this is a Contributor rather than an Author.
     * 
     * @return <code>true</code> if it is a contributor object, <code>false</false> if it is an author
     */
    public Boolean isContributor() {
        return contributor;
    }

    /**
     * Sets whether or not this is a Contributor rather than an Author.
     * 
     * @param contributor <code>true</code> if it is a contributor object, <code>false</false> if it is an author
     */
    public void setContributor(Boolean contributor) {
        this.contributor = contributor;
    }

    /**
     * Returns an XML Element containing an XML representation of the Author/Contributor.
     * 
     * @param doc the Document to which this XML Element is being appended
     * @return the XML element containing the Author/Contributor's data
     */
    @Override
    public Element output(Document doc) {
        TNode main;
        String elem_name;
        
        //is this an author or contributor
        elem_name = (isContributor()) ? "contributor" : "author";
        main = new TNode(elem_name, getName(), doc);
        if (getContribution() != null) {
            main.tag.setAttribute("Contribution", getContribution());
        }
        return main.tag;
    }
}
