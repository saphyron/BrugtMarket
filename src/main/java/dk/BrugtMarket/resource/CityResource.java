package dk.BrugtMarket.resource;

import dk.BrugtMarket.resource.dto.CategoryDTO;
import dk.BrugtMarket.resource.dto.CityDTO;
import dk.BrugtMarket.resource.dto.CreateCityDTO;
import dk.BrugtMarket.resource.dto.ReadCityDTO;
import dk.BrugtMarket.service.CityService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;
import java.util.stream.Collectors;

@Path("/city")
@RequestScoped
public class CityResource {
    private final CityService service;
    private final Mapper mapper;

    @Inject
    public CityResource(CityService service, Mapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Consumes
    @Path("/")
    @POST
    public void createCity(CreateCityDTO createCityDTO) {
        service.insert(mapper.mapCity(createCityDTO));
    }

}
