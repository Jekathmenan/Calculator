/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.m326.simplecalculator.View;

import ch.bbbaden.m326.simplecalculator.Model.Operand;
import ch.bbbaden.m326.simplecalculator.ViewModel.ViewModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Jekathmenan
 */
public class View implements Initializable
{

    @FXML
    private Label lblOutput;

    private ViewModel viewModel;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }  
    
    public void bind()
    {
        lblOutput.textProperty().bind(viewModel.getOutput());
    }
    
    @FXML
    private void exitAction(MouseEvent event)
    {
        viewModel.exitAction();
    }

    @FXML
    private void minimizeAction(MouseEvent event)
    {
        viewModel.minimizeAction();
    }
    
    // Handling the . action
    @FXML
    private void dotAction(ActionEvent event)
    {
        viewModel.numberAction(".");
    }

    // Handling all the number actions from 0 to 9
    @FXML
    private void zeroAction(ActionEvent event)
    {
        viewModel.numberAction("0");
    }

    @FXML
    private void oneAction(ActionEvent event)
    {
        viewModel.numberAction("1");
    }
    
    @FXML
    private void twoAction(ActionEvent event)
    {
        viewModel.numberAction("2");
    }
    
    @FXML
    private void threeAction(ActionEvent event)
    {
        viewModel.numberAction("3");
    }

    @FXML
    private void fourAction(ActionEvent event)
    {
        viewModel.numberAction("4");
    }
    
    @FXML
    private void fiveAction(ActionEvent event)
    {
        viewModel.numberAction("5");
    }
    
    @FXML
    private void sixAction(ActionEvent event)
    {
        viewModel.numberAction("6");
    }
    
    @FXML
    private void sevenAction(ActionEvent event)
    {
        viewModel.numberAction("7");
    }

    @FXML
    private void eightAction(ActionEvent event)
    {
        viewModel.numberAction("8");
    }
    
    @FXML
    private void nineAction(ActionEvent event)
    {
        viewModel.numberAction("9");
    }

    
    // Operand action
    @FXML
    private void minusAction(ActionEvent event)
    {
        viewModel.operandAction(Operand.SUBSTRACTION);
    }

    @FXML
    private void plusAction(ActionEvent event)
    {
        viewModel.operandAction(Operand.ADDITION);
    }

    @FXML
    private void multiAction(ActionEvent event)
    {
        viewModel.operandAction(Operand.MULTIPLICATION);
    }

    @FXML
    private void divideAction(ActionEvent event)
    {
        viewModel.operandAction(Operand.DIVISION);
    }

    @FXML
    private void moduloAction(ActionEvent event)
    {
        viewModel.operandAction(Operand.MODULO);
    }
    
    
    // handles the equals action
    @FXML
    private void equalsAction(ActionEvent event)
    {
        viewModel.equalsAction();
    }
    
    // deletes all values
    @FXML
    private void deleteAction(ActionEvent event)
    {
        viewModel.deleteAction();
    }

    @FXML
    private void plusMinusAction(ActionEvent event)
    {
        viewModel.plusMinusAction();
    }

    public void setViewModel(ViewModel viewModel)
    {
        this.viewModel = viewModel;
    }
    
    
}
