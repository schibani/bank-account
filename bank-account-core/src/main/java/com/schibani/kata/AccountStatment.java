package com.schibani.kata;

import java.util.List;
import java.util.stream.Collectors;

public class AccountStatment {

    private  final List<String> statments;

    public AccountStatment(List<String> statments) {
        this.statments = statments;
    }

    public List<String> getStatments() {
        return statments;
    }

    @Override
    public String toString() {
        return statments.stream().collect(Collectors.joining("\n------------------------------------------\n")).toString();
    }
}
