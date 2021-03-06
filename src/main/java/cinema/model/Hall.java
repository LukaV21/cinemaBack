package cinema.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

@Entity
public class Hall {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 @Column
	 private String hallName;
	 @ManyToMany
	 @JoinTable(name = "hall_projectionType", joinColumns = @JoinColumn (name = "hall_id", referencedColumnName = "id"),
	         inverseJoinColumns = @JoinColumn(name = "projectionType_id", referencedColumnName = "id"))
	 private Set<ProjectionType> projectionTypes = new HashSet<>();
	 
	 @ManyToMany
	 @JoinTable(name = "hall_seat", joinColumns = @JoinColumn (name = "hall_id", referencedColumnName = "id"),
	         inverseJoinColumns = @JoinColumn(name = "seat_id", referencedColumnName = "id"))
	 private Set<Seat> seats = new HashSet<>();
	 
	 @OneToMany(mappedBy = "hall", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	 private List<Projection> projections = new ArrayList<>();
	 
	 
	 public Hall() {
		 
	 }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getHallName() {
		return hallName;
	}


	public void setHallName(String hallName) {
		this.hallName = hallName;
	}


	public Set<ProjectionType> getProjectionTypes() {
		return projectionTypes;
	}


	public void setProjectionTypes(Set<ProjectionType> projectionTypes) {
		this.projectionTypes = projectionTypes;
	}


	public Set<Seat> getSeats() {
		return seats;
	}


	public void setSeats(Set<Seat> seats) {
		this.seats = seats;
	}


	public List<Projection> getProjections() {
		return projections;
	}


	public void setProjections(List<Projection> projections) {
		this.projections = projections;
	}
	
	
	 
	
	
	
	 
	

}
