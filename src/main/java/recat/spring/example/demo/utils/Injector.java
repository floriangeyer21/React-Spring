package recat.spring.example.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import recat.spring.example.demo.service.interfaces.BankService;
import recat.spring.example.demo.service.interfaces.CreditCardService;
import recat.spring.example.demo.service.interfaces.UserService;

import javax.annotation.PostConstruct;

@Component
public class Injector {
    private UserService userService;
    private BankService bankService;
    private CreditCardService creditCardService;

    @Autowired
    public Injector(UserService userService,
                    BankService bankService,
                    CreditCardService creditCardService) {
        this.userService = userService;
        this.bankService = bankService;
        this.creditCardService = creditCardService;
    }

    @PostConstruct
    public void injectDataToDb() {

    }
}
