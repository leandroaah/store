package minsa.test.store.sales.infrastructure.db.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "PRICE", schema = "STORE")
@NoArgsConstructor
@Getter
@Setter
public class PriceJpa {

    @Id
    @SequenceGenerator(name= "PRICE_SEQUENCE", sequenceName = "PRICE_SEQUENCE_ID", initialValue=3, allocationSize = 1)
    @GeneratedValue(generator = "PRICE_SEQUENCE")
    @Column(name = "ID")
    private Long priceId;
    @Column(name = "BRAND_ID")
    private Long brandId;
    @Column(name = "START_DATE")
    private LocalDateTime startDate;
    @Column(name = "END_DATE")
    private LocalDateTime endDate;
    @Column(name = "PRICE_LIST")
    private int priceList;
    @Column(name = "PRODUCT_ID")
    private Long productId;
    private int priority;
    private BigDecimal price;
    private String curr;

}
