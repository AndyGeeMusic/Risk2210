package test;

import com.company.Dice;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DiceTest {

    @Test
    public void getDiceRollShouldBeBetweenOneAndSix() {
        Dice dice = new Dice();
        dice.roll(1,2,0,3,2,0);
        assertTrue(1 <= dice.roll(1) && dice.roll(1) <= 6);
    }

}
