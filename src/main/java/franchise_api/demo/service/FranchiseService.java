package franchise_api.demo.service;

import franchise_api.demo.dto.CreateFranchiseRequest;
import franchise_api.demo.dto.TopStockProductResponse;
import franchise_api.demo.entity.Franchise;
import franchise_api.demo.repository.FranchiseRepository;
import franchise_api.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FranchiseService {

    private final FranchiseRepository franchiseRepository;
    private final ProductRepository productRepository;

    public Franchise create(CreateFranchiseRequest request) {

        Franchise franchise = new Franchise();
        franchise.setName(request.name());

        return franchiseRepository.save(franchise);
    }

    public List<TopStockProductResponse> getTopProducts(Long franchiseId) {

        franchiseRepository.findById(franchiseId)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));

        return productRepository.findTopProductsByFranchise(franchiseId);
    }

    public Franchise updateName(Long franchiseId, String name) {

        Franchise franchise = franchiseRepository.findById(franchiseId)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));

        franchise.setName(name);

        return franchiseRepository.save(franchise);
    }
}