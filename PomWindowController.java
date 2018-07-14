package controller;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PomWindowController {

	private Stage pomStage;
	

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
    

	public void setPomStage(Stage pomStage) {
		this.pomStage=pomStage;	
		
	}

	@FXML public void CloseAnimation(){
		pomStage.close();
	}
    
}



