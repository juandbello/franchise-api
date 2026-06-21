package franchise_api.demo.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateFranchiseRequest(

        @NotBlank(message = "El nombre es obligatorio")
        String name

) {
}