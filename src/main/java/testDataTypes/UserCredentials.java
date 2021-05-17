package testDataTypes;

import java.util.HashMap;
import java.util.Map;
/**************************
 *  (C) L Somni            *
 ***************************/

public class UserCredentials {


	private String userName;

	private String address;
	private String email;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}