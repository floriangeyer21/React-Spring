package recat.spring.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import recat.spring.example.demo.domain.entity.Address;
import recat.spring.example.demo.repository.AddressRepository;
import recat.spring.example.demo.service.interfaces.AddressService;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address getAddressById(Long id) {
        return addressRepository.getOne(id);
    }
}
