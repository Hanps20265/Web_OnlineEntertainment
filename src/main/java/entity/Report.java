package entity;


import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.ParameterMode;

@Entity
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(
		name = "Report.favoriteByYear",
		procedureName = "sp_FavoritesByYear",
	
		parameters = {
			@StoredProcedureParameter(
					mode = ParameterMode.IN,
					name= "year", 
					type = Integer.class)
			}
)
})

public class Report {
	@Id
	Serializable group;
	Long likes;
	Date newest;
	Date oldest;
	public Report() {
	}
	public Report(Serializable group, Long likes, Date newest, Date oldest) {
		this.group = group;
		this.likes = likes;
		this.newest = newest;
		this.oldest = oldest;
	}
	public Serializable getGroup() {
		return group;
	}
	public void setGroup(Serializable group) {
		this.group = group;
	}
	public Long getLikes() {
		return likes;
	}
	public void setLikes(Long likes) {
		this.likes = likes;
	}
	public Date getNewest() {
		return newest;
	}
	public void setNewest(Date newest) {
		this.newest = newest;
	}
	public Date getOldest() {
		return oldest;
	}
	public void setOldest(Date oldest) {
		this.oldest = oldest;
	}
	
}
