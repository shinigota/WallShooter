package fr.somedagpistudents.wallshooter.tools;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
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
                objectA.onCollision(objectB);
                objectB.onCollision(objectA);
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
                objectA.onCollision(objectB);
                objectB.onCollision(objectA);
                return true;
            }
        }
        return  false;
    }

    static boolean collision(float posA, float posB, float bWidth) {
        return ( posB <= posA) && (posA <= (posB + bWidth));
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
