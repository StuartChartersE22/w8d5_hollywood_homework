package db.dbhelpers;

import behaviours.IAct;
import db.DBHelper;
import models.Film;

import java.util.List;
import java.util.Map;

public class DBFilm extends DBHelper {

    public static void addCastToFilm(Film film, Map<IAct, String> cast){
        film.addCast(cast);
        update(film);
    }

//    public static List<IAct> getCastMembersForFilm(Film film){
//        return getAssociationsForAnObject(film, IAct.class, "cast");
//    }
}
