package railway.management;

import java.io.Serializable;
import java.util.Scanner;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import railway.management.*;

public class Cancellation { // train details of the ticket should be stored

    void cancelTicket() throws IOException {
        Scanner sc = new Scanner(System.in);
        int sn;

        System.out.println("enter pnr");
        int pnr_num = sc.nextInt();

        FileInputStream fi = new FileInputStream("C:\\Users\\Dhara Patel\\Desktop\\RailwayManagement\\myPassenger.ser");
        ObjectInputStream oi = new ObjectInputStream(fi);

        FileInputStream fi2 = new FileInputStream("C:\\Users\\Dhara Patel\\Desktop\\RailwayManagement\\seatAllocation.ser");
        ObjectInputStream oi2 = new ObjectInputStream(fi2);

        // Read objects
        /*
         * while(true) { try{ info pi = (info) oi.readObject(); if(pi.getPnr() ==
         * pnr_num) { System.out.println("Enter the seat number(s) to be deleted: ");
         * do{ sn = sc.nextInt(); pi.seatnum[sn]=0; }while(sn!=0); //change end
         * condition } } catch(EOFException e) { System.out.println("WRONG PNR NUMBER");
         * } catch (ClassNotFoundException e) { e.printStackTrace(); } finally {
         * oi.close(); fi.close(); sc.close(); } }
         */
        
        try {
            info pi = (info) oi.readObject();
            System.out.println(pi.toString());
            System.out.println(pi.getPnr());
            if(pi.getPnr() == pnr_num)
            {
                System.out.println("Enter the seat number(s) to be deleted: ");
                do{
                    sn = sc.nextInt();
                    SeatChart chart = (SeatChart) oi2.readObject(); //repeating seat numbers
                    //read chart acc to day n train no. then delete seat
                } while(sn!=0);         //change end condition
            }  
            oi.close(); 
            fi.close();
        } catch (ClassNotFoundException e) {
            System.out.println("class not found!!");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} 

    }
}
