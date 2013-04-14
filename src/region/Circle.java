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

public class Circle extends Region implements IOutputtable {

    protected Point center = new Point(false);
    protected int radius = 0;

    public Circle(String name){
        super(name);
    }
    
    public Circle(String name, int center_x, int center_z, int radius) {
        this(name);
        setCenter(center_x, center_z);
        setRadius(radius);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    public void setCenter(int center_x, int center_z){
        center.setX(center_x);
        center.setZ(center_z);
    }

    public Element output(Document doc) {
        Element main = doc.createElement("circle");
        main.setAttribute("name", name);
        main.setAttribute("center", center.toString());
        main.setAttribute("radius", String.valueOf(radius));
        return main;
    }
}
