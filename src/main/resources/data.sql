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



