import models.Director;
import models.Film;
import models.Genre;
import models.Studio;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirectorTest {

    Director director;
    Studio studio;
    Film film1;
    Film film2;

    @Before
    public void setUp() {
        studio = new Studio("New Line Cinema", 500000000.00);
        director = new Director("Peter Jackson");
        film1 = new Film("Lord of The Rings: The Fellowship of the Ring", studio, director, Genre.FANTASY);
        film2 = new Film("Lord of The Rings: The Two Towers", studio, director, Genre.FANTASY);

    }

    @Test
    public void canAddFilms() {
        director.addFilm(film1);
        director.addFilm(film2);
        assertEquals(2, director.getFilms().size());
    }


}
