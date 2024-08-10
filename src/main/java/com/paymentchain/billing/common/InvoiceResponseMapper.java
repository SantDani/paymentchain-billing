/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.paymentchain.billing.common;

import com.paymentchain.billing.dto.InvoiceResponseDTO;
import com.paymentchain.billing.entities.Invoice;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.mapstruct.Mappings;

/**
 *
 * @author SantiagoSRP
 */
@Mapper(componentModel ="spring")
public interface InvoiceResponseMapper {

    @Mappings({
        @Mapping(source = "customerId", target = "customerId"),
        @Mapping(source = "id", target = "invoiceId")
    })
    InvoiceResponseDTO InvoiceToInvoiceRespose(Invoice source);

    List<InvoiceResponseDTO> InvoiceListToInvoiceResposeList(List<Invoice> source);

    @InheritInverseConfiguration
    Invoice InvoiceResponseToInvoice(InvoiceResponseDTO source);

    @InheritInverseConfiguration
    List<Invoice> InvoiceResponseToInvoiceList(List<InvoiceResponseDTO> source);
}
