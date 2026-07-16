package br.com.joaodddev.orderservice.domain.model.order;

import br.com.joaodddev.orderservice.domain.model.identifier.Identifier;
import java.util.UUID;

public record OrderId(UUID value) implements Identifier<UUID> {

    public static OrderId newId() {
        return new OrderId(UUID.randomUUID());
    }

}