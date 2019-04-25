//package at.nacs.lechef.persistence;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.LazyCollection;
//import org.hibernate.annotations.LazyCollectionOption;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Data
//@Entity
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//public class ShoppingList {
//  @Id
//  @GeneratedValue
//  private Long id;
//
//  @LazyCollection(LazyCollectionOption.FALSE)
//  @OneToMany(cascade = CascadeType.ALL)
//  private List<Ingredient> necessaries = new ArrayList<>();
//}
