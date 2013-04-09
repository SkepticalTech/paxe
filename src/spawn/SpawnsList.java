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
package spawn;

import helpers.ComplexList;
import helpers.IOutputtable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import region.Region;

public class SpawnsList<Spawn> extends ComplexList implements IOutputtable {
    private Region default_region;
    private int default_yaw;
    
    public SpawnsList(){
        super("spawns");
    }
    public SpawnsList(Region def_spawn, int def_yaw){
        this();
        setDefault_region(def_spawn);
        setDefault_yaw(def_yaw);
    }

    /**
     * @return the default_spawn
     */
    public Region getDefault_region() {
        return default_region;
    }

    /**
     * @param default_spawn the default_spawn to set
     */
    public void setDefault_region(Region default_region) {
        this.default_region = default_region;
    }

    /**
     * @return the default_yaw
     */
    public int getDefault_yaw() {
        return default_yaw;
    }

    /**
     * @param default_yaw the default_yaw to set
     */
    public void setDefault_yaw(int default_yaw) {
        this.default_yaw = default_yaw;
    }
    
    public Element output(Document doc){
        Element main = super.output(doc);
        Element dspawn = doc.createElement("default");
        dspawn.setAttribute("yaw", String.valueOf(default_yaw));
        dspawn.appendChild(default_region.output(doc));
        main.appendChild(dspawn);
        return main;
    }
    
}
