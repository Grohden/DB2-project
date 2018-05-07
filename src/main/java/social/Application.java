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

    @Bean
    public CommandLineRunner demo(PersonRepository persons, FriendshipRepository friendships) {
        return (args) -> {
            final Calendar bornDate = Calendar.getInstance();

            final Person fOne = new Person(
                    "Primeiro",
                    bornDate,
                    "test@123",
                    "joinville",
                    "joinville"
            );

            final Person fTwo = new Person(
                    "Segundo",
                    bornDate,
                    "test@123",
                    "joinville",
                    "joinville"
            );

            persons.save(fOne);
            persons.save(fTwo);

            final Friendship first = new Friendship(
                    persons.findById(1L).orElse(null),
                    persons.findById(2L).orElse(null),
                    Calendar.getInstance()
            );

            friendships.save(first);

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
