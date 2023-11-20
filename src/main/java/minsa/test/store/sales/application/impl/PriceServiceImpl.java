package minsa.test.store.sales.application.impl;

import lombok.AllArgsConstructor;
import minsa.test.store.sales.application.PriceService;
import minsa.test.store.sales.domain.entity.Price;
import minsa.test.store.sales.domain.repository.PriceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;
    @Override
    public Price getPrice(LocalDateTime date, Long productId, Long brandId) {
        return priceRepository.getPrice(date, productId, brandId);
    }
}
