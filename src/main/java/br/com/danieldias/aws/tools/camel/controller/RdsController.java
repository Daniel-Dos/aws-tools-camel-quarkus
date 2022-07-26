package br.com.danieldias.aws.tools.camel.controller;

import br.com.danieldias.aws.tools.camel.service.RdsCall;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/rds")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RdsController {

    private RdsCall rdsCall;

    @Inject
    public RdsController(RdsCall rdsCall) {
        this.rdsCall = rdsCall;
    }

    @GET
    @Path("describeDBInstances")
    public Response describeCluster() throws Exception {

        var describeDBInstances = this.rdsCall.describeDBInstances();
        return Response.ok(describeDBInstances).build();
    }
}
