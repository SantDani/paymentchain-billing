/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.paymentchain.billing.entities;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author SantiagoSRP
 */
@Entity
@Data
public class Invoice {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
   private long id;
   private long customerId;
   private String number;
   private String detail;
   private double amount;  
}

