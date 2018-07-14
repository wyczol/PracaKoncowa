package controller;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
public class ZachWindowController {
	
	private Stage zachStage;

	
	
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
    private Button dodajButton, raportButton;
    

	public void setZachStage(Stage zachStage) {
		this.zachStage=zachStage;	
		
	}

	@FXML public void CloseAnimation(){
		zachStage.close();
	}
    
}

