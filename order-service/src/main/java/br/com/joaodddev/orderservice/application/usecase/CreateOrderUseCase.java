package br.com.joaodddev.orderservice.application.usecase;

import br.com.joaodddev.orderservice.application.command.CreateOrderCommand;
import br.com.joaodddev.orderservice.domain.model.order.Order;

public interface CreateOrderUseCase {

    Order execute(CreateOrderCommand command);

}