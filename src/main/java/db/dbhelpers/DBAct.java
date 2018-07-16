package db.dbhelpers;

import db.DBHelper;
import models.Actor;
import models.Film;

import java.util.List;

public class DBAct extends DBHelper {

    public static List<Film> getFilmsforActor(Actor actor){
        return getAssociationsForAnObject(actor, Film.class, "cast");
    }
}
