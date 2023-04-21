package components;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="trialTable")
@Component
public class UserData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Size(min=1, max = 7,message = "Id must be between {min} and {max} characters long")
	@NotBlank(message = "Id is required")
	private long id;
	
	@Column(name="email")
	@NotEmpty(message = "Email is required")
	private String email;
	
	@Size(min=2, max = 30,message = "The user name must be between {min} and {max} characters long")
	@NotBlank(message = "User Name is required")
	@Column(name="userName")
	private String userName;
	
	@Column(name="password")
	@Size(min=2, max = 30,message = "The password must be between {min} and {max} characters long")
	@NotBlank(message = "Password is required")
	private String password;
}
