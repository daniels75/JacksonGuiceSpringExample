package org.daniels.samples.rest.web.rest;

import com.google.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.daniels.samples.rest.domain.User;
import org.daniels.samples.rest.service.contract.DummyService;

@Path("/dummy")
public class DummyRestService {
    private final DummyService dummyService;

    @Inject
    public DummyRestService(DummyService DummyService) {
        this.dummyService = DummyService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User getDefaultDummyInJSON() {
        return dummyService.getDefaultUser();
    }
}
