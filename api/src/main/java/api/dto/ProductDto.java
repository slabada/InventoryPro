package api.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductDto {
    private long id;
    @Size(max = 64)
    @NotBlank
    private String name;
    @Size(max = 255)
    private String description;
    @DecimalMin(value = "0", inclusive = false)
    private BigDecimal price;
}
