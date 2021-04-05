package com.stephane.invoiceservice.service;

import com.stephane.invoiceservice.dto.Client;
import com.stephane.invoiceservice.dto.InvoiceDto;
import com.stephane.invoiceservice.entity.Invoice;
import com.stephane.invoiceservice.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public Invoice createInvoice(Invoice invoice) {
        invoice.setDates(LocalDate.now());
        return invoiceRepository.save(invoice);
    }

    @Override
    public List<Invoice> getAllInvoiceDtos() {
        return invoiceRepository.findAll();
    }

    @Override
    public InvoiceDto getInvoiceDtoById(Long invoiceId) {
        InvoiceDto invoiceDto = new InvoiceDto();
        Invoice invoice;
        Client client;
        Optional<Invoice> invoiceOptional = invoiceRepository.findById(invoiceId);
        if(invoiceOptional.isPresent()) {

            invoice = invoiceOptional.get();
            client = restTemplate.getForObject(String.format("http://localhost:9001/clients/%d", invoice.getClientId()), Client.class);

            invoiceDto.setInvoice(invoice);
            invoiceDto.setClient(client);
            return invoiceDto;
        }
        throw new RuntimeException();
    }
}
