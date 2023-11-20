package minsa.test.store.sales.infrastructure.db.repository;

import minsa.test.store.sales.infrastructure.db.entity.PriceJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceJpaRepository extends JpaRepository<PriceJpa, Long> {
}
