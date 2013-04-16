package core;

import helpers.*;
import info.*;
import gui.*;
import region.*;
import spawn.*;
import filters.*;
import com.thoughtworks.xstream.*;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * The main map class, representing the entire PGM map as a Java data structure.
 * Data acquired from a GUI (or other) source can be stored here, and outputted
 * as properly formatted XML.
 *
 * @author Skeptical_Tech
 * @license Gnu Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Map {

    private String name, objective, version, PGMVersion;
    public ComplexList<Author> authors;
    public ComplexList<Author> contributors;
    public ComplexList<Rule> rules;
    public ComplexList<Team> teams;
    public ComplexList<Kit> kits;
    //TODO: priority queue for regions, need to put multiregion constructs after regular regions
    public ComplexList<Region> regions;
    public ComplexList<Filter> filters;
    public ComplexList<Spawn> spawns;
    public ComplexList<Portal> portals;
    private Element root;

    /**
     * Constructs a Map object. The various ComplexLists represent major XML
     * elements.
     */
    public Map() {
        authors = new ComplexList<>("authors");
        contributors = new ComplexList<>("contributors");
        rules = new ComplexList<>("rules");
        teams = new ComplexList<>("teams");
        kits = new ComplexList<>("kits");
        regions = new ComplexList<>("regions");
        filters = new ComplexList<>("filters");
        spawns = new ComplexList<>("spawns");
        portals = new ComplexList<>("portals");
    }

    /**
     * Constructs a map object and assigns a name.
     *
     * @param name The name of the map
     */
    public Map(String name) {
        this();
        setName(name);
    }

    /**
     * Returns the name of the map.
     *
     * @return the name of the map.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the map.
     *
     * @param name the name of the map
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the map objective.
     * 
     * @return the objective
     */
    public String getObjective() {
        return objective;
    }
    
    /**
     * Sets the map objective
     * 
     * @param objective the objective
     */
    public void setObjective(String objective) {
        this.objective = objective;
    }

    /**
     * Returns the version of the map.
     * 
     * @return the version of the map (as a string)
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the version of the map.
     * 
     * @param version the version of the map (as a string)
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * Returns the version of the PGM plugin this map is intended to run on.
     * 
     * @return the PGM plugin version
     */
    public String getPGMVersion() {
        return PGMVersion;
    }

    /**
     * Sets the version of the PGM plugin this map is intended to run on.
     * 
     * @param PGMVersion the PGM plugin version
     */
    public void setPGMVersion(String PGMVersion) {
        this.PGMVersion = PGMVersion;
    }

    //Calls the output() of the given Complex List if it is not empty
    private void outputIfPopulated(ComplexList list, Document doc, Element elem) {
        if (!list.isEmpty()) {
            elem.appendChild(list.output(doc));
        }
    }
    
    /**
     * The main XML generation method. It turns the object into PGM-compatible
     * XML (as a string), calling the output methods of it's child ComplexLists.
     * 
     * @param loc the file path to output the XML to
     */
    public void output(String loc) {
        try {
            DocumentBuilderFactory doc_factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder doc_builder = doc_factory.newDocumentBuilder();
            Document doc = doc_builder.newDocument();

            root = doc.createElement("map");
            root.setAttribute("proto", getPGMVersion());
            //Insert info about how this was created
            root.appendChild(doc.createComment("Generated by " + PAXE.program_name + " " + PAXE.version));

            root.appendChild(new TNode("name", getName(), doc).tag);
            root.appendChild(new TNode("version", getVersion(), doc).tag);
            root.appendChild(new TNode("objective", getObjective(), doc).tag);
            outputIfPopulated(authors, doc, root);
            outputIfPopulated(contributors, doc, root);
            outputIfPopulated(rules, doc, root);
            outputIfPopulated(teams, doc, root);
            outputIfPopulated(kits, doc, root);
            outputIfPopulated(regions, doc, root);
            outputIfPopulated(filters, doc, root);
            outputIfPopulated(spawns, doc, root);
            outputIfPopulated(portals, doc, root);

            doc.appendChild(root);

            //output
            //set up a transformer
            Transformer trans = TransformerFactory.newInstance().newTransformer();
            trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");

            //create string from xml tree
            StringWriter sw = new StringWriter();
            trans.transform(new DOMSource(doc), new StreamResult(sw));

            //write to file
            PrintWriter pw = new PrintWriter(new File(loc));
            pw.print(sw.toString());
            pw.close();


        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (Exception e) {
            System.out.println(e); //TODO better error handling
        }
    }
    
    /**
     * Converts the Map object into a serialized XML string.
     * This does not generate the PGM compatible XML, it is just for saving and
     * loading purposes
     * 
     * @return the map as a serialized XML string
     */
    public String serializeXml() {
        return new XStream(new StaxDriver()).toXML(this);
    }
}
