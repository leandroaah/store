package minsa.test.store.sales.infrastructure.db.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import minsa.test.store.sales.application.mapper.PriceMapper;
import minsa.test.store.sales.domain.entity.Price;
import minsa.test.store.sales.domain.repository.PriceRepository;
import minsa.test.store.sales.infrastructure.db.entity.PriceJpa;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class PriceRepositoryImpl implements PriceRepository {

    private final PriceMapper priceMapper;

    @PersistenceContext
    private EntityManager entityManager;

    private static final String PRIORITY = "priority";

    @Override
    public Price getPrice(LocalDateTime date, Long productId, Long brandId) {
        return priceMapper.toEntity(findPriceByFilters(date, productId, brandId));
    }

    private PriceJpa findPriceByFilters(LocalDateTime date, Long productId, Long brandId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PriceJpa> criteriaQuery = criteriaBuilder.createQuery(PriceJpa.class);
        Root<PriceJpa> root = criteriaQuery.from(PriceJpa.class);
        List<Predicate> predicates = buildPredicates(criteriaBuilder, root, date, productId, brandId);
        criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])))
                .orderBy(criteriaBuilder.desc(root.get(PRIORITY)));
        return entityManager.createQuery(criteriaQuery).getResultStream().findFirst().orElse(new PriceJpa());
    }

    private List<Predicate> buildPredicates(CriteriaBuilder criteriaBuilder, Root<PriceJpa> root, LocalDateTime date,
                                            Long productId, Long brandId) {
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("startDate"), date));
        predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("endDate"), date));
        predicates.add(criteriaBuilder.equal(root.get("productId"), productId));
        predicates.add(criteriaBuilder.equal(root.get("brandId"), brandId));
        return predicates;
    }
}
