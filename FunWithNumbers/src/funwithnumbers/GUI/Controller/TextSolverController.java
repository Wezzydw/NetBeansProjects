/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithnumbers.GUI.Controller;

import funwithnumbers.GUI.Model.TextSolverModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Wezzy
 */
public class TextSolverController implements Initializable {

    @FXML
    private TextField txtinput;
    @FXML
    private Label txtoutput;
    
    private TextSolverModel tsm = new TextSolverModel();
    @FXML
    private ComboBox<String> ComboBox;

    @FXML
    private void ComboBoxInput(ActionEvent event){
        
        int selectedIndex = ComboBox.getSelectionModel().getSelectedIndex();
 
        switch (selectedIndex)
        {
            case 0:
                txtoutput.setText(tsm.getTXT(txtinput.getText()));
                break;
            case 1:
                txtoutput.setText(tsm.getFirstName(txtinput.getText()));
                break;
            case 2:
                txtoutput.setText(tsm.getLastName(txtinput.getText()));
                break;
            case 3:
                txtoutput.setText("Number of letters is: " + tsm.getNumberOfLetters(txtinput.getText()));
                break;
            case 4:
                txtoutput.setText(tsm.getFormattedName(txtinput.getText()));
                break;
            default:
                throw new UnsupportedOperationException("Selected conversion not supported yet");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ComboBox.setItems(FXCollections.observableArrayList("Exercise 7", "Exercise 8", "Exercise 9", "Exercise 10", "Exercise 11 (Challenging)"));
        ComboBox.setVisibleRowCount(5);
    }    
    
}
