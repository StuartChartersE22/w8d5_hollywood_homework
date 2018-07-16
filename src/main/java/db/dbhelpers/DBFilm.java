package db.dbhelpers;

import behaviours.IAct;
import db.DBHelper;
import db.HibernateUtil;
import models.Actor;
import models.Film;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.Map;

public class DBFilm extends DBHelper {

    private static Session session;

    public static void addCastToFilm(Film film, Map<String, Actor> cast){
        film.addCast(cast);
        update(film);
    }

    public static List<Actor> getCastMembersForFilm(Film film){
        return getAssociationsForAnObject(film, Actor.class, "roles");
    }
//    public static List<Actor> getCastMembersForFilm(Film film){
//        List<Actor> results = null;
//        session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            Criteria cr = session.createCriteria(Actor.class);
//            cr.createAlias("roles", "film");
//            cr.add(Restrictions.eq("film.id", film.getId()));
//            results = cr.list();
//        }catch (HibernateException e){
//            e.printStackTrace();
//        }finally {
//            session.close();
//        }
//        return results;
//    }
}
