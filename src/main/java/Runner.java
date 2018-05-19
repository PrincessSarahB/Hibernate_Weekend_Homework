import db.*;
import models.Actor;
import models.Director;
import models.Film;
import models.Studio;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Studio studio1 = new Studio("Wiseau Films", 6000000.00);
        DBHelper.save(studio1);
        Studio studio2 = new Studio("New Line Cinema", 300000000.00);
        DBHelper.save(studio2);
        Director director1 = new Director("Tommy Wiseau");
        DBHelper.save(director1);
        Director director2 = new Director("Peter Jackson");
        DBHelper.save(director2);
        Actor actor1 = new Actor("Greg Sestero", 1000.00, 1000.00);
        DBHelper.save(actor1);
        Actor actor2  = new Actor("Tommy Wiseau", 1000000.00, 5000.00);
        DBHelper.save(actor2);
        Actor actor3 = new Actor("Elijah Wood", 2000000.00, 10000.00);
        DBHelper.save(actor3);
        Actor actor4 = new Actor("Sean Astin", 100000.00, 7000.00);
        DBHelper.save(actor4);

        Film film1 = new Film ("The Room", studio1, director1);
        DBHelper.save(film1);
        Film film2 = new Film("Lord of the Rings: The Fellowship of the Ring", studio2, director2);
        DBHelper.save(film2);
        Film film3 = new Film("Lord of the Rings: The Two Towers", studio2, director2);
        DBHelper.save(film3);
        Film film4 = new Film("Lord of the Rings: Return of the King", studio2, director2);
        DBHelper.save(film4);

        List<Film> films = DBHelper.getAll(Film.class);
        List<Actor> actors = DBHelper.getAll(Actor.class);
        List<Director> directors = DBHelper.getAll(Director.class);
        List<Studio> studios = DBHelper.getAll(Studio.class);

        Film foundFilm = DBHelper.find(Film.class, film1.getId());
        Actor foundActor = DBHelper.find(Actor.class, actor4.getId());
        Director foundDirector = DBHelper.find(Director.class, director1.getId());
        Studio foundStudio = DBHelper.find(Studio.class, studio2.getId());

        DBFilm.addActorsToFilm(actor3, film2);
        DBFilm.addActorsToFilm(actor3, film3);
        DBFilm.addActorsToFilm(actor3, film4);
        DBFilm.addActorsToFilm(actor4, film2);

        DBDirector.addFilmToDirector(director2, film2);
        DBDirector.addFilmToDirector(director2, film3);
        DBDirector.addFilmToDirector(director2, film4);

        DBStudio.addFilmToStudio(studio1, film1);


        List<Actor> actorsInFilm = DBFilm.listAllActorsOnFilm(film2);
        List<Film> actorsFilms = DBActor.listActorsFilms(actor3);

        List<Film> directorsFilms = DBDirector.showDirectorsFilms(director2);
        List<Film> studiosFilms = DBStudio.showStudiosFilms(studio1);
    }
}
