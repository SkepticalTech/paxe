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
import helpers.TNode;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Block extends Point implements IOutputtable {

    public Block(int x, int y, int z) {
        super(true);
        setX(x);
        setY(y);
        setZ(z);
    }

    public Element output(Document doc) {
        TNode main = main = new TNode("block", toString(), doc);
        return main.tag;
    }
}
