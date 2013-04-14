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

class Point {

    protected int x, y, z;
    protected boolean is3D = false;

    //for a default point, 2d/3d
    public Point(boolean is3D){
        this.is3D = is3D;
    }
    
    //for a 3d point
    public Point(int x, int y, int z) {
        setX(x);
        setY(y);
        setZ(z);
        is3D = true;
    }

    public Point(int x, int y) {
        setX(x);
        setY(y);
        is3D = false;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the z
     */
    public int getZ() {
        //TODO: Error handling here if it is not a 3d point
        return z;
    }

    /**
     * @param z the z to set
     */
    public void setZ(int z) {
        if(is3D){
            this.z = z;
        }
    }

    public String toString() {
        return is3D ? ("" + x + "," + y + "," + z) : "" + x + "," + y;
    }
}
