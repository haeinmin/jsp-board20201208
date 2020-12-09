package member.service;

import java.util.Map;

public class JoinRequest {
	
	private String id;
	private String name;
	private String password;
	private String confirmPassword;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public void validate(Map<String, Boolean> errors) {
		//id, name, pw, confirmPassword 잘 들어왔는지 확인을 밑에 checkEmpty() 매소드로 다시 뺌
		checkEmpty(errors, id, "id");
		checkEmpty(errors, name, "name");
		checkEmpty(errors, password, "password");
		checkEmpty(errors, confirmPassword, "confirmPassword");
		
		if (!errors.containsKey("confirmPassword")) {			
			if (!isPasswordEqualToConfirm()) {
				errors.put("notMatch", true);
			}
		}
	}
	
	public boolean isPasswordEqualToConfirm() {
		return password != null && password.equals(confirmPassword);
	}
	
	private void checkEmpty(Map<String, Boolean> errors, String value, String fieldName) {
		if (value == null || value.isEmpty()) {      // value가 비어 있으면 fieldName으로 맵에 넣은 것 
			errors.put(fieldName, true);
		}
	}

}
