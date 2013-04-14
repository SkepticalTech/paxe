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

package region;

import helpers.IOutputtable;
import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class MultiRegion extends ArrayList<Region> implements IOutputtable {

    protected String name; 
    protected String type = "union"; //Type = union, complement, intersect

    public MultiRegion(String name, String type) {
        setName(name);
        setType(type);
    }

    //Single inheritance only, so have to rewrite this, worth it for ArrayList features
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Element output(Document doc) {
        Element main = doc.createElement(type);
        if (!isEmpty()) {
            for (Region reg : this) {
                main.appendChild(reg.outputRef(doc));
            }
        }
        return main;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
