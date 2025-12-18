import java.util.Scanner;
import java.util.Random;


public class Rock_Paper_Scissors {

        static int candy = 0;

        public static boolean playRound(Scanner sc, Random rand) {
        String[] options = {"rock", "paper", "scissors"};

        System.out.print("Enter Rock/Paper/Scissors: ");
        String player = sc.nextLine().toLowerCase();

        if (!player.equals("rock") &&
            !player.equals("paper") &&
            !player.equals("scissors")) {
            System.out.println("Invalid input");
            return false;
        }

        String computer = options[rand.nextInt(3)];
        System.out.println("Computer chose: " + computer);

        if (player.equals(computer)) {
            System.out.println("You Draw");
            candy += 2;
        }
        else if (player.equals("rock") && computer.equals("scissors") ||
                 player.equals("paper") && computer.equals("rock") ||
                 player.equals("scissors") && computer.equals("paper")) {
            System.out.println("You Wins");
            candy += 5;
        }
        else {
            System.out.println("Computer Wins");
        }

        return true;
    }


    public static boolean askPlayAgain(Scanner sc) {
        while (true) {
            System.out.print("Play again? (Yes/No): ");
            String answer = sc.nextLine().toLowerCase();

            if (answer.equals("yes")) {
                return true;
            }
            else if (answer.equals("no")) {
                return false;
            }
            else {
                System.out.println("Invalid input");
            }
        }
    }
    
    
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        boolean playAgain = true;
        
        while (playAgain) {
            boolean success = playRound(sc, rand);

            if (!success) continue;

            playAgain = askPlayAgain(sc);
        }

        //End game
        System.out.println("End Game!");
        System.out.println("Total Candy: " + candy);
        sc.close(); //จบการทำงาน 
    }
}