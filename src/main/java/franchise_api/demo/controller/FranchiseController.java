package franchise_api.demo.controller;

import franchise_api.demo.dto.CreateFranchiseRequest;
import franchise_api.demo.dto.TopStockProductResponse;
import franchise_api.demo.dto.UpdateNameRequest;
import franchise_api.demo.entity.Franchise;
import franchise_api.demo.service.FranchiseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/franchises")
@RequiredArgsConstructor
public class FranchiseController {

    private final FranchiseService franchiseService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Franchise create(@Valid @RequestBody CreateFranchiseRequest request) {

        return franchiseService.create(request);
    }

    @GetMapping("/{franchiseId}/top-stock")
    public List<TopStockProductResponse> getTopProducts(
            @PathVariable Long franchiseId) {

        return franchiseService.getTopProducts(franchiseId);
    }

    @PatchMapping("/{franchiseId}")
    public Franchise updateName(
            @PathVariable Long franchiseId,
            @Valid @RequestBody UpdateNameRequest request) {

        return franchiseService.updateName(franchiseId, request.name());
    }
}