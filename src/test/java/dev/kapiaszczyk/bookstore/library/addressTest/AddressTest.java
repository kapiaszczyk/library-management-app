package dev.kapiaszczyk.bookstore.library.addressTest;

import dev.kapiaszczyk.bookstore.library.address.Address;
import dev.kapiaszczyk.bookstore.library.address.AddressRepository;
import dev.kapiaszczyk.bookstore.library.city.City;
import dev.kapiaszczyk.bookstore.library.city.CityRepository;
import dev.kapiaszczyk.bookstore.library.cityCode.CityCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class AddressTest {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CityRepository cityRepository;

    private Address address;
    private City city;
    private CityCode cityCode;

    @BeforeEach
    public void setUp() {
        address = new Address();
        address.setStreet("St. Mary's Street 5");
        addressRepository.save(address);
    }

    @Test
    public void addressCanBeAdded() {
        // Retrieve address
        Address savedAddress = addressRepository.findById(address.getId()).get();

        // Check if address was added
        assertNotNull(savedAddress);
    }

    @Test
    public void addressCanBeUpdated() {
        // Update address
        Address savedAddress = addressRepository.findById(address.getId()).get();
        savedAddress.setStreet("St. Mary's Street 6");
        addressRepository.save(savedAddress);

        // Check if address was updated
        Address updatedAddress = addressRepository.findById(address.getId()).get();
        assertThat(updatedAddress.getStreet(), equalTo(savedAddress.getStreet()));
    }

    @Test
    public void addressCanBeDeleted() {
        // Delete address
        addressRepository.delete(address);

        // Check if address was deleted
        assertEquals(0, addressRepository.count());
    }

}
