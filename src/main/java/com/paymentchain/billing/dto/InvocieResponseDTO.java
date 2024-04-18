/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.paymentchain.billing.dto;

import io.swagger.v3.oas.annotations.media.Schema;


/**
 *
 * @author SantiagoSRP
 */
@Schema(name = "InvocieResponsetDTO", description = "Model represent a invoice on database")
public class InvocieResponseDTO {
   @Schema(name = "invoiceId", requiredMode = Schema.RequiredMode.REQUIRED,example = "2", defaultValue = "1", description = "Unique Id of customer on database")
   private long invoiceId;
   @Schema(name = "customerId", requiredMode = Schema.RequiredMode.REQUIRED,example = "2", defaultValue = "1", description = "Unique Id of customer that represent the owner of invoice")
   private long customerId;
   @Schema(name = "number", requiredMode = Schema.RequiredMode.REQUIRED ,example = "3", defaultValue = "8", description = "Number given on fisical invoice")
   private String number;
   private String detail;
   private double amount; 
    
}
