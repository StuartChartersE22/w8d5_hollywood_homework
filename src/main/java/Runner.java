import behaviours.IAct;
import db.DBHelper;
import db.dbhelpers.DBAct;
import db.dbhelpers.DBFilm;
import models.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Runner {

    public static void main(String[] args) {

        models.Actor actor1 = new models.Actor("Bill", 20000000);
        DBHelper.save(actor1);
        models.Actor actor2 = new models.Actor("Jane", 200000);
        DBHelper.save(actor2);

        Map<String, Actor> cast = new HashMap<String, Actor>();
        cast.put("Lead man", actor1);
        cast.put("Lead lady", actor2);

        Director director = new Director("Greg", 234234);
        DBHelper.save(director);

        Studio studio = new Studio("Warner Bros.", 239809834);
        DBHelper.save(studio);

        Film film = new Film("Hunter", director, 12343, GenreType.COMEDY, studio);
        DBHelper.save(film);

        DBFilm.addCastToFilm(film, cast);

        List<Actor> castForFilm = DBFilm.getCastMembersForFilm(film);
        List<Film> filmsForActor = DBAct.getFilmsforActor(actor1);

        System.exit(0);
    }
}
