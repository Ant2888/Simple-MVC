package controller;

import handling.GloblVars.Events;
import handling.Observer;
import model.PersonDB;
import view.AnotherScene;
import view.MainView;
import view.SuccessLoginView;
import view.ViewGeneric;

public class Controller implements Observer{

	private ViewGeneric view;
	private PersonDB person;
	
	public Controller(ViewGeneric view, PersonDB person) {
		view.addObserver(this);
		this.view = view;
		this.person = person;
	}
	
	//I put this, essentially, middle man method here to be able to 
	//override the decode event to be capable of taking more than just enums
	@Override
	public void update(Object args) {
		if(args instanceof Events){
			decodeEvent((Events)args);
		}
	}
	
	//Now here is where you can decide whether to continually add observers as you create new 
	//Views or decide to implement it into the constructor. For this example I choose the latter.
	private void decodeEvent(Events event){
		switch(event){
		case MV_SUBMIT_BUTTON:
			person.addPerson(((MainView)view).getUsername(),
					((MainView)view).getPassword());
			//going to show a successlogin view now
			view = new SuccessLoginView(view.getStage(), view.getObservers());
			break;
		case MV_GET_DATA:
			System.out.println("\n\n\n");
			person.viewDB();
			break;
		case AS_PREV_SCENE:
			view = new SuccessLoginView(view.getStage(), view.getObservers());
			break;
		case SLV_GOTO_AS:
			view = new AnotherScene(view.getStage(), view.getObservers());
			break;
		default:
			break;
		}
	}

}
