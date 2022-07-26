package br.com.danieldias.aws.tools.camel.controller;

import br.com.danieldias.aws.tools.camel.service.kmsCall;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/kms")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class KmsController {

    private kmsCall kmscall;

    @Inject
    public KmsController(kmsCall kmscall) {
        this.kmscall = kmscall;
    }

    @GET
    @Path("listKeys")
    public Response listKeys() {

        var listAccessKeys = kmscall.listKeys();
        return Response.ok(listAccessKeys).build();
    }

    @GET
    @Path("describeKey")
    public Response describeKey() {

        var describeKey = kmscall.describeKey();
        return Response.ok(describeKey).build();
    }
}
