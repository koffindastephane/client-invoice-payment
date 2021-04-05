package com.stephane.invoiceservice.service;

import com.stephane.invoiceservice.dto.InvoiceDto;
import com.stephane.invoiceservice.entity.Invoice;

import java.util.List;

public interface InvoiceService {

    public Invoice createInvoice(Invoice invoice);
    public List<Invoice> getAllInvoiceDtos();
    public InvoiceDto getInvoiceDtoById(Long id);

}
