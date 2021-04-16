package recat.spring.example.demo.service.mappers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import recat.spring.example.demo.domain.dto.AddressDto;
import recat.spring.example.demo.domain.dto.BankDto;
import recat.spring.example.demo.domain.dto.CreditCardDto;
import recat.spring.example.demo.domain.dto.UserDto;
import recat.spring.example.demo.domain.entity.Address;
import recat.spring.example.demo.domain.entity.Bank;
import recat.spring.example.demo.domain.entity.CreditCard;
import recat.spring.example.demo.domain.entity.User;

import java.util.List;
import java.util.stream.Collectors;

@Component
@NoArgsConstructor

public class BankMapper {
    private UserMapper userMapper;
    private AddressMapper addressMapper;
    private CreditCardMapper creditCardMapper;

    @Autowired
    public BankMapper(UserMapper userMapper,
                      AddressMapper addressMapper,
                      CreditCardMapper creditCardMapper) {
        this.userMapper = userMapper;
        this.addressMapper = addressMapper;
        this.creditCardMapper = creditCardMapper;
    }

    public Bank mapDtoToBank(BankDto bankDto) {
        List<Address> addresses = bankDto.getAddresses().stream()
                .map(address -> addressMapper.mapDtoToAddress(address))
                .collect(Collectors.toList());
        List<User> clients = bankDto.getClients().stream()
                .map(client -> userMapper.mapDtoToUser(client))
                .collect(Collectors.toList());
        List<CreditCard> creditCards = bankDto.getCreditCards().stream()
                .map(creditCard -> creditCardMapper.mapDtoToCreditCard(creditCard))
                .collect(Collectors.toList());
        return Bank.builder()
                .addresses(addresses)
                .clients(clients)
                .companyName(bankDto.getCompanyName())
                .creditCards(creditCards)
                .build();
    }

    public BankDto mapBankToDto(Bank bank) {
        List<AddressDto> addresses = bank.getAddresses().stream()
                .map(address -> addressMapper.mapAddressToDto(address))
                .collect(Collectors.toList());
        List<UserDto> clients = bank.getClients().stream()
                .map(client -> userMapper.mapUserToDto(client))
                .collect(Collectors.toList());
        List<CreditCardDto> creditCards = bank.getCreditCards().stream()
                .map(creditCard -> creditCardMapper.mapCreditCardToDto(creditCard))
                .collect(Collectors.toList());
        return BankDto.builder()
                .id(bank.getId())
                .addresses(addresses)
                .clients(clients)
                .companyName(bank.getCompanyName())
                .creditCards(creditCards)
                .build();
    }
}
