package Ravikumar.Sujatha.Casino;
import java.util.Scanner;

/**
 * Created by sujatharavikumar on 10/1/16.
 */
public class Input {

    Scanner in = new Scanner(System.in);

    public int getUserInput(){
        return in.nextInt();
    }

    public double getAmount(){
        return in.nextDouble();

    }

    public char getHitOrStand(){
        return in.next().charAt(0);
    }


}
