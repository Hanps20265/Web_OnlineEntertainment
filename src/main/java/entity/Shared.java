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
@Table (name="Shared",
uniqueConstraints={@UniqueConstraint(columnNames={"VideoId" , "UserId"})})
public class Shared {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) // Mô tả field tự tăng
	Long sharedId;
	@ManyToOne @JoinColumn(name = "UserId") //Class có khóa ngoại sẽ được mô tả bằng @JoinColumn
	Users user;
	@ManyToOne @JoinColumn(name = "VideoId") 
	Videos video;
	@Temporal(TemporalType.DATE) // Mô tả kiểu thời gian
	Date shareDate = new Date();
	public Shared() {
	}
	public Shared(Users user, Videos video, Date shareDate) {
	
		this.user = user;
		this.video = video;
		this.shareDate = shareDate;
	}
	public Shared(Long sharedId, Users user, Videos video, Date shareDate) {
		this.sharedId = sharedId;
		this.user = user;
		this.video = video;
		this.shareDate = shareDate;
	}
	public Long getSharedId() {
		return sharedId;
	}
	public void setSharedId(Long sharedId) {
		this.sharedId = sharedId;
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
	public Date getShareDate() {
		return shareDate;
	}
	public void setShareDate(Date shareDate) {
		this.shareDate = shareDate;
	}
	
}
