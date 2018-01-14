package com.sgib.kata;

import java.time.format.DateTimeFormatter;

public interface Utils {

    long MAX_DEPOSIT_AMOUNT_ALLOWED = 1000;

    DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
}
