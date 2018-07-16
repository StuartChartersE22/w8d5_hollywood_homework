package behaviours;

import models.Film;

import java.util.List;
import java.util.Map;

public interface IAct extends IDB {

    void setRoles(Map<String, Film> roles);
}
