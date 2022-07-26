package br.com.danieldias.aws.tools.camel.controller;

import br.com.danieldias.aws.tools.camel.service.LambdaCall;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/lambda")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LambdaController {

    private LambdaCall lambdaCall;

    @Inject
    public LambdaController(LambdaCall lambdaCall) {
        this.lambdaCall = lambdaCall;
    }

    @POST
    @Path("invokeFunction")
    public Response invokeFunction(String funcao) {

        var retorno = this.lambdaCall.invokeFunction(funcao);
        return Response.ok(retorno).build();
    }

    @GET
    @Path("listFunctions")
    public Response listFunctions() {

        var retorno = this.lambdaCall.listFunctions();
        return Response.ok(retorno).build();
    }

    @GET
    @Path("getFunction")
    public Response getFunction() {

        var retorno = this.lambdaCall.getFunction();
        return Response.ok(retorno).build();
    }
}
