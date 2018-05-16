package social.entities;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class Friendship {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
//    @NotNull
    private Person friend;

    @OneToOne
//    @NotNull
    private Person friendship;

    @Temporal(TemporalType.DATE)
    private Calendar friendShipDate;

    protected Friendship() {}

    public Friendship(Person friend, Person friendship, Calendar friendShipDate) {
        this.friend = friend;
        this.friendship = friendship;
        this.friendShipDate = friendShipDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Person getFriend() {
        return friend;
    }

    public void setFriend(Person friend) {
        this.friend = friend;
    }

    public Person getFriendship() {
        return friendship;
    }

    public void setFriendship(Person friendship) {
        this.friendship = friendship;
    }

    public Calendar getFriendShipDate() {
        return friendShipDate;
    }

    public void setFriendShipDate(Calendar friendShipDate) {
        this.friendShipDate = friendShipDate;
    }

    public void setFriendId(Long id) {
        this.friend = new Person(id);
    }

    public void setFriendshipId(Long id) {
        this.friendship = new Person(id);
    }
}
