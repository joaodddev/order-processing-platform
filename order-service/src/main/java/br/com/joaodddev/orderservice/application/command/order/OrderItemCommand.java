package br.com.joaodddev.orderservice.application.command.order;

import java.math.BigDecimal;

public record OrderItemCommand(
        String productId,
        Integer quantity,
        BigDecimal unitPrice
) {
}