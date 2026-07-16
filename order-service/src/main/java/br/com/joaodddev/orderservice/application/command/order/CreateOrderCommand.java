package br.com.joaodddev.orderservice.application.command.order;

import java.util.List;

public record CreateOrderCommand(
        List<OrderItemCommand> items
) {
}