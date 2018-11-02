package com.cernelea.app;


import com.cernelea.employeeModel.EmployeeData;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/mainWindow.fxml"));

        primaryStage.setTitle("Employee List");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
      
    }

    @Override
    public void stop() throws Exception {
     

    }

    public static void main(String[] args) {

        launch(args);

    }

}
