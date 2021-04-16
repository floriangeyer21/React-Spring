package recat.spring.example.demo.service.mappers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import recat.spring.example.demo.domain.dto.CreditCardDto;
import recat.spring.example.demo.domain.entity.Bank;
import recat.spring.example.demo.domain.entity.CreditCard;

@Component
@NoArgsConstructor
public class CreditCardMapper {

    public CreditCard mapDtoToCreditCard(CreditCardDto creditCardDto) {
        return CreditCard.builder()
                .number(creditCardDto.getNumber())
                .build();
    }

    public CreditCardDto mapCreditCardToDto(CreditCard creditCard) {
        return CreditCardDto.builder()
                .id(creditCard.getId())
                .number(creditCard.getNumber())
                .build();
    }
}
