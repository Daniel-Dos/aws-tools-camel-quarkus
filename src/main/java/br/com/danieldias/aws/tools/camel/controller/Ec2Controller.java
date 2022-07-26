package br.com.danieldias.aws.tools.camel.controller;
import br.com.danieldias.aws.tools.camel.service.Ec2Call;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ec2")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Ec2Controller {

    private Ec2Call ec2Call;

    @Inject
    public Ec2Controller(Ec2Call ec2Call) {
        this.ec2Call = ec2Call;
    }

    @GET
    @Path("describeInstances")
    public Response describeCluster() {

        var retorno = this.ec2Call.describeInstances();
        return Response.ok(retorno).build();
    }
}
