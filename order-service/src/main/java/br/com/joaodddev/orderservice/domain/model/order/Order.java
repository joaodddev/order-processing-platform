package br.com.joaodddev.orderservice.domain.model.order;

import br.com.joaodddev.orderservice.domain.event.OrderCreatedEvent;
import br.com.joaodddev.orderservice.domain.model.aggregate.AggregateRoot;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Order extends AggregateRoot<OrderId> {

    private final OrderId id;

    private final List<OrderItem> items = new ArrayList<>();

    private OrderStatus status;

    private Money total;

    private Order(OrderId id) {

        this.id = id;
        this.status = OrderStatus.CREATED;

        registerEvent(
                new OrderCreatedEvent(
                        id,
                        Instant.now()
                )
        );
    }

    public static Order create() {
        return new Order(OrderId.newId());
    }

    @Override
    public OrderId getId() {
        return id;
    }

}