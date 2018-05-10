package social;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import social.entities.Friendship;
import social.entities.Person;
import social.repositories.FriendshipRepository;
import social.repositories.PersonRepository;

import java.util.Calendar;

@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    private Person makeSimplePerson(String name) {
        final Calendar bornDate = Calendar.getInstance();

        return new Person(
                name,
                bornDate,
                "gabriel.rohden@test.com",
                "joinville",
                "joinville"
        );
    }

    @Bean
    public CommandLineRunner demo(PersonRepository persons, FriendshipRepository friendships) {
        return (args) -> {


            final Person fOne = makeSimplePerson("One");
            final Person fTwo = makeSimplePerson("Two");
            final Person fThree = makeSimplePerson("Three");
            final Person fFour = makeSimplePerson("Four");

            persons.save(fOne);
            persons.save(fTwo);
            persons.save(fThree);
            persons.save(fFour);

            final Friendship first = new Friendship(
                    fOne, fTwo,
                    Calendar.getInstance()
            );

            final Friendship second = new Friendship(
                    fOne, fThree,
                    Calendar.getInstance()
            );

            final Friendship third = new Friendship(
                    fFour, fOne,
                    Calendar.getInstance()
            );

            friendships.save(first);
            friendships.save(second);
            friendships.save(third);

            // fetch an individual customer by ID
            friendships.findById(1L)
                    .ifPresent(f -> {
                        log.info("Customer found with findById(1L):");
                        log.info("--------------------------------");
                        log.info(f.toString());
                        log.info("");
                    });

            log.info("");
        };
    }
}
