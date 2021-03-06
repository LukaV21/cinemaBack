package cinema.service;

import java.util.List;

import cinema.model.ProjectionType;

public interface ProjectionTypeService {

	List<ProjectionType> findAll();

	ProjectionType findOne(Long projectionTypeId);

}
