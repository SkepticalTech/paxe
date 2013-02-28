package core;

import info.Armor;
import info.Author;
import info.Enchantment;
import info.Item;
import info.Potion;
import info.Team;
import region.Circle;
import region.Region;
import spawn.Kit;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
public class PAXE {

    public static final String version = "0.0.1";
    public static final String program_name = "PAXE";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map neato = new Map();
        neato.name = "Sample Map";
        neato.objective = "Do something or other";
        neato.version = "9001";
        neato.protocol = "0.0.0";

        neato.authors.add(new Author("Fred Flintstone", "Yabadadadoo"));
        neato.contributors.add(new Author("Chuck Norris", true));
        neato.teams.add(new Team("Polka Dots", "Purple", 50));
        neato.teams.add(new Team("Plaid", "Red", 50));

        Kit spawn = new Kit("Spawn");
        spawn.setItem(0, new Item("Stone sword"));
        spawn.setHelmet(new Armor("Iron Helmet"));
        spawn.addPotion(new Potion("fast digging", 1200, 2));
        spawn.getItem(0).enchantments.add(new Enchantment("knockback", 1));
        spawn.getItem(0).enchantments.add(new Enchantment("durability", 3));
        neato.kits.add(spawn);

        Kit red_team = new Kit("Red Team");
        red_team.addParent(spawn);
        red_team.setItem(1, new Item("Red Item"));
        
        Kit blue_team = new Kit("Blue Team");
        blue_team.addParent(spawn);
        blue_team.setItem(1, new Item("Blue Item"));
        

        neato.kits.add(red_team);
        neato.kits.add(blue_team);
        
        neato.regions.add(new Region("Region1"));
        neato.regions.add(new Circle("Circle1", 5, 4, 10));
        neato.output("output.xml");
    }
}
