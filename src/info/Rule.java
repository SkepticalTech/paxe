/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

import helpers.IOutputtable;
import helpers.TNode;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Rule implements IOutputtable {

    protected String text;

    public Rule(String txt) {
        setText(txt);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Element output(Document doc) {
        return new TNode("rule", getText(), doc).tag;
    }
}