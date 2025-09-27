package br.com.gabriel.account.record;

import java.math.BigDecimal;

public record AccountInformation(String accountId, String accountType, BigDecimal balance) {
}
