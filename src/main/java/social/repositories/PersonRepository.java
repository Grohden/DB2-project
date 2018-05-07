package social.repositories;

import org.springframework.data.repository.CrudRepository;
import social.entities.Person;

//@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends CrudRepository<Person, Long> {

}
