package fr.somedagpistudents.wallshooter.entity.bonus;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by benjamin on 1/31/17.
 */
public class BonusTest {
    @Test
    public void bonusHasType() throws Exception {


        for (int i = 0; i <10 ; i++) {
            Bonus bonus = new Bonus(0,0,new BonusType(i));
            assertNotNull(bonus);
            Assert.assertEquals(i, bonus.getTypeBonus());
        }
    }
}
