package cinema.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.ProjectionType;
import cinema.web.dto.ProjectionTypeDto;

@Component
public class ProjectionTypeToProjectionTypeDto implements Converter<ProjectionType, ProjectionTypeDto> {

	@Override
	public ProjectionTypeDto convert(ProjectionType source) {
		ProjectionTypeDto dto = new ProjectionTypeDto();
		
		dto.setId(source.getId());
		dto.setProjectionTypeName(source.getProjectionTypeName());

		
		return dto;
	}
	
	
	public List<ProjectionTypeDto> convert(List<ProjectionType> source){
        List<ProjectionTypeDto> dtoS = new ArrayList<>();

        for(ProjectionType it : source) {
        	dtoS.add(convert(it));
        }

        return dtoS;
    }

}
