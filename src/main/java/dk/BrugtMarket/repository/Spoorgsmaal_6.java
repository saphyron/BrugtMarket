package dk.BrugtMarket.repository;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Arrays;
import java.util.List;

public class Spoorgsmaal_6 {

    public interface PolyMorphService {
        List<String> getValues();
    }

    @Dependent
    public class PolyOne implements PolyMorphService {
        @Override
        public List<String> getValues() {
            return Arrays.asList("PolyOne");
        }
    }
    @Alternative
    public class PolyTwo implements PolyMorphService {
        @Override
        public List<String> getValues() {
            return Arrays.asList("PolyTwo");
        }
    }
    @Alternative
    public class PolyThree implements PolyMorphService {
        @Override
        public List<String> getValues() {
            return Arrays.asList("PolyThree");
        }
    }

    public class PolyController {
        private final PolyMorphService service;
        @Inject
        public PolyController(PolyMorphService service) {
            this.service = service;
        }

        @Path("poly")
        @GET
        public List<String> getMiniData() {
            return service.getValues();
        }
    }
}
