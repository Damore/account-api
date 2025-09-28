package br.com.gabriel.account.circuitbreaker.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;
import org.springframework.stereotype.Service;
import br.com.gabriel.account.record.AccountInformation;

@Service
public class AccountService {

    public AccountInformation getAccountInformation(UUID userId) {
        final var random = new Random(userId.hashCode()); // Seed the random generator with the userId hash code for consistent results per userId
        final double value = random.nextDouble();
        if (value <= 0.5) {
            throw new RuntimeException("Simulated service failure");
        }
        final var accountId = String.valueOf(10000 + random.nextInt(90000)); // this is to simulate an accountId search based on the userId
        return new AccountInformation(accountId, "CHECKING_ACCOUNT",
                BigDecimal.valueOf(-1_000_000 + (2_000_000 * random.nextDouble())).setScale(2, RoundingMode.DOWN));
    }
}
