/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
