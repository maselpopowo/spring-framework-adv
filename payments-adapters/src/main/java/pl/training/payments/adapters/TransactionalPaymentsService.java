package pl.training.payments.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.training.payments.ports.input.GetPaymentUseCase;
import pl.training.payments.ports.input.ProcessPaymentUseCase;
import pl.training.payments.ports.model.*;

@Primary
@Transactional
@Component
@RequiredArgsConstructor
public class TransactionalPaymentsService implements ProcessPaymentUseCase, GetPaymentUseCase {

    private final ProcessPaymentUseCase processPaymentUseCase;
    private final GetPaymentUseCase getPaymentUseCase;

    @Override
    public PaymentPort getById(PaymentIdPort paymentIdPort) {
        return getPaymentUseCase.getById(paymentIdPort);
    }

    @Override
    public ResultPagePort<PaymentPort> getByStatus(PaymentStatusPort paymentStatusPort, PagePort pagePort) {
        return getPaymentUseCase.getByStatus(paymentStatusPort, pagePort);
    }

    @Override
    public PaymentPort process(PaymentRequestPort paymentRequestPort) {
        return processPaymentUseCase.process(paymentRequestPort);
    }

}