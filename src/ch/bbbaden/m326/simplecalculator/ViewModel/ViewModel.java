/* Author: Jekathmenan Selvarajah
 * Project: Programmierwochen_Casino To change this license header, choose License Headers in Project Properties.
 * Project: Programmierwochen_Casino To change this template file, choose Tools | Templates
 * Project: Programmierwochen_Casino and open the template in the editor.
 */

package ch.bbbaden.m326.simplecalculator.ViewModel;

import ch.bbbaden.m326.simplecalculator.Model.Model;
import ch.bbbaden.m326.simplecalculator.Model.Operand;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Jekathmenan
 */
public class ViewModel implements PropertyChangeListener
{
    private final Model model;
    private StringProperty output = new SimpleStringProperty();

    public ViewModel(Model model)
    {
        this.model = model;
    }
    
    public void exitAction()
    {
        model.exitAction();
    }
    
    public void minimizeAction()
    {
        
        model.minimizeAction();
    }
    
    public void operandAction(Operand operand)
    {
        model.operationAction(operand);
    }
    
    public void numberAction(String value)
    {
        model.numberAction(value);
    }
    
    public void equalsAction()
    {
        model.equalsAction();
    }
    
    public void plusMinusAction()
    {
        model.plusMinusAction();
    }
    
    public void deleteAction()
    {
        model.deleteAction();
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        switch(evt.getPropertyName())
        {
            case "output":
                output.set(evt.getNewValue().toString());
        }
    }

    public StringProperty getOutput()
    {
        return output;
    }
}
