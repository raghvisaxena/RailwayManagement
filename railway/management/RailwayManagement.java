package railway.management;
import java.io.IOException;
import java.util.Scanner;
import railway.management.*;
public class RailwayManagement {

    public static void main(String[] args) {
    int choice=0;
    Scanner obj=new Scanner(System.in);
    
    while(choice !=5){
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.println("Press: \n 1- Train Search\n 2- Seat Reservation \n 3- Booking Status \n 4- Ticket Cancellation \n 5- Exit");
        System.out.println("---------------------------------------------------------------------------------------------------------------------\n\n");
        choice = obj.nextInt();

        if(choice==1){
            SeatReservation obj1=new SeatReservation();
            if(obj1.Destination())
             continue;
            if(obj1.trainSearch())
             continue;
        }
        if(choice ==2){
            SeatReservation obj2=new SeatReservation();
            if(obj2.Destination())
             continue;
            if(obj2.trainSearch())
             continue;
            obj2.getTrain();
            if(obj2.readChart())
             continue;
            obj2.passenger();
            try {
                if (obj2.preference())
                    continue;
            } catch (IOException e) {
                System.out.print("Caught ");
                e.printStackTrace();
            }
            obj2.passengerFile();
            obj2.Pass();
        }
        if(choice == 3) {
            bookingstatus b = new bookingstatus();
            b.bookingstatusinfo();
        }
        if(choice == 4) {
            Cancellation c = new Cancellation();
                c.cancelTicket();
        }
    }
    obj.close();
    }

}
