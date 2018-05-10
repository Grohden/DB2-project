package social.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import social.entities.Friendship;
import social.projections.WithPersons;

@RepositoryRestResource(
        excerptProjection = WithPersons.class,
        collectionResourceRel = "friendship",
        path = "friendship"
)
public interface FriendshipRepository extends CrudRepository<Friendship, Long> {
}
