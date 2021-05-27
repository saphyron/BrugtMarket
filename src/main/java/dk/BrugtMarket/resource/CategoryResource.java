package dk.BrugtMarket.resource;

import dk.BrugtMarket.resource.dto.CategoryCountDTO;
import dk.BrugtMarket.resource.dto.CategoryDTO;
import dk.BrugtMarket.resource.dto.CreateCategoryDTO;
import dk.BrugtMarket.resource.dto.ReadCategoryDTO;
import dk.BrugtMarket.service.CategoryService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/categories")
@RequestScoped
public class CategoryResource {
    private final CategoryService service;
    private final Mapper mapper;

    @Inject
    public CategoryResource(CategoryService service, Mapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    @POST
    public void createCategory(CreateCategoryDTO createCategoryDTO) {
        service.insert(mapper.mapCategory(createCategoryDTO));
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    @GET
    public List<CategoryDTO> getAll() {
        return service.getCategoryNames().stream().map(CategoryDTO::new).collect(Collectors.toList());

    }

    @Produces(MediaType.APPLICATION_JSON)
    @Path("/count")
    @GET
    public List<CategoryCountDTO> getCountCategories() {
        return service.getCountCategory().entrySet().stream().map(e->new CategoryCountDTO(e.getKey(),e.getValue())).collect(Collectors.toList());
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Path("/advertisements")
    @GET
    public List<ReadCategoryDTO> getCategoryAdvertisement() {
        return mapper.mapReadCategories(service.getCategories());
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @GET
    public List<ReadCategoryDTO> getById(@PathParam("id") String id) {
        List<ReadCategoryDTO> selectedCategory = mapper.mapReadCategories(service.getCategoryById(id));
        return selectedCategory;
    }
}
