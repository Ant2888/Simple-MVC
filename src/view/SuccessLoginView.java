package view;

import java.util.ArrayList;

import handling.GloblVars;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SuccessLoginView extends ViewGeneric{

	private Stage stage;
	private VBox root;
	
	public SuccessLoginView(Stage stage) {
		super(stage, new VBox(), GloblVars.WIDTH, GloblVars.HEIGHT);
		root = (VBox) getRoot();
		
		obsArr = new ArrayList<>();
		
		TextField tf = new TextField("Success!");
		tf.setPrefWidth(getWidth()/2);
		
		root.getChildren().add(tf);
		root.setStyle("-fx-alignment: center center");
		
		this.stage = stage;
		stage.setScene(this);
	}
	
	public Stage getStage(){
		return stage;
	}
}
