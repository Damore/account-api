package br.com.gabriel.account.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.util.UUID;
import org.springframework.stereotype.Service;
import br.com.gabriel.account.record.AccountInformation;

@Service
public class AccountService {

    public AccountInformation getAccountInformation(UUID userId) {
        final var random = new SecureRandom();
        final double value = random.nextDouble();
        if (value <= 0.5) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return new AccountInformation(String.valueOf(10000 + random.nextInt(90000)), "CHECKING_ACCOUNT",
                BigDecimal.valueOf(-1_000_000 + (2_000_000 * random.nextDouble())).setScale(2, RoundingMode.DOWN));
    }
}
