import db.DBHelper;
import models.Actor;
import models.Director;
import models.Film;
import models.Studio;

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
        Actor actor1 = new Actor("Greg Sestero", 1000);
        DBHelper.save(actor1);
        Actor actor2  = new Actor("Tommy Wiseau", 1000000.00);
        DBHelper.save(actor2);
        Actor actor3 = new Actor("Elijah Wood", 2000000.00);
        DBHelper.save(actor3);
        Actor actor4 = new Actor("Sean Astin", 100000.00);
        DBHelper.save(actor4);

        Film film1 = new Film ("The Room", studio1, director1);
        DBHelper.save(film1);
        Film film2 = new Film("Lord of the Rings: The Fellowship of the Ring", studio2, director2);
        DBHelper.save(film2);
        Film film3 = new Film("Lord of the Rings: The Two Towers", studio2, director2);
        DBHelper.save(film3);
        Film film4 = new Film("Lord of the Rings: Return of the King", studio2, director2);
        DBHelper.save(film4);


    }
}
