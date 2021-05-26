package dk.BrugtMarket.resource;



import dk.BrugtMarket.domain.*;
import dk.BrugtMarket.resource.dto.*;
import dk.BrugtMarket.service.request.AdvertisementRequest;

import javax.enterprise.context.Dependent;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Dependent
class Mapper {

    Id mapId (String id) { return new Id(id); }
    Sales_Type mapSalesType (String salesType) { return new Sales_Type(salesType); }
    Headline mapHeadline (String headline) { return new Headline(headline); }
    Text mapText (String text) { return new Text(text); }
    Price mapPrice (int price) { return new Price(price); }
    Creation_Date mapDate (Date date) { return new Creation_Date(date); }

    Advertisement mapAdvertisement(CreateAdvertisementDTO createAdvertisementDTO) {
        return new Advertisement(
                mapSalesType(createAdvertisementDTO.getType()),
                mapHeadline(createAdvertisementDTO.getHeadline()),
                mapText(createAdvertisementDTO.getText()),
                mapPrice(createAdvertisementDTO.getPrice()),
                mapDate(createAdvertisementDTO.getCreation())
        );
    }

    List<Advertisement> mapAdvertisement(List<CreateAdvertisementDTO> createAdvertisementDTOS) {
        return createAdvertisementDTOS.stream().map(this::mapAdvertisement).collect(Collectors.toList());
    }

    ReadAdvertisementDTO mapReadAdvertisement(Advertisement advertisement) {
        return new ReadAdvertisementDTO(
                advertisement.getType().getType(),
                advertisement.getHeadline().getHeadline(),
                advertisement.getText().getText(),
                advertisement.getPrice().getPrice(),
                advertisement.getCreation().getDate()
        );
    }

    List<ReadAdvertisementDTO> mapReadAdvertisement(List<Advertisement> advertisements) {
        return advertisements.stream().map(this::mapReadAdvertisement).collect(Collectors.toList());
    }

    Zip_Code mapZip (String zip) { return new Zip_Code(zip); }

    City mapCity(CreateCityDTO cityDTO) {
        return new City(
                cityDTO.getCity(),
                mapZip(cityDTO.getZipCode())
        );
    }

    List<City> mapCity(List<CreateCityDTO> cityDTO) {
        return cityDTO.stream().map(this::mapCity).collect(Collectors.toList());
    }



    First_Name mapFirst (String first) { return new First_Name(first); }
    Last_Name mapLast (String last) { return new Last_Name(last); }
    Company_Name mapCompany (String company) { return new Company_Name(company); }
    Phone_Number mapPN (String pn) { return new Phone_Number(pn); }
    Phone_Code mapPC (String pc) { return new Phone_Code(pc); }
    Email mapEmail (String email) { return new Email(email); }
    Type mapType (String type) { return new Type(type); }

    Ad_User mapUser(CreateUserDTO createUserDTO) {
        return new Ad_User(
                mapFirst(createUserDTO.getFirstName()),
                mapLast(createUserDTO.getLastName()),
                mapCompany(createUserDTO.getCompanyName()),
                mapPN(createUserDTO.getPhoneNumber()),
                mapPC(createUserDTO.getPhoneCode()),
                mapEmail(createUserDTO.getEmail()),
                mapDate(createUserDTO.getCreation()),
                mapAdvertisement(createUserDTO.getAdvertisements()),
                mapCity(createUserDTO.getCity()),
                mapType(createUserDTO.getType())
        );
    }

    Category mapCategory(CreateCategoryDTO createCategoryDTO) {
        return new Category(
                createCategoryDTO.getCategory(),
                mapAdvertisement(createCategoryDTO.getAdvertisements())
        );
    }

    AdvertisementDTO mapAdvertisementDTO(Advertisement advertisement) {
        return new AdvertisementDTO(
                advertisement.getId().getId().toString(),
                advertisement.getType().getType(),
                advertisement.getHeadline().getHeadline(),
                advertisement.getText().getText(),
                advertisement.getPrice().getPrice(),
                advertisement.getCreation().getDate()
        );
    }

    List<AdvertisementDTO> mapAdvertisementDTO(List<Advertisement> advertisements) {
        return advertisements.stream().map(this::mapAdvertisementDTO).collect(Collectors.toList());
    }

    CityDTO mapCityDTO(City city) {
        return new CityDTO(
                city.getCity(),
                city.getZip().getZip()
        );
    }

    ReadUserDTO mapReadUser(Ad_User user) {
        return new ReadUserDTO(
                user.getFirst().getName(),
                user.getLast().getName(),
                user.getCompany().getName(),
                user.getPhone().getNumber(),
                user.getPhc().getCode(),
                user.getEmail().getEmail(),
                user.getCreation().getDate(),
                mapAdvertisementDTO(user.getAdvertisements()),
                mapCityDTO(user.getCity()),
                user.getType().getType()
        );
    }

    ReadCategoryDTO mapReadCategories(Category category) {
        return new ReadCategoryDTO(
                category.getCategory(),
                mapAdvertisementDTO(category.getAdvertisement())
        );
    }

    List<ReadUserDTO> mapReadUser(List<Ad_User> user) {
        return user.stream().map(this::mapReadUser).collect(Collectors.toList());
    }

    ReadCityDTO mapReadCity(City city) {
        return new ReadCityDTO(
                city.getCity(),
                city.getZip().getZip()
        );
    }

    List<ReadCityDTO> mapReadCity(List<City> city) {
        return city.stream().map(this::mapReadCity).collect(Collectors.toList());
    }



    List<ReadCategoryDTO> mapReadCategories(List<Category> categories) {
        return categories.stream().map(this::mapReadCategories).collect(Collectors.toList());
    }


}
