package view;

import java.util.ArrayList;

import handling.GloblVars;
import handling.Observer;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SuccessLoginView extends ViewGeneric{

	private VBox root;
	
	//You would make this display screen take a person to load in all the data for
	public SuccessLoginView(Stage stage, ArrayList<Observer> obsArr) {
		super(stage, new VBox(), GloblVars.WIDTH, GloblVars.HEIGHT, obsArr);
		root = (VBox) getRoot();
		
		obsArr = new ArrayList<>();
		
		Label tf = new Label("Success!");
		Button nxtSc = new Button("Another Scene");
		nxtSc.setOnAction(e->{
			NotifyObservers(GloblVars.Events.SLV_GOTO_AS);
		});
		
		root.getChildren().addAll(tf, nxtSc);
		root.setStyle("-fx-alignment: center center");
		init();
	}
}
