package DataBase
;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


import KlasyPrzejsciowe.Warminskie_obiekt_do_bazy;
import salesProcessing.Sales;

public class Obsluga_Bazy {

	//Laczenie sie do servera 
		
	private static String url = "jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf";
	private static String uzytkownik = "mmaciej3";
	private static String haslo = "mmaciej3";

	private static ResultSet rs;
	private static Statement polecenie;
	private static Connection polaczenie;
	

	public static void polacz_z_baza() {
		try {
			polaczenie = DriverManager.getConnection(url, uzytkownik, haslo);
			System.out.println("Sukces!. Pod³¹czono do bazy");
			polecenie = polaczenie.createStatement();
		} catch (SQLException e) {
			System.out.println("B³¹d programu!");
			e.printStackTrace();}}
	


	public static void zapisz_do_tablicy_Ocenianie(String sql) {
		try {
			System.out.println("zapisano: " + polecenie.executeUpdate(sql)); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//Zaopytanie bazy
	public static boolean sprawdzBaze(String sql) {
		boolean exist = false;
		try {
			rs = polecenie.executeQuery(sql);
			exist = rs.next();
			rs.close();
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return exist;
	}
	//weryfikacja wartosci liczbowej 
	public static void jestCyfra(Scanner input) {
		while (!input.hasNextInt()) {
			System.out.println("WprowadŸ cyfre:");
			input.next();
		}
	}
	//Zaladowanie danych warminskie 
	public static void warminskie_zaloz_tablice() {
		try {
		String warminskie = "CREATE TABLE warminskie (miesiac integer not null, sprzedaz integer not null)";
		System.out.println("laduje: " + polecenie.execute(warminskie));
	}catch (Exception e) {
		System.out.println("B³¹d programu!");
		e.printStackTrace();}}
	//ladowanie danych Warminksie do tablicy SQL
	
	public static void warminskie_laduj_dane_do_sql() {
		try {
			String warminskie1 = "INSERT INTO warminskie(typ, wojewodztwo, miesiac1, salemaz)" + "VALUES('Osobowy','Mazowieckie','Styczen', 23190)";
			String warminskie2 = "INSERT INTO warminskie(typ, wojewodztwo, miesiac1, salemaz)" + "VALUES('Osobowy','Mazowieckie','luty', 24955)";
			String warminskie3 = "INSERT INTO warminskie(typ, wojewodztwo, miesiac1, salemaz)" + "VALUES('Osobowy','Mazowieckie','Marzec', 34164)";
			String warminskie4 = "INSERT INTO warminskie(typ, wojewodztwo, miesiac1, salemaz)" + "VALUES('Osobowy','Mazowieckie','Kwiecien', 29017)";
			String warminskie5 = "INSERT INTO warminskie(typ, wojewodztwo, miesiac1, salemaz)" + "VALUES('Osobowy','Mazowieckie','Maj', 25429)";
			String warminskie6 = "INSERT INTO warminskie(typ, wojewodztwo, miesiac1, salemaz)" + "VALUES('Osobowy','Mazowieckie','Czerwiec', 2605)";
			String warminskie7 = "INSERT INTO warminskie(typ, wojewodztwo, miesiac1, salemaz)" + "VALUES('Osobowy','Mazowieckie','Lipiec', 28327)";
			String warminskie8 = "INSERT INTO warminskie(typ, wojewodztwo, miesiac1, salemaz)" + "VALUES('Osobowy','Mazowieckie','Sierpien', 26778)";
			
			
		System.out.println("laduje: " + polecenie.execute(warminskie1));
		System.out.println("laduje: " + polecenie.execute(warminskie2));
		System.out.println("laduje: " + polecenie.execute(warminskie3));
		System.out.println("laduje: " + polecenie.execute(warminskie4));
		System.out.println("laduje: " + polecenie.execute(warminskie5));
		System.out.println("laduje: " + polecenie.execute(warminskie6));
		System.out.println("laduje: " + polecenie.execute(warminskie7));
		System.out.println("laduje: " + polecenie.execute(warminskie8));
		
	} catch (Exception e) {
		System.out.println("B³¹d programu!");
		e.printStackTrace();}}
	
	//*************************************************************
		//* Metoda aktualizacji pliku do bazy danych  
	//**********************************
	
	public static void Warm_aktualizacja_pliku_do_bazy_SQL() {
		
		try {
			String url = "jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf";
			String uzytkownik 	= "mmaciej3";
			String haslo 		= "mmaciej3";
			String sql1 = "SELECT typ, wojewodztwo, miesiac1, salemaz FROM warminskie" ;
						Connection polaczenie = DriverManager.getConnection(url, uzytkownik, haslo);
			System.out.println("AutoCommit: "+ polaczenie.getAutoCommit());
			Statement polecenie = polaczenie.createStatement();
			
			ResultSet rs = polecenie.executeQuery(sql1);
			
			int z = 0;
			
			while (rs.next()) {
				System.out.println(rs.getString("TYP")+"|"+rs.getString("WOJEWODZTWO")+"|"+rs.getString("MIESIAC1")+"|"+rs.getInt("SALEMAZ"));
				
			
			
			
			
			
			}
			
			polaczenie.close();
		} catch (SQLException e) {
			System.out.println("Nieudane poÅ‚Ä…czenie z bazÄ… danych!");
			e.printStackTrace();
			return;
		}
		System.out.println("Sukces!");
	}
		
	
	
	//*************************************************************
	//* Metoda updatujaca tablicy SQL Warminskie
	//*************************************************************
	public static void Warm_Update_czerwiec() {
		try {
			String url = "jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf";
			String uzytkownik 	= "mmaciej3";
			String haslo 		= "mmaciej3";
			Sales[] sprzedaz;
			sprzedaz = new Sales[8];
			Scanner discscanner = null;
			Scanner wczytaj = null;
			try {
				discscanner = new Scanner(new File("maz.txt"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();}
			for (int mies = 0; mies <= 7; mies++) {
				sprzedaz[mies] = new Sales();
				sprzedaz[mies].readSales(discscanner);
				}
			int a, b, c, d, u, f, g, h;
			f = sprzedaz[0].showSaleFigure();
			u = sprzedaz[1].showSaleFigure();
			d = sprzedaz[2].showSaleFigure();
			a = sprzedaz[3].showSaleFigure();
			b = sprzedaz[4].showSaleFigure();
			c = sprzedaz[5].showSaleFigure();
			//*************************************************************
			//* Update tablicy SQL
			//*************************************************************
			
			String sql1 = "UPDATE warminskie SET salemaz ="+ c +"WHERE miesiac1 = 'Czerwiec' " ;
		
			Connection polaczenie = DriverManager.getConnection(url, uzytkownik, haslo);
			System.out.println("AutoCommit: "+ polaczenie.getAutoCommit());
			Statement polecenie = polaczenie.createStatement();
			System.out.println("execute: "+ polecenie.execute(sql1));
			
			
			polaczenie.close();
		} catch (SQLException e) {
			System.out.println("Nieudane poÅ‚Ä…czenie z bazÄ… danych!");
			e.printStackTrace();
			return;
		}
		System.out.println("Sukces!");
		
	}
	
	// Wczytywanie danych z talblicy SQL do obiektu
	public static void warminskie_wczytaj_dane() {
		
		Warminskie_obiekt_do_bazy s1= new Warminskie_obiekt_do_bazy();
		try {
			String sql1 = "SELECT miesiac1, salemaz FROM warminskie" ;
			ResultSet rs = polecenie.executeQuery(sql1);
			int dd=0;
			while (rs.next()) {
				System.out.println(rs.getString("MIESIAC1")+"	|"+rs.getInt("Salemaz"));
				s1.setSprzedaz(rs.getInt("SALEMAZ"));
				System.out.println("RRRRRRRRRR" +s1.getSprzedaz());
				
				
			}
		} catch (SQLException e) {
			System.out.println("Nieudane poÅ‚Ä…czenie z bazÄ… danych!");
			e.printStackTrace();
			return;	}}
		
		
	
	
	
//	public static void utworz_dane() {
//		try {
//			// String url = "jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf";
//						// String uzytkownik = "mmaciej3";
//						// String haslo = "mmaciej3";
//						
//			
//			
//			String sql1 = "CREATE TABLE ocenianie(rodzaj_oceny char(1) not null, idp integer not null, idn integer not null, idu integer not null, ido integer not null)";
//						String sql2 = "CREATE TABLE ocena ("+"ido integer not null,"+ "opis_oceny char(20) not null,"+ "wartosc_oceny float not null)";
//						String sql3 = "CREATE TABLE nauczyciel (" + "idn integer not null," + "imie_nauczyciela char(20) not null,"
//								+ "nazwisko_nauczyciela char(30) not null)";
//						String sql4 = "CREATE TABLE przedmiot (" + "idp integer not null," + "nazwa_przedmiotu char(20) not null" + ")";
//						String sql5 = "CREATE TABLE uczen ("+"idu integer not null,"+ "imie_ucznia char(20) not null,"+ "nazwisko_ucznia char(30) not null)";
//						
//						String ocena1 = "INSERT INTO ocena(ido, opis_oceny, wartosc_oceny)" + "VALUES(1, 'BDB',5) ";
//						String ocena2 = "INSERT INTO ocena(ido, opis_oceny, wartosc_oceny)" + "VALUES(2, 'DB',4) ";
//						String ocena3 = "INSERT INTO ocena(ido, opis_oceny, wartosc_oceny)" + "VALUES(3, 'DST',3) ";
//						String ocena4 = "INSERT INTO ocena(ido, opis_oceny, wartosc_oceny)" + "VALUES(4, 'NDST','2') ";
//						
//						String n1 = "INSERT INTO nauczyciel(idn, imie_nauczyciela, nazwisko_nauczyciela)" + "VALUES(1, 'NAUCZYCIEL','MATEMATYKI') ";
//						String n2 = "INSERT INTO nauczyciel(idn, imie_nauczyciela, nazwisko_nauczyciela)" + "VALUES(2, 'NAUCZYCIELKA','FIZYKI') ";
//						String n3 = "INSERT INTO nauczyciel(idn, imie_nauczyciela, nazwisko_nauczyciela)" + "VALUES(3, 'NAUCZYCIELka','INFORMATYKI') ";
//						String n4 = "INSERT INTO nauczyciel(idn, imie_nauczyciela, nazwisko_nauczyciela)" + "VALUES(4, 'NAUCZYCIEL','ANGIELSKIEGO') ";
//						
//						String p1 = "INSERT INTO przedmiot(idp, nazwa_przedmiotu)" + "VALUES(1, 'MATEMATYKA') ";
//						String p2 = "INSERT INTO przedmiot(idp, nazwa_przedmiotu)" + "VALUES(2, 'FIZYKA') ";
//						String p3 = "INSERT INTO przedmiot(idp, nazwa_przedmiotu)" + "VALUES(3, 'INFORMATYKA') ";
//						String p4 = "INSERT INTO przedmiot(idp, nazwa_przedmiotu)" + "VALUES(4, 'ANGIELSKI') ";
//						
//						String u1 = "INSERT INTO uczen(idu, imie_ucznia, nazwisko_ucznia)" + "VALUES(1, 'uczen1','nazwisko1') ";
//						String u2 = "INSERT INTO uczen(idu, imie_ucznia, nazwisko_ucznia)" + "VALUES(2, 'uczen2','nazwisko2') ";
//						String u3 = "INSERT INTO uczen(idu, imie_ucznia, nazwisko_ucznia)" + "VALUES(3, 'uczen3','nazwisko3') ";
//						String u4 = "INSERT INTO uczen(idu, imie_ucznia, nazwisko_ucznia)" + "VALUES(4, 'uczen4','nazwisko4') ";
//						
//						// Connection polaczenie = DriverManager.getConnection(url, uzytkownik, haslo);
//						// System.out.println("AutoCommit: " + polaczenie.getAutoCommit());
//						//Statement polecenie = polaczenie.createStatement();
//						System.out.println("execute: " + polecenie.execute(sql1));
//						System.out.println("execute: " + polecenie.execute(sql2));
//						System.out.println("execute: " + polecenie.execute(sql3));
//						System.out.println("execute: " + polecenie.execute(sql4));
//						System.out.println("execute: " + polecenie.execute(sql5));
//						
//						System.out.println("execute: " + polecenie.execute(ocena1));
//						System.out.println("execute: " + polecenie.execute(ocena2));
//						System.out.println("execute: " + polecenie.execute(ocena3));
//						System.out.println("execute: " + polecenie.execute(ocena4));
//						
//						System.out.println("execute: " + polecenie.execute(n1));
//						System.out.println("execute: " + polecenie.execute(n2));
//						System.out.println("execute: " + polecenie.execute(n3));
//						System.out.println("execute: " + polecenie.execute(n4));
//						
//						System.out.println("execute: " + polecenie.execute(p1));
//						System.out.println("execute: " + polecenie.execute(p2));
//						System.out.println("execute: " + polecenie.execute(p3));
//						System.out.println("execute: " + polecenie.execute(p4));
//						
//						System.out.println("execute: " + polecenie.execute(u1));
//						System.out.println("execute: " + polecenie.execute(u2));
//						System.out.println("execute: " + polecenie.execute(u3));
//						System.out.println("execute: " + polecenie.execute(u4));
//						
//		} catch (Exception e) {
//			System.out.println("B³¹d programu!");
//			e.printStackTrace();
//		}
	
}