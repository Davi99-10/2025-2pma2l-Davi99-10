package br.com.mariojp.solid.lspaccounts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankServiceTest {

    private BankService bankService;
    private CheckingAccount checking;
    private SavingsAccount savings;

    @BeforeEach
    void setUp() {
        bankService = new BankService();
        checking = new CheckingAccount();
        savings = new SavingsAccount();
    }

    @Test
    void testCheckingAccountWithdrawalSucceeds() {
        checking.deposit(100.0);
        bankService.processWithdrawal(checking, 30.0);
        assertEquals(70.0, checking.getBalance());
    }

    @Test
    void testSavingsAccountWithdrawalIsIgnoredAndDoesNotThrowException() {
        savings.deposit(100.0);

        assertDoesNotThrow(() -> {
            bankService.processWithdrawal(savings, 30.0);
        });

        assertEquals(100.0, savings.getBalance());
    }
}