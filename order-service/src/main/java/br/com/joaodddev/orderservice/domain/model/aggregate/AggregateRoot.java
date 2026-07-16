package br.com.joaodddev.orderservice.domain.model.aggregate;

import br.com.joaodddev.orderservice.domain.event.DomainEvent;
import br.com.joaodddev.orderservice.domain.model.identifier.Identifier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AggregateRoot<ID extends Identifier<?>> {

    private final List<DomainEvent> domainEvents = new ArrayList<>();

    public abstract ID getId();

    protected void registerEvent(DomainEvent event) {
        domainEvents.add(event);
    }

    public List<DomainEvent> domainEvents() {
        return Collections.unmodifiableList(domainEvents);
    }

    public void clearEvents() {
        domainEvents.clear();
    }
}