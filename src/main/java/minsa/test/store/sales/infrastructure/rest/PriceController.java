package minsa.test.store.sales.infrastructure.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(summary = "Find price by parameters",
            tags = {"price"},
            description = "Return a product identifier, brand identifier, rate to apply, application dates and final " +
                    "price to be applied filtered by input parameters.",
            responses = {
                    @ApiResponse(description = "The price", content = @Content(
                            schema = @Schema(implementation = PriceOutputDto.class)))
            })
    public ResponseEntity<PriceOutputDto> findPriceByFilter(@Parameter(example = "yyyy-MM-ddTHH:mm:ss") @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                 LocalDateTime date,
                                                 @RequestParam Long productId,
                                                 @RequestParam Long brandId) {
        return ResponseEntity.ok(priceMapper.toPriceOutputDto(priceService.getPrice(date, productId, brandId)));
    }

}
