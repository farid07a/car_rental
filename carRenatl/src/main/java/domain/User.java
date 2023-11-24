package domain;

import java.util.Objects;

public class User {
	// Attributes
	private long userId; // 8 Bytes
	private String userName;
	private String userEmail;
	private String userPassword;
	private String userAddress;
	private boolean userBlocked;
	private UserRole userRole;

	public User() {

	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword="
				+ userPassword + ", userAddress=" + userAddress + ", userBlocked=" + userBlocked + ", userRole="
				+ userRole + "]";
	}
	
	
	
	// using in Map 
	@Override
	public int hashCode() {
		return Objects.hash(userAddress, userBlocked, userEmail, userId, userName, userPassword, userRole);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(userAddress, other.userAddress) && userBlocked == other.userBlocked
				&& Objects.equals(userEmail, other.userEmail) && userId == other.userId
				&& Objects.equals(userName, other.userName) && Objects.equals(userPassword, other.userPassword)
				&& userRole == other.userRole;
	}

	public User(long userId, String userName, String userEmail, String userPassword, String userAddress,
			boolean userBlocked, UserRole userRole) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userAddress = userAddress;
		this.userBlocked = userBlocked;
		this.userRole = userRole;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public boolean isUserBlocked() {
		return userBlocked;
	}

	public void setUserBlocked(boolean userBlocked) {
		this.userBlocked = userBlocked;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	
	

}
