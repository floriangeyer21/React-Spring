package recat.spring.example.demo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import recat.spring.example.demo.domain.entity.Bank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardDto {
    private Long id;
    private Double number;
}
