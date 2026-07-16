package br.com.joaodddev.orderservice.domain.event;

import java.time.Instant;

public interface DomainEvent {

    Instant occurredOn();

}