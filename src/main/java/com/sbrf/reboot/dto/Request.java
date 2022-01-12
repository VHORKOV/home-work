package com.sbrf.reboot.dto;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Request implements Serializable {
    private String atmNumber;
}