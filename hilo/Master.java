package hilo;
import java.util.Scanner;

public class Master {
    /*Starts the game and handles, inputs, updates, and outputs. Also
    keeps track of how many points the player has earned and whether or not
    the game has ended.
    */

    boolean keep_playing;
    int score;
    String highlow;
    Dealer dealer = new Dealer();
    Scanner scanner = new Scanner(System.in);

    public Master() {
        keep_playing = true;
        score = 300;
    }

    public void start_game() {
       /*Starts the game.*/
       
        Master master = new Master();
        
        do {
            master.get_inputs();
            master.do_updates();
            keep_playing = master.do_outputs();
        }
        while (keep_playing == true);
    }

    public void get_inputs() {
        /*Calls the generate_number function and takes input from
        the user.
        */

        boolean invalid_input = true;
        
        dealer.generate_number();
        System.out.println("\n\nThe current number is: " + dealer.current_num);

        while (invalid_input == true) {
            System.out.println("Higher or lower? [h/l]: ");
            highlow = scanner.nextLine();

            if (highlow.toLowerCase().equalsIgnoreCase("h") || highlow.toLowerCase().equalsIgnoreCase("l")) {
                invalid_input = false;
            }
            else {
                System.out.println("\nInvalid input.\n");
            }
        }
    }

    public void do_updates() {
        /*Calls the get_points function and updates the player's total
        score.
        */

        int points = dealer.get_points(highlow);
        score += points;
    }

    public boolean do_outputs() {
        /*Prints the new number and the current score and asks the player
        whether they wish to continue playing (if the score does not equal
        zero).
         */
        
        System.out.println("\nThe new number is: " + dealer.new_num);
        System.out.println("Your current score is: " + score);
        
        if (score > 0) {
            System.out.println("Play again? [y/n]: ");
            String choice = scanner.nextLine();
            
            if (choice.toLowerCase().equals("y")) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            System.out.println("Better luck next time!");
            return false;
        }
    }
}
