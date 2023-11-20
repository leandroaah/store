package minsa.test.store.sales.application.mapper;

import minsa.test.store.sales.domain.entity.Price;
import minsa.test.store.sales.infrastructure.db.entity.PriceJpa;
import minsa.test.store.sales.infrastructure.rest.dto.PriceOutputDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    @Mapping(target = "price", source = "priceUnit")
    PriceOutputDto toPriceOutputDto(Price price);

    @Mapping(target = "priceUnit", source = "price")
    Price toEntity(PriceJpa priceJpa);
}
