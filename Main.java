package controller;
	
import java.io.IOException;

import controller.RegionWindowController;
import controller.Main;
import controller.MainWindowController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	private Stage primaryStage;
	
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage=primaryStage;
		mainWindow();
			}
	
	
	
	public void mainWindow() {
		try {
			FXMLLoader loader =
					new FXMLLoader(
							Main.class.getResource("/view/MainViewWindow.fxml")
							);
			AnchorPane pane = loader.load();
			primaryStage.setMinWidth(516.0);
			primaryStage.setMinHeight(449.0);
			Scene scene = new Scene(pane);
			MainWindowController mainWindowController = 
					loader.getController();
			mainWindowController.setMain(this);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

	
	public static void main(String[] args) {
		launch(args);
	}
}
