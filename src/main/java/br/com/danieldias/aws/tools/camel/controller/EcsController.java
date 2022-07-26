package br.com.danieldias.aws.tools.camel.controller;

import br.com.danieldias.aws.tools.camel.service.EcsCall;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ecs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EcsController {

    private EcsCall ecsCall;

    @Inject
    public EcsController(EcsCall ecsCall) {
        this.ecsCall = ecsCall;
    }

    @GET
    @Path("listClusters")
    public Response listClusters() {
        var retorno = this.ecsCall.listECS();
        return Response.ok(retorno).build();
    }

    @GET
    @Path("describeCluster")
    public Response describeCluster() {
        var retorno = this.ecsCall.describeCluster();
        return Response.ok(retorno).build();
    }
}
