package at.nacs.lechef.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
  List<Recipe> findAllByType(String type);

  List<Recipe> findAllByLabel(String label);

  List<Recipe> findAllByOrigin(String origin);
}
