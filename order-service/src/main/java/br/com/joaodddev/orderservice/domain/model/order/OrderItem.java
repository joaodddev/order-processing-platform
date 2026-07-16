package br.com.joaodddev.orderservice.domain.model.order;

public record OrderItem(

        String productId,
        Integer quantity,
        Money unitPrice

) {

    public OrderItem {

        if (productId == null || productId.isBlank()) {
            throw new IllegalArgumentException("ProductId cannot be null");
        }

        if (quantity == null || quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        if (unitPrice == null) {
            throw new IllegalArgumentException("Unit price cannot be null");
        }
    }

    public Money subtotal() {
        return unitPrice.multiply(quantity);
    }
}