package social.repositories;

import org.springframework.data.repository.CrudRepository;
import social.entities.Friendship;

public interface FriendshipRepository extends CrudRepository<Friendship, Long> {
}
