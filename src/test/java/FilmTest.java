import models.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FilmTest {

    Director director;
    Studio studio;
    Film film1;
    Film film2;
    Actor actor;

    @Before
    public void setUp() {
        studio = new Studio("New Line Cinema", 500000000.00);
        director = new Director("Peter Jackson");
        film1 = new Film("Lord of The Rings: The Fellowship of the Ring", studio, director, Genre.FANTASY);
        film2 = new Film("Lord of The Rings: The Two Towers", studio, director, Genre.FANTASY);
        actor = new Actor("Sir Ian McKellen", 400000.00, 25000.00);

    }

    @Test
    public void canAddActor() {
        film1.addActorToFilm(actor);
        assertEquals(1, film1.getActors().size());
    }
}
