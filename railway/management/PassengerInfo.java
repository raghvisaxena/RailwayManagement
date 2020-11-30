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
//import railway.management.SeatReservation.passengerinfo;

class info implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name, day;
    private int age, pnr, trainnum, choice;
    private char gender;
    private int[] seatnum = new int[104];
    Random r= new Random();
    transient Scanner sc = new Scanner(System.in);

    info(){
    }

    public int getPnr(){
        return this.pnr;
    }

    public int gettn()
    {
        return this.trainnum;
    }
    public String getday()
    {
        return this.day;
    }
    public int getchoice()
    {
        return choice;
    }
    public int[] getSeatnum() {
        return seatnum;
    }

    public void getinfo(int t,String d,int[] snum,int c){
        
        System.out.print("Enter name:   ");
        this.name=sc.nextLine();
        System.out.print("Enter age:   ");
        this.age=sc.nextInt();
        System.out.print("Enter gender f/m/o:   ");
        this.gender=sc.next().charAt(0);
        this.pnr= r.nextInt(5000) ;
        this.day=d;
        this.trainnum=t;
        this.seatnum=snum;
        this.choice=c;
    }

    @Override
	public String toString() {
        return ("\nname: "+ name +"   age:"+ age +"   gender:"+ gender +"    PNR:"+ pnr 
                +"\ntrain number:"+ trainnum +"   day:"+ day +"\nSeat numbers:"+ Arrays.toString(seatnum) +"\n");
	}
}

public class PassengerInfo {
    public static void main(String[] args) { //write(info i) funcn should be called from seatReservation
        info s1 = new info();
        int [] a = {1,2,3,6,5};
        s1.getinfo(7, "monday", a);
        info s2 = new info();
        s2.getinfo(2, "hdwh", a);
        //File file = new File("myPassenger.ser");
        try {
			FileOutputStream f = new FileOutputStream(new File("myPassenger.ser"),true);
			ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(s1);
            System.out.println("lalllallal");
            o.writeObject(s2);
            System.out.println("rrrrrlalllallal");

            o.close();
			f.close();
            
            FileInputStream fi = new FileInputStream(new File("myPassenger.ser"));
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
            info ps1 = (info) oi.readObject();
            System.out.println(ps1.toString());
            info ps2 = (info) oi.readObject();
            System.out.println("ddddddddd");
            System.out.println(ps2.toString());
            
			oi.close();
			fi.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
}