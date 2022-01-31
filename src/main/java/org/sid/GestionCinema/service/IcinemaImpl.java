package org.sid.GestionCinema.service;

import org.sid.GestionCinema.dao.*;
import org.sid.GestionCinema.entities.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;
@Service
@Transactional
public class IcinemaImpl implements Icinema {

    private VilleRepo villeRepo;

    private CinemaRepo cinemaRepo;

    private SalleRepo salleRepo;

    private PlaceRepo placeRepo;

    private SeanceRepo seanceRepo;

    private  CategorieRepo categorieRepo;

    private FilmRepo filmRepo;

    private FilmProjectionRepo filmProjectionRepo;

    private TicketPlaceRepo ticketPlaceRepo;

    public IcinemaImpl(VilleRepo villeRepo, CinemaRepo cinemaRepo, SalleRepo salleRepo,
                       PlaceRepo placeRepo, SeanceRepo seanceRepo, CategorieRepo categorieRepo,
                       FilmRepo filmRepo, FilmProjectionRepo filmProjectionRepo, TicketPlaceRepo ticketPlaceRepo) {
        this.villeRepo = villeRepo;
        this.cinemaRepo = cinemaRepo;
        this.salleRepo = salleRepo;
        this.placeRepo = placeRepo;
        this.seanceRepo = seanceRepo;
        this.categorieRepo = categorieRepo;
        this.filmRepo = filmRepo;
        this.filmProjectionRepo = filmProjectionRepo;
        this.ticketPlaceRepo = ticketPlaceRepo;
    }

    @Override
    public void initVillee() {

        Stream.of("Yaounde","Rabat","casablanca","Douala","Paris").forEach(ville->{
                    Ville v=new Ville();
                    v.setNom(ville);
                    v.setNombreHabitant(200000+(int)(Math.random()*100000));
                    villeRepo.save(v);
        });
    }

    @Override
    public void initCinemas() {
        villeRepo.findAll().forEach(ville->{
                Stream.of("Abbia","wouri","Lutetia","Colisée").forEach(cnema->{
                    Cinema cinema=new Cinema();
                    cinema.setName(cnema);
                    cinema.setNombreSalle(3+(int)(Math.random()*2));
                    cinema.setVille(ville);
                    cinemaRepo.save(cinema);

                });}
        );

    }

    @Override
    public void initSalles() {
        cinemaRepo.findAll().forEach(cinema -> {
            for(int i=0;i<cinema.getNombreSalle();i++){
                Salle salle=new Salle();
                      salle.setName("salle "+(i+1));
                      salle.setCinema(cinema);
                      salle.setNombrePlace(10+(int)(Math.random()*40));
                       salleRepo.save(salle);
            }
        });


    }

    @Override
    public void initPlace() {
        salleRepo.findAll().forEach(salle->{
            for(int i=0;i<salle.getNombrePlace();i++){
                Place place=new Place();
                place.setNumero(i+1);
                place.setSalle(salle);
                placeRepo.save(place);


            }
        });


    }



    @Override
    public void initSeance() {
        DateFormat dateFormat=new SimpleDateFormat("HH:mm");
        Stream.of("10:00","13:00","16:00","20:00").forEach(heure->{
            Seance seance=new Seance();
            try {
                seance.setHeureDebut(dateFormat.parse(heure));
                seanceRepo.save(seance);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });

    }

    @Override
    public void initCategori() {

        Stream.of("guerre","documentaire","hausa","aventure","fiction").forEach( categorie ->{

                   Categorie categori=new Categorie();
                   categori.setNonCategorie(categorie);
                   categorieRepo.save(categori);


                }

        );

    }

    @Override
    public void initFilms() {
        double[] durre=new double[]{1.5,2.5,3,2,};
        List<Categorie> categorieList= categorieRepo.findAll();
        Stream.of("Izzar so","Taqaddama","Labarrin Maryam",
                "Ducumentaire Zinedine Zidane","documentaire sur Samuel eto'o",
                "Le documentaire Et je choisis de vivre ","Le Parrain ","Le film 300","La Guerre de Troie",
                "King Kong").forEach(film->{
            Film filme=new Film();
                  filme.setTitre(film);
                  filme.setDuree(durre[new Random().nextInt(durre.length)]);
                  filme.setPhoto(film.replace(" ",""));
                  filme.setCategorie(categorieList.get(new Random().nextInt(categorieList.size())));
                 filmRepo.save(filme);

        });

    }

    @Override
    public void initPojection() {
        double[] prices=new double[]{30,50,70,100};
        villeRepo.findAll().forEach(ville -> {
            ville.getCinemaList().forEach(cinema -> {
                cinema.getSalles().forEach(salle -> {
                    filmRepo.findAll().forEach(film -> {
                        seanceRepo.findAll().forEach(seance -> {
                            FilmProjection filmProjection=new FilmProjection();
                             filmProjection.setDateProjection(new Date());
                             filmProjection.setFilm(film);
                             filmProjection.setPrix(prices[new Random().nextInt(prices.length)]);
                             filmProjection.setSalle(salle);
                             filmProjection.setSeance(seance);
                             filmProjectionRepo.save(filmProjection);
                                }

                        );
                    });
                });
            });
        });

    }

    @Override
    public void initTicketPlace() {
        filmProjectionRepo.findAll().forEach(projection->{
            projection.getSalle().getPlaceList().forEach(place -> {
                TicketPlace ticketPlace=new TicketPlace();
                ticketPlace.setPlace(place);
                ticketPlace.setPrix(projection.getPrix());
                ticketPlace.setFilmProjection(projection);
                ticketPlace.setReserve(false);
                ticketPlaceRepo.save(ticketPlace);

            });
        });

    }
}
