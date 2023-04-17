package entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@NamedQueries(
		{
			@NamedQuery(name = "Videos.findByKeyword",
							query = "SELECT DISTINCT o.video FROM Favorites o WHERE o.video.title LIKE :keyword"),
			
			@NamedQuery(name = "Videos.findByUser", 
							query = "SELECT o.video FROM Favorites o WHERE o.user.userId=:id"), 
			
			@NamedQuery(name = "Videos.findInRange",
							query = "SELECT DISTINCT o.video FROM Favorites o WHERE o.likeDate BETWEEN :min AND :max"),
			
			@NamedQuery(name = "Videos.findInMonths",
							query = "SELECT DISTINCT o.video FROM Favorites o WHERE month(o.likeDate) IN (:months)")
		}
)

@NamedNativeQueries({
@NamedNativeQuery(name = "Report.random10",
					query = "SELECT * FROM Videos ORDER BY RAND() LIMIT 10",
					resultClass = Videos.class) })

@Entity
@Table(name = "Videos")
public class Videos {
	 
	@Id
	@Column(name="VideoId")
	String videoId;
	
	@Column(name="Title")
	String title;
	
	@Column(name="Poster")
	String poster;
	
	@Column(name="Descriptions")
	String descriptions;
	
	@Column(name="Views")
	Integer views = 0;
	
	@Column(name="Active")
	Boolean active = true; 
	
	@OneToMany(mappedBy = "video") 
	List<Favorites> favorites;

	public Videos() {
	}

	public Videos(String videoId, String title, String poster, String descriptions, Integer views, Boolean active,
			List<Favorites> favorites) {
		this.videoId = videoId;
		this.title = title;
		this.poster = poster;
		this.descriptions = descriptions;
		this.views = views;
		this.active = active;
		this.favorites = favorites;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public List<Favorites> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Favorites> favorites) {
		this.favorites = favorites;
	} 
	
	
}


