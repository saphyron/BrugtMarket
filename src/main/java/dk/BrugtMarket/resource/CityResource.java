package dk.BrugtMarket.resource;

import dk.BrugtMarket.resource.dto.CreateCityDTO;
import dk.BrugtMarket.service.CityService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

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

    @Produces
    @Path("")
    @POST
    public void createCity(CreateCityDTO createCityDTO) {
        service.insert(mapper.mapCity(createCityDTO));
    }
}
