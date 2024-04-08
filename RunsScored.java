/****************************
 * RunsScored.java
 * Represents RunsScored 
 * @author Hashim Afzal
 * @version 1.0
 ****************************/
public class RunsScored {
    private int runs;
    private int notout;
    public RunsScored(){
        runs = 0;
        notout = 0;
       
    }

    public RunsScored(int r, int n){
        runs = r;
        notout = n;
      }
    public int getRuns(){
        return runs;
    }
    public int getNotout(){
        return notout;
    }
    public String toString(){
        return ("Runs: " + runs + "not out: " + notout);
     
}
}