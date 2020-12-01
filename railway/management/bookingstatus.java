package railway.management;


import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import railway.management.*;

 class bookingstatus {

    
    public void bookingstatusinfo() { int nop=0;
        try {
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream
        System.out.print("Enter name (under whose the tickets have been booked): ");
        String str= sc.nextLine();
        System.out.print("Enter pnr: ");
        int pnr= sc.nextInt();
        String filename= str + ".txt";
        
        FileInputStream fi = new FileInputStream(new File(filename));
        ObjectInputStream oi = new ObjectInputStream(fi);

        // Read objects
        PassengerInfo ps1 = (PassengerInfo) oi.readObject();
       
       if(ps1.getPnr()==pnr){
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("PNR matched! Your Booking Status is shown below.");
        System.out.println("Passenger name: "+ ps1.getName() + " \nAge: "+ ps1.getAge() +"  Gender: "+ ps1.getgender() +"\nPNR: "+  ps1.getPnr() +"    Train number: "+ ps1.gettn() + "   Day: " + ps1.getday() + "\nBooked Seat Numbers: " + ps1.getSeatnum());
    
       nop=ps1.getSeatnum().size();
       
       System.out.print("\nAmount paid: "+nop*ps1.getchoice()*30);
       System.out.print("\nClass:");
        if(ps1.getchoice()==1) System.out.print(" General");
        if(ps1.getchoice()==2) System.out.print(" AC3");
        if(ps1.getchoice()==3) System.out.print(" AC2");
        if(ps1.getchoice()==4) System.out.print(" AC1");
    System.out.println("\nBooking Status: Your ticket has been confirmed.");
    System.out.println("-------------------------------------------------------------------------------------------------------");}
    else {System.out.println("Sorry invalid PNR entered.");}
        oi.close();
        fi.close();

    } catch (FileNotFoundException e) {
        System.out.println("No booking done under the respective name and PNR");
    } catch (IOException e) {
        System.out.println("Error initializing stream");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }}
}
