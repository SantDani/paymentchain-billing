/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paymentchain.billing.controller;


import com.paymentchain.billing.common.InvoiceRequestMapper;
import com.paymentchain.billing.common.InvoiceResponseMapper;
import com.paymentchain.billing.dto.InvocieRequestDTO;
import com.paymentchain.billing.dto.InvocieResponseDTO;
import com.paymentchain.billing.entities.Invoice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.paymentchain.billing.respository.InvoiceRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


import java.util.Optional;

/**
 *
 * @author SantiagoSRP
 */
@Tag(name = "Billing API", description = "This APi serve all functionality for management Invoices")
@RestController
@RequestMapping("/billing")
public class InvoiceRestController {
    
    @Autowired
    InvoiceRepository billingRepository;    
    
    
    @Autowired
    InvoiceRequestMapper invoiceRequestMapper; 
    
    @Autowired
    InvoiceResponseMapper invoiceResponseMapper; 
    
    @Operation(description = "Return all invoices bundled into Response", summary ="Return 204 if no data found")
    @ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Exito"),
    @ApiResponse(responseCode = "500", description = "Internal error")})
    @GetMapping()
    public List<InvocieResponseDTO> list() {
       List<Invoice> invoices = billingRepository.findAll();
       return invoiceResponseMapper.InvoiceListToInvoiceResposeList(invoices);
    } 
    
    @GetMapping("/{id}")
    public InvocieResponseDTO get(@PathVariable String id) {
        Optional<Invoice> foundInvoice = billingRepository.findById(Long.valueOf(id));
        InvocieResponseDTO invoiceResponse =invoiceResponseMapper.InvoiceToInvoiceRespose(foundInvoice.get());
        return invoiceResponse;
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody InvocieRequestDTO input) {
       Invoice save = null; 
        Optional<Invoice> findById = billingRepository.findById(Long.valueOf(id));
        Invoice get = findById.get();
        if(get != null){             
            get.setAmount(input.getAmount());
            get.setDetail(input.getDetail());
            get.setCustomerId(input.getCustomerId());
            get.setNumber(input.getNumber());
            
            save = billingRepository.save(get);
        }
        
        InvocieResponseDTO invocieResponseDTO= invoiceResponseMapper.InvoiceToInvoiceRespose(save);
        
        return ResponseEntity.ok(invocieResponseDTO);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody InvocieRequestDTO input) { 
        Invoice invoiceRequest = invoiceRequestMapper.InvoiceRequestToInvoice(input);
        Invoice save = billingRepository.save(invoiceRequest);
        
        InvocieResponseDTO invoiceResponse= invoiceResponseMapper.InvoiceToInvoiceRespose(save);
        
        return ResponseEntity.ok(invoiceResponse);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
          Invoice save = null; 
        Optional<Invoice> findById = billingRepository.findById(Long.valueOf(id));
        Invoice get = findById.get();
        if(get != null){               
                  billingRepository.delete(get);  
        }
        return ResponseEntity.ok().build();
    }
}
