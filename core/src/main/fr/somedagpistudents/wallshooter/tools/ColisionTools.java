package fr.somedagpistudents.wallshooter.tools;

import fr.somedagpistudents.wallshooter.entity.Entity;
import fr.somedagpistudents.wallshooter.entity.MovableEntity;

/**
 * Created by djacques on 30/01/17.
 */
public class ColisionTools {
    public static boolean contact(Entity objectA, Entity objectB){
        return collision(objectA,objectB) || collision(objectB,objectA);
    }
    public static boolean contactMoove(MovableEntity objectA, MovableEntity objectB, float delta){

        return collision(objectA,objectB,delta) || collision(objectB,objectA,delta);
    }

    public static boolean collision(MovableEntity objectA, MovableEntity objectB,float delta){
        boolean colisionLeft = collision(objectA.getX(), (objectB.getX()+(objectB.getXSpeed()*delta)), (objectB.getWidth()+(objectB.getXSpeed()*delta)));
        boolean colisionRight = collision(objectA.getX() + objectA.getWidth(), (objectB.getX()+(objectB.getXSpeed()*delta)), (objectB.getWidth()+(objectB.getXSpeed()*delta)));
        boolean colisionTop = collision(objectA.getY(), (objectB.getY()+(objectB.getYSpeed()*delta)), (objectB.getHeight()+(objectB.getYSpeed()*delta)));
        boolean colisionBottom = collision(objectA.getY() + objectA.getHeight(), (objectB.getY()+(objectB.getYSpeed()*delta)), (objectB.getHeight()+(objectB.getYSpeed()*delta)));
        if(colisionLeft || colisionRight){
            if(colisionTop || colisionBottom) {
                objectA.onCollision(objectB, delta);
                objectB.onCollision(objectA, delta);
                return true;
            }
        }
        return  false;
    }

    public static boolean collision(Entity objectA, Entity objectB){
        boolean colisionLeft = collision(objectA.getX(), objectB.getX(), objectB.getWidth());
        boolean colisionRight = collision(objectA.getX() + objectA.getWidth(), objectB.getX(), objectB.getWidth());
        boolean colisionTop = collision(objectA.getY(), objectB.getY(), objectB.getHeight());
        boolean colisionBottom = collision(objectA.getY() + objectA.getHeight(), objectB.getY(), objectB.getHeight());

        if(colisionLeft || colisionRight){
            if(colisionTop || colisionBottom) {
                objectA.onCollision(objectB, 0);
                objectB.onCollision(objectA, 0);

                return true;

            }
        }
        return  false;
    }

    static boolean collision(float posA, float posB, float bWidth) {
        return ( posB <= posA) && (posA <= (posB + bWidth));
    }

    public static boolean contactTopBottom(MovableEntity objectA, MovableEntity objectB, float delta) {
        return (objectA.getY()+objectA.getHeight()-objectA.getYSpeed()*delta <= objectB.getY()-objectB.getYSpeed()*delta );
    }

    public static boolean contactBottomTop(MovableEntity objectA, MovableEntity objectB, float delta) {
        return (objectA.getY()-objectA.getYSpeed()*delta >= objectB.getY() + objectB.getHeight()-objectB.getYSpeed()*delta );
    }

    public static boolean contactLeftRight(MovableEntity objectA, MovableEntity objectB, float delta) {
        return (objectA.getX()-objectA.getXSpeed()*delta >= objectB.getX()+ objectB.getWidth()-objectB.getXSpeed()*delta);
    }

    public static boolean contactRightLeft(MovableEntity objectA, MovableEntity objectB, float delta) {
        return (objectA.getX()+objectA.getWidth()-objectA.getXSpeed()*delta <= objectB.getX()-objectB.getXSpeed()*delta);
    }
}
