/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithnumbers.GUI.Controller;

import funwithnumbers.GUI.Model.NumberConversionModel;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

/**
 *
 * @author WezzyLaptop
 */
public class NumberConversionController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextField txtNumberInput;
    @FXML
    private Label lblResult;
    private NumberConversionModel ncmodel = new NumberConversionModel();
    
    @FXML
    private void handleButtonActionKTM(ActionEvent event) {
        
        double txtFieldValue = Double.parseDouble(txtNumberInput.getText());
        double resultInMiles = ncmodel.getMilesFromKilometer(txtFieldValue);
        //String resultAsString = String.valueOf(resultInMiles);
        String resultAsString = String.format("%.3f",resultInMiles);
        lblResult.setText("Resultat: " + resultAsString);
    }
    
    @FXML
    private void handleButtonActionMTK(ActionEvent event){
        
        double txtFieldValue = Double.parseDouble(txtNumberInput.getText());
        double resultInKM = ncmodel.getKilometersFromMiles(txtFieldValue);
        String resultAsString = String.valueOf(resultInKM);
        lblResult.setText("Resultat:" + resultAsString);
    
    
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //TextInputDialog dialog = new TextInputDialog("");
        
        //dialog.setTitle("Text Input Dialog");
        //dialog.setContentText("Please enter your name");
        
        //Optional<String> result = dialog.showAndWait();
        
        //if(result.isPresent()){
            //String message = ncmodel.getGreetingsMessage(result.get());
            //label.setText(message);
        //}
    }    
    
}
