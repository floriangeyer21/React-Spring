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
public class UserMapper {
    private CreditCardMapper creditCardMapper;
    private AddressMapper addressMapper;

    @Autowired
    public UserMapper(CreditCardMapper creditCardMapper,
                      AddressMapper addressMapper) {
        this.creditCardMapper = creditCardMapper;
        this.addressMapper = addressMapper;
    }

    public User mapDtoToUser(UserDto userDto) {
        List<Address> addresses = userDto.getAddresses().stream()
                .map(address -> addressMapper.mapDtoToAddress(address))
                .collect(Collectors.toList());
        List<CreditCard> creditCards = userDto.getCreditCards().stream()
                .map(creditCard -> creditCardMapper.mapDtoToCreditCard(creditCard))
                .collect(Collectors.toList());
        return User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .addresses(addresses)
                .creditCards(creditCards)
                .build();
    }

    public UserDto mapUserToDto(User user) {
        List<AddressDto> addresses = user.getAddresses().stream()
                .map(address -> addressMapper.mapAddressToDto(address))
                .collect(Collectors.toList());
        List<CreditCardDto> creditCards = user.getCreditCards().stream()
                .map(creditCard -> creditCardMapper.mapCreditCardToDto(creditCard))
                .collect(Collectors.toList());
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .addresses(addresses)
                .creditCards(creditCards)
                .build();
    }
}
