package dk.BrugtMarket.resource;

import dk.BrugtMarket.domain.Id;
import dk.BrugtMarket.resource.dto.CreateAdvertisementDTO;
import dk.BrugtMarket.resource.dto.CreateUserAdvertisementDTO;
import dk.BrugtMarket.resource.dto.ReadAdvertisementDTO;
import dk.BrugtMarket.service.Ad_UserService;
import dk.BrugtMarket.service.AdvertisementService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("advertisements")
@RequestScoped
public class AdvertisementResource {
    private final AdvertisementService service;
    private final Mapper mapper;
    private final Ad_UserService userService;

    @Inject
    public AdvertisementResource(AdvertisementService service, Mapper mapper, Ad_UserService userService) {
        this.service = service;
        this.mapper = mapper;
        this.userService = userService;
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Path("")
    @GET
    public List<ReadAdvertisementDTO> getAll() {
        try {
            return mapper.mapReadAdvertisement(service.getAllAdvertisements());
        } catch (NoResultException e) {
            throw new NoResultException(e.getMessage());
        }
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @GET
    public ReadAdvertisementDTO getById(@PathParam("id") Id id) {
        ReadAdvertisementDTO selectedAdvertisement = mapper.mapReadAdvertisement(service.getById(id));
        return selectedAdvertisement;
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{userId}")
    @POST
    public ReadAdvertisementDTO createAdvertisements(@PathParam("userId")String userID, CreateAdvertisementDTO createAdvertisementDTO, CreateUserAdvertisementDTO createUserAdvertisementDTO) {
        service.insertAdvertisement(mapper.mapAdvertisement(createAdvertisementDTO));
        return mapper.mapReadAdvertisement(userService.receiveAdvertisement(
                mapper.mapCreateUserAdvertisement(userID,createUserAdvertisementDTO)
        ));
    }
}
