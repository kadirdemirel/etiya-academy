package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.IInvoiceService;
import com.etiya.ecommercedemopair7.business.constants.Messages;
import com.etiya.ecommercedemopair7.business.request.invoices.AddInvoiceRequest;
import com.etiya.ecommercedemopair7.business.response.invoices.AddInvoiceResponse;
import com.etiya.ecommercedemopair7.core.utilities.mapping.IModelMapperService;
import com.etiya.ecommercedemopair7.core.utilities.messages.IMessageSourceService;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import com.etiya.ecommercedemopair7.core.utilities.results.SuccessDataResult;
import com.etiya.ecommercedemopair7.entities.concretes.Invoice;
import com.etiya.ecommercedemopair7.repository.abstracts.IInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class InvoiceManager implements IInvoiceService {
    private IInvoiceRepository invoiceRepository;
    private IModelMapperService modelMapperService;
    private IMessageSourceService messageSourceService;

    @Autowired
    InvoiceManager(IInvoiceRepository invoiceRepository, IModelMapperService modelMapperService,
                   IMessageSourceService messageSourceService) {
        this.invoiceRepository = invoiceRepository;
        this.modelMapperService = modelMapperService;
        this.messageSourceService = messageSourceService;
    }

    @Transactional
    @Override
    public DataResult<AddInvoiceResponse> add(AddInvoiceRequest addInvoiceRequest) {
        Invoice invoice = modelMapperService.forRequest().map(addInvoiceRequest, Invoice.class);
        Invoice savedInvoice = invoiceRepository.save(invoice);
        AddInvoiceResponse response = modelMapperService.forResponse().map(savedInvoice, AddInvoiceResponse.class);
        return new SuccessDataResult<>(response, messageSourceService.getMessage(Messages.Invoice.invoiceAdded));
    }
}
