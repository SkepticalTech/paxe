/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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

    public Element output(Document doc) {
        Element main = doc.createElement("spawn");
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
}
