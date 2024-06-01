package api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryDto {
    private long id;
    private ProductDto product;
    private LocationDto location;
    private int quantity;
}
