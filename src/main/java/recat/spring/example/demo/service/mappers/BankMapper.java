package recat.spring.example.demo.service.mappers;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import recat.spring.example.demo.domain.dto.request.BankRequestDto;
import recat.spring.example.demo.domain.dto.response.BankResponseDto;
import recat.spring.example.demo.domain.entity.Bank;

@Component
@NoArgsConstructor

public class BankMapper {
    private UserMapper userMapper;
    private CreditCardMapper creditCardMapper;

    @Autowired
    public BankMapper(UserMapper userMapper,
                      CreditCardMapper creditCardMapper) {
        this.userMapper = userMapper;
        this.creditCardMapper = creditCardMapper;
    }

    public Bank mapDtoToBank(BankRequestDto bankRequestDto) {
        return Bank.builder()
                .companyName(bankRequestDto.getCompanyName())
                .build();
    }

    public BankResponseDto mapBankToDto(Bank bank) {
        return BankResponseDto.builder()
                .id(bank.getId())
                .companyName(bank.getCompanyName())
                .build();
    }
}
