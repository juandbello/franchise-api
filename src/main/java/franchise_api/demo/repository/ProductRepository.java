package franchise_api.demo.repository;

import franchise_api.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import franchise_api.demo.dto.TopStockProductResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("""
                SELECT new franchise_api.demo.dto.TopStockProductResponse(
                    b.name,
                    p.name,
                    MAX(p.stock)
                )
                FROM Product p
                JOIN p.branch b
                JOIN b.franchise f
                WHERE f.id = :franchiseId
                GROUP BY b.id, b.name, p.id, p.name, p.stock
                HAVING p.stock = (
                    SELECT MAX(p2.stock)
                    FROM Product p2
                    WHERE p2.branch.id = b.id
                )
            """)
    List<TopStockProductResponse> findTopProductsByFranchise(
            @Param("franchiseId") Long franchiseId);
}