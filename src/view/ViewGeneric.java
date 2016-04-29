package view;

import java.util.ArrayList;

import handling.Observer;
import handling.Subject;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//Note that there is no reason for it to be abstract yet. But developing
//further on this would require it to be.
public abstract class ViewGeneric extends Scene implements Subject{

	protected ArrayList<Observer> obsArr;
	protected Stage stage;
	protected boolean first = true; //make sure that we don't need a scene.show()
	
	public ViewGeneric(Stage stage, Parent root, int width, int height) {
		super(root, width, height);
		this.stage = stage;
	}

	//use this method at the end of every scene to do the check above
	//can override
	protected void init(){
		if(first){
			stage.setResizable(false);
			stage.setTitle("MVC Example");
			stage.show();
			first = false;
		}
	}
	
	@Override
	public void addObserver(Observer o){
		obsArr.add(o);
	}
	
	@Override
	public void removeObserver(Observer o){
		obsArr.remove(o);
	}
	
	@Override
	public void NotifyObserver(Object args){
		for (Observer observer : obsArr) {
			observer.update(args);
		}
	}
	
	public Stage getStage(){
		return stage;
	}
	
}
