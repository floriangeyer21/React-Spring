package recat.spring.example.demo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankDto {
    private Long id;
    private String companyName;
    private List<AddressDto> addresses;
    private List<UserDto> clients;
    private List<CreditCardDto> creditCards;
}
