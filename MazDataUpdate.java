package KlasyPrzejsciowe;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.Scanner;

import salesProcessing.Sales;

public class MazDataUpdate {

	int p; 

	public int getP() {
	return p;
}

public void setP(int p) {
	this.p = p;
}

	public static void main(String[] args) throws IOException {

		// Wczytywanie z liku
		Sales[] sprzedaz;
		sprzedaz = new Sales[8];
		Scanner discscanner = null;
		Scanner wczytaj = null;
		try {
			discscanner = new Scanner(new File("maz.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int mies = 0; mies <= 7; mies++) {
			sprzedaz[mies] = new Sales();
			sprzedaz[mies].readSales(discscanner);
		}
		System.out.println("********** Testowe wyœwietlenie wartoœci obiektów **************");

		for (int i = 0; i <= 7; i++) {

			System.out.println(sprzedaz[i].pokazTyp());
			System.out.println(sprzedaz[i].pokazwojewodztwo());
			System.out.println(sprzedaz[i].pokazMiesiac1());
			System.out.println(sprzedaz[i].showSaleFigure());
		}
		System.out.println("********** Testowe wyœwietlenie wartoœci jednego obiektu  **************");

		System.out.println(sprzedaz[0].pokazTyp());
		System.out.println(sprzedaz[0].pokazwojewodztwo());
		System.out.println(sprzedaz[0].pokazMiesiac1());
		System.out.println(sprzedaz[0].showSaleFigure());

		// ************** Zapisywanie do pliku *********************
//******************* definicja obiektów zapisywania ****************************
		File happyFile = new File("grubo1.txt");
		FileWriter fileWriter = new FileWriter(happyFile, true);
		BufferedWriter buffer = new BufferedWriter(fileWriter);
		PrintWriter printWriter = new PrintWriter(buffer);

		if (happyFile.exists() == false) {
			happyFile.createNewFile();
			System.out.println("The file has been created");
		} else {
			System.out.print("The file already exists");
		}
		System.out.println("The file is created...");
//***************** operacja aktualizcji osatniego miesi¹caq *************************
		
		
		
		
		
		//****************  pêtla zapisywania **************************
		
		
	
		
		for (int i = 0; i <= 7; i++) {

			printWriter.println(sprzedaz[i].pokazTyp());
			printWriter.println(sprzedaz[i].pokazwojewodztwo());
			printWriter.println(sprzedaz[i].pokazMiesiac1());
			printWriter.println(sprzedaz[i].showSaleFigure());

		}
		printWriter.print(sprzedaz[0].pokazTyp());
		printWriter.print(" hello world\n");
		printWriter.close();
		System.out.println("The file is completed...");
	}

}
