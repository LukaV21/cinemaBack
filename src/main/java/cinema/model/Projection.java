package cinema.model;

import java.time.LocalDateTime;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.ParamDef;

@Entity
@SQLDelete(sql = "UPDATE projection SET deleted = true WHERE id=?")
@FilterDef(name = "deletedProjectionFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter(name = "deletedProjectionFilter", condition = "deleted = :isDeleted")
public class Projection {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
    private Movie movie;
	@ManyToOne 
	private ProjectionType projectionType;
	@ManyToOne
	private Hall hall;
	@Column
	private LocalDateTime projectionStart;
	@Column
	private LocalDateTime projectionEnd;
	@Column
	private double ticketPrice;	
	@Column
    private String admin;
	@Column
	private boolean deleted = Boolean.FALSE;
	
	public Projection() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public ProjectionType getProjectionType() {
		return projectionType;
	}

	public void setProjectionType(ProjectionType projectionType) {
		this.projectionType = projectionType;
	}

	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

	



	public LocalDateTime getProjectionStart() {
		return projectionStart;
	}

	public void setProjectionStart(LocalDateTime projectionStart) {
		this.projectionStart = projectionStart;
	}

	public LocalDateTime getProjectionEnd() {
		return projectionEnd;
	}

	public void setProjectionEnd(LocalDateTime projectionEnd) {
		this.projectionEnd = projectionEnd;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	
	
	

}
