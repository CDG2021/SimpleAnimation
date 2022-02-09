/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javafxhw5_2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 * @author Carlos Garcia
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Rectangle rectShape;
    
    @FXML
    private CheckBox translateBox;

    @FXML
    private CheckBox rotateBox;

    @FXML
    private RadioButton parallelRadio;


    @FXML
    private Button play;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        play.setOnAction(event ->
        {   
            //Tranlates
            ScaleTransition translate1 = new ScaleTransition(new Duration(2000));
            translate1.setCycleCount(2);
            translate1.setAutoReverse(true);
            translate1.setFromX(1.0);
            translate1.setFromY(1.0);
            translate1.setToX(2.0);
            translate1.setToY(2.0);
            
            //Fade
            FadeTransition translate2 = new FadeTransition(new Duration(2000));
            translate2.setCycleCount(2);
            translate2.setAutoReverse(true);
            translate2.setFromValue(1);
            translate2.setToValue(0.25);
            
            //translate
            TranslateTransition translate3 = new TranslateTransition(new Duration(2000));
            translate3.setCycleCount(2);
            translate3.setAutoReverse(true);
            translate3.setFromX(-20);
            translate3.setToX(175);
            
            RotateTransition translate4 = new RotateTransition(new Duration(2000));
            translate4.setCycleCount(2);
            translate4.setAutoReverse(true);
            translate4.setFromAngle(0);
            translate4.setToAngle(360);
            
            if(parallelRadio.isSelected())
            {
                if(translateBox.isSelected() && rotateBox.isSelected())
                {
                    ParallelTransition pt = new ParallelTransition(rectShape, translate3, translate4, translate1, translate2);
                    pt.play();
                }
                else if(translateBox.isSelected())
                {
                    ParallelTransition pt = new ParallelTransition(rectShape, translate3, translate1, translate2);
                     pt.play();
                }
                else if(rotateBox.isSelected())
                {
                    ParallelTransition pt = new ParallelTransition(rectShape, translate4, translate1, translate2);
                     pt.play();
                }
                else{
                    ParallelTransition pt = new ParallelTransition(rectShape, translate1, translate2);
                     pt.play();
                }
            }
            else{
                if(translateBox.isSelected() && rotateBox.isSelected())
                {
                    SequentialTransition  st = new SequentialTransition (rectShape, translate3, translate4, translate1, translate2);
                    st.play();
                }
                else if(translateBox.isSelected())
                {
                    SequentialTransition  st = new SequentialTransition (rectShape, translate3, translate1, translate2);
                    st.play();
                }
                else if(rotateBox.isSelected())
                {
                    SequentialTransition  st = new SequentialTransition (rectShape, translate4, translate1, translate2);
                    st.play();
                }
                else{
                    SequentialTransition  st = new SequentialTransition (rectShape, translate1, translate2);
                    st.play();
                }
            }
        });
    }    

}
