package br.com.gabriel.account.controller;

import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.gabriel.account.record.AccountInformation;
import br.com.gabriel.account.circuitbreaker.service.AccountService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/account/{userId}")
    public ResponseEntity<AccountInformation> getAccountByUserId(@PathVariable UUID userId) {
        return ResponseEntity.ok(accountService.getAccountInformation(userId));
    }
}
