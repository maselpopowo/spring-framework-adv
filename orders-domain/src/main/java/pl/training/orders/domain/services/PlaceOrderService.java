package pl.training.orders.domain.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import pl.training.orders.ports.input.PlaceOrderUseCase;
import pl.training.orders.ports.model.OrderPort;
import pl.training.orders.ports.output.PaymentService;

import static java.util.Collections.emptyMap;
import static pl.training.orders.ports.output.PaymentService.DEFAULT_PAYMENT_CURRENCY;

@Log
@RequiredArgsConstructor
public class PlaceOrderService implements PlaceOrderUseCase {

    private final PaymentService paymentService;

    @Override
    public void place(OrderPort orderPort) {
        var totalValue = orderPort.getTotalValue();
        log.info("Processing new Order with value %s".formatted(totalValue));
        paymentService.pay(totalValue, DEFAULT_PAYMENT_CURRENCY, emptyMap())
                .ifPresent(paymentPort -> log.info("Payment processed " + paymentPort));
    }

}