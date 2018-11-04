/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithnumbers.GUI.Controller;

import funwithnumbers.GUI.Model.MoveCalculatorModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author WezzyLaptop
 */
public class MoveCalculatorController implements Initializable {

    @FXML
    private TextField x1;
    @FXML
    private TextField x2;
    @FXML
    private TextField y1;
    @FXML
    private TextField y2;
    @FXML
    private TextArea resultatDC;
    @FXML
    private TextField x3;
    @FXML
    private TextField y3;
    @FXML
    private TextField angle;
    @FXML
    private TextField length;
    @FXML
    private TextArea resultTMC;
    @FXML
    private Button buttonDC;
    @FXML
    private Button buttonTMC;
    
    private MoveCalculatorModel mcm = new MoveCalculatorModel();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void calculateDC(ActionEvent event) {
        
        double dx1 = Double.parseDouble(x1.getText());
        double dx2 = Double.parseDouble(x2.getText());
        double dy1 = Double.parseDouble(y1.getText());
        double dy2 = Double.parseDouble(y2.getText());
        
 
        
        String resultOf = mcm.getDistanceCalculated(dx1,dx2,dy1,dy2);
        resultatDC.setText(resultOf);
    }

    @FXML
    private void calculateTMC(ActionEvent event) {
        
        double dx1 = Double.parseDouble(x3.getText());
        double dy1 = Double.parseDouble(y3.getText());
        double dangle = Double.parseDouble(angle.getText());
        double dlength = Double.parseDouble(length.getText());
        
        String resultx = String.valueOf(mcm.getTMCX(dx1,dangle, dlength));
        String resulty = String.valueOf(mcm.getTMCY(dy1,dangle, dlength));
        resultTMC.setText(resultx + ", " + resulty);
    }
    
}
