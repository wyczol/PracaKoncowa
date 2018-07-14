package controller;



import Person.Person;
import controller.Main;
import controller.MainWindowController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RegionWindowController {
	
	
	private Stage zachStage;
	Person imie;
	
	public void zach() {
	try {
		FXMLLoader loader =
				new FXMLLoader(
						ZachWindowController.class.getResource("/view/zach.fxml")
						);
		AnchorPane pane = loader.load();
		Stage zachStage= new Stage();
		zachStage.setMinWidth(516.0);
		zachStage.setMinHeight(449.0);
		Scene scene = new Scene(pane);
		ZachWindowController zachWindowController = 
				loader.getController();
		zachWindowController.setZachStage(zachStage);
		zachStage.setScene(scene);
		zachStage.showAndWait();
	} catch(Exception e) {
		e.printStackTrace();
	}
}
	public void setRegionStage(Stage regionStage) {
		
	}
	
	@FXML Label lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7, lbl8, lbl9, lbl10, lbl11, lbl12, lbl13, lbl14,
	lbl15, lbl16, ihrename;
	@FXML ImageView image;
	
	@FXML
	public void wyswietlimie() {
		String text = imie.getImie();
		//IDlabel.setText(text);
	}

	
	public void pom() {
		
		try {
			FXMLLoader loader =
					new FXMLLoader(
							PomWindowController.class.getResource("/view/zach.fxml")
							);
			AnchorPane pane = loader.load();
			Stage zachStage= new Stage();
			zachStage.setMinWidth(516.0);
			zachStage.setMinHeight(449.0);
			Scene scene = new Scene(pane);
			ZachWindowController zachWindowController = 
					loader.getController();
			zachWindowController.setZachStage(zachStage);
			zachStage.setScene(scene);
			zachStage.showAndWait();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void war() {
	
		try {
			FXMLLoader loader1 =
					new FXMLLoader(
							MazWindowController.class.getResource("/view/Maz.fxml")
							);
			AnchorPane pane = loader1.load();
			Stage mazStage= new Stage();
			mazStage.setMinWidth(516.0);
			mazStage.setMinHeight(449.0);
			Scene scene = new Scene(pane);
			MazWindowController mazWindowController = 
					loader1.getController();
			mazWindowController.setMazStage(mazStage);//setZachStage(zachStage);
			mazStage.setScene(scene);
			mazStage.showAndWait();
			//imie.showImie();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public void lubus() {}
	
	public void wielk() {}
	
	public void kuj() {}


	@FXML public void closeMainWindow(){
		zachStage.close();
}}
