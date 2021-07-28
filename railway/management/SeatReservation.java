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
    int numofpassengers;
    int trainNumber;
    int choice;
    String destination;
    String source;
    String d;
    ArrayList<Integer> seatNum = new ArrayList<Integer>(numofpassengers);

    public boolean Destination(){
        System.out.println("------------------------------");
        System.out.println("Welcome to the Railway");
        System.out.println("Enter the day");d=s.nextLine();
         if(!(d.equals("monday") || d.equals("tuesday") || d.equals("wednesday") || d.equals("thursday") || d.equals("friday") || d.equals("saturday") || d.equals("sunday")))
            {
                System.out.println("\nWrong input for day\nTry again");
                return true;
            }
        System.out.println("Enter the your destinantion");destination=s.nextLine();
        System.out.println("Enter the your source");source=s.nextLine(); 
        System.out.println("------------------------------");System.out.println("\n");
        return false;
    }

    
    public boolean trainSearch(){
        try {
            int count=0;
            FileInputStream fileIn = new FileInputStream("C:\\Users\\Dhara Patel\\Desktop\\RailwayManagement\\myTrains.ser");
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

    public Boolean readChart(){
        int j=0;
        try {
 
            FileInputStream fi = new FileInputStream("C:\\Users\\Dhara Patel\\Desktop\\RailwayManagement\\seatAllocation.ser");
            ObjectInputStream oi = new ObjectInputStream(fi);
            for(int i=0;i<154;i++){
            SeatChart pr1=(SeatChart) oi.readObject();
            
            if(pr1.getDay().equals(d) && pr1.getTrainNumber()==trainNumber){
                for(j=0; j<3; j++){  
                    pr1.show();
                    choice=pr1.getChoice();
                    if(choice>4 || choice<1){
                    System.out.println("Wrong input for choice\nEnter choice again");
                    continue;
                    } 
                    else 
                    break;
                }     
            }
            }
         oi.close();
         fi.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if(j==3)
         return true;
        else
         return false; 
    }
   

    public int nonwindowseats(int choice, SeatChart SEAT_CHART){
        if (choice==1)
        {
            for(int i=0;i<104;i++)
            {if(i%2==1 && SEAT_CHART.gen[i]!=1){
                SEAT_CHART.gen[i]=1;
                return i;}
            } 
        }

        if(choice==2)
        {
            for(int i=0;i<104;i++)
            {if(i%2==1  && SEAT_CHART.AC3[i]!=1){
                SEAT_CHART.AC3[i]=1;
                return i;}
            }
        }

        if(choice==3)
        {
            for(int i=0;i<54;i++)
            {if(i%2==1  && SEAT_CHART.AC2[i]!=1){
                SEAT_CHART.AC2[i]=1;
                return i;
            }
            } 
        }

        if(choice==4)
        {
            for(int i=0;i<28;i++)
            {if(i%2==1  && SEAT_CHART.AC1[i]!=1){
                SEAT_CHART.AC1[i]=1;
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
                return i;}}}

        else if(choice==2)
        {
            for(int i=1;i<=104;i++)
            {if(i%2==0  && SEAT_CHART.AC3[i]!=1){
                SEAT_CHART.AC3[i]=1;
                return i;}}}

        else if(choice==3)
        {
            for(int i=1;i<=54;i++)
            {if(i%2==0  && SEAT_CHART.AC2[i]!=1){
                SEAT_CHART.AC2[i]=1;
                return i;}}}

        else if(choice==4)
        { 
            for(int i=1;i<=28;i++)
            {if(i%2==0  && SEAT_CHART.AC1[i]!=1){
                SEAT_CHART.AC1[i]=1;
                return i;}}}

        return -1;
    }
    
    
    public void passenger(){
        System.out.println("Enter number of passengers");
        numofpassengers=s.nextInt();
    }
 
    public Boolean preference() throws IOException {
        System.out.println("Enter number of window seats");
        int ws=s.nextInt();
        int wsc=0,nwsc=0;

        FileInputStream fin = new FileInputStream(new File("C:\\Users\\Dhara Patel\\Desktop\\RailwayManagement\\seatAllocation.ser"));
        ObjectInputStream oin = new ObjectInputStream(fin);
        FileOutputStream fout = new FileOutputStream(new File("temp.ser"));
        ObjectOutputStream oout = new ObjectOutputStream(fout);
        try{
            for(int j=0;j<154;j++){
                SeatChart sc1 = (SeatChart) oin.readObject();
            
                if(sc1.getDay().equals(d) && sc1.getTrainNumber()==trainNumber){

                    int i=0;
                    for(;i<ws;i++){
                        wsc=this.windowseats(choice, sc1);
                        if(wsc!=-1)
                                seatNum.add(wsc);
                        else{
                                System.out.println("Enough window seats not available");
                                seatNum.clear(); 
                                System.out.println("Press enter to continue");
                                Scanner sc = new Scanner(System.in);
                                sc.nextLine();

                                return true;
                            }
                    }

                    for (; i<numofpassengers; i++){
                        nwsc=this.nonwindowseats(choice, sc1);
                        if(nwsc!=-1)
                         seatNum.add(nwsc);
                        else{
                            System.out.println("Enough nonwindow seats not available");
                            seatNum.clear(); 
                            System.out.println("Press enter to continue");
                            Scanner sc = new Scanner(System.in);
                            sc.nextLine(); 
                            
                            return true;
                        }   
                    }
                
                    oout.writeObject(sc1);    
                }
                else{
                    oout.writeObject(sc1);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            oin.close();
            fin.close();
            oout.close();
            fout.close();

            if(wsc==-1 || nwsc==-1)
             new File("C:\\Users\\Dhara Patel\\Desktop\\RailwayManagement\\temp.ser").delete(); 
        }
        

        File file = new File("C:\\Users\\Dhara Patel\\Desktop\\RailwayManagement\\seatAllocation.ser");
        file.delete();
        new File("C:\\Users\\Dhara Patel\\Desktop\\RailwayManagement\\temp.ser").renameTo(new File("seatAllocation.ser"));
        
        return false;
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
