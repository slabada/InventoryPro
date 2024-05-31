package api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationDto {
    @NotBlank
    @Size(max = 16)
    private String sector;
    @NotBlank
    @Size(max = 16)
    private String wardrobe;
    @NotBlank
    @Size(max = 16)
    private String shelf;
}
