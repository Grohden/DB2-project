package social.entities;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class Friendship {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private Person friend;

    @OneToOne
    private Person friendship;

    @Temporal(TemporalType.DATE)
    private Calendar friendShipDate;

    protected Friendship() {}

    public Friendship(Person friend, Person friendship, Calendar friendShipDate) {
        this.friend = friend;
        this.friendship = friendship;
        this.friendShipDate = friendShipDate;
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
}
