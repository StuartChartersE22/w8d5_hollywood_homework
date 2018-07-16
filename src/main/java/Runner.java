import behaviours.IAct;
import db.DBHelper;
import db.dbhelpers.DBFilm;
import models.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Runner {

    public static void main(String[] args) {

        Actor actor1 = new Actor("Bill", 20000000);
        DBHelper.save(actor1);
        Actor actor2 = new Actor("Jane", 200000);
        DBHelper.save(actor2);

        Map<Actor, String> cast = new HashMap<Actor, String>();
        cast.put(actor1, "Lead man");
        cast.put(actor2, "Lead lady");

        Director director = new Director("Greg", 234234);
        DBHelper.save(director);

        Studio studio = new Studio("Warner Bros.", 239809834);
        DBHelper.save(studio);

        Film film = new Film("Hunter", director, 12343, GenreType.COMEDY, studio);
        DBHelper.save(film);

        DBFilm.addCastToFilm(film, cast);

//        List<IAct> castForFilm = DBFilm.getCastMembersForFilm(film);

        System.exit(0);
    }
}
