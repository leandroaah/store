package minsa.test.store.sales.domain.repository;

import minsa.test.store.sales.domain.entity.Price;

import java.time.LocalDateTime;

public interface PriceRepository {

    Price getPrice(LocalDateTime date, Long productId, Long brandId);
}
