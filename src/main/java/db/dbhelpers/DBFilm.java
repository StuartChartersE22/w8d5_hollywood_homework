package db.dbhelpers;

import behaviours.IAct;
import db.DBHelper;
import models.Actor;
import models.Film;

import java.util.List;
import java.util.Map;

public class DBFilm extends DBHelper {

    public static void addCastToFilm(Film film, Map<String, Actor> cast){
        film.addCast(cast);
        update(film);
    }

//    public static List<Actor> getCastMembersForFilm(Film film){
//        return getAssociationsForAnObject(film, Actor.class, "cast");
//    }
}
