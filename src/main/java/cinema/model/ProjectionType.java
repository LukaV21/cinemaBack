package cinema.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProjectionType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String projectionTypeName;
	
	
	public ProjectionType() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getProjectionName() {
		return projectionTypeName;
	}


	public void setProjectionName(String projectionName) {
		this.projectionTypeName = projectionName;
	}
	
	
	

}