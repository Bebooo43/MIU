package lab6.prob2;

import java.util.HashSet;
import java.util.Set;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Lab6Prob2 extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		 primaryStage.setTitle("Address Form");
         GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(15, 15, 15, 15));
            
            HBox hbox = new HBox(5);
            VBox vbox1 = new VBox(5);            
            VBox vbox2 = new VBox(5);

            Button btn = new Button("Count Letters");
            Button btn1 = new Button("Reverse Letters");
            Button btn2 = new Button("Remove Duplicate");
            
            btn.setMinSize(120,30);
            btn1.setMinSize(120,30);
            btn2.setMinSize(120,30);

            vbox1.getChildren().add(btn);
            vbox1.getChildren().add(btn1);
            vbox1.getChildren().add(btn2);
            vbox1.setAlignment(Pos.BASELINE_CENTER);

            hbox.setAlignment(Pos.CENTER);
            hbox.getChildren().add(vbox1);
            
            Label label = new Label("Input");
            TextField textField = new TextField();
            vbox2.getChildren().add(label);
            vbox2.getChildren().add(textField);
            Label label2 = new Label("output");
            TextField textField2 = new TextField();
            
            vbox2.getChildren().add(label2);
            vbox2.getChildren().add(textField2);
            vbox2.setAlignment(Pos.BASELINE_CENTER);
            vbox2.setPadding(new Insets(0,20,20,10));

            hbox.getChildren().add(vbox2);
            
            grid.add(hbox, 0, 0);
            Scene scene = new Scene(grid, 500, 200);
            primaryStage.setScene(scene);
            primaryStage.show();
            
         
            
            btn.setOnAction(new EventHandler<ActionEvent>() {
              @Override
              public void handle(ActionEvent e) {
            	  
            	   if(textField.getText().length() < 1) {
                 	  Alert alert = new Alert(Alert.AlertType.INFORMATION);
                 	    alert.setTitle("Alert");
                 	    alert.setHeaderText("Input is Empty");
                 	    alert.setContentText("Put Some Text in input TextField");
                 	    alert.showAndWait();
                 	return;
                 }
            	  textField2.setText(textField.getText().length()+"");
              }
          });
            
            btn1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                	   if(textField.getText().length() < 1) {
                     	  Alert alert = new Alert(Alert.AlertType.INFORMATION);
                     	    alert.setTitle("Alert");
                     	    alert.setHeaderText("Input is Empty");
                     	    alert.setContentText("Put Some Text in input TextField");
                     	    alert.showAndWait();
                     	return;
                     }
                	
              	  textField2.setText(new StringBuilder(textField.getText()).reverse()+"");
              	  
                }
            });
           
            btn2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                	
            	   if(textField.getText().length() < 1) {
            		   	Alert alert = new Alert(Alert.AlertType.INFORMATION);
	             	    alert.setTitle("Alert");
	             	    alert.setHeaderText("Input is Empty");
	             	    alert.setContentText("Put Some Text in input TextField");
	             	    alert.showAndWait();
	             	    return;
            	   	}
                	
                	Set<Character> str = new HashSet<>();
                	for(int i = 0;i< textField.getText().length();i++) {
                		str.add(textField.getText().charAt(i));
                	}
               
                	String newStr = str.toString().replace("[", "");
                	newStr = newStr.toString().replace("]", "");
                	newStr = newStr.toString().replace(",", "");
                	newStr = newStr.replaceAll("\\s", "");
              	  	textField2.setText(newStr);
              	  
                }
            });
	}
}
