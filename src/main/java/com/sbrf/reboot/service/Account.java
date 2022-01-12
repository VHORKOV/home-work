package com.sbrf.reboot.service;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Builder;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class Account {
    private long clientId;
    private Long accountNumber;
    private LocalDate createDate;
    private BigDecimal balance;

}


