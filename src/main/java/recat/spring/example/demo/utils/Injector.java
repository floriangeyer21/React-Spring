package recat.spring.example.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import recat.spring.example.demo.domain.entity.Address;
import recat.spring.example.demo.service.interfaces.AddressService;
import recat.spring.example.demo.service.interfaces.BankService;
import recat.spring.example.demo.service.interfaces.CreditCardService;
import recat.spring.example.demo.service.interfaces.UserService;

import javax.annotation.PostConstruct;

@Component
public class Injector {
    private UserService userService;
    private BankService bankService;
    private CreditCardService creditCardService;
    private AddressService addressService;

    @Autowired
    public Injector(UserService userService,
                    BankService bankService,
                    CreditCardService creditCardService,
                    AddressService addressService) {
        this.userService = userService;
        this.bankService = bankService;
        this.creditCardService = creditCardService;
        this.addressService = addressService;
    }

    @PostConstruct
    public void injectDataToDb() {
        Address address = Address.builder()
                .address("Mock address 1")
                .build();
        addressService.saveAddress(address);
        address = Address.builder()
                .address("Mock address 2")
                .build();
        addressService.saveAddress(address);
    }
}
