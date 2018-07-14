package salesProcessing;

import static java.lang.System.out;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.text.NumberFormat;

public class Sales {

	private String typ;
	private String wojewodztwo;
	private String miesiac1;
	private int saleMaz;
	//private int MazFigure;
	
	
	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public String getMiesiac1() {
		return miesiac1;
	}

	public void setMiesiac1(String miesiac1) {
		this.miesiac1 = miesiac1;
	}

	public int getSaleMaz() {
		return saleMaz;
	}

	public void setSaleMaz(int saleMaz) {
		this.saleMaz = saleMaz;
	}

//	public int getMazFigure() {
//		return MazFigure;
//	}
//
//	public void setMazFigure(int mazFigure) {
//		MazFigure = mazFigure;
//	}




	public void readSales(Scanner discscanner) {

		typ = discscanner.next();
		wojewodztwo = discscanner.next();
		miesiac1 = discscanner.next();
		saleMaz = discscanner.nextInt();
	}

	public int showSaleFigure() {
		return saleMaz;
	}
	
	public String pokazTyp() {
		return typ;
	}
	
	public String pokazMiesiac1() {
		return miesiac1;
	}
	public String pokazwojewodztwo() {
		return wojewodztwo;
	}
	
	
	//Zapisywanie do pliku
	

public static void main(String[] args) throws IOException {
		
		File happyFile = new File("grubo1.txt"); 
		FileWriter fileWriter = new FileWriter(happyFile, true);
		BufferedWriter buffer = new BufferedWriter(fileWriter);
		PrintWriter printWriter = new PrintWriter(buffer);
		
		if (happyFile.exists()== false) {
			happyFile.createNewFile();
			System.out.println("The file has been created");
		} else {
			System.out.print("The file already exists");
		}
		System.out.println("The file is created...");
		
							
		printWriter.print(" Salesupdate\n");
		
		
		printWriter.close();System.out.println("The file is completed...");
	}
	

	public void writeSales() {
		out.print(typ);
		out.print("\t");
		out.print(wojewodztwo);
		out.print("\t");
		out.print(miesiac1);
		out.print("\t\t");
		out.print(saleMaz);
		out.println();
	}

}
