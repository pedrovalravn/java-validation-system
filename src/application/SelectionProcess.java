package application;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SelectionProcess {

    public static void main(String[] args) {
        String [] applicants = {"Hank", "Jesse", "Saul", "Walter", "Skyler"};
        for(String applicant : applicants){
            callingApplicant(applicant);
        }
    }
    
    static void callingApplicant(String applicant){
        int attempts = 1;
        boolean keepTrying = true;
        boolean answered = false;
        do{
            answered = answerCall();
            keepTrying = !answered;

            if(keepTrying)
                attempts++;
            else
                System.out.println("CONTACTED WITH SUCCESS.");

        }while(keepTrying && attempts < 3);

        if(answered)
            System.out.println("We have managed to contact " + applicant + " after " + attempts + " attempts.");
        else
            System.out.println("We have'nt managed to contact " + applicant + " after " + attempts + " attempts.");

    }

    static boolean answerCall(){
        return new Random().nextInt(3)==1;
    }

    static void printSelected(){
         String [] applicants = {"Hank", "Jesse", "Saul", "Walter", "Skyler"};
         System.out.println("Printing applicants list informing elements index");

         for(int index=0; index < applicants.length; index++){
            System.out.println("The applicant n°" + (index+1) + " it's  " + applicants[index]);
         }

         System.out.println("Abbreviated form of For Each interaction");

         for(String applicant : applicants){
            System.out.println("The selected applicant is: " + applicant);
         }
    }

    static void applicantsSelection(){
        
        String [] applicants = {"Hank", "Jesse", "Saul", "Walter", "Skyler", "Gustavo", "Mike", "Ignacio", "Marie", "Holly"};

        int selectedApplicants = 0;
        int actualApplicants = 0;
        double baseWage = 2000.0;
        
        while(selectedApplicants < 5 && actualApplicants < applicants.length){
            String applicant = applicants[actualApplicants];
            double expectedWage = expectedValue(); 

            System.out.println("The applicant " + applicant + " requested this wage value: " + expectedWage);
            if(baseWage >= expectedWage){
                System.out.println("The applicant " + applicant + " is selected to our job vacancy.");
            }
            actualApplicants++;
        }
    }

    static double expectedValue(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void applicantAnalysis(double expectedWage){
        double baseWage = 2000.0;
        if(baseWage > expectedWage){
            System.out.println("CALL APPLICANT");
         } else if(baseWage == expectedWage) {
            System.out.println("CALL APPLICANT WITH COUNTER OFFER");
         } else{
            System.out.println("WAITING FOR RESULTS OF REMAINING APPLICANTS.");
         }
    }
}
