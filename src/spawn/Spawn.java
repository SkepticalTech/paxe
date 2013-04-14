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

import helpers.IOutputtable;
import info.Team;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import region.Region;

public class Spawn implements IOutputtable {

    private int yaw;
    private Team team;
    private Kit kit;
    private Region region;
    private boolean safe;
    
    public Spawn(){
        
    }

    public Element output(Document doc) {
        Element main = doc.createElement("spawn");
        if(safe){
            main.setAttribute("safe", "true");
        }
        if (team != null) {
            main.setAttribute("team", team.getName());
        }
        if (kit != null) {
            main.setAttribute("kit", kit.getName());
        }
        main.setAttribute("yaw", String.valueOf(yaw));
        return main;
    }

    /**
     * @return the yaw
     */
    public int getYaw() {
        return yaw;
    }

    /**
     * @param yaw the yaw to set
     */
    public void setYaw(int yaw) {
        this.yaw = yaw;
    }

    /**
     * @return the team
     */
    public Team getTeam() {
        return team;
    }

    /**
     * @param team the team to set
     */
    public void setTeam(Team team) {
        this.team = team;
    }

    /**
     * @return the kit
     */
    public Kit getKit() {
        return kit;
    }

    /**
     * @param kit the kit to set
     */
    public void setKit(Kit kit) {
        this.kit = kit;
    }

    /**
     * @return the region
     */
    public Region getRegion() {
        return region;
    }

    /**
     * @param region the region to set
     */
    public void setRegion(Region region) {
        this.region = region;
    }

    /**
     * @return the safe
     */
    public boolean isSafe() {
        return safe;
    }

    /**
     * @param safe the safe to set
     */
    public void setSafe(boolean safe) {
        this.safe = safe;
    }
}
