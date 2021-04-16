package recat.spring.example.demo.service.mappers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import recat.spring.example.demo.domain.dto.AddressDto;
import recat.spring.example.demo.domain.entity.Address;

@Component
@NoArgsConstructor
public class AddressMapper {

    public Address mapDtoToAddress(AddressDto addressDto) {
        return Address.builder()
                .address(addressDto.getAddress())
                .build();
    }

    public AddressDto mapAddressToDto(Address address) {
        return AddressDto.builder()
                .id(address.getId())
                .address(address.getAddress())
                .build();
    }
}
