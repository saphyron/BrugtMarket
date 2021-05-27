package dk.BrugtMarket.resource;

import dk.BrugtMarket.domain.Category;
import dk.BrugtMarket.domain.Id;
import dk.BrugtMarket.resource.dto.CreateAdvertisementDTO;
import dk.BrugtMarket.resource.dto.ReadAdvertisementDTO;
import dk.BrugtMarket.service.Ad_UserService;
import dk.BrugtMarket.service.AdvertisementService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/advertisements")
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
    @Path("/")
    @GET
    public List<ReadAdvertisementDTO> getAll() {
        return mapper.mapReadAdvertisement(service.getAllAdvertisements());

    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @GET
    public ReadAdvertisementDTO getById(@PathParam("id") String id) {
        ReadAdvertisementDTO selectedAdvertisement = mapper.mapReadAdvertisement(service.getById(new Id(id)));
        return selectedAdvertisement;
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/User/{userId}")
    @POST
    public void createAdvertisement(@PathParam("userId") String userID, CreateAdvertisementDTO advertisement) {
        service.insertAdvertisement(new Id(userID), new CreateAdvertisementDTO(
                advertisement.getCategory(),
                advertisement.getType(),
                advertisement.getHeadline(),
                advertisement.getText(),
                advertisement.getPrice(),
                advertisement.getCreation()
        ));
    }

}
