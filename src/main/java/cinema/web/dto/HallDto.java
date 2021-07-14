package cinema.web.dto;

import java.util.HashSet;
import java.util.Set;

public class HallDto {
	
	private Long id;
	private String hallName;
	
	private Set<ProjectionTypeDto> projectionTypes = new HashSet<>();
	
	
	public HallDto() {
		
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


	public Set<ProjectionTypeDto> getProjectionTypes() {
		return projectionTypes;
	}


	public void setProjectionTypes(Set<ProjectionTypeDto> projectionTypes) {
		this.projectionTypes = projectionTypes;
	}
	
	

}
