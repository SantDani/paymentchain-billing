/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.paymentchain.billing.common;

import com.paymentchain.billing.dto.InvoiceRequestDTO;
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
public interface InvoiceRequestMapper {

    @Mappings({
        @Mapping(source = "customerId", target = "customerId")})
    Invoice InvoiceRequestToInvoice(InvoiceRequestDTO source);

    List<Invoice> InvoiceRequestListToInvoiceList(List<InvoiceRequestDTO> source);

    @InheritInverseConfiguration
    InvoiceRequestDTO InvoiceToInvoiceRequest(Invoice source);

    @InheritInverseConfiguration
    List<InvoiceRequestDTO> InvoiceListToInvoiceRequestList(List<Invoice> source);
}
