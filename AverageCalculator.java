/*******************************
 * AverageCalculator.java
 * Allows user to view batting statistics over a season by displaying total runs scored, average, innings and a visual representation of runs scored throughout the season
 * @author Hashim Afzal
 * @version 1.0
 *********************************/
import java.util.ArrayList;
import java.util.Scanner;

public class AverageCalculator {
    public static void main(String args[]){
        Scanner keyboard = new Scanner (System.in);
        ArrayList<RunsScored> inningsList = new ArrayList<RunsScored>();
        int innings = inningsList.size();

        while (true){       // now program will loop indifinitely so user can add innings as they progress through the season
            System.out.println("Please select one of the following options:");
            System.out.println("1: Add a new game");
            System.out.println("2: Calculate Batting Statistics");
            System.out.println("3: End Session");

            int option = keyboard.nextInt();
            keyboard.nextLine();
        
            switch(option){
                case 1: System.out.println("Enter runs scored in your innings: ");
                    int runs = keyboard.nextInt();
                    keyboard.nextLine();
                    System.out.println("Where you out in your innings? (Y/N) ");
                    String out = keyboard.nextLine();
                    int notout = 0;
                    if (!out.equalsIgnoreCase("Y")){     // if user was not out, not out value will increment by 1
                        notout++;
                    }
                    inningsList.add(new RunsScored(runs, notout));      //value will be added to the arraylist inningsList
                    //System.out.println(inningsList);
                    break;
                case 2: int totalRuns = 0;
                int totalNotout = 0;
                for (RunsScored RunScored: inningsList){
                    totalRuns += RunScored.getRuns();
                    totalNotout += RunScored.getNotout();
                }
                int length = inningsList.size();                    //displaying number of innings through the length of the arraylist
                double average = (double) totalRuns / (length - totalNotout);   // in cricket batting average is calculated with total runs / times out, if batter was not out that will be subtracted from number of innings
                System.out.println("Innings: " + length);
                System.out.println("Runs: " + totalRuns);
                System.out.println("Notout: " + totalNotout);
                System.out.println("Average: " + average);

                System.out.println("Runs scored over season: (* denotes 10 runs)"); //using stars to form a graph displaying how many runs a user scored, rounding down to 10
                for (RunsScored runScored : inningsList) {
                    int visualRuns = (runScored.getRuns() / 10) * 10;
                    int stars = visualRuns / 10;
                    System.out.println("Match " + (inningsList.indexOf(runScored) + 1) + ": " + "*".repeat(stars)); 

                    }
                    break;
                case 3: System.out.println("The program will now close");
                System.exit(0);
            }
            }
    }
}