package recat.spring.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import recat.spring.example.demo.domain.entity.Bank;
import recat.spring.example.demo.repository.BankRepository;
import recat.spring.example.demo.service.interfaces.BankService;

import java.util.List;

@Service
@Transactional
public class BankServiceImpl implements BankService {
    private BankRepository bankRepository;

    @Autowired
    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public Bank saveBank(Bank bank) {
        return bankRepository.save(bank);
    }

    @Override
    public Bank getBankById(Long id) {
        return bankRepository.getOne(id);
    }

    @Override
    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }
}
