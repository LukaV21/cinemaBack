package cinema.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Seat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private int seatNumber;
	@ManyToMany(mappedBy = "seats",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Set<Hall> halls = new HashSet<>();
	 
	 
	public Seat() {}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	


	public int getSeatNumber() {
		return seatNumber;
	}


	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}


	public Set<Hall> getHalls() {
		return halls;
	}


	public void setHalls(Set<Hall> halls) {
		this.halls = halls;
	}
	
	
}
