package minsa.test.store.sales.application;

import minsa.test.store.sales.domain.entity.Price;

import java.time.LocalDateTime;

public interface PriceService {

    Price getPrice(LocalDateTime date, Long productId, Long brandId);
}
