package minsa.test.store.sales.infrastructure.db.repository;

import minsa.test.store.sales.infrastructure.db.entity.ProductJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductJpa, Long> {
}
