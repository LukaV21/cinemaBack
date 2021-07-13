package cinema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import cinema.model.Korisnik;
import cinema.web.dto.KorisnikPromenaLozinkeDto;

public interface KorisnikService {

    Optional<Korisnik> findOne(Long id);

    List<Korisnik> findAll();

    Page<Korisnik> findAll(int brojStranice);

    Korisnik save(Korisnik korisnik);

    void delete(Long id);

    Optional<Korisnik> findbyKorisnickoIme(String korisnickoIme);

    boolean changePassword(Long id, KorisnikPromenaLozinkeDto korisnikPromenaLozinkeDto);
}
