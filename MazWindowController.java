package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.Scanner;

import DataBase.Obsluga_Bazy;
import KlasyPrzejsciowe.MazDataUpdate;
import KlasyPrzejsciowe.Warminskie_obiekt_do_bazy;
import Person.Person;
import SalesUpdate.MazUpdate;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import salesProcessing.Sales;
import salesProcessing.ShowSales;

public class MazWindowController implements Initializable {

	private static String url = "jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf";
	private static String uzytkownik = "mmaciej3";
	private static String haslo = "mmaciej3";

	private static ResultSet rs;
	private static Statement polecenie;
	private static Connection polaczenie;

	private Stage mazStage;
	private ShowSales a1;
	private MazUpdate u;
	
	private int nowaSprzedazMazInt;
	private int nowaSprzedazMazInt1;
	private int ilosc;
	

	@FXML
	private BarChart<?, ?> BarChart;

	@FXML
	private CategoryAxis x;

	@FXML
	private NumberAxis y;

	@FXML
	private Label lblCar;
	@FXML
	private TextField txtFieldCar;

	@FXML
	private Button raportButton;

	public MazWindowController(int amount) {
		ilosc = amount;
	}
	
	public int amount()
	{
		return ilosc;
	}
	
	public MazWindowController add(MazWindowController mazT) {
		return new MazWindowController(amount()+mazT.amount());
	}

	public int compare (MazWindowController mazT) {
		if (amount() == mazT.ilosc)
		{
			return 1;
		}
	
		else if(amount() ! = mazT.ilosc) {
			return 0;
		}
	}


	public void setMazStage(Stage mazStage) {
		this.mazStage = mazStage;

	}

	@FXML
	public void CloseAnimation() {
		mazStage.close();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
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
		// ****************************************************************************************
		// ****************** Operacje na bazach
		// ********************************************************************************

		Obsluga_Bazy.polacz_z_baza();
		Obsluga_Bazy.Warm_aktualizacja_pliku_do_bazy_SQL();
		//Obsluga_Bazy.warminskie_zaloz_tablice();
		//Obsluga_Bazy.warminskie_laduj_dane_do_sql();
		 //Obsluga_Bazy.warminskie_wczytaj_dane();

		// obiekt do przechqwycenia sprzeda�y z klasy SQL
		Obsluga_Bazy.Warm_Update_czerwiec();
		Warminskie_obiekt_do_bazy s1 = new Warminskie_obiekt_do_bazy();

		// Obsluga_Bazy.sprawdzBaze("SELECT miesiac, sprzedaz FROM warminskie");
		// System.out.println("DD: " + Obsluga_Bazy.sprawdzBaze("SELECT sprzedaz FROM
		// warminskie"));

		 Sales[] sql;
		 sql = new Sales[8];
		 for (int yy= 0; yy<=7; yy++ ) {
		 sql[yy] = new Sales();
		 //sql[yy] = Obsluga_Bazy.sprawdzBaze("SELECT miesiac1, salemaz FROM warminskie");
		
		 }
		int a, b, c, d, e, f, g, h;

		f = sprzedaz[0].showSaleFigure();
		e = sprzedaz[1].showSaleFigure();
		d = sprzedaz[2].showSaleFigure();
		a = sprzedaz[3].showSaleFigure();
		b = sprzedaz[4].showSaleFigure();
		c = sprzedaz[5].showSaleFigure();
		// wykres
		XYChart.Series series1 = new XYChart.Series();
		series1.getData().add(new XYChart.Data("stycze�", f));
		// series.getData().add(new XYChart.Data("maj",28327));

		XYChart.Series series2 = new XYChart.Series();
		series2.getData().add(new XYChart.Data("luty", e));

		XYChart.Series series3 = new XYChart.Series();
		series3.getData().add(new XYChart.Data("marzec", d));

		XYChart.Series series4 = new XYChart.Series();
		series4.getData().add(new XYChart.Data("kwiecie�", a));

		XYChart.Series series5 = new XYChart.Series();
		series5.getData().add(new XYChart.Data("maj", b));

		XYChart.Series series6 = new XYChart.Series();
		series6.getData().add(new XYChart.Data("czerwiec", c));

		BarChart.getData().addAll(series1, series2, series3, series4, series5, series6);
		discscanner.close();

	}

	@FXML
	private Button dodajButton;

	@FXML
	public void SalesUpdateMaz() throws IOException {
		MazDataUpdate p = new MazDataUpdate();
		MazUpdate u = new MazUpdate();
		
		int nowaSprzedazMazInt1;
		int h;
		String nowaSprzedazMaz = txtFieldCar.getText();
		// Konwersja Warto�ci Textfield na Integer za pomoc� funkcji
		// Integer.parseInt(nowaSprzedazMaz);
		nowaSprzedazMazInt = Integer.parseInt(nowaSprzedazMaz);

		System.out.println("**************** wyswietlam warto�� pola TextField  ***************************");
		System.out.println(nowaSprzedazMaz);
		System.out.println("**************** wyswietlam warto�� pola Integer ***************************");
		
		// zapis dodnej warto�ci sprzedazy do obiektu u klasy MazUpdate

		u.setMazUpdate(nowaSprzedazMazInt);
		p.setP(nowaSprzedazMazInt);
		System.out
				.println("**************** wyswietlam warto�� obiektu u klasy MazUpdate  ***************************");
		// Tu od�wie�enie wykresu
		System.out.println(u.getMazUpdate());
		System.out.println(
				"**************** wyswietlam warto�� obiektu u klasy MazDataUpdate  ***************************");
		// Tu od�wie�enie wykresu
		System.out.println(p.getP());

		Sales[] sprzedaz;
		sprzedaz = new Sales[8];

		Scanner discscanner = null;
		Scanner wczytaj = null;
		try {
			discscanner = new Scanner(new File("maz.txt"));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		for (int mies = 0; mies <= 7; mies++) {
			sprzedaz[mies] = new Sales();
			sprzedaz[mies].readSales(discscanner);
		}

		int a, b, c, d, e, f, g;

		f = sprzedaz[0].showSaleFigure();
		e = sprzedaz[1].showSaleFigure();
		d = sprzedaz[2].showSaleFigure();
		a = sprzedaz[3].showSaleFigure();
		b = sprzedaz[4].showSaleFigure();
		c = sprzedaz[5].showSaleFigure();

		System.out.println("**************** wyswietlam warto�� obiektu u klasy sprzeda�  ***************************");

		System.out.println(c);

		System.out.println(
				"**************** wyswietlam warto�� obiektu sprzeda�+ nowa warto��  ***************************");
		System.out.println("Obecna warto��: " + c);
		System.out.println("dodana warto��: " + p.getP());
		// ***********************************************************************************
		// aktualizacja i zapisanie do pliku 
		// ****************************************************************
		h = c + p.getP();
		System.out.println("Nowa warto��  sprzeda�y: " + h);
		sprzedaz[5].setSaleMaz(h);

		File happyFile1 = new File("maz.txt");
		FileWriter fileWriter1 = new FileWriter(happyFile1, false);
		BufferedWriter buffer1 = new BufferedWriter(fileWriter1);
		PrintWriter printWriter1 = new PrintWriter(buffer1);

		for (int i = 0; i <= 7; i++) {

			printWriter1.println(sprzedaz[i].pokazTyp());
			printWriter1.println(sprzedaz[i].pokazwojewodztwo());
			printWriter1.println(sprzedaz[i].pokazMiesiac1());
			printWriter1.println(sprzedaz[i].showSaleFigure());

		}
		printWriter1.close();
	}

	@FXML
	private Button Refresh;

	@FXML
	public void przelicz() {

		try {
			FXMLLoader loader1 = new FXMLLoader(MazWindowController.class.getResource("/view/Maz.fxml"));
			AnchorPane pane = loader1.load();
			Stage mazStage = new Stage();
			mazStage.setMinWidth(516.0);
			mazStage.setMinHeight(449.0);
			Scene scene = new Scene(pane);
			MazWindowController mazWindowController = loader1.getController();
			mazWindowController.setMazStage(mazStage);// setZachStage(zachStage);
			mazStage.setScene(scene);
			mazStage.showAndWait();
			// imie.showImie();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}