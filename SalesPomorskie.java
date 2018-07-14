package salesProcessing;

import static java.lang.System.out;
import java.util.Scanner;
import java.text.NumberFormat;

public class SalesPomorskie {

	private String typ;
	private String wojewodztwo;
	private String miesiac;
	private int salePom;
	private int PomFigure;
	
	
	public void readSalesPom (Scanner pomScanner) {
						typ = pomScanner.next();
		wojewodztwo = pomScanner.next();
		miesiac= pomScanner.next();
		salePom = pomScanner.nextInt();
			}
	
	public void showSaleFigure() {
		PomFigure= salePom;
	}
	public void writeSalesPom() {
		out.print(typ);
		out.print("\t");
		out.print(wojewodztwo);
		out.print("\t");
		out.print(miesiac);
		out.print("\t\t");
		out.print(salePom);
		out.println();
	
		
	}
	
}
