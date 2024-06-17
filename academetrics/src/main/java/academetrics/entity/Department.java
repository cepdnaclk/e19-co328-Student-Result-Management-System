package academetrics.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Department {
    @Id
    private String id;
    private String name;

}
