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
public class ProjectionType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String projectionTypeName;
	@ManyToMany(mappedBy = "projectionTypes",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Set<Hall> halls = new HashSet<>();
	
	
	public ProjectionType() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getProjectionTypeName() {
		return projectionTypeName;
	}


	public void setProjectionTypeName(String projectionName) {
		this.projectionTypeName = projectionName;
	}


	public Set<Hall> getHalls() {
		return halls;
	}


	public void setHalls(Set<Hall> halls) {
		this.halls = halls;
	}
	
	
	
	
	

}
