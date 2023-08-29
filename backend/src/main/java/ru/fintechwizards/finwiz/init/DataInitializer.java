package ru.fintechwizards.finwiz.init;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.fintechwizards.finwiz.models.Account;
import ru.fintechwizards.finwiz.models.Bank;
import ru.fintechwizards.finwiz.models.Transaction;
import ru.fintechwizards.finwiz.models.User;
import ru.fintechwizards.finwiz.repositories.AccountRepository;
import ru.fintechwizards.finwiz.repositories.BankRepository;
import ru.fintechwizards.finwiz.repositories.TransactionRepository;
import ru.fintechwizards.finwiz.repositories.UserJpaRepository;

import java.math.BigDecimal;

@Component
public class DataInitializer implements ApplicationRunner {
    private final AccountRepository accRepository;
    private final BankRepository bankRepository;
    private final TransactionRepository transRepository;
    private final UserJpaRepository userRepository;
    public DataInitializer(AccountRepository accRepository, BankRepository bankRepository,
                           TransactionRepository transRepository, UserJpaRepository userRepository) {
        this.accRepository = accRepository;
        this.bankRepository = bankRepository;
        this.transRepository = transRepository;
        this.userRepository = userRepository;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user1 = new User();
        user1.setUsername("user1");
        user1.setPassword("1");
        User user2 = new User();
        user2.setUsername("user2");
        user2.setPassword("2");
        userRepository.save(user1);
        userRepository.save(user2);
        Bank bank1 = new Bank();
        bank1.setCountry("Russian");
        bank1.setName("SberBank");
        Bank bank2 = new Bank();
        bank2.setName("ChinaBank");
        bank2.setCountry("China");
        bankRepository.save(bank1);
        bankRepository.save(bank2);
        Account acc1 = new Account();
        acc1.setBank(bankRepository.findById(1L).get());
        acc1.setUser(userRepository.findById(1L).get());
        acc1.setBalance(BigDecimal.valueOf(10000));
        acc1.setCurrency("RUB");
        Account acc2 = new Account();
        acc2.setBank(bankRepository.findById(2L).get());
        acc2.setUser(userRepository.findById(2L).get());
        acc2.setBalance(BigDecimal.valueOf(10000));
        acc2.setCurrency("CNY");
        accRepository.save(acc1);
        accRepository.save(acc2);
        Transaction transaction1 = new Transaction();
        transaction1.setSenderAccount(accRepository.findById(1L).get());
        transaction1.setReceiverAccount(accRepository.findById(2L).get());
        transaction1.setAmount(BigDecimal.valueOf(0));
        transaction1.setCurrencyStart("RUB");
        transaction1.setCurrencyFinal("CNY");
        transRepository.save(transaction1);
    }
}
