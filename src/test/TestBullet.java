package test;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import model.BulletImpl;
import model.ID;
import utility.Pair;


public class TestBullet {
	@Test
    public void testBullet() {
        final BulletImpl testBullet = new BulletImpl(0, 0, ID.PLAYER);
        assertNotNull(testBullet);
        final Pair<Integer, Integer> position = testBullet.getPosition();
        testBullet.setSpeed(0, 0);
        testBullet.update();
        assertEquals(position, testBullet.getPosition());
    }
}
