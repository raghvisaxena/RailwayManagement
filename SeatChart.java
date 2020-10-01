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
        System.out.println("1. General" + count(gen));
        System.out.println("2. Third AC" + count(AC3));
        System.out.println("3. Second AC" + count(AC2));
        System.out.println("4. First AC" + count(AC1));
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

    try {
		
        FileOutputStream f = new FileOutputStream(new File("seatAllocation.ser"));
        ObjectOutputStream o = new ObjectOutputStream(f);

        // Write objects to file
        o.writeObject(p1);
        o.writeObject(p2);
        o.writeObject(p3);

        o.close();
        f.close();

        FileInputStream fi = new FileInputStream(new File("seatAllocation.ser"));
        ObjectInputStream oi = new ObjectInputStream(fi);

        // Read objects
        SeatChart pr1 = (SeatChart) oi.readObject();
        SeatChart pr2 = (SeatChart) oi.readObject();
        SeatChart pr3 = (SeatChart) oi.readObject();
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
