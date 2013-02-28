/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package helpers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class TNode {
    public Element tag;
    public Text content;
    
    public TNode(String name, String cont, Document doc){
        tag = doc.createElement(name);
        content = doc.createTextNode(cont);
        tag.appendChild(content);
    }
    public void setAttribute(String attrib, String value){
        tag.setAttribute(attrib, value);
    }
}
