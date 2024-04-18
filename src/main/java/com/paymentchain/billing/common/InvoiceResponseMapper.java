/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.paymentchain.billing.common;

import com.paymentchain.billing.dto.InvocieResponseDTO;
import com.paymentchain.billing.entities.Invoice;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapping;

import org.mapstruct.Mappings;

/**
 *
 * @author SantiagoSRP
 */
public interface InvoiceResponseMapper {

    @Mappings({
        @Mapping(source = "customerId", target = "customerId"),
        @Mapping(source = "id", target = "invoiceId")
    })
    InvocieResponseDTO InvoiceRequestToInvoice(Invoice source);

    List<InvocieResponseDTO> InvoiceRequestListToInvoiceList(List<Invoice> source);

    @InheritInverseConfiguration
    Invoice InvoiceToInvoiceRequest(InvocieResponseDTO source);

    @InheritInverseConfiguration
    List<Invoice> InvoiceListToInvoiceRequestList(List<InvocieResponseDTO> source);
}
