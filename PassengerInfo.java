package railway.management;

import java.io.Serializable;
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
import railway.management.SeatReservation.passengerinfo;

class info implements Serializable{
    private static final long serialVersionUID = 1L;
    String name;
    int age;
    char gender;
    int pnr;
    Random r= new Random();
    transient Scanner sc = new Scanner(System.in);

    info(){

    }

    info(String n, int age, char g, int pnr) {
        this.name=n;
		this.age=age;
        this.gender=g;
        this.pnr=pnr;
	}

    
    public String setName(){
        System.out.print("Enter name:   ");
        this.name=sc.nextLine();
        return this.name;
    }

    public int setAge(){
        System.out.print("Enter age:   ");
        this.age=sc.nextInt();
        return this.age;
    }

    public char setGender(){
        System.out.print("Enter gender f/m/o:   ");
        this.gender=sc.next().charAt(0);
        return this.gender;
    }

    int getPnr(){
        this.pnr= r.nextInt(5000) ;
        return pnr;
    }
    @Override
	public String toString() {
		return ("name: "+ name+ "   age:" + age +"   gender:"+ gender +"    PNR:"+pnr );
	}
}
/*class passFile{
    public String[] getinfo(){
        info p1 = new info();
        String n= p1.setName();
        int a= p1.setAge();
        char g= p1.setGender();
        int p= p1.getPnr();
        String[] s={n, Integer.toString(a), String.valueOf(g), Integer.toString(g)};
        return s;
    }
}*/
public class PassengerInfo {
    public String[] getinfo(){
        info p1 = new info();
        String n= p1.setName();
        int a= p1.setAge();
        char g= p1.setGender();
        int p= p1.getPnr();
        String[] s={n, Integer.toString(a), String.valueOf(g), Integer.toString(p)};
        return s;
    }
    
    public static void main(String[] args) {
        PassengerInfo p1= new PassengerInfo();
        String[] pass=p1.getinfo();
        info s1 = new info(pass[0], Integer.parseInt(pass[1]), pass[2].charAt(0), Integer.parseInt(pass[3]));
        
        try {
			FileOutputStream f = new FileOutputStream(new File("myPassenger.ser"));
			ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(s1);

            o.close();
			f.close();
            
            FileInputStream fi = new FileInputStream(new File("myPassenger.ser"));
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
            info ps1 = (info) oi.readObject();
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