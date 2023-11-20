package minsa.test.store.sales.infrastructure.db.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PRODUCT", schema = "STORE")
@AllArgsConstructor
@Getter
@Setter
public class ProductJpa {

    @Id
    @SequenceGenerator(name= "PRODUCT_SEQUENCE", sequenceName = "PRODUCT_SEQUENCE_ID", initialValue=35457, allocationSize = 1)
    @GeneratedValue(generator = "PRODUCT_SEQUENCE")
    private Long id;
    private String name;
}
