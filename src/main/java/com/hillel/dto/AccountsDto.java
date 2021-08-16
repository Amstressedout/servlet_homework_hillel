package com.hillel.dto;

import lombok.Data;

@Data
public class AccountsDto {
    private int id;
    private int clientId;
    private String number;
    private double value;
}
