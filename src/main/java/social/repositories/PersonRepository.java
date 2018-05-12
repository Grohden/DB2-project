package social.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import social.entities.Person;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "person", path = "person")
public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query("SELECT DISTINCT p FROM Person p JOIN Friendship f on (:personid IN (f.friend.id, f.friendship.id) AND p.id <> :personid)")
    List<Person> findFriends(@Param("personid") Long personId);

}
