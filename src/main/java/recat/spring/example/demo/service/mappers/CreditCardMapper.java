package recat.spring.example.demo.service.mappers;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import recat.spring.example.demo.domain.dto.request.CreditCardRequestDto;
import recat.spring.example.demo.domain.dto.response.CreditCardResponseDto;
import recat.spring.example.demo.domain.entity.CreditCard;

@Component
@NoArgsConstructor
public class CreditCardMapper {

    public CreditCard mapDtoToCreditCard(CreditCardRequestDto creditCardRequestDto) {
        return CreditCard.builder()
                .number(creditCardRequestDto.getNumber())
                .build();
    }

    public CreditCardResponseDto mapCreditCardToDto(CreditCard creditCard) {
        return CreditCardResponseDto.builder()
                .id(creditCard.getId())
                .number(creditCard.getNumber())
                .build();
    }
}
