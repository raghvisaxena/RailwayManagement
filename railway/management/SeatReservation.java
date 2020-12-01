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
    ArrayList<Integer> seatNum = new ArrayList<Integer>(numofpassengers);

    public void Destination(){
        System.out.println("------------------------------");
        System.out.println("Welcome to the Railway");
        System.out.println("Enter the day");d=s.nextLine();
        System.out.println("Enter the your destinantion");destination=s.nextLine();
        System.out.println("Enter the your source");source=s.nextLine(); 
        System.out.println("------------------------------");System.out.println("\n");
    }

    
    public boolean trainSearch(){
        try {
            int count=0;
            FileInputStream fileIn = new FileInputStream("C:\\Users\\hp\\myTrains.ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            for(int i=0;i<22;i++){
            Object obj = objectIn.readObject();
            data pr1=(data) obj;
            String[] s=pr1.getStations();
            int c=0;
            for(int j=0;j < pr1.getNumStation();j++){
                for(int k=j+1;k<pr1.getNumStation();k++){
                    if((s[j].equals(source)) && (s[k].equals(destination))){
                        System.out.println(pr1.toString());
                    }    
                    else{
                        c++;
                    }    
                }
            }
            if(c==pr1.getNumStation()*(pr1.getNumStation()-1)/2)
                count++; 
        }
            objectIn.close();
            fileIn.close();

            if(count==22){
                System.out.println("No Trains Available\n");
                return true; 
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public void getTrain(){
        System.out.println("Enter Train of your choice");
        trainNumber=s.nextInt();
    }

    public void readChart(){
        try {
 
            FileInputStream fi = new FileInputStream("C:\\Users\\hp\\seatAllocation.ser");
            ObjectInputStream oi = new ObjectInputStream(fi);
            for(int i=0;i<154;i++){
            SeatChart pr1=(SeatChart) oi.readObject();
            
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
   

    public int nonwindowseats(int choice, SeatChart SEAT_CHART){
        if (choice==1){
        if(SEAT_CHART.gen[103]!=1)
        {
            for(int i=0;i<104;i++)
            {if(i%2==1 && SEAT_CHART.gen[i]!=1){
                SEAT_CHART.gen[i]=1;
                //countg--;
                return i;}
            }
            
        }
    }

        if(choice==2)
        {
            if(SEAT_CHART.AC3[103]!=1){
            for(int i=0;i<104;i++)
            {if(i%2==1  && SEAT_CHART.AC3[i]!=1){
                SEAT_CHART.AC3[i]=1;
                //countAC3--;
                return i;}}
            }
        }

        if(choice==3)
        {
            for(int i=0;i<54;i++)
            {if(i%2==1  && SEAT_CHART.AC2[i]!=1){
                SEAT_CHART.AC2[i]=1;
                //countAC2--;
                return i;
            }
            } 
        }

        if(choice==4)
        {
            for(int i=0;i<54;i++)
            {if(i%2==1  && SEAT_CHART.AC1[i]!=1){
                SEAT_CHART.AC1[i]=1;
                //countAC1--;
                return i;}
            }
        }
        

        return -1;

    }

    public int windowseats(int choice, SeatChart SEAT_CHART){
        if(choice==1)
        {
            for(int i=1;i<=104;i++)
            {if(i%2==0 && SEAT_CHART.gen[i]!=1){
                SEAT_CHART.gen[i]=1;
                //countg--;
                return i;}}}

        else if(choice==2)
        {
            for(int i=1;i<=104;i++)
            {if(i%2==0  && SEAT_CHART.AC3[i]!=1){
                SEAT_CHART.AC3[i]=1;
                //countAC3--;
                return i;}}}

        else if(choice==3)
        {
            for(int i=1;i<=54;i++)
            {if(i%2==0  && SEAT_CHART.AC2[i]!=1){
                SEAT_CHART.AC2[i]=1;
                //countAC2--;
                return i;}}}

        else if(choice==4)
        { 
            for(int i=1;i<=54;i++)
            {if(i%2==0  && SEAT_CHART.AC1[i]!=1){
                SEAT_CHART.AC1[i]=1;
                //countAC1--;
                return i;}}}

        return -1;

    }
    
    
    public void passenger(){
        System.out.println("Enter number of passengers");
        numofpassengers=s.nextInt();
    }
 
    public void preference() {
        System.out.println("Enter number of window seats");
        int ws=s.nextInt();

        try{
            FileInputStream fin = new FileInputStream(new File("C:\\Users\\Dhara Patel\\Desktop\\RailwayManagement\\seatAllocation.ser"));
            ObjectInputStream oin = new ObjectInputStream(fin);
            FileOutputStream fout = new FileOutputStream(new File("temp.ser"));
            ObjectOutputStream oout = new ObjectOutputStream(fout);

            for(int j=0;j<154;j++){
                SeatChart sc1 = (SeatChart) oin.readObject();
            
                if(sc1.getDay().equals(d) && sc1.getTrainNumber()==trainNumber){
                    int i=0;
                    for(;i<ws;i++){
                        seatNum.add(this.windowseats(choice, sc1));
                    }

                    for (; i<numofpassengers; i++){
                        seatNum.add(this.nonwindowseats(choice, sc1));
                    }
                    
                    oout.writeObject(sc1);    
                }
                else{
                    oout.writeObject(sc1);
                }
            }

            oin.close();
            fin.close();
            oout.close();
            fout.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        File file = new File("C:\\Users\\Dhara Patel\\Desktop\\RailwayManagement\\seatAllocation.ser");
        file.delete();
        new File("C:\\Users\\Dhara Patel\\Desktop\\RailwayManagement\\temp.ser").renameTo(new File("seatAllocation.ser"));

    }

    public void passengerFile(){
    PassengerInfo psngr = new PassengerInfo();
    psngr.getinfo(trainNumber, d, seatNum, choice);
    }

    public void Pass() {

        Date timenow = new Date();

        System.out.println();

        System.out.println("Date: " + timenow.toString());

        System.out.println("from:  " + source +"-------->to:  "+ destination);

        System.out.println("fare:" + numofpassengers*choice*30);

        System.out.println("Your seat numbers are:" + seatNum); 
        System.out.println("Please enjoy the ride.");

        System.out.println();

    }
}