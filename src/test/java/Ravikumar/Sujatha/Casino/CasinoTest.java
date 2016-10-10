package Ravikumar.Sujatha.Casino;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sujatharavikumar on 10/9/16.
 */
public class CasinoTest {

    @Test
    public void addPlayerTest(){
        DummyUserInput dummyUserInput = new DummyUserInput();
        Player player = new Player();
        double moneyInPlayerWallet = dummyUserInput.getDummyAmountIntoPlayerWallet();
        player.setMoneyInWallet(moneyInPlayerWallet);
        Assert.assertTrue(player.getMoneyInWallet() == moneyInPlayerWallet);
    }

}
