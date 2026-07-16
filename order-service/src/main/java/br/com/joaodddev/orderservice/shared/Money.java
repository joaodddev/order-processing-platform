package br.com.joaodddev.orderservice.domain.model.shared;

import br.com.joaodddev.orderservice.domain.model.valueobject.ValueObject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public record Money(BigDecimal value) implements ValueObject {

    private static final int SCALE = 2;

    public Money {

        Objects.requireNonNull(value, "Money cannot be null");

        if (value.signum() < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }

        value = value.setScale(SCALE, RoundingMode.HALF_EVEN);
    }

    public static Money zero() {
        return new Money(BigDecimal.ZERO);
    }

    public Money add(Money other) {
        return new Money(this.value.add(other.value));
    }

    public Money subtract(Money other) {

        BigDecimal result = this.value.subtract(other.value);

        if (result.signum() < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }

        return new Money(result);
    }

    public Money multiply(int quantity) {

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        return new Money(
                this.value.multiply(BigDecimal.valueOf(quantity))
        );
    }

    public boolean isZero() {
        return value.compareTo(BigDecimal.ZERO) == 0;
    }

    public boolean isGreaterThan(Money other) {
        return value.compareTo(other.value) > 0;
    }

    public boolean isLessThan(Money other) {
        return value.compareTo(other.value) < 0;
    }

    public boolean isGreaterOrEqual(Money other) {
        return value.compareTo(other.value) >= 0;
    }

    public boolean isLessOrEqual(Money other) {
        return value.compareTo(other.value) <= 0;
    }
}