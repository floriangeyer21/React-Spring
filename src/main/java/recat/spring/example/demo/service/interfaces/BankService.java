package recat.spring.example.demo.service.interfaces;

import recat.spring.example.demo.domain.entity.Bank;

import java.util.List;

public interface BankService {

    Bank saveBank(Bank bank);

    Bank getBankById(Long id);

    List<Bank> getAllBanks();
}
