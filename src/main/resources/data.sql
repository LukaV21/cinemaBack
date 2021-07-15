INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
				VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
				VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
				VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');

INSERT INTO `cinema`.`projection_type` (`id`, `projection_type_name`) 
				VALUES ('1', '2D');
INSERT INTO `cinema`.`projection_type` (`id`, `projection_type_name`) 
				VALUES ('2', '3D');
INSERT INTO `cinema`.`projection_type` (`id`, `projection_type_name`) 
				VALUES ('3', '4D');
              
INSERT INTO `cinema`.`hall` (`id`, `hall_name`) 
				VALUES ('1', 'Hall #1');
INSERT INTO `cinema`.`hall` (`id`, `hall_name`) 
				VALUES ('2', 'Hall #2');
INSERT INTO `cinema`.`hall` (`id`, `hall_name`) 
				VALUES ('3', 'Hall #3');
INSERT INTO `cinema`.`hall` (`id`, `hall_name`) 
				VALUES ('4', 'Hall #4');
                
INSERT INTO `cinema`.`hall_projection_type` (`hall_id`, `projection_type_id`) 
				VALUES ('1', '1');
INSERT INTO `cinema`.`hall_projection_type` (`hall_id`, `projection_type_id`) 
				VALUES ('1', '2');
INSERT INTO `cinema`.`hall_projection_type` (`hall_id`, `projection_type_id`) 
				VALUES ('1', '3');
INSERT INTO `cinema`.`hall_projection_type` (`hall_id`, `projection_type_id`) 
				VALUES ('2', '2');
INSERT INTO `cinema`.`hall_projection_type` (`hall_id`, `projection_type_id`) 
				VALUES ('2', '3');
INSERT INTO `cinema`.`hall_projection_type` (`hall_id`, `projection_type_id`) 
				VALUES ('3', '1');
INSERT INTO `cinema`.`hall_projection_type` (`hall_id`, `projection_type_id`) 
				VALUES ('4', '1');
                
INSERT INTO `cinema`.`seat` (`id`, `seat_number`) 
				VALUES ('1', '1');
INSERT INTO `cinema`.`seat` (`id`, `seat_number`) 
				VALUES ('2', '2');
INSERT INTO `cinema`.`seat` (`id`, `seat_number`) 
				VALUES ('3', '3');
INSERT INTO `cinema`.`seat` (`id`, `seat_number`) 
				VALUES ('4', '4');
INSERT INTO `cinema`.`seat` (`id`, `seat_number`) 
				VALUES ('5', '5');
                
INSERT INTO `cinema`.`hall_seat` (`hall_id`, `seat_id`) VALUES ('1', '1');
INSERT INTO `cinema`.`hall_seat` (`hall_id`, `seat_id`) VALUES ('1', '2');
INSERT INTO `cinema`.`hall_seat` (`hall_id`, `seat_id`) VALUES ('1', '3');
INSERT INTO `cinema`.`hall_seat` (`hall_id`, `seat_id`) VALUES ('1', '4');
INSERT INTO `cinema`.`hall_seat` (`hall_id`, `seat_id`) VALUES ('1', '5');
INSERT INTO `cinema`.`hall_seat` (`hall_id`, `seat_id`) VALUES ('2', '1');
INSERT INTO `cinema`.`hall_seat` (`hall_id`, `seat_id`) VALUES ('2', '2');
INSERT INTO `cinema`.`hall_seat` (`hall_id`, `seat_id`) VALUES ('2', '3');
INSERT INTO `cinema`.`hall_seat` (`hall_id`, `seat_id`) VALUES ('2', '4');
INSERT INTO `cinema`.`hall_seat` (`hall_id`, `seat_id`) VALUES ('2', '5');
INSERT INTO `cinema`.`hall_seat` (`hall_id`, `seat_id`) VALUES ('3', '1');
INSERT INTO `cinema`.`hall_seat` (`hall_id`, `seat_id`) VALUES ('3', '2');
INSERT INTO `cinema`.`hall_seat` (`hall_id`, `seat_id`) VALUES ('3', '3');
INSERT INTO `cinema`.`hall_seat` (`hall_id`, `seat_id`) VALUES ('3', '4');
INSERT INTO `cinema`.`hall_seat` (`hall_id`, `seat_id`) VALUES ('3', '5');
INSERT INTO `cinema`.`hall_seat` (`hall_id`, `seat_id`) VALUES ('4', '1');
INSERT INTO `cinema`.`hall_seat` (`hall_id`, `seat_id`) VALUES ('4', '2');
INSERT INTO `cinema`.`hall_seat` (`hall_id`, `seat_id`) VALUES ('4', '3');
INSERT INTO `cinema`.`hall_seat` (`hall_id`, `seat_id`) VALUES ('4', '4');
INSERT INTO `cinema`.`hall_seat` (`hall_id`, `seat_id`) VALUES ('4', '5');

INSERT INTO `cinema`.`movie` (`id`, `actors`, `deleted`, `description`, `director`, `distributor`, `duration`, `genres`, `movie_name`, `origin_country`, `release_year`) 
	VALUES ('1', 'Anatoly Solonitsyn, Ivan Lapikov, Nikolai Grinko', FALSE, 'The life, times and afflictions of the fifteenth-century Russian iconographer St. Andrei Rublev', 'Andrei Tarkovsky', '	Columbia Pictures', '205', 'Biography, Drama, History', 'Andrei Rublev', 'Soviet Union', '1966');

INSERT INTO `cinema`.`movie` (`id`, `actors`, `deleted`, `description`, `director`, `distributor`, `duration`, `genres`, `movie_name`, `origin_country`, `release_year`) 
	VALUES ('2', 'Jean-Pierre Léaud, Albert Rémy, Claire Maurier ', FALSE, 'A young boy, left without attention, delves into a life of petty crime.', 'François Truffaut', 'Cocinor', '99', 'Crime, Drama', 'The 400 Blows', 'France', '1959');
    
INSERT INTO `cinema`.`movie` (`id`, `actors`, `deleted`, `description`, `director`, `distributor`, `duration`, `genres`, `movie_name`, `origin_country`, `release_year`) 
	VALUES ('3', 'Bekim Fehmiu, Olivera Katarina, Velimir \'Bata\' Zivojinovic ', FALSE, 'Tensions arise in a Gypsy community when a local feather seller falls in love with a much younger girl.', 'Aleksandar Petrovic', 'Avala Film', '94', 'Drama', 'Skupljaci perja', 'Yugoslavia', '1967');







