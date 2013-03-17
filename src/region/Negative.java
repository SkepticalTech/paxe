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
import org.w3c.dom.Document;
import org.w3c.dom.Element;

//Does not inherit region, it only uses the references
public class Negative implements IOutputtable {
    protected Region region;
    
    public Negative(Region reg){
        region = reg;
    }
    
    public Element output(Document doc){
        Element main = doc.createElement("negative");
        main.appendChild(region.outputRef(doc));
        return main;
    }
}
