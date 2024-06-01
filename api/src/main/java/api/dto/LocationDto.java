package api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class LocationDto {
    private long id;
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
