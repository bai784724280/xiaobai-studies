package com.aiyuns.tinkerplay.Entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;

import java.math.BigDecimal;

@Schema(name = "转账请求封装实体类")
public class TransferRequest {
    @NotEmpty
    private String fromAccountNumber;
    @NotEmpty
    private String toAccountNumber;
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 10, fraction = 2)
    private BigDecimal amount;

    public String getFromAccountNumber() {
        return fromAccountNumber;
    }

    public void setFromAccountNumber(String fromAccountNumber) {
        this.fromAccountNumber = fromAccountNumber;
    }

    public String getToAccountNumber() {
        return toAccountNumber;
    }

    public void setToAccountNumber(String toAccountNumber) {
        this.toAccountNumber = toAccountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
