package cinema.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.Seat;
import cinema.web.dto.SeatDto;

@Component
public class SeatToSeatDto implements Converter<Seat, SeatDto> {
	
	
	@Override
	public SeatDto convert(Seat source) {
		SeatDto dto = new SeatDto();
		
		dto.setId(source.getId());
		dto.setSeatNumber(source.getSeatNumber());

		return dto;
	}
	
	public List<SeatDto> convert(List<Seat> source){
        List<SeatDto> dtoS = new ArrayList<>();

        for(Seat it : source) {
        	dtoS.add(convert(it));
        }

        return dtoS;
    }

}
