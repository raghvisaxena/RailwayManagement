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
   
    try {
		
        FileOutputStream f = new FileOutputStream(new File("seatAllocation.ser"));
        ObjectOutputStream o = new ObjectOutputStream(f);

        // Write objects to file
        for(int i=1;i<=22;++i)
        {
            SeatChart p1= new SeatChart("monday",i);
            o.writeObject(p1);
        }

        for(int i=1;i<=22;++i)
        {
            SeatChart p1= new SeatChart("tuesday",i);
            o.writeObject(p1);
        }

        for(int i=1;i<=22;++i)
        {
            SeatChart p1= new SeatChart("wednesday",i);
            o.writeObject(p1);
        }

        for(int i=1;i<=22;++i)
        {
            SeatChart p1= new SeatChart("thursday",i);
            o.writeObject(p1);
        }

        for(int i=1;i<=22;++i)
        {
            SeatChart p1= new SeatChart("friday",i);
            o.writeObject(p1);
        }

        for(int i=1;i<=22;++i)
        {
            SeatChart p1= new SeatChart("saturday",i);
            o.writeObject(p1);
        }

        for(int i=1;i<=22;++i)
        {
            SeatChart p1= new SeatChart("sunday",i);
            o.writeObject(p1);
        }
       
        o.close();
        f.close();

        FileInputStream fi = new FileInputStream("C:\\Users\\Dhara Patel\\Desktop\\RailwayManagement\\seatAllocation.ser");
        ObjectInputStream oi = new ObjectInputStream(fi);

        // Read objects
        for(int v=0;v<45;++v)
        {
        SeatChart pr1 = (SeatChart) oi.readObject();
        if(v==16)
        pr1.show();
        } 

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
