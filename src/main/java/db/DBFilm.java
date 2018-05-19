package db;

import models.Actor;
import models.Film;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

import static db.DBHelper.save;

public class DBFilm {

    private static Session session;

    public static void addActorsToFilm(Actor actor, Film film){
        film.addActorToFilm(actor);
        actor.addFilmToActor(film);
        save(film);
    }

    public static List<Actor> listAllActorsOnFilm(Film film){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Actor> actors = null;
        try {
            Criteria cr = session.createCriteria(Actor.class);
            cr.createAlias("films", "individual_film");
            cr.add(Restrictions.eq("individual_film.id", film.getId()));
            actors = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        } return actors;

    }



}
