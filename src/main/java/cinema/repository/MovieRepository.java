package cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cinema.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long>{

}
