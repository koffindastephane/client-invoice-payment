package com.stephane.invoiceservice.controller;

import com.stephane.invoiceservice.dto.InvoiceDto;
import com.stephane.invoiceservice.entity.Invoice;
import com.stephane.invoiceservice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @PostMapping("/")
    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
        return new ResponseEntity<>(invoiceService.createInvoice(invoice), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Invoice>> getAllInvoices() {
        return new ResponseEntity<>(invoiceService.getAllInvoiceDtos(), HttpStatus.OK);
    }

    @GetMapping("/{invoiceId}")
    public ResponseEntity<InvoiceDto> getInvoiceById(@PathVariable Long invoiceId) {
        return new ResponseEntity<>(invoiceService.getInvoiceDtoById(invoiceId), HttpStatus.OK);
    }

}
