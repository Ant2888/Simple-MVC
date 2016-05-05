package view;

import java.util.ArrayList;

import handling.GloblVars;
import handling.Observer;
import handling.GloblVars.Events;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainView extends ViewGeneric{

	private TextField txt1;
	private PasswordField txt2;
	
	public MainView(Stage stage, ArrayList<Observer> obsArr) {
		super(stage, new VBox(10), GloblVars.WIDTH, GloblVars.HEIGHT, obsArr);
		VBox vb = (VBox)getRoot();
		vb.setStyle("-fx-alignment: center center");
		obsArr = new ArrayList<>();
		txt1 = new TextField("Enter username");
		txt2 = new PasswordField();
		txt1.setMaxWidth(150);
		txt2.setMaxWidth(150);
		
		Button b = new Button("SUBMIT");
		b.setOnAction(e->{
			NotifyObservers(Events.MV_SUBMIT_BUTTON);
		});
		Button db = new Button("GET DATA");
		db.setOnAction(e->{
			NotifyObservers(Events.MV_GET_DATA);
		});
		
		
		vb.getChildren().addAll(txt1, txt2, b,db);
		init();
	}

	//don't necessarily need this
	public void stop(){
		stage.close();
	}
	
	public String getUsername(){
		String toret = txt1.getText();
		txt1.clear();
		return toret;
	}
	
	public String getPassword(){
		String toret = txt2.getText();
		txt2.clear();
		return toret;
	}
	
}
