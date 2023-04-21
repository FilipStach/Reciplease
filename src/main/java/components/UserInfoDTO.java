package components;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserInfoDTO {
	@NotBlank(message = "Name is required")
	@NotEmpty(message = "Name should not be empty")
	@Size(min=2, max = 30,message = "The name must be between {min} and {max} characters long")
	private String userName;
	@Size(min=2, max = 30,message = "The crush name must be between {min} and {max} characters long")
	@NotBlank(message = "Crush Name is required")
	@NotEmpty(message = "Name should not be empty")
	private String crushName;
	
	@AssertTrue(message = " *** you have to agree to proceed")
	private boolean termAndCondition;
	
	
	
	public boolean isTermAndCondition() {
		return termAndCondition;
	}
	public void setTermAndCondition(boolean termAndCondition) {
		this.termAndCondition = termAndCondition;
	}
	public UserInfoDTO() {

	}
	public String getUserName() {

		return userName;
	}
	public void setUserName(String userName) {

		this.userName = userName;
	}

	public String getCrushName() {
		return crushName;
	}
	public void setCrushName(String crushName) {
		this.crushName = crushName;
	}
	@Override
	public String toString() {
		return "UserInfoDTO [userName=" + userName +"]";
	}


}
