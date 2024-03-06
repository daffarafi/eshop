package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;
import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class Payment {
    String id;
    String method;
    String status;
    Order order;
    Map<String, String> paymentData;

    public Payment(String id, String method, Order order, Map<String, String> paymentData) {
        this.id = id;
        this.order = order;
        this.paymentData = paymentData;

        if (!PaymentMethod.contains(method)) {
            throw new IllegalArgumentException("Invalid payment method.");
        }

        this.method = method;

        if (method.equals(PaymentMethod.VOUCHER.getValue())) {
            String voucherCode = paymentData.get("voucherCode");
            if (voucherCode == null || voucherCode.isEmpty()) {
                this.status = PaymentStatus.REJECTED.getValue();
                this.order.setStatus(OrderStatus.FAILED.getValue());
                return;
            }
            int digitCount = 0;
            for (int i = 0; i < voucherCode.length(); i++) {
                if (Character.isDigit(voucherCode.charAt(i))) {
                    digitCount++;
                }
                if (digitCount == 8) break;
            }
            if (voucherCode.length() < 16) {
                this.status = PaymentStatus.REJECTED.getValue();
                this.order.setStatus(OrderStatus.FAILED.getValue());
            } else if (!voucherCode.startsWith("ESHOP")) {
                this.status = PaymentStatus.REJECTED.getValue();
                this.order.setStatus(OrderStatus.FAILED.getValue());
            } else if (digitCount != 8) {
                this.status = PaymentStatus.REJECTED.getValue();
                this.order.setStatus(OrderStatus.FAILED.getValue());
            } else {
                this.status = PaymentStatus.SUCCESS.getValue();
                this.order.setStatus(OrderStatus.SUCCESS.getValue());
            }
        } else {
            if (paymentData.get("address") == null || paymentData.get("address").isEmpty() ||
                    paymentData.get("deliveryFee") == null || paymentData.get("deliveryFee").isEmpty()) {
                this.status = PaymentStatus.REJECTED.getValue();
                this.order.setStatus(OrderStatus.FAILED.getValue());
            } else {
                this.status = PaymentStatus.SUCCESS.getValue();
                this.order.setStatus(OrderStatus.SUCCESS.getValue());
            }
        }
    }

    public void setStatus(String status) {
        if (PaymentStatus.contains(status)) {
            this.status = status;
            if (status.equals(PaymentStatus.SUCCESS.getValue())) {
                this.order.setStatus(OrderStatus.SUCCESS.getValue());
            } else {
                this.order.setStatus(OrderStatus.FAILED.getValue());
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
}
