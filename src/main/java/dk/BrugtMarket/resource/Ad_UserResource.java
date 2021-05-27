package dk.BrugtMarket.resource;

import dk.BrugtMarket.domain.Id;
import dk.BrugtMarket.resource.dto.CreateUserDTO;
import dk.BrugtMarket.resource.dto.ReadUserDTO;
import dk.BrugtMarket.service.Ad_UserService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
@RequestScoped
public class Ad_UserResource {
    private final Ad_UserService userService;
    private final Mapper mapper;

    @Inject
    public Ad_UserResource(Ad_UserService userService, Mapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    @GET
    public List<ReadUserDTO> getAll() {
        return mapper.mapReadUser(userService.getAllUsers());

    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    @POST
    public void createUser(CreateUserDTO createUserDTO) {
        userService.insertUser(mapper.mapUser(createUserDTO));
    }
}
