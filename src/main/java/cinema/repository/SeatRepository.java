package cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cinema.model.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

	Seat findOneById(Long seatId);

}
