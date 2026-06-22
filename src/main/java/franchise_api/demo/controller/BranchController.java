package franchise_api.demo.controller;

import franchise_api.demo.dto.CreateBranchRequest;
import franchise_api.demo.dto.UpdateNameRequest;
import franchise_api.demo.entity.Branch;
import franchise_api.demo.service.BranchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/franchises/{franchiseId}/branches")
public class BranchController {

    private final BranchService branchService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Branch create(
            @PathVariable Long franchiseId,
            @Valid @RequestBody CreateBranchRequest request) {

        return branchService.create(franchiseId, request);
    }

    @PatchMapping("/{branchId}")
    public Branch updateName(
            @PathVariable Long branchId,
            @Valid @RequestBody UpdateNameRequest request) {

        return branchService.updateName(branchId, request.name());
    }
}