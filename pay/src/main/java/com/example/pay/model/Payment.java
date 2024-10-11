package com.example.pay.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable{

    private Long id;
    private Long idUser;
    private Long idProdutc;
    private String cardNumber;
}
