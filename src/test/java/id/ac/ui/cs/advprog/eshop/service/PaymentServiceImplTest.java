package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PaymentServiceImplTest {
    @InjectMocks
    PaymentService paymentService;
    @Mock
    PaymentRepository paymentRepository;

    List<Payment> payments;
    Order order;
    @BeforeEach
    void setUp() {
        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        products.add(product1);

        order = new Order("dhi138cy-28d7-c9s8-1u23-s9d8c7d72837", products, 1708560000L, "Safira Sudrajat");

        Order order = new Order("dhi138cy-28d7-c9s8-1u23-s9d8c7d72837", products, 1708560000L, "Safira Sudrajat");

        payments = new ArrayList<>();
        Map<String, String> paymentData1 = new HashMap<>();
        paymentData1.put("voucherCode", "ESHOP1234567ADFER");
        Payment payment1 = new Payment("d8s7hw71-9ds7-919d-x9c8s8dj9d8", PaymentMethod.VOUCHER.getValue(), order, paymentData1);
        payments.add(payment1);

        Map<String, String> paymentData2 = new HashMap<>();
        paymentData2.put("voucherCode", "ESHOP1234567ADFER");
        Payment payment2 = new Payment("dsad1232-dsae-123d-wed123d1w3d", PaymentMethod.VOUCHER.getValue(), order, paymentData2);
        payments.add(payment2);
    }

    @Test
    void testCreatePayment() {
        Payment payment = payments.get(1);
        doReturn(payment).when(paymentRepository).save(payment);

        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("voucherCode", "ESHOP1234678ABCD");
        Payment newPayment = paymentService.addPayment(order, PaymentMethod.VOUCHER.getValue(), paymentData);
        verify(paymentRepository, times(1)).save(payment);
        Payment result = paymentService.getPayment(newPayment.getId());
        assertEquals(result.getId(), newPayment.getId());
    }

    @Test
    void testSetStatus() {
        Payment payment = payments.get(1);
        Payment newPayment = new Payment(payment.getId(), payment.getMethod(), payment.getOrder(), payment.getPaymentData());
        doReturn(payment).when(paymentRepository).findById(payment.getId());
        doReturn(newPayment).when(paymentRepository).save(any(Payment.class));

        Payment result = paymentService.setStatus(payment, PaymentStatus.SUCCESS.getValue());

        assertEquals(payment.getId(), result.getId());
        assertEquals(PaymentStatus.SUCCESS.getValue(), result.getStatus());
        verify(paymentRepository, times(1)).save(any(Payment.class));
    }

    @Test
    void testFindByIdIfIdFound() {
        Payment payment = payments.get(1);
        doReturn(payment).when(paymentRepository).findById(payment.getId());

        Payment result = paymentService.getPayment(payment.getId());
        assertEquals(payment.getId(), result.getId());
    }

    @Test
    void testFindByIdIfIdNotFound() {
        doReturn(null).when(paymentRepository).getPayment("zczc");
        assertNull(paymentService.getPayment("zczc"));
    }
}