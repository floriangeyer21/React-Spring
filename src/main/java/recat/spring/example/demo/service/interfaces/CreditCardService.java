package recat.spring.example.demo.service.interfaces;

import recat.spring.example.demo.domain.entity.CreditCard;

import java.util.List;

public interface CreditCardService {

    CreditCard saveCreditCard(CreditCard creditCard);

    CreditCard getCreditCardById(Long id);

    List<CreditCard> getAllCreditCards();
}
