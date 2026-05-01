package lld.meetingscheduler;

import java.util.Objects;

/**
 * @author Anirudh
 * @since 17/04/26
 */
public class Attendee {
    long id;
    String name;
    String email;

    public Attendee(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public void acceptInvite() {
        System.out.println("Accepted Invite");
    }

    public void declineInvite() {
        System.out.println("Declined Invite");
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Attendee attendee)) return false;
        return id == attendee.id && Objects.equals(name, attendee.name) && Objects.equals(email, attendee.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }
}
