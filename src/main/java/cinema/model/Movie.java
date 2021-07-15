package cinema.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.ParamDef;

@Entity
@SQLDelete(sql = "UPDATE movie SET deleted = true WHERE id=?")
@FilterDef(name = "deletedMovieFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter(name = "deletedMovieFilter", condition = "deleted = :isDeleted")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column 
	private String movieName;
	@Column(nullable = true)
	private String director;
	@Column(nullable = true)
	private String actors;
	@Column(nullable = true)
	private String genres;
	@Column 
	@Min(0)
	private int duration;
	@Column
	private String distributor;
	@Column
	private String originCountry;
	@Column
	private int releaseYear;
	@Column (nullable = true)
	private String description;
	@Column
	private boolean deleted = Boolean.FALSE;
	
	
	public Movie() {}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getMovieName() {
		return movieName;
	}


	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}


	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}


	public String getActors() {
		return actors;
	}


	public void setActors(String actors) {
		this.actors = actors;
	}


	public String getGenres() {
		return genres;
	}


	public void setGenres(String genres) {
		this.genres = genres;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public String getDistributor() {
		return distributor;
	}


	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}


	public String getOriginCountry() {
		return originCountry;
	}


	public void setOriginCountry(String originCountry) {
		this.originCountry = originCountry;
	}





	public int getReleaseYear() {
		return releaseYear;
	}


	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public boolean isDeleted() {
		return deleted;
	}


	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	

}
