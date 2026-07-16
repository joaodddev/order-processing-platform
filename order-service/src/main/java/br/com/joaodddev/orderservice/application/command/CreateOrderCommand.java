package br.com.joaodddev.orderservice.application.command;

import java.util.List;

public record CreateOrderCommand(
        List<OrderItemCommand> items
) {
}