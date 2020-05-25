/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.m326.simplecalculator;

import ch.bbbaden.m326.simplecalculator.Model.Model;
import ch.bbbaden.m326.simplecalculator.View.View;
import ch.bbbaden.m326.simplecalculator.ViewModel.ViewModel;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Jekathmenan
 */
public class MainApp extends Application
{
    Stage stage;
    
    @Override
    public void start(Stage primaryStage) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("View/View.fxml"));
        Parent root = loader.load();
        
        View view = loader.getController();
        Model model = new Model(this);
        final ViewModel viewModel = new ViewModel(model);
        view.setViewModel(viewModel);
        model.addPropertyChangeListener(viewModel);
        view.bind();
        
        //
        stage = primaryStage;
        
        // All the binding need to be done here
        
        Scene scene = new Scene(root);
        
        // setting scene to not resizable and undecorated
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void minimizeView() throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("View/View.fxml"));
        Parent root = loader.load();
        
        View view = loader.getController();
        Model model = new Model(this);
        final ViewModel viewModel = new ViewModel(model);
        view.setViewModel(viewModel);
        model.addPropertyChangeListener(viewModel);
        view.bind();
        
        
        // All the binding need to be done here
        
        Scene scene = new Scene(root);
        
        // setting scene to not resizable and undecorated
        stage.setResizable(false);
        //stage.initStyle(StageStyle.UNDECORATED);
        
        // minimize window
        stage.setIconified(true);
        
        stage.setScene(scene);
        stage.show();
    }
    
    public void exit()
    {
        System.exit(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
    
}
