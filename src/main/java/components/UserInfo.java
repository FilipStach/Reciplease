package components;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserInfo {
	@NotBlank(message = "Name is required")
	@Size(min=2, max = 30,message = "The name must be between {min} and {max} characters long")
	private String email;
	@Size(min=2, max = 30,message = "The crush name must be between {min} and {max} characters long")
	@NotBlank(message = "Crush Name is required")
	private String password;
	
	@AssertTrue(message = " *** you have to agree to proceed")
	private boolean termAndCondition;
	
	
	
	public boolean isTermAndCondition() {
		return termAndCondition;
	}
	public void setTermAndCondition(boolean termAndCondition) {
		this.termAndCondition = termAndCondition;
	}
	public UserInfo() {

	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}



}