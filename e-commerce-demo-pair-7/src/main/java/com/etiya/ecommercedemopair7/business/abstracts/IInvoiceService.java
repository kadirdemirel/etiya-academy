package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.request.invoices.AddInvoiceRequest;
import com.etiya.ecommercedemopair7.business.response.invoices.AddInvoiceResponse;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;

public interface IInvoiceService {
    DataResult<AddInvoiceResponse> add(AddInvoiceRequest addInvoiceRequest);
}
