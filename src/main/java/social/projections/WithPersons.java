package social.projections;

import org.springframework.data.rest.core.config.Projection;
import social.entities.Friendship;
import social.entities.Person;

import java.util.Calendar;

@Projection(name = "withPersons", types = {Friendship.class})
public interface WithPersons {

    Calendar getFriendShipDate();

    Person getFriendship();

    Person getFriend();
}
