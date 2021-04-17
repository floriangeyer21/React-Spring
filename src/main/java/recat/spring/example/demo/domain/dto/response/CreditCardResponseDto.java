package recat.spring.example.demo.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import recat.spring.example.demo.domain.entity.Bank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardResponseDto {
    private Long id;
    private int number;
}
