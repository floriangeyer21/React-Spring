package recat.spring.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import recat.spring.example.demo.domain.entity.CreditCard;
import recat.spring.example.demo.repository.CreditCardRepository;
import recat.spring.example.demo.service.interfaces.CreditCardService;

import java.util.List;

@Service
@Transactional
public class CreditCardServiceImpl implements CreditCardService {
    private CreditCardRepository creditCardRepository;

    @Autowired
    public CreditCardServiceImpl(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    @Override
    public CreditCard saveCreditCard(CreditCard creditCard) {
        return creditCardRepository.save(creditCard);
    }

    @Override
    public CreditCard getCreditCardById(Long id) {
        return creditCardRepository.getOne(id);
    }

    @Override
    public List<CreditCard> getAllCreditCards() {
        return creditCardRepository.findAll();
    }
}
