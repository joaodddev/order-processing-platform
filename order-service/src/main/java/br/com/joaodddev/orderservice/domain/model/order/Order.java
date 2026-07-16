package br.com.joaodddev.orderservice.domain.model.order;

import br.com.joaodddev.orderservice.domain.event.OrderCreatedEvent;
import br.com.joaodddev.orderservice.domain.model.aggregate.AggregateRoot;
import br.com.joaodddev.orderservice.domain.model.shared.Money;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order extends AggregateRoot<OrderId> {

    private final OrderId id;

    private final List<OrderItem> items = new ArrayList<>();

    private OrderStatus status;

    private Money total;

    private Order(OrderId id) {

        this.id = id;
        this.status = OrderStatus.CREATED;
        this.total = Money.zero();

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

    public void addItem(OrderItem item) {

        if (status != OrderStatus.CREATED) {
            throw new IllegalStateException(
                    "Cannot modify an order that is not in CREATED status"
            );
        }

        items.add(item);

        recalculateTotal();
    }

    private void recalculateTotal() {

        Money total = Money.zero();

        for (OrderItem item : items) {
            total = total.add(item.subtotal());
        }

        this.total = total;
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public Money getTotal() {
        return total;
    }

    public OrderStatus getStatus() {
        return status;
    }

    @Override
    public OrderId getId() {
        return id;
    }
}