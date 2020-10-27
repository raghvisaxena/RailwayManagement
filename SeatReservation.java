package railway.management;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.*;
import railway.management.*;
import java.io.Serializable;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SeatReservation {
    Scanner s = new Scanner(System.in);
    private static int[] general = new int[104];
    private static int[] Ac3 = new int[104];
    private static int[] Ac2 = new int[54];
    private static int[] Ac1 = new int[28];
    int countg = 104;
    int countAC1=28;
    int countAC2=54;
    int countAC3=104;
    int numofpassengers;
    int trainNumber;
    int choice;
    String destination;
    String source;
    String d;
    

    public void Destination(){
        System.out.println("------------------------------");
        System.out.println("Welcome to the Railway");
        System.out.println("Enter the day");d=s.nextLine();
        System.out.println("Enter the your destinantion");destination=s.nextLine();
        System.out.println("Enter the your source");source=s.nextLine(); 
        System.out.println("------------------------------");System.out.println("\n");
    }

    
    public void trainSearch(){
        try {
 
            FileInputStream fileIn = new FileInputStream("C:\\Users\\hp\\Desktop\\RailwayManagementSystem\\src\\railway\\management\\myTrains.ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            for(int i=0;i<2;i++){
            Object obj = objectIn.readObject();
            data pr1=(data) obj;
            String[] s=pr1.getStations();
            for(int j=0;j < pr1.getNumStation();j++){
                for(int k=j+1;k<pr1.getNumStation();k++){
                    if((s[j].equals(source)) && (s[k].equals(destination))){
                        System.out.println(pr1.toString());
                    }
                }
            }}
            objectIn.close();
            fileIn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getTrain(){
        System.out.println("Enter Train of your choice");
        trainNumber=s.nextInt();
    }

    public void readChart(){
        try {
 
            FileInputStream fi = new FileInputStream("C:\\Users\\hp\\Desktop\\RailwayManagementSystem\\src\\railway\\management\\seatAllocation.ser");
            ObjectInputStream oi = new ObjectInputStream(fi);
            for(int i=0;i<2;i++){
            Object obj1 = oi.readObject();
            SeatChart pr1=(SeatChart) obj1;
            if(pr1.getDay().equals(d) && pr1.getTrainNumber()==trainNumber){
                pr1.show(); choice=pr1.getChoice();
            }
            }
        oi.close();
            fi.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
   

    public int nonwindowseats(int choice){
        if (choice==1){
        if(general[103]!=1)
        {
            for(int i=0;i<104;i++)
            {if(i%2==1 && general[i]!=1){
                general[i]=1;
                countg--;
                return i;}
            }
            
        }
    }


        if(choice==2)
        {
            if(Ac3[103]!=1){
            for(int i=0;i<104;i++)
            {if(i%2==1  && Ac3[i]!=1){
                Ac3[i]=1;
                countAC3--;
                return i;}}
            }
        }

        if(choice==3)
        {
            for(int i=0;i<54;i++)
            {if(i%2==1  && Ac2[i]!=1){
                Ac2[i]=1;
                countAC2--;
                return i;
            }
            } 
        }

        if(choice==4)
        {
            for(int i=0;i<54;i++)
            {if(i%2==1  && Ac1[i]!=1){
                Ac1[i]=1;
                countAC1--;
                return i;}
            }
        }

        return -1;

    }
    public int windowseats(int choice){
        if(choice==1)
        {
            for(int i=1;i<=104;i++)
            {if(i%2==0 && general[i]!=1){
                general[i]=1;
                countg--;
                return i;}}}

        else if(choice==2)
        {
            for(int i=1;i<=104;i++)
            {if(i%2==0  && Ac3[i]!=1){
                Ac3[i]=1;
                countAC3--;
                return i;}}}

        else if(choice==3)
        {
            for(int i=1;i<=54;i++)
            {if(i%2==0  && Ac2[i]!=1){
                Ac2[i]=1;
                countAC2--;
                return i;}}}

        else if(choice==4)
        { 
            for(int i=1;i<=54;i++)
            {if(i%2==0  && Ac1[i]!=1){
                Ac1[i]=1;
                countAC1--;
                return i;}}}

        return -1;

    }

    public void passenger(){
        System.out.println("Enter number of passengers");
        numofpassengers=s.nextInt();
    }

    public int[] seatNum = new int[104];

    public void preference(){
        System.out.println("Enter number of window seats");
        int ws=s.nextInt();
        
        int i=0;
        for(;i<ws;i++){
            seatNum[i]= this.windowseats(choice);
        }

        for (; i<numofpassengers; i++){
            seatNum[i]=this.nonwindowseats(choice);
        }


    }


    public void Pass() {

        Date timenow = new Date();

        System.out.println();

        System.out.println("Date: " + timenow.toString());

        System.out.println("from:  " + source +"-------->to:  "+ destination);

        System.out.println("fare:" + numofpassengers*choice*30);

        System.out.println("Your seat numbers are:"); for(int j=0;j<numofpassengers;j++){System.out.println(seatNum[j]);}

        System.out.println("Please enjoy the ride.");

        System.out.println();

    }
}