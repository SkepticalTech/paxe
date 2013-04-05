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
package core;

/*
 * Holds two objects, generic.
 * Used for many operations when I need multiple return values at once
 */
public class Duplex<T, U>{
    private T obj1;
    private U obj2;
    
    public Duplex(){
    }
    
    public Duplex(T ob1, U ob2){
        obj1 = ob1;
        obj2 = ob2;
    }
    
    public T getFirst(){
        return obj1;
    }
    
    public U getSecond(){
        return obj2;
    }
    
    public void setFirst(T ob){
        obj1 = ob;
    }
    
    public void setSecond(U ob){
        obj2 = ob;
    }
    
}
