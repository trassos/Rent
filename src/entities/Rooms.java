package entities;

public class Rooms {
	public String name;
	public String email;
	public int id;
	
	public Rooms(String name, String email, int id) {
		this.name = name;
		this.email = email;
		this.id = id;
	}
	/*
	 * public ocupation() { for (int i = 0; i < array.length; i++) { Rooms[].class.
	 * lista = } return }
	 */
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
