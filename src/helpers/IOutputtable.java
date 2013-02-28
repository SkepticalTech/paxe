package helpers;


import org.w3c.dom.Document;
import org.w3c.dom.Element;

/*
 * Interface for standardizing XML output
 */

public interface IOutputtable {
    //Doc = the XML document, elem = the element to hook the generated
    //XML onto
    public Element output(Document doc);
    
}
