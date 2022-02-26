package com.sbrf.reboot.dto;

import lombok.*;


import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Response implements Serializable {
    private String statusCode;
}