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

public class Rectangle extends Region implements IOutputtable {
    protected Point min = new Point(false);
    protected Point max = new Point(false);
    
    public Rectangle(String name){
        super(name);
    }
    
    public Rectangle(String name, int min_x, int min_z, int max_x, int max_z) {
        this(name);
        setMin(min_x, min_z);
        setMax(max_x, max_z);
    }
    
    public void setMin(int min_x, int min_z){
        min.setX(min_x);
        min.setZ(min_z);
    }
    
    public void setMax(int max_x, int max_z){
        max.setX(max_x);
        max.setZ(max_z);
    }
    
    public Element output(Document doc) {
        Element main = doc.createElement("rectangle");
        main.setAttribute("name", name);
        main.setAttribute("min", min.toString());
        main.setAttribute("max", max.toString());
        return main;
    }
    
}
