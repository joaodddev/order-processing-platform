package br.com.joaodddev.orderservice.domain.model.entity;

import br.com.joaodddev.orderservice.domain.model.identifier.Identifier;

public abstract class Entity<ID extends Identifier<?>> {

    public abstract ID getId();

}