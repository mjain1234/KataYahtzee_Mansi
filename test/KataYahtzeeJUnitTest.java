import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import katayahtzee_mansi.KataYahtzee_Mansi;
        

/**
 *
 * @author Mansi
 */

public class KataYahtzeeJUnitTest {
	//creating an object of KataYahtzee_Mansi for testing 
	KataYahtzee_Mansi kata  = new KataYahtzee_Mansi();
    
    //testing to check the function checkPairs        
    @Test
    public final void PairTest(){
        int arry[] = {3, 3, 3, 4, 4 }; // points should be (4+4=8)
        //asset statement
		Assert.assertEquals(8, kata.checkPairs(arry));
    }
    
    //testing to check the function checkTwoPairs        
    @Test
    public final void TwoPairTest(){ 
        int arry[] = {1, 1, 2, 3, 3 }; // points should be (3+3+1+1=8)
        //asset statement
		Assert.assertEquals(8, kata.checkTwoPairs(arry));        
    } 
 
    //testing to check the function checkPairs        
    @Test
    public final void checkThreeOfAKind(){
        int arry[] = {3, 3, 3, 4, 5 }; // points should be (3+3+3=9)
        //asset statement
		Assert.assertEquals(9, kata.checkThreeOfAKind(arry));
    }
    
	//testing to check the function smallStraight        
    @Test
    public final void SmallStraightTest(){
        int arry[] = {1, 2, 3, 4, 5 }; // points should be (1+2+3+4+5=15)
		//asset statement
        Assert.assertEquals(15, kata.smallStraight(arry));
    }
    
	//testing to check the function smallStraight        
    @Test
    public final void yahtzeeTest(){
        int arry[] = {4, 4, 4, 4,4 };
		//asset statement
        Assert.assertEquals(50, kata.yahtzee(arry));
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

}
