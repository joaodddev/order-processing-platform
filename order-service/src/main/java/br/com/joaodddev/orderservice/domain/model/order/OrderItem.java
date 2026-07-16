package br.com.joaodddev.orderservice.domain.model.order;

public record OrderItem(

        String productId,
        Integer quantity,
        Money unitPrice

) {
}