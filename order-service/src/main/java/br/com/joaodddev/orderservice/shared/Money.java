package br.com.joaodddev.orderservice.domain.model.shared;

import br.com.joaodddev.orderservice.domain.model.valueobject.ValueObject;

import java.math.BigDecimal;

public record Money(BigDecimal value) implements ValueObject {

    public Money {
        if (value == null) {
            throw new IllegalArgumentException("Money cannot be null");
        }

        if (value.signum() < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
    }

}