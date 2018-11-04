/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithnumbers.GUI.Controller;

import funwithnumbers.GUI.Model.TemperatureConversionModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author WezzyLaptop
 */

public class TemperatureConversionController implements Initializable {
@FXML
private TextField txtInput;
@FXML
private ComboBox comboConversion;
@FXML
private TextArea lblResult;

private TemperatureConversionModel tcmodel = new TemperatureConversionModel();


    @FXML
    public void handleSelectComboBox(ActionEvent event)
    {
        double inputTemp = Double.parseDouble(txtInput.getText());
        double tempValue = 0;
   
        int selectedIndex = comboConversion.getSelectionModel().getSelectedIndex();
 
        switch (selectedIndex)
        {
            case 0:
                tempValue = tcmodel.getTemperatureInFahrenheit(inputTemp);
                break;
            case 1:
                tempValue = tcmodel.getTemperatureInCelcius(inputTemp);
                break;
            default:
                throw new UnsupportedOperationException("Selected conversion not supported yet");      
        }
 
        String resultText = String.valueOf(tempValue);
        lblResult.setText(resultText);
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comboConversion.setItems(FXCollections.observableArrayList("Celcius to Fahrenheit", "Fahrenheit to Celcius"));
        comboConversion.setVisibleRowCount(2);
    }    
    
}
