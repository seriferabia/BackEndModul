package at.nacs.shop.run;

import at.nacs.shop.persistence.Item;
import at.nacs.shop.persistence.ItemRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

@Configuration
public class ShopRunner {

    @Bean
    ApplicationRunner runner(List<Item> items, ItemRepository repository){
        return args -> {
            //DeleteAllData
            repository.deleteAll();
            //SaveAllData
            repository.saveAll(items);

            System.out.println("--- ALL ---");
            List<Item> all = repository.findAll();
            all.forEach(System.out::println);

            System.out.println("--- BY ID ---");
            String id = all.get(0).getId();
            Optional<Item> byId = repository.findById(id);
            System.out.println(byId.get());

            System.out.println("--- BY NAME ---");
            Optional<Item> keyboard = repository.findOneByName("keyboard");
            System.out.println(keyboard.get());

            System.out.println("--- BY TYPE ---");
            List<Item> byType = repository.findByType("electronics");
            byType.forEach(System.out::println);

            System.out.println("--- AND ---");
            List<Item> and = repository.findByNameAndPrice("sofa",45.95);
            and.forEach(System.out::println);

            System.out.println("--- LESS THAN ---");
            List<Item> lessThan = repository.findByPriceLessThan(50.00);
            lessThan.forEach(System.out::println);

            System.out.println("--- BETWEEN ---");
            List<Item> between = repository.findByPriceBetween(40.00, 50.00);
            between.forEach(System.out::println);

            System.out.println("--- ORDER BY ---");
            List<Item> orderBy = repository.findByOrderByPriceAsc();
            orderBy.forEach(System.out::println);

        };
    }
}
