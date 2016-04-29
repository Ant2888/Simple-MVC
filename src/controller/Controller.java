package controller;

import handling.GloblVars.Events;
import handling.Observer;
import model.PersonDB;
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
	
	@Override
	public void update(Object args) {
		if(args instanceof Events){
			decodeEvent((Events)args);
		}
	}
	
	private void decodeEvent(Events event){
		switch(event){
		case MV_SUBMIT_BUTTON:
			person.addPerson(((MainView)view).getUsername(),
					((MainView)view).getPassword());
			//going to show a successlogin view now
			view = new SuccessLoginView(view.getStage());
			break;
		case MV_GET_DATA:
			System.out.println("\n\n\n");
			person.viewDB();
			break;
		default:
			break;
		}
	}

}
