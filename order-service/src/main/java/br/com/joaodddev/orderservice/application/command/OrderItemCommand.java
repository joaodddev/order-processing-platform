package br.com.joaodddev.orderservice.application.command;

import java.math.BigDecimal;

public record OrderItemCommand(
        String productId,
        Integer quantity,
        BigDecimal unitPrice
) {
}