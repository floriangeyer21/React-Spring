package recat.spring.example.demo.service.interfaces;

import recat.spring.example.demo.domain.entity.Address;

public interface AddressService {

    Address saveAddress(Address address);

    Address getAddressById(Long id);
}
