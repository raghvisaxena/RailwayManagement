package railway.management;

import java.io.Serializable;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import railway.management.*;

public class SeatChart implements Serializable{
    private static final long serialVersionUID = 1L;
    int trainNumber;
    String date;
    int[] gen = new int[104];
    int[] AC3 = new int[104];
    int[] AC2= new int[54];
    int[] AC1 = new int[28];
    int choice;

    SeatChart(String d, int n){
        this.trainNumber=n;
        this.date=d;
    }

    public void show(){
        Scanner scan = new Scanner(System.in);
        System.out.println("1. General ---- " + count(gen));
        System.out.println("2. Third AC ---- " + count(AC3));
        System.out.println("3. Second AC ---- " + count(AC2));
        System.out.println("4. First AC ---- " + count(AC1));
        System.out.println("Enter the your Choice");
        choice=scan.nextInt();
    }

    public int getChoice(){
        return choice;
    }

    public int getTrainNumber(){
        return trainNumber;
    }

    public String getDay(){
        return date;
    }

    public int count(int[] a){
        int c=0;
        for(int i=0;i<a.length;i++){
            if(a[i]==0)
            c++;
        }
        return c;
    }

}

class seat{

    public static void main(String[] args) {
    SeatChart p1= new SeatChart("monday",1);
    SeatChart p2= new SeatChart("monday",2);
    SeatChart p3= new SeatChart("monday",3);
    SeatChart p4= new SeatChart("monday",4);
    SeatChart p5= new SeatChart("monday",5);
    SeatChart p6= new SeatChart("monday",6);
    SeatChart p7= new SeatChart("monday",7);
    SeatChart q7= new SeatChart("tuesday",7);
    SeatChart q1= new SeatChart("tuesday",1);
    SeatChart q2= new SeatChart("tuesday",2);
    SeatChart q3= new SeatChart("tuesday",3);
    SeatChart q4= new SeatChart("tuesday",4);
    SeatChart q5= new SeatChart("tuesday",5);
    SeatChart q6= new SeatChart("tuesday",6);
    SeatChart w1= new SeatChart("wednesday",1);SeatChart w2= new SeatChart("wednesday",2);SeatChart w3= new SeatChart("wednesday",3);SeatChart w4= new SeatChart("wednesday",4);SeatChart w5= new SeatChart("wednesday",5);SeatChart w6= new SeatChart("wednesday",6);SeatChart w7= new SeatChart("wednesday",7);

    try {
		
        FileOutputStream f = new FileOutputStream(new File("seatAllocation.ser"));
        ObjectOutputStream o = new ObjectOutputStream(f);

        // Write objects to file
        o.writeObject(p1);
        o.writeObject(p2);
        o.writeObject(p3);
        o.writeObject(p4);
        o.writeObject(p5);
        o.writeObject(p6);
        o.writeObject(p7);
        o.writeObject(q1);
        o.writeObject(q2);
        o.writeObject(q3);
        o.writeObject(q4);
        o.writeObject(q5);
        o.writeObject(q6);
        o.writeObject(q7);
        o.writeObject(w1);


        o.close();
        f.close();

        FileInputStream fi = new FileInputStream(new File("seatAllocation.ser"));
        ObjectInputStream oi = new ObjectInputStream(fi);

        // Read objects
        SeatChart pr1 = (SeatChart) oi.readObject();
        SeatChart pr2 = (SeatChart) oi.readObject();
        SeatChart pr3 = (SeatChart) oi.readObject();
        SeatChart pr4 = (SeatChart) oi.readObject();
        SeatChart pr5 = (SeatChart) oi.readObject();
        SeatChart pr6 = (SeatChart) oi.readObject();
        SeatChart pr7 = (SeatChart) oi.readObject();
        SeatChart pr8 = (SeatChart) oi.readObject();
        SeatChart pr9 = (SeatChart) oi.readObject();


        pr1.show();
        pr2.show();
        pr3.show();



        oi.close();
        fi.close();

    } 
    catch (FileNotFoundException e) {
        System.out.println("File not found");
    } catch (IOException e) {
        System.out.println("Error initializing stream");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }

}}
