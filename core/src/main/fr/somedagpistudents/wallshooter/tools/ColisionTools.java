package fr.somedagpistudents.wallshooter.tools;

import fr.somedagpistudents.wallshooter.entity.Entity;

/**
 * Created by djacques on 30/01/17.
 */
public class ColisionTools {
    public static boolean contact(Entity objectA, Entity objectB){
        boolean colisionLeft = (( objectA.getX() <= objectB.getX() )&& (objectB.getX() <= (objectA.getX()+objectA.getWidth())));
        boolean colisionRight = (( objectA.getX() <= objectB.getX()+objectB.getWidth() )&& (objectB.getX()+objectB.getWidth() <= (objectA.getX()+objectA.getWidth())));
        boolean colisionTop = (( objectA.getY() <= objectB.getY())&& (objectB.getY() <= (objectA.getY()+objectA.getHeight())));
        boolean colisionBottom = (( objectA.getY() <= objectB.getY()+objectB.getHeight())&& (objectB.getY()+objectB.getHeight() <= (objectA.getY()+objectA.getHeight())));
        if(colisionLeft || colisionRight){
            if(colisionTop || colisionBottom) {
                objectA.contactWith(objectB);
                objectB.contactWith(objectA);
                return true;
            }
        }
        return  false;
    }
}
