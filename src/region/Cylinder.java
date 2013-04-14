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

public class Cylinder extends Circle implements IOutputtable {
    protected int height = 0;
    
    public Cylinder(String name, int center_x, int center_y, int center_z, int radius, int height) {
        super(name);
        setCenter(center_x, center_y, center_z);
        setRadius(radius);
        setHeight(height);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    public void setCenter(int center_x, int center_y, int center_z){
        super.setCenter(center_x, center_z);
        center.setY(center_y);
    }
    
    public Element output(Document doc) {
        Element main = super.output(doc);
        main.setAttribute("height", String.valueOf(height));
        doc.renameNode(main, null, "cylinder"); //easier to make and rename
        return main;
    }
}
