package br.com.danieldias.aws.tools.camel.Controller;

import br.com.danieldias.aws.tools.camel.service.SecretsManagerCall;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/secretsManager")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SecretsManagerController {

    private SecretsManagerCall secretsManagerCall;

    @Inject
    public SecretsManagerController(SecretsManagerCall secretsManagerCall) {
        this.secretsManagerCall = secretsManagerCall;
    }

    @GET
    @Path("listSecrets")
    public Response listSecrets() {
        var listSecrets = secretsManagerCall.listSecrets();
        return Response.ok(listSecrets).build();
    }

    @GET
    @Path("getSecret")
    public Response getSecret() {
        var listSecrets = secretsManagerCall.getSecret();
        return Response.ok(listSecrets).build();
    }

    @GET
    @Path("describeSecret")
    public Response describeSecret() {
        var describeSecret = secretsManagerCall.describeSecret();
        return Response.ok(describeSecret).build();
    }
}
