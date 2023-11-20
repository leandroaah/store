package minsa.test.store.sales.infrastructure.rest;

import lombok.AllArgsConstructor;
import minsa.test.store.sales.application.PriceService;
import minsa.test.store.sales.application.mapper.PriceMapper;
import minsa.test.store.sales.infrastructure.rest.dto.PriceOutputDto;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/store")
@AllArgsConstructor
public class PriceController {

    private final PriceService priceService;
    private final PriceMapper priceMapper;

    @GetMapping("/price")
    public ResponseEntity<PriceOutputDto> findPriceByFilter(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                 LocalDateTime date,
                                                 @RequestParam Long productId,
                                                 @RequestParam Long brandId) {
        return ResponseEntity.ok(priceMapper.toPriceOutputDto(priceService.getPrice(date, productId, brandId)));
    }

}
