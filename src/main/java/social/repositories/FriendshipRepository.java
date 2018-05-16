package social.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import social.entities.Friendship;
import social.projections.WithPersons;

import javax.transaction.Transactional;

@CrossOrigin
@RepositoryRestResource(
        excerptProjection = WithPersons.class,
        collectionResourceRel = "friendship",
        path = "friendship"
)
public interface FriendshipRepository extends CrudRepository<Friendship, Long> {

    @Query("SELECT DISTINCT f FROM Friendship f WHERE (:friendId IN (f.friend.id, f.friendship.id) AND :friendshipId IN (f.friend.id, f.friendship.id))")
    Friendship findFriendshipByIds(@Param("friendId") Long friendId, @Param("friendshipId") Long friendshipId);

    @Transactional
    @Modifying
    @Query("DELETE FROM Friendship f WHERE (:friendId IN (f.friend.id, f.friendship.id) AND :friendshipId IN (f.friend.id, f.friendship.id))")
    void deleteFriendshipByIds(@Param("friendId") Long friendId, @Param("friendshipId") Long friendshipId);
}
