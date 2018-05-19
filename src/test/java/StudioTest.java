import models.Actor;
import models.Director;
import models.Film;
import models.Studio;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudioTest {

    Director director;
    Studio studio;
    Film film1;
    Film film2;
    Actor actor;

    @Before
    public void setUp() {
        studio = new Studio("New Line Cinema", 500000000.00);
        director = new Director("Peter Jackson");
        film1 = new Film("Lord of The Rings: The Fellowship of the Ring", studio, director);
        film2 = new Film("Lord of The Rings: The Two Towers", studio, director);
        actor = new Actor("Sir Ian McKellen", 400000.00, 25000.00);

    }

    @Test
    public void canAddFilms() {
        studio.addFilm(film1);
        studio.addFilm(film2);
        assertEquals(2, studio.getFilms().size());
    }
}
