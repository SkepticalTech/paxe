/*
 * The main map class, holds all of the information needed to make the map.xml
 */
package core;

import info.Author;
import helpers.TNode;
import info.Team;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import spawn.Kit;

public class Map {

    public String name, objective, version, protocol;
    public ComplexList authors, contributors, rules, teams, kits;
    public ComplexList filters, regions, spawns, portals;
    public Element root;
    //rules, teams;

    public Map() {
        authors = new ComplexList("authors");
        contributors = new ComplexList("contributors");
        rules = new ComplexList("rules");
        teams = new ComplexList("teams");
        kits = new ComplexList("kits");
        regions = new ComplexList("regions");
        filters = new ComplexList("filters");
        spawns = new ComplexList("spawns");
        portals = new ComplexList("portals");

    }
    //Calls the output() of the given Complex List if it is not empty

    private void outputIfPopulated(ComplexList li, Document doc, Element elem) {
        if (!li.isEmpty()) {
            elem.appendChild(li.output(doc));
        }
    }
    //Starts the xml writing process, and spits it out to a file

    public void output(String loc) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            root = doc.createElement("map");
            root.setAttribute("proto", protocol);
            //Insert info about how this was created
            root.appendChild(doc.createComment("Generated by " + PAXE.program_name + " " + PAXE.version));

            root.appendChild(new TNode("name", name, doc).tag);
            root.appendChild(new TNode("version", version, doc).tag);
            root.appendChild(new TNode("objective", objective, doc).tag);
            outputIfPopulated(authors, doc, root);
            outputIfPopulated(contributors, doc, root);
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
            System.out.println(e);
        }
    }
}
