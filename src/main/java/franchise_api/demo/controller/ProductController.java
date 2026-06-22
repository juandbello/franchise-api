package franchise_api.demo.controller;

import franchise_api.demo.dto.CreateProductRequest;
import franchise_api.demo.dto.UpdateNameRequest;
import franchise_api.demo.dto.UpdateStockRequest;
import franchise_api.demo.entity.Product;
import franchise_api.demo.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/branches/{branchId}/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(
            @PathVariable Long branchId,
            @Valid @RequestBody CreateProductRequest request) {

        return productService.create(branchId, request);
    }

    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable Long branchId,
            @PathVariable Long productId) {

        productService.delete(productId);
    }

    @PatchMapping("/{productId}/stock")
    public Product updateStock(
            @PathVariable Long branchId,
            @PathVariable Long productId,
            @Valid @RequestBody UpdateStockRequest request) {

        return productService.updateStock(productId, request.stock());
    }

    @PatchMapping("/{productId}")
    public Product updateName(
            @PathVariable Long branchId,
            @PathVariable Long productId,
            @Valid @RequestBody UpdateNameRequest request) {

        return productService.updateName(productId, request.name());
    }
}