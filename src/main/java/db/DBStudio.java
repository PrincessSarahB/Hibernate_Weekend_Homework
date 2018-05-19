package db;

import models.Director;
import models.Film;
import models.Studio;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBStudio {

    private static Session session;

    public static void addFilmToStudio(Studio studio, Film film){
        studio.addFilm(film);
    }

    public static List<Film> showStudiosFilms(Studio studio){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Film> films = null;

        try {
            Criteria cr = session.createCriteria(Film.class);
            cr.add(Restrictions.eq("studio", studio));
            films = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
        } return films;
    }
}
