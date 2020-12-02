package railway.management;

import java.io.Serializable;
import java.util.Scanner;
import javax.lang.model.util.ElementScanner6;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import railway.management.*;

public class Cancellation { 

    void cancelTicket() {
        Scanner sc = new Scanner(System.in);
        int sn;

        System.out.println("enter name");
        String n = sc.nextLine();
        System.out.println("\nenter pnr");
        int pnr_num = sc.nextInt();
        
        String filename = (n +".txt");
        try{
        FileInputStream fi2 = new FileInputStream(new File(filename));
        ObjectInputStream oi2 = new ObjectInputStream(fi2);

        FileInputStream fi = new FileInputStream(new File("C:\\Users\\Dhara Patel\\Desktop\\RailwayManagement\\seatAllocation.ser"));
        ObjectInputStream oi = new ObjectInputStream(fi);

        FileOutputStream f = new FileOutputStream(new File("Canceltemp.ser"));
        ObjectOutputStream o = new ObjectOutputStream(f);

      
            PassengerInfo pi = (PassengerInfo) oi2.readObject();
            oi2.close(); 
            fi2.close();
            //new File(filename).delete();
          
            if(pi.getPnr() == pnr_num)
            {
                new File(filename).delete();
                System.out.println(pi.toString());

                for(int i=0; i<154; ++i){    
                    SeatChart chart = (SeatChart) oi.readObject();
                    if(chart.trainNumber == pi.gettn() && chart.date.equals(pi.getday()))
                    {
                        System.out.println("Enter the seat number(s) to be cancelled:- \n(Enter 0 after entering all seat numbers for cancellation) ");
                        switch(pi.getchoice())
                        {   
                            case 1 : do{
                                        sn = sc.nextInt();
                                        chart.gen[sn]=0;
                                        pi.getSeatnum().remove(Integer.valueOf(sn));
                                      } while(sn!=0);
                                      break;

                            case 2 : do{
                                        sn = sc.nextInt();
                                        chart.AC3[sn]=0;
                                        pi.getSeatnum().remove(Integer.valueOf(sn));
                                      } while(sn!=0);
                                      break;
                                      
                            case 3 : do{
                                        sn = sc.nextInt();
                                        chart.AC2[sn]=0;
                                        pi.getSeatnum().remove(Integer.valueOf(sn));
                                      } while(sn!=0);  
                                      break; 
                                      
                            case 4 : do{
                                        sn = sc.nextInt();
                                        chart.AC1[sn]=0;
                                        pi.getSeatnum().remove(Integer.valueOf(sn));
                                      } while(sn!=0);  
                                      break;          
                        }

                        o.writeObject(chart);
                    } 
                    else 
                    {
                        o.writeObject(chart);
                    } 
                }
              
            oi.close(); 
            fi.close();
            o.close();
            f.close();

             f = new FileOutputStream(new File(filename));
             o = new ObjectOutputStream(f);
            o.writeObject(pi);
            o.close();
            f.close();

                if(pi.getSeatnum().isEmpty())
                {
                System.out.println("\nAll booked seats have been cancelled\n");
                new File(filename).delete();
                } 
                else  
                System.out.println("\nYour booked seats after cancellation are : " + pi.getSeatnum() + "\n");
                
                File file1 = new File("C:\\Users\\Dhara Patel\\Desktop\\RailwayManagement\\seatAllocation.ser");
                file1.delete();
                new File("Canceltemp.ser").renameTo(new File("seatAllocation.ser"));
                
            }
            else   
            {
                o.writeObject(new SeatChart("temp", 1)); 
                o.close();
                f.close();
                new File("Canceltemp.ser").delete();
                
                System.out.println("\nWRONG PNR\n");
            }
            
        } catch (ClassNotFoundException e) {
            System.out.println("class not found");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
			System.out.println("No booking done under the respective name and PNR");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
        } 

    }
}
