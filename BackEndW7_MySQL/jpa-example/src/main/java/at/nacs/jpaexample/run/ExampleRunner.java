package at.nacs.jpaexample.run;

import at.nacs.jpaexample.persistence.Cellphone;
import at.nacs.jpaexample.persistence.Cloth;
import at.nacs.jpaexample.persistence.Person;
import at.nacs.jpaexample.persistence.PersonRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExampleRunner {
    @Bean
    ApplicationRunner runner(PersonRepository repository){
        return args -> {
            repository.deleteAll();

            Person person = new Person();
            person.setName("Serife");

            Cellphone privatePhone = new Cellphone();
            privatePhone.setNumber("1234567");

            Cellphone workPhone = new Cellphone();
            workPhone.setNumber("7654321");

            person.setPrivatePhone(privatePhone);
            person.setWorkPhone(workPhone);

            Cloth jeans = new Cloth();
            jeans.setName("Jeans");

            Cloth shirt = new Cloth();
            shirt.setName("T-shirt");

            person.getCloths().add(jeans);
            person.getCloths().add(shirt);
            repository.save(person);
        };
    }
}
