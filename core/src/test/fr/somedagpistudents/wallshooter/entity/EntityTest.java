package fr.somedagpistudents.wallshooter.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by benjamin on 1/31/17.
 */
public class EntityTest {
    @Test
    public void createEntity() {
        Entity entity1= new DummyEntity(50, 60, 70, 80);
        assertNotNull(entity1);
        assertEquals(entity1.getX(), 50, 0);
        assertEquals(entity1.getY(), 60, 0);
        assertEquals(entity1.getWidth(), 70, 0);
        assertEquals(entity1.getHeight(), 80, 0);

        Entity entity2 = new DummyEntity(10, 20, 30);
        assertNotNull(entity2);
        assertEquals(entity2.getX(), 10, 0);
        assertEquals(entity2.getY(), 20, 0);
        assertEquals(entity2.getWidth(), 30, 0);
        assertEquals(entity2.getHeight(), 30, 0);
    }
}

class DummyEntity extends Entity {

    public DummyEntity(float x, float y, float size) {
        super(x, y, size);
    }

    public DummyEntity(float x, float y, float width, float height) {
        super(x, y, width, height);
    }

    @Override
    public void update() { }

    @Override
    public void onCollision(Object object) {}
}