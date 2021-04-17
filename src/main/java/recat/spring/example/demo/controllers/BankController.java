package recat.spring.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import recat.spring.example.demo.domain.dto.request.BankRequestDto;
import recat.spring.example.demo.domain.dto.response.BankResponseDto;
import recat.spring.example.demo.domain.entity.Bank;
import recat.spring.example.demo.service.interfaces.BankService;
import recat.spring.example.demo.service.mappers.BankMapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/banks")
public class BankController {
    private BankService bankService;
    private BankMapper bankMapper;

    @Autowired
    public BankController(BankService bankService,
                          BankMapper bankMapper) {
        this.bankService = bankService;
        this.bankMapper = bankMapper;
    }

    @GetMapping("/{id}")
    public BankResponseDto getBankById(@PathVariable Long id) {
        return bankMapper.mapBankToDto(bankService.getBankById(id));
    }

    @PostMapping
    public BankResponseDto saveBank(@RequestBody BankRequestDto bankRequestDto){
        Bank bank = bankMapper.mapDtoToBank(bankRequestDto);
        return bankMapper.mapBankToDto(bankService.saveBank(bank));
    }

    @GetMapping
    public List<BankResponseDto> getAllBanks() {
        return bankService.getAllBanks().stream()
                .map(bank -> bankMapper.mapBankToDto(bank))
                .collect(Collectors.toList());
    }
}
