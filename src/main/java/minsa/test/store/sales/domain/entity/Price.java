package minsa.test.store.sales.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class Price {

    private Long id;
    private Long brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int priceList;
    private Long productId;
    private int priority;
    private double priceUnit;
    private String curr;
}
