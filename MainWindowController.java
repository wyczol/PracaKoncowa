package controller;

import java.io.IOException;

import Person.Person;
import controller.RegionWindowController;
import controller.Main;
import controller.MainWindowController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class MainWindowController {

	Main main;
	private Stage primaryStage;
	private Stage primaryStage1;
	Person imie;
	
	@FXML 
	Label welcomemsg;
	
	@FXML
	TextField IDfield;
	@FXML
	Button button;
	@FXML
	public void handlebutton() {
	
		System.out.println("*************** Test zapisu **************************");
		
		String text=IDfield.getText();
		Person imie = new Person();
		
		imie.setImie(text);
		System.out.println("*************** Wy�wietlenie warto�ci obiektu imie **************************");
		imie.showImie();
		IDfield.setText(text);
		
		//person.setFirstName(text);
		IDfield.clear();		
		
		try {
				FXMLLoader loader =
					new FXMLLoader(
							RegionWindowController.class.getResource("/view/RegionWindowView.fxml")
							);
			AnchorPane pane = loader.load();
			Stage regionStage= new Stage();
			regionStage.setMinWidth(800.00);
			regionStage.setMinHeight(600.00);
			Scene scene = new Scene(pane);
			RegionWindowController regionWindowController = 
					loader.getController();
			regionWindowController.setRegionStage(regionStage);
			regionStage.setScene(scene);
			regionStage.show();
			
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	
	
	public void setMain(Main main) {
		this.main=main;
		
	}
	@FXML public void closeMainWindow(){
		primaryStage.close();
		
	}

}
