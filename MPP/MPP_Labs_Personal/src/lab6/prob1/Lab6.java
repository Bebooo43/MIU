package lab6.prob1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Lab6 extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		
		 primaryStage.setTitle("Address Form");
         GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(25, 25, 25, 25));
            
            Label name = new Label("Name");
            grid.add(name, 0, 0);
            TextField userTextField = new TextField();
            grid.add(userTextField, 0, 1);
            grid.setGridLinesVisible(false) ;
         
            Label street = new Label("Street");
            grid.add(street, 1, 0);
            TextField streetTextField = new TextField();
            grid.add(streetTextField, 1, 1);
            
            Label city = new Label("City");
            grid.add(city, 2, 0);
            TextField cityTextField = new TextField();
            grid.add(cityTextField, 2, 1);
            
            Label State = new Label("State");
            grid.add(State, 0,3);
            TextField StateTextField = new TextField();
            grid.add(StateTextField, 0, 4);
            
            Label Zip = new Label("Zip");
            grid.add(Zip, 1, 3);
            TextField ZipTextField = new TextField();
            grid.add(ZipTextField, 1, 4);
          
            Button btn = new Button("Submitt");
            HBox hbBtn = new HBox(10);
            
            hbBtn.setAlignment(Pos.BASELINE_CENTER);
            hbBtn.getChildren().add(btn);
            grid.add(hbBtn, 1, 5);
           
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    System.out.println(userTextField.getText()+"\n"+ streetTextField.getText()+"\n"+
                            StateTextField.getText()+", "+cityTextField.getText()+" "+ZipTextField.getText());
                }
            });
     
            Scene scene = new Scene(grid, 500, 200);
            primaryStage.setScene(scene);
            primaryStage.show();
    
		
	}
	@Override
	public void stop() {
		//clean up resources
	}
}
