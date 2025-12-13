import java.util.Scanner;
import java.util.Random;


public class Rock_Paper_Scissors {

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int candy = 0;

        boolean PlayAgain = true;
        String[] options = {"rock", "paper", "scissors"};

        while (PlayAgain) 
        {
            //Get input player
            System.out.print("Enter Rock/Paper/Scissors: ");
            String player = sc.nextLine().toLowerCase();

            //Error
            if (!player.equals("rock") && 
                !player.equals("paper") && 
                !player.equals("scissors")) 
            {
                System.out.println("Invalid input");
                continue;
            }

            //RANDOM
            String computer = options[rand.nextInt(3)]; // สุ่ม rock paper scissors
            System.out.println("Computer chose: " + computer);

            //Result
            if (player.equals(computer)) // คำตอบเหมือนกัน
            {
                System.out.println("You Draw");
                candy += 2;
            }
            else if (player.equals("rock") && computer.equals("scissors") || 
                    player.equals("paper") && computer.equals("rock") || 
                    player.equals("scissors") && computer.equals("paper")) 
            {
                System.out.println("You Wins");
                candy += 5;
            }
            else 
                System.out.println("Computer Wins");
                candy += 0;

            //Play again
            boolean Vaid_answer = false;
            while (!Vaid_answer) 
            {
                System.out.print("Play again? (Yes/No): ");
                String answer = sc.nextLine().toLowerCase();
                if (!answer.equals("yes") && !answer.equals("no")) 
                {
                    System.out.println("Invalid input"); //ถ้าคำตอบไม่เท่ากับ  yes หรือ no
                    continue;
                }
                if (answer.equals("yes"))
                {
                    Vaid_answer = true; //ออกจากลูป vaid_answer และ เล่นเกมต่อ
                }
                else if (answer.equals("no"))
                {
                    PlayAgain = false; //เกมจะถูกหยุด
                    Vaid_answer = true;//ออกจากลูป vaid_answer
                }
            }
            
        }

        //End game
        System.out.println("End Game!");
        System.out.println("Total Candy: " + candy);
        sc.close(); //จบการทำงาน เคลียร์พื้นที่
    }
}