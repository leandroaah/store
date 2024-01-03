package minsa.test.store.sales.infrastructure.db.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "BRAND", schema = "STORE")
@AllArgsConstructor
@Getter
@Setter
public class BrandJpa {
    @Id
    @SequenceGenerator(name= "BRAND_SEQUENCE", sequenceName = "BRAND_SEQUENCE_ID", initialValue=3, allocationSize = 1)
    @GeneratedValue(generator = "BRAND_SEQUENCE")
    private Long id;
    private String name;
}
