package com.sbrf.reboot.lesson14;

import lombok.AllArgsConstructor;
import lombok.Getter;


import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class Account {
    private BigDecimal balance;
    private LocalDate createDate;
    private Currency currency;
    }

