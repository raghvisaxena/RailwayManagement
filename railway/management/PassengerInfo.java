package railway.management;

import java.io.Serializable;
import java.util.ArrayList;
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

class PassengerInfo implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name, day;
    private int age, pnr, trainnum, choice;
    private char gender;
    private ArrayList<Integer> seatnum = new ArrayList<Integer>();
    Random r= new Random();
    transient Scanner sc = new Scanner(System.in);

    PassengerInfo(){
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
        return this.choice;
    }
    
    public ArrayList<Integer> getSeatnum() {
        return seatnum;
    }

    public void getinfo(int t, String d, ArrayList<Integer> snum, int c){
        
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
        writeinfo();
    }

    @Override
	public String toString() {
        return ("\nname: "+ name +"   age:"+ age +"   gender:"+ gender +"    PNR:"+ pnr 
                +"\ntrain number:"+ trainnum +"   day:"+ day +"\nSeat numbers:"+ seatnum +"\n");
    }
    
    public void writeinfo(){
        //File file = new File("myPassenger.ser");
        try {
            String filename = (this.name +".txt");
			FileOutputStream f = new FileOutputStream(new File(filename));
			ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(this);

            o.close();
			f.close();
            
            FileInputStream fi = new FileInputStream(new File(filename));
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
            PassengerInfo ps1 = (PassengerInfo) oi.readObject();
            System.out.println(ps1.toString());
    
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