
import Solution.AustraliaMapSolution;
import Solution.JobShopSchedulingSolution;
import Solution.nQueenSolution;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Constraint Satisfaction Problems by hekl0 and Hoang Le");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please choose Problem: ");
        System.out.println("   1. Australia Map");
        System.out.println("   2. Job Shop Scheduling");
        System.out.println("   3. N-Queens");
        System.out.print("Your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                new AustraliaMapSolution();
                break;
            case 2:
                new JobShopSchedulingSolution();
                break;
            case 3:
                System.out.print("The number of Queen (Recommend 8): ");
                int num = scanner.nextInt();
                new nQueenSolution(num);
                break;
        }
    }






}
