package br.com.joaodddev.orderservice.application.usecase.order;

import br.com.joaodddev.orderservice.application.command.CreateOrderCommand;
import br.com.joaodddev.orderservice.application.port.out.OrderRepository;
import br.com.joaodddev.orderservice.application.usecase.CreateOrderUseCase;
import br.com.joaodddev.orderservice.domain.model.order.Order;
import org.springframework.stereotype.Service;

@Service
public class CreateOrderUseCaseImpl implements CreateOrderUseCase {

    private final OrderRepository repository;

    public CreateOrderUseCaseImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Order execute(CreateOrderCommand command) {

        Order order = Order.create();

        return repository.save(order);
    }
}