package fr.somedagpistudents.wallshooter.tools;

import fr.somedagpistudents.wallshooter.entity.Entity;

/**
 * Created by djacques on 30/01/17.
 */
public class ColisionTools {
    public static boolean contact(Entity objectA, Entity objectB){
        return colision(objectA,objectB) || colision(objectB,objectA);
    }
    public static boolean colision(Entity objectA, Entity objectB){
        boolean colisionLeft = (( objectA.getX() <= objectB.getX() )&& (objectB.getX() <= (objectA.getX()+objectA.getWidth())));
        boolean colisionRight = (( objectA.getX() <= objectB.getX()+objectB.getWidth() )&& (objectB.getX()+objectB.getWidth() <= (objectA.getX()+objectA.getWidth())));
        boolean colisionTop = (( objectA.getY() <= objectB.getY())&& (objectB.getY() <= (objectA.getY()+objectA.getHeight())));
        boolean colisionBottom = (( objectA.getY() <= objectB.getY()+objectB.getHeight())&& (objectB.getY()+objectB.getHeight() <= (objectA.getY()+objectA.getHeight())));
        if(colisionLeft || colisionRight){
            if(colisionTop || colisionBottom) {
                objectA.onCollision(objectB);
                objectB.onCollision(objectA);
                return true;
            }
        }
        return  false;
    }

    public static boolean contactTopBottom(Entity objectA, Entity objectB) {
        return (objectA.getY()+objectA.getHeight() >= objectB.getY() && objectA.getY()+objectA.getHeight() <= objectB.getY() +10);
    }

    public static boolean contactBottomTop(Entity objectA, Entity objectB) {
        return (objectA.getY() <= objectB.getY()+objectB.getHeight() && objectA.getY() >= objectB.getY()+objectB.getHeight() -10);
    }

    public static boolean contactLeftRight(Entity objectA, Entity objectB) {
        return ((objectA.getX() <= objectB.getX()+ objectB.getWidth()) && (objectA.getX() >= (objectB.getX()+ objectB.getWidth()-10)));
    }

    public static boolean contactRightLeft(Entity objectA, Entity objectB) {
        return ((objectA.getX() + objectA.getWidth() >= objectB.getX()) && (objectA.getX() + objectA.getWidth() <= (objectB.getX()+10)));
    }
}
