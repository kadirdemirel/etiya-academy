package com.etiya.ecommercedemopair7.business.request.invoices;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddInvoiceRequest {
    @NotNull
    private String number;
    @NotNull
    private LocalDate createdDate;
    @Min(1)
    private int orderId;
}
