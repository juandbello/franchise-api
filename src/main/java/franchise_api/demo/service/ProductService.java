package franchise_api.demo.service;

import franchise_api.demo.dto.CreateProductRequest;
import franchise_api.demo.entity.Branch;
import franchise_api.demo.entity.Product;
import franchise_api.demo.repository.BranchRepository;
import franchise_api.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final BranchRepository branchRepository;

    public Product create(Long branchId, CreateProductRequest request) {

        Branch branch = branchRepository.findById(branchId)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));

        Product product = new Product();
        product.setName(request.name());
        product.setStock(request.stock());
        product.setBranch(branch);

        return productRepository.save(product);
    }

    public void delete(Long productId) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        productRepository.delete(product);
    }

    public Product updateStock(Long productId, Integer stock) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        product.setStock(stock);

        return productRepository.save(product);
    }

    public Product updateName(Long productId, String name) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        product.setName(name);

        return productRepository.save(product);
    }
}