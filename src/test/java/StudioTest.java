import models.*;
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
        film1 = new Film("Lord of The Rings: The Fellowship of the Ring", studio, director, Genre.FANTASY);
        film2 = new Film("Lord of The Rings: The Two Towers", studio, director, Genre.FANTASY);
        actor = new Actor("Sir Ian McKellen", 400000.00, 25000.00);

    }

    @Test
    public void canAddFilms() {
        studio.addFilm(film1);
        studio.addFilm(film2);
        assertEquals(2, studio.getFilms().size());
    }

    @Test
    public void canPayActor(){
        studio.payActor(actor);
        assertEquals(499975000.00, studio.getBudget(), 0.01);
    }

    @Test
    public void actorIsPaid(){
        studio.payActor(actor);
        assertEquals(425000.00, actor.getBankAccount(), 0.01);
    }
}
