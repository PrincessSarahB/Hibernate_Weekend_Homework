package db;

import models.Actor;
import models.Film;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBActor {

    private static Session session;

    public static List<Film> listActorsFilms(Actor actor){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Film> films = null;
        try {
            Criteria cr = session.createCriteria(Film.class);
            cr.createAlias("actors", "individual_actor");
            cr.add(Restrictions.eq("individual_actor.id", actor.getId()));
            films = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        } return films;

    }

    public static List<Film> listActorsFilmsByGenre(Actor actor){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Film> films = null;
        try {
            Criteria cr = session.createCriteria(Film.class);
            cr.createAlias("actors", "individual_actor");
            cr.add(Restrictions.eq("individual_actor.id", actor.getId()));
            cr.addOrder(Order.asc("genre"));
            films = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        } return films;

    }
}
