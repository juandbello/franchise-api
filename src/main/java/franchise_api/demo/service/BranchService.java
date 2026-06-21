package franchise_api.demo.service;

import franchise_api.demo.dto.CreateBranchRequest;
import franchise_api.demo.entity.Branch;
import franchise_api.demo.entity.Franchise;
import franchise_api.demo.repository.BranchRepository;
import franchise_api.demo.repository.FranchiseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BranchService {

    private final BranchRepository branchRepository;
    private final FranchiseRepository franchiseRepository;

    public Branch create(Long franchiseId, CreateBranchRequest request) {

        Franchise franchise = franchiseRepository.findById(franchiseId)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));

        Branch branch = new Branch();
        branch.setName(request.name());
        branch.setFranchise(franchise);

        return branchRepository.save(branch);
    }

    public Branch updateName(Long branchId, String name) {

        Branch branch = branchRepository.findById(branchId)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));

        branch.setName(name);

        return branchRepository.save(branch);
    }
}