package dto;

public class LoginDTO {
	String Username;
	String password;
	
	public LoginDTO() {
		this("","");
	}

	public LoginDTO(String username, String password) {
		
		Username = username;
		this.password = password;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDTO [Username=" + Username + ", password=" + password + "]";
	}
	
	
	

}
