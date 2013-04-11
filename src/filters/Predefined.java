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
package filters;

public class Predefined extends Filter{
    //The text value of the string
    private String value;
    
    //Boolean values for allowed/denied/unset 
    //true = allowed, false = denied, null = unset
    private Boolean player_access, block_place, block_break,
            world_transform, player_spawn, entities, mob_spawn;

    public Predefined(String val) {
        this.value = val;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return the player_access
     */
    public Boolean getPlayer_access() {
        return player_access;
    }

    /**
     * @param player_access the player_access to set
     */
    public void setPlayer_access(Boolean player_access) {
        this.player_access = player_access;
    }

    /**
     * @return the block_place
     */
    public Boolean getBlock_place() {
        return block_place;
    }

    /**
     * @param block_place the block_place to set
     */
    public void setBlock_place(Boolean block_place) {
        this.block_place = block_place;
    }

    /**
     * @return the block_break
     */
    public Boolean getBlock_break() {
        return block_break;
    }

    /**
     * @param block_break the block_break to set
     */
    public void setBlock_break(Boolean block_break) {
        this.block_break = block_break;
    }

    /**
     * @return the world_transform
     */
    public Boolean getWorld_transform() {
        return world_transform;
    }

    /**
     * @param world_transform the world_transform to set
     */
    public void setWorld_transform(Boolean world_transform) {
        this.world_transform = world_transform;
    }

    /**
     * @return the player_spawn
     */
    public Boolean getPlayer_spawn() {
        return player_spawn;
    }

    /**
     * @param player_spawn the player_spawn to set
     */
    public void setPlayer_spawn(Boolean player_spawn) {
        this.player_spawn = player_spawn;
    }

    /**
     * @return the entities
     */
    public Boolean getEntities() {
        return entities;
    }

    /**
     * @param entities the entities to set
     */
    public void setEntities(Boolean entities) {
        this.entities = entities;
    }

    /**
     * @return the mob_spawn
     */
    public Boolean getMob_spawn() {
        return mob_spawn;
    }

    /**
     * @param mob_spawn the mob_spawn to set
     */
    public void setMob_spawn(Boolean mob_spawn) {
        this.mob_spawn = mob_spawn;
    }
}
