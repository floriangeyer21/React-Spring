package recat.spring.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import recat.spring.example.demo.domain.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
