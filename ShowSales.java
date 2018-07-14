package salesProcessing;

import static java.lang.System.out;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.lang.model.element.NestingKind;

public class ShowSales {
	
	int a;

	public static void main(String[] args) throws IOException {
		int a;
		Sales sprzedaz[];
		sprzedaz = new Sales[8];
		SalesPomorskie sprzedazPom[];
		sprzedazPom = new SalesPomorskie[8]; 
		SalesSummaryOsobowe summary[];
		summary = new SalesSummaryOsobowe[8];
		
//		SalesSummaryOsobowe totalPL[];
//		totalPL = new SalesSummaryOsobowe[8];
		
	
		
		Scanner discscanner = new Scanner(new File("maz.txt"));
		
		for (int mies=0; mies<=7; mies++) {
			sprzedaz[mies] = new Sales();
			sprzedaz[mies].readSales(discscanner);
		}
				
		Scanner pomScanner = new Scanner(new File("pom.txt"));
		for (int mies=0; mies<=7; mies++) {
			sprzedazPom[mies] = new SalesPomorskie();
			sprzedazPom[mies].readSalesPom(pomScanner);
		}
		
		
		out.println("typ\twojewodztwo\tmiesiac\t\tsprzedaz");
		for (int mies=0; mies<=7; mies++) {
			sprzedaz[mies].writeSales();
		}
		out.println("<------- PRZERWA ------->");
		out.println("typ\twojewodztwo\tmiesiac\t\tsprzedaz");
		for (int mies=0; mies<=7; mies++) {
			sprzedazPom[mies].writeSalesPom();
		}
		out.println("typ\twojewodztwo\tmiesiac\t\tsprzedaz");
		for (int mies=0; mies<=7; mies++) {
			sprzedaz[mies].showSaleFigure();

		}
		out.println("<------- PRZERWA ------->");
		
		
		out.println(sprzedaz[1].showSaleFigure()+sprzedaz[2].showSaleFigure());
		out.println("<------- PRZERWA ------->");
		a= sprzedaz[1].showSaleFigure()+sprzedaz[2].showSaleFigure();
		
		out.println(a);
		discscanner.close();
		pomScanner.close();
		
	}
	
}
