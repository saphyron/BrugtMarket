package dk.BrugtMarket.repository;

import dk.BrugtMarket.domain.*;
import dk.BrugtMarket.repository.entity.Ad_UserPO;
import dk.BrugtMarket.repository.entity.AdvertisementPO;
import dk.BrugtMarket.repository.entity.CityPO;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.stream.Collectors;

@Dependent
public class Mapper {

    // TODO: 25/05/2021 mapCategoryPO

    public List<Ad_User> mapUsers(List<Ad_UserPO> users) {
        return users.stream().map(a->mapUser(a)).collect(Collectors.toList());
    }

    public List<City> mapCities(List<CityPO> cities) {
        return cities.stream().map(a->mapCity(a)).collect(Collectors.toList());
    }

    public List<Advertisement> mapAdvertisements(List<AdvertisementPO> advertisements) {
        return advertisements.stream().map(a->mapAdvertisement(a)).collect(Collectors.toList());
    }

    public Ad_User mapUser(Ad_UserPO adUserPO) {
        return new Ad_User(
                new Id(adUserPO.getId().toString()),
                new First_Name(adUserPO.getFirstName()),
                new Last_Name(adUserPO.getLastName()),
                new Company_Name(adUserPO.getCompanyName()),
                new Phone_Number(adUserPO.getPhoneNumber()),
                new Phone_Code(adUserPO.getPhoneCode()),
                new Email(adUserPO.getEmail()),
                new Creation_Date(adUserPO.getCreationDate()),
                mapAdvertisements(adUserPO.getAdvertisements()),
                mapCity(adUserPO.getCity()),
                new Type(adUserPO.getType())
        );
    }

    public Ad_UserPO mapUserPO(Ad_User adUser) {
        return new Ad_UserPO(
                adUser.getFirst().getName(),
                adUser.getLast().getName(),
                adUser.getCompany().getName(),
                adUser.getPhone().getNumber(),
                adUser.getPhc().getCode(),
                adUser.getEmail().getEmail(),
                mapCityPO(adUser.getCity()),
                adUser.getCreation().getDate(),
                adUser.getType().getType()
        );
    }

    public City mapCity(CityPO city) {
        return new City(
                city.getCity(),
                new Zip_Code(city.getZipCode())
        );
    }

    public CityPO mapCityPO(City city) {
        return new CityPO(
                city.getCity(),
                city.getZip().toString()
        );
    }

    public Advertisement mapAdvertisement(AdvertisementPO advertisementPO) {
        return new Advertisement(
                new Id(advertisementPO.getId()),
                new Category(advertisementPO.getCategory()),
                new Sales_Type(advertisementPO.getSalesType()),
                new Headline(advertisementPO.getHeadline()),
                new Text(advertisementPO.getText()),
                new Price(advertisementPO.getPrice()),
                new Creation_Date(advertisementPO.getCreationDate())
        );
    }

    public List<Advertisement> mapAdvertisement(List<AdvertisementPO> advertisements) {
        return advertisements.stream().map(this::mapAdvertisement).collect(Collectors.toList());
    }

    public AdvertisementPO mapAdvertisementPO(Advertisement advertisement) {
        return new AdvertisementPO(
                advertisement.getCategory().getCategory(),
                advertisement.getType().getType(),
                advertisement.getHeadline().getHeadline(),
                advertisement.getText().getText(),
                advertisement.getPrice().getPrice(),
                advertisement.getCreation().getDate()
        );
    }

    public List<AdvertisementPO> mapAdvertisementPO(List<Advertisement> advertisements) {
        return advertisements.stream().map(this::mapAdvertisementPO).collect(Collectors.toList());
    }

}
