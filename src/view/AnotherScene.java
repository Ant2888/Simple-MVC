package view;

import java.util.ArrayList;

import handling.GloblVars;
import handling.Observer;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AnotherScene extends ViewGeneric{

	/*
	 * Note now that this is only one particular example of how to do this.
	 * There many different ways aside of just this one i.e- using containers
	 * that are meant to do just this, switch scenes around. 
	 * 
	 * I'm just giving a particular example of swapping around scenes.
	 */
	
	public AnotherScene(Stage stage, ArrayList<Observer> obsArr) {
		super(stage, new VBox(), GloblVars.WIDTH, GloblVars.HEIGHT, obsArr);
		
		//initialize the scene
		loadScene();
		
		//call this last to actually place the scene
		init();
	}

	private void loadScene(){
		//safe cast since we know it's a vbox
		VBox root = (VBox)getRoot();
		Button goBack = new Button("Return");
		root.getChildren().addAll(new Label("Another scene!"), goBack);
		root.setStyle("-fx-alignment: center center");
		
		goBack.setOnAction(e->{
			NotifyObservers(GloblVars.Events.AS_PREV_SCENE);
		});
	}
	
}
