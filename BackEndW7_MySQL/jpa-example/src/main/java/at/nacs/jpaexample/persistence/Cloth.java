package at.nacs.jpaexample.persistence;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Data
@Entity
public class Cloth {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
