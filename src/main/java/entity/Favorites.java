package entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;


@Entity
@Table (name="Favorites", 
uniqueConstraints={@UniqueConstraint(columnNames={"VideoId" , "UserId"})})
public class Favorites {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) // Mô tả field tự tăng
	Long favoriteId;
	@ManyToOne @JoinColumn(name = "UserId") //Class có khóa ngoại sẽ được mô tả bằng @JoinColumn
	Users user;
	@ManyToOne @JoinColumn(name = "VideoId") 
	Videos video;
	@Temporal(TemporalType.DATE) // Mô tả kiểu thời gian
	Date likeDate = new Date();
	public Favorites() {
	}
	public Favorites(Users user, Videos video, Date likeDate) {
	
		this.user = user;
		this.video = video;
		this.likeDate = likeDate;
	}
	public Favorites(Long favoriteId, Users user, Videos video, Date likeDate) {
		this.favoriteId = favoriteId;
		this.user = user;
		this.video = video;
		this.likeDate = likeDate;
	}
	public Long getFavoriteId() {
		return favoriteId;
	}
	public void setFavoriteId(Long favoriteId) {
		this.favoriteId = favoriteId;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Videos getVideo() {
		return video;
	}
	public void setVideo(Videos video) {
		this.video = video;
	}
	public Date getLikeDate() {
		return likeDate;
	}
	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}
	
	
}
