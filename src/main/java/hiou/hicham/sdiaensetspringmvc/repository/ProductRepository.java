package hiou.hicham.sdiaensetspringmvc.repository;

import hiou.hicham.sdiaensetspringmvc.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}