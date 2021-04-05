package com.stephane.invoiceservice.dto;

import com.stephane.invoiceservice.entity.Invoice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {

    private Invoice invoice;
    private Client client;

}
