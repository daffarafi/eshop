package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;
import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {
    private Order order;

    @BeforeEach
    void setup() {
        Product product1 = new Product();
        List<Product> products = new ArrayList<>();
        products.add(product1);
        order = new Order("1238d7d2d-20s9-d8ef-19d8s7d9eh12", products, 128560000L, "Safira Sudrajat");
    }

    @Test
    void testCreatePaymentWithVoucherSuccess() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
        Payment payment = new Payment("d8s7hw71-9ds7-919d-x9c8s8dj9d8", PaymentMethod.VOUCHER.getValue(), order, paymentData);
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
        assertEquals(OrderStatus.SUCCESS.getValue(), order.getStatus());
    }

    @Test
    void testCreatePaymentWithInvalidMethod() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("voucherCode", "ESHOP1234ABC5678");

        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("d8s7hw71-9ds7-919d-x9c8s8dj9d8", "KUCING", order, paymentData);
        });
    }

    @Test
    void testCreatePaymentVoucherWithInvalidPaymentData() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("notVoucherCode", "ESHOP1234ABC5678");
        Payment payment = new Payment("d8s7hw71-9ds7-919d-x9c8s8dj9d8", PaymentMethod.VOUCHER.getValue(), order, paymentData);

        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
        assertEquals(OrderStatus.FAILED.getValue(), order.getStatus());

    }

    @Test
    void testCreatePaymentWith13CharacterVoucherCode() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("voucherCode", "ESHOP12345678");
        Payment payment = new Payment("d8s7hw71-9ds7-919d-x9c8s8dj9d8", PaymentMethod.VOUCHER.getValue(), order, paymentData);

        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
        assertEquals(OrderStatus.FAILED.getValue(), order.getStatus());

    }

    @Test
    void testCreatePaymentWithVoucherWithoutEshop() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("voucherCode", "NOTESHOP12345678");

        Payment payment = new Payment("d8s7hw71-9ds7-919d-x9c8s8dj9d8", PaymentMethod.VOUCHER.getValue(), order, paymentData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
        assertEquals(OrderStatus.FAILED.getValue(), order.getStatus());

    }
    @Test
    void testCreatePaymentWithNumberLessThanEightOnVoucherCode() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("voucherCode", "ESHOP1234567ADFER");
        Payment payment = new Payment("d8s7hw71-9ds7-919d-x9c8s8dj9d8", PaymentMethod.VOUCHER.getValue(), order, paymentData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
        assertEquals(OrderStatus.FAILED.getValue(), order.getStatus());
    }

    @Test
    void testCreatePaymentWithCodSuccess() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("address", "Depok Street");
        paymentData.put("deliveryFee", "10000");
        Payment payment = new Payment("d8s7hw71-9ds7-919d-x9c8s8dj9d8", PaymentMethod.COD.getValue(), order, paymentData);
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
        assertEquals(OrderStatus.SUCCESS.getValue(), order.getStatus());
    }

    @Test
    void testCreatePaymentCodWithoutAddress() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("deliveryFee", "10000");
        Payment payment = new Payment("d8s7hw71-9ds7-919d-x9c8s8dj9d8", PaymentMethod.COD.getValue(), order, paymentData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
        assertEquals(OrderStatus.FAILED.getValue(), order.getStatus());
    }

    @Test
    void testCreatePaymentCodWithoutDeliveryFee() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("address", "Depok Street");
        Payment payment = new Payment("d8s7hw71-9ds7-919d-x9c8s8dj9d8", PaymentMethod.COD.getValue(), order, paymentData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
        assertEquals(OrderStatus.FAILED.getValue(), order.getStatus());
    }

    @Test
    void testSetStatusToInvalidStatus() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
        Payment payment = new Payment("d8s7hw71-9ds7-919d-x9c8s8dj9d8", PaymentMethod.VOUCHER.getValue(), order, paymentData);
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
        assertEquals(OrderStatus.SUCCESS.getValue(), order.getStatus());

        payment.setStatus(PaymentStatus.REJECTED.getValue());
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
        assertEquals(OrderStatus.FAILED.getValue(), order.getStatus());
    }
    @Test
    void testSetStatusToValidStatus() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("voucherCode", "NOTVALID");
        Payment payment = new Payment("d8s7hw71-9ds7-919d-x9c8s8dj9d8", PaymentMethod.VOUCHER.getValue(), order, paymentData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
        assertEquals(OrderStatus.FAILED.getValue(), order.getStatus());

        payment.setStatus(PaymentStatus.SUCCESS.getValue());
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
        assertEquals(OrderStatus.SUCCESS.getValue(), order.getStatus());
    }
}
