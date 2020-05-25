/* Author: Jekathmenan Selvarajah
 * Project: Programmierwochen_Casino To change this license header, choose License Headers in Project Properties.
 * Project: Programmierwochen_Casino To change this template file, choose Tools | Templates
 * Project: Programmierwochen_Casino and open the template in the editor.
 */
package ch.bbbaden.m326.simplecalculator.Model;

import ch.bbbaden.m326.simplecalculator.MainApp;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.math.BigDecimal;

/**
 *
 * @author Jekathmenan
 */
public class Model
{

    private final PropertyChangeSupport changes = new PropertyChangeSupport(this);
    private MainApp mainApp;

    private Operand state = null;

    private String number1 = "";
    private String number2 = "";

    private double nr1;
    private double nr2;
    private boolean chosenOne = true;
    private boolean decimal;

    /**
     *
     * A constructor to initialize mainApp
     *
     * @param mainApp
     */
    public Model(MainApp mainApp)
    {
        this.mainApp = mainApp;
    }

    /**
     *
     * A method to exit the view --> Calls mainApps exit()
     *
     */
    public void exitAction()
    {
        mainApp.exit();
    }

    /**
     *
     * A method to minimize Window
     *
     */
    public void minimizeAction()
    {
        try
        {
            mainApp.minimizeView();
        } catch (IOException ex)
        {

        }
    }

    /**
     *
     * A method to change state+
     *
     * @param operand
     */
    public void operationAction(Operand operand)
    {
        if (!chosenOne)
        {

            this.state = operand;
            nr2 = Double.valueOf(number2);

            //calculating the result
            nr1 = calculate();
            number1 = Double.toString(nr1);

            changes.firePropertyChange("output", null, number1);
            chosenOne = true;
            number2 = "";
            nr2 = 0;
            
            System.out.println(number1);
            System.out.println(nr1);
            
            System.out.println(number2);
            System.out.println(nr2);
        } 
        else
        {
            
            this.state = operand;
            nr1 = Double.valueOf(number1);
            chosenOne = false;
            changes.firePropertyChange("output", null, 0);
        }
    }

    public void numberAction(String number)
    {
        if (number.charAt(0) == '.' && !decimal)
        {
            if (chosenOne)
            {
                if(number1.equals(""))
                {
                    number1 += "0.";
                    changes.firePropertyChange("output", null, number1);
                }
                else
                {
                    number1 += ".";
                    changes.firePropertyChange("output", null, number1);
                }
            } 
            else
            {
                if(number2.equals(""))
                {
                    number2 += number;
                    changes.firePropertyChange("output", null, number2);
                }
            }
        } 
        else if(number.charAt(0) != '.')
        {
            if (chosenOne)
            {
                number1 += number;
                changes.firePropertyChange("output", null, number1);
            } else
            {
                number2 += number;
                changes.firePropertyChange("output", null, number2);
                System.out.println(number2);
            }
        }

    }

    public void plusMinusAction()
    {
        if (chosenOne)
        {
            if (number1.charAt(0) == '-')
            {
                number1 = "";
            } else
            {
                number1 = "-";
            }
        } else
        {
            if (number1.charAt(0) == '-')
            {
                number1 = "";
            } else
            {
                number1 = "-";
            }
        }
    }

    public void equalsAction()
    {

        // setting the value
        if (!chosenOne)
        {
            nr2 = Double.valueOf(number2);
            nr1 = calculate();
            number1 = Double.toString(nr1);
            changes.firePropertyChange("output", null, nr1);
            nr2 = 0;
            chosenOne = true;
            decimal = false;
        } 
        
        
    }

    public double calculate()
    {
        double result;
        switch (state)
        {
            case ADDITION:
                return nr1 + nr2;
            case SUBSTRACTION:
                return nr1 - nr2;
            case MULTIPLICATION:
                return nr1 * nr2;
            case DIVISION:
                return (nr1 / nr2);
            case MODULO:
                return nr1 % nr2;
        }
        return 0.0;
    }

    public void deleteAction()
    {
        number1 = "";
        number2 = "";
        state = null;

        nr1 = 0.0;
        nr2 = 0.0;

        chosenOne = true;
        changes.firePropertyChange("output", null, 0);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener)
    {
        changes.addPropertyChangeListener(listener);
    }
}
