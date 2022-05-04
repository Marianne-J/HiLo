package hilo;
import java.util.ArrayList;
import java.util.Random;

public class Dealer {
    /*Handles generating a new number, storing the new and current number,
    and determining how many points the player earns or loses.
    */
    
    int current_num;
    int new_num;
    Random random = new Random();

    public Dealer() {
        current_num = 0;
        new_num = 0;
    }

    public int get_points(String highlow) {
        /*Takes the user's response (higher or lower), compares the
        new number and the current number, and determines whether the player earns
        or loses points. If the number does not change, no points are given or
        taken.
        */

        int points = 0;

        if (highlow.toLowerCase().equals("h")) {
            if (new_num > current_num) {
                points = 100;
            }
            else if (new_num == current_num) {
                points = 0;
            }
            else {
                points = -75;
            }
        }
        else if (highlow.toLowerCase().equals("l")) {
            if (new_num < current_num) {
                points = 100;
            }
            else if (new_num == current_num) {
                points = 0;
            }
            else {
                points = -75;
            }
        }

        return points;
    }

    public void generate_number() {
        /*Generates a new number.*/
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i < 21; i++) {
            numbers.add(i);
        }

        if (current_num == 0) {
            current_num = numbers.get(random.nextInt(numbers.size()));
        }
        else {
            current_num = new_num;
        }

        new_num = numbers.get(random.nextInt(numbers.size()));
    }
}
