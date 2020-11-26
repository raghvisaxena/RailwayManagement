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
        System.out.println("Press: \n 1- Train Search\n 2- Seat Reservation \n 3- Booking Status \n 4-Ticket Cancellation \n 5- Exit");
        System.out.println("---------------------------------------------------------------------------------------------------------------------\n\n");
        choice =obj.nextInt();
        if(choice==1){
            SeatReservation obj1=new SeatReservation();
            obj1.Destination();
            obj1.trainSearch();
        }
        if(choice ==2){
        SeatReservation obj2=new SeatReservation();
        obj2.Destination();
        obj2.trainSearch();
        obj2.getTrain();
        obj2.readChart();
        obj2.passenger();
        obj2.preference();
        obj2.Pass();
        }
        if(choice == 4) {
        Cancellation c = new Cancellation();
        try {
			c.cancelTicket();
		} catch (IOException e) {
			e.printStackTrace();
		}
        }
    }
    obj.close();
    }

}