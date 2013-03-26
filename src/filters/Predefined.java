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

public enum Predefined {

    ALLOW_ALL("allow-all"),
    DENY_ALL("deny-all"),
    ALLOW_PLAYERS("allow-players"),
    DENY_PLAYERS("deny-players"),
    ALLOW_BLOCKS("allow-blocks"),
    DENY_BLOCKS("deny-blocks"),
    ALLOW_PLACE("allow-place"),
    DENY_PLACE("deny-place");
    
    private String value;

    private Predefined(String val) {
        this.value = val;
    }
}
