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

class data implements Serializable {

	private static final long serialVersionUID = 1L;
	private int trainNum;
    private int numStation;
    private String[] station = new String[20];

	data() {
	}


	data(int num, int n, String[] station) {
        this.trainNum = num;
		this.numStation=n;
		this.station=station;
	}

	public int getTrainNum(){
		return trainNum;
	}
	public int getNumStation(){
		return numStation;
	}

	public String[] getStations(){
		return station;
	}

	@Override
	public String toString() {
		return ("train: "+ trainNum + "   number of stations:" + numStation +"   " + station[0] +" - "+ station[numStation-1]);
	}
}



public class train {

	public static void main(String[] args) {
		String[] station1={"surat","vadodara","anand","nadiad","raipur","ujjain","dewas","indore"};
		data p1 = new data(1,8,station1);


		String[] station2={"Delhi","noida","mathura","ayodhya","kanpur","lucknow","agra","gwalior","bhopal","ujjain","indore"};
		data p2 = new data(2,11,station2);

		String[] station3={"indore","dewas","ujjain","raipur","nadiad","anand","vadodara","surat"};
		data p3 = new data(1,8, station3);

		String[] station4={"indore","ujjain","bhopal","gwalior","agra","lucknow","kanpur","ayodhya","mathura","noida","Delhi"};
		data p4 = new data(4,11, station4);

		String[] station5={"surat","vadodara","udaipur","ajmer","jaipur","agra","noida","delhi"};
		data p5 = new data(5,8, station5);

		String[] station6={"delhi","noida","agra","Jaipur","Ajmer","Udaipur","vadodara","surat","vapi","mumbai"};
		data p6 = new data(7, 10, station6);

		String[] station7={"patna","deoghar","durgapur","dhanbad","bardhaman","kolkata"};
		data p7 = new data(7, 6, station7);

		String[] station8={"mumbai","vapi","vadodara","udaipur","ajmer","jaipur","surat","agra","noida","delhi"};
		data p8 = new data(8,10, station8);

		String[] station9 = {"new delhi", "ghaziabad", "aligarh", "tundla", "etawah", "kanpur", "lucknow"};
		data p9 = new data(9,7,station9);

		String[] station10 = { "ujjain" ,"vidisha", "bina", "damoh", "katni", "satna", "prayagraj", "varanasi", "kashi", "patna" };
		data p10 = new data(10,10,station10);

		String[] station11 = { "bhopal", "sehore", "ujjain", "ratlam", "mandasor", "nimach", "chittaurgarh", "ajmer", "kishangarh", "jaipur"};
		data p11 = new data(11,10,station11);

		String[] station12 = { "jodhpur", "jaipur", "gandhinagar", "agra", "kanpur", "lucknow","faizabad", "ayodhya", "varanasi" };
		data p12 = new data(12,9,station12);

		String[] station13 = { "varanasi", "ayodhya", "faizabad", "lucknow", "Kanpur", "agra","gandhinagar", "jaipur", "jodhpur" };
		data p13 = new data(13,9,station13);

		String[] station14 = { "jaipur", "kishangarh", "ajmer", "chittaurgarh", "nimach", "mandasor", "ratlam", "ujjain", "sehore", "bhopal"};
				data p14 = new data(14,10,station14);

		String[] station15 = { "patna" ,"kashi", "varanasi", "prayagraj", "satna", "katni", "damoh", "bina", "vidisha", "ujjain" };
				data p15 = new data(15,10,station15);

		String[] station16 = {"lucknow", "kanpur", "etawah", "Tundla", "aligarh", "ghaziabad", "new delhi"};
				data p16 = new data(16,7,station16);

		String[] station17 = { "mumbai" ,"panvel", "ratnagiri", "kudal", "madgaon", "udupi", "mangalore", "kannur", "alleppey","kollam" };
				data p17 = new data(17,10,station17);

		String[] station18 = { "kollam" ,"alleype", "kannur", "mangalore", "udupi", "madgaon", "kudal", "ratnagiri", "panvel","mumbai" };
				data p18 = new data(18,10,station18);

		String[] station19 = { "new delhi" ,"mathura", "agra","jhansi", "bhopal", "itarsi", "nagpur", "sirpur", "warangal", "nellore", "gudur", "chennai", "puducherry", "tiruchirapalli", "madurai", "kanyakumari" };
				data p19 = new data(19,16,station19);

		String[] station20 = { "kanyakumari" , "madurai", "tiruchirapalli", "puducherry", "chennai","gudur", "nellore", "warangal", "sirpur", "nagpur", "itarsi", "bhopal", "jhansi", "agra", "mathura", "new delhi" };
				data p20 = new data(20,16,station20);

		String[] station21={"kolkata","bardhaman","dhanbad","durgapur","deoghar","patna"};
		data p21= new data(21, 6, station21);
		
		String[] station22={"new delhi","mathura","agra","gwalior","jhansi","bina","bhopal","itarsi","belapur","ahmadnagar", "solapur","anantapur","hindupur","bangalore"};
		data p22= new data(21, 14, station22);

		try {
		
			FileOutputStream f = new FileOutputStream(new File("myTrains.ser"));
			ObjectOutputStream o = new ObjectOutputStream(f);

			// Write objects to file
			o.writeObject(p1);
			o.writeObject(p2);
			o.writeObject(p3);
			o.writeObject(p4);
			o.writeObject(p5);
			o.writeObject(p6);
			o.writeObject(p7);
			o.writeObject(p8);
			o.writeObject(p9);
			o.writeObject(p10);
			o.writeObject(p11);
			o.writeObject(p12);
			o.writeObject(p13);
			o.writeObject(p14);
			o.writeObject(p15);
			o.writeObject(p16);
			o.writeObject(p17);
			o.writeObject(p18);
			o.writeObject(p19);
			o.writeObject(p20);
			o.writeObject(p21);

			o.close();
			f.close();

			FileInputStream fi = new FileInputStream(new File("myTrains.ser"));
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
			data pr1 = (data) oi.readObject();
			data pr2 = (data) oi.readObject();
			data pr3 = (data) oi.readObject();
			data pr4 = (data) oi.readObject();
			data pr5 = (data) oi.readObject();
			data pr6 = (data) oi.readObject();
			data pr7 = (data) oi.readObject();
			data pr8 = (data) oi.readObject();
			data pr9 = (data) oi.readObject();
			data pr10 = (data) oi.readObject();
			data pr11 = (data) oi.readObject();
			data pr12= (data) oi.readObject();
			data pr13= (data) oi.readObject();
			data pr14= (data) oi.readObject();
			data pr15= (data) oi.readObject();
			data pr16= (data) oi.readObject();
			data pr17= (data) oi.readObject();
			data pr18= (data) oi.readObject();
			data pr19= (data) oi.readObject();
			data pr20= (data) oi.readObject();
			data pr21= (data) oi.readObject();
			System.out.println(pr1.toString());
			System.out.println(pr2.toString());
			System.out.println(pr3.toString());
			System.out.println(pr4.toString());
			System.out.println(pr5.toString());
			System.out.println(pr6.toString());
			System.out.println(pr7.toString());
			System.out.println(pr8.toString());
			System.out.println(pr9.toString());
			System.out.println(pr10.toString());
			System.out.println(pr11.toString());
			System.out.println(pr12.toString());
			System.out.println(pr13.toString());
			System.out.println(pr14.toString());
			System.out.println(pr15.toString());
			System.out.println(pr16.toString());
			System.out.println(pr17.toString());
			System.out.println(pr18.toString());
			System.out.println(pr19.toString());
			System.out.println(pr20.toString());
			System.out.println(pr21.toString());


			oi.close();
			fi.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

