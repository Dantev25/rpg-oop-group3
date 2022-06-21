import java.util.Scanner;

public class testCharacter{
    public static void main(String arg[]){
        int choice;
        Character p1 = new Character("Sadiyah",5,5,5,5);
        System.out.print("My first character is :");p1.display();
        do {
            System.out.println("What do you wanna do now ?");
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Create character");
                    break;
                case 2:
                    System.out.println("Upgrade pve");
                    break;
                case 3:
                    System.out.println("Fight");
                    break;
                default:
                    System.out.println("1: Create | 2: Farm | 3: Fight | -1: Exit");
                    break;

            }
        }while (choice != -1);
    }
}