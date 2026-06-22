package franchise_api.demo.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateNameRequest(

        @NotBlank(message = "El nombre es obligatorio")
        String name

) {
}