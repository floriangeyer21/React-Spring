package recat.spring.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import recat.spring.example.demo.domain.dto.request.CreditCardRequestDto;
import recat.spring.example.demo.domain.dto.response.CreditCardResponseDto;
import recat.spring.example.demo.domain.entity.CreditCard;
import recat.spring.example.demo.service.interfaces.CreditCardService;
import recat.spring.example.demo.service.mappers.CreditCardMapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/credit-cards")
public class CreditCardController {
    private CreditCardService creditCardService;
    private CreditCardMapper creditCardMapper;

    @Autowired
    public CreditCardController(CreditCardService creditCardService,
                                CreditCardMapper creditCardMapper) {
        this.creditCardService = creditCardService;
        this.creditCardMapper = creditCardMapper;
    }

    @GetMapping("/{id}")
    public CreditCardResponseDto getCreditCardById(@PathVariable Long id) {
        return creditCardMapper.mapCreditCardToDto(creditCardService.getCreditCardById(id));
    }

    @PostMapping
    public CreditCardResponseDto saveCreditCard(@RequestBody CreditCardRequestDto creditCardRequestDto) {
        CreditCard creditCard = creditCardMapper.mapDtoToCreditCard(creditCardRequestDto);
        return creditCardMapper.mapCreditCardToDto(creditCardService.saveCreditCard(creditCard));
    }

    @GetMapping
    public List<CreditCardResponseDto> getAllCreditCards() {
        return creditCardService.getAllCreditCards().stream()
                .map(creditCard -> creditCardMapper.mapCreditCardToDto(creditCard))
                .collect(Collectors.toList());
    }
}
