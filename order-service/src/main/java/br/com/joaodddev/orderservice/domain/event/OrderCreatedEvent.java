package br.com.joaodddev.orderservice.domain.event;

import br.com.joaodddev.orderservice.domain.model.order.OrderId;

import java.time.Instant;

public record OrderCreatedEvent(

        OrderId orderId,
        Instant occurredOn

) implements DomainEvent {
}