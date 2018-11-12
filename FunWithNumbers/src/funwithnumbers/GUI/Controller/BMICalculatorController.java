/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithnumbers.GUI.Controller;

import funwithnumbers.GUI.Model.BMICalculatorModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author WezzyLaptop
 */
public class BMICalculatorController implements Initializable {

    @FXML
    private TextField height;
    @FXML
    private TextField weight;
    @FXML
    private Label txtheight;
    @FXML
    private Label txtweight;
    @FXML
    private Button workBitch;
    
    private BMICalculatorModel bmiCalcModel = new BMICalculatorModel();
    @FXML
    private TextArea txtout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonActionWorkBitch(ActionEvent event) {
        
        double txtHeightValue = Double.parseDouble(height.getText());
        double txtWeightValue = Double.parseDouble(weight.getText());
        double bmi = bmiCalcModel.getBMI(txtHeightValue, txtWeightValue);
        String resultAsString = String.valueOf(bmi);
        txtout.setText(resultAsString);
    }
    
}
