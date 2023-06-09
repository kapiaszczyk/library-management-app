package dev.kapiaszczyk.bookstore.library.address;

import dev.kapiaszczyk.bookstore.library.city.City;
import dev.kapiaszczyk.bookstore.library.libraryUser.LibraryUser;
import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "street")
    private String street;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    private City city;

    @OneToOne
    @JoinColumn(name = "library_user_id")
    private LibraryUser libraryUser;

    public Address() {
    }

    public Address(String street, City city, LibraryUser libraryUser)  {
        this.street = street;
        this.city = city;
        this.libraryUser = libraryUser;
    }

    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public LibraryUser getLibraryUser() {
        return libraryUser;
    }

    public void setLibraryUser(LibraryUser libraryUser) {
        this.libraryUser = libraryUser;
    }

}
