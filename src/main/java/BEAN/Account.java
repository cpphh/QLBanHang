package BEAN;

public class Account {
	private String username;
	private String password;
	private String fullname;
	private int admin;
	
	
	public Account() {
		super();
	}

	public Account(String username, String password, String fullname, int admin) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.admin = admin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}
	
}
