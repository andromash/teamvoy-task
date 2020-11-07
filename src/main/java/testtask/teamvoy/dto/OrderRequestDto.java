package testtask.teamvoy.dto;

public class OrderRequestDto {
    private Long price;
    private Integer quantity;
    private Long itemId;

    public OrderRequestDto() {
    }

    public OrderRequestDto(Long price, Integer quantity, Long itemId) {
        this.price = price;
        this.quantity = quantity;
        this.itemId = itemId;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
}
