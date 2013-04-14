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

public class Cuboid extends Rectangle implements IOutputtable {

    protected Point min = new Point(true);
    protected Point max = new Point(true);
    
    public Cuboid(String name, int min_x, int min_y, int min_z, int max_x, int max_y, int max_z) {
        super(name);
        setMin(min_x, min_y, min_z);
        setMax(max_x, max_y, min_z);
    }
    
    public void setMin(int min_x, int min_y, int min_z){
        super.setMin(min_x, min_z);
        min.setY(min_y);
    }
    
    public void setMax(int max_x, int max_y, int max_z){
        super.setMin(max_x, max_y);
        max.setY(max_y);
    }
    
    public Element output(Document doc) {
        Element main = super.output(doc);
        doc.renameNode(main, null, "cuboid"); //easier to make and rename
        return main;
    }
    
}
