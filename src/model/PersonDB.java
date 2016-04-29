package model;

import java.util.ArrayList;

public class PersonDB {
	ArrayList<Person> people;
	
	public PersonDB() {
		people = new ArrayList<>();
	}
	
	public void addPerson(Person p){
		people.add(p);
	}
	public void addPerson(String userName, String password){
		people.add(new Person(userName,password));
	}
	
	public void removePerson(Person p){
		people.remove(p);
	}
	public void removePerson(String userName, String password){
		people.add(new Person(userName,password));
	}
	
	public void viewDB(){
		for (Person p: people) {
			System.out.println("Username: "+p.name+"\n"+"Password: "+p.password);
		}
	}
	
}
