package entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table (name="Users")
public class Users {
	@Id
	@Column(name="UserId")
	String userId;
	
	@Column(name="Password")
	String password;
	
	@Column(name="Fullname")
	String fullname;
	
	@Column(name="Email")
	String email;
	
	@Column(name="Admin")
	Boolean admin = false;
	
	// Một user có thể yêu thích nhiều video
	@OneToMany(mappedBy = "user") 
	List<Favorites> favorites;

	public Users() {
	}

	public Users(String userId, String password, String fullname, String email, Boolean admin,
			List<Favorites> favorites) {
		this.userId = userId;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
		this.admin = admin;
		this.favorites = favorites;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public List<Favorites> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Favorites> favorites) {
		this.favorites = favorites;
	}

	@Override
	public String toString() {
		return "Users [id=" + userId + ", password=" + password + ", fullname=" + fullname + ", email=" + email + ", admin="
				+ admin + "]";
	}
	
	
	
}
