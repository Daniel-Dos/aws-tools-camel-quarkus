package br.com.danieldias.aws.tools.camel.Controller;

import br.com.danieldias.aws.tools.camel.service.S3Call;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/s3")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class S3Controller {

    private S3Call s3Call;

    @Inject
    public S3Controller(S3Call s3Call) {
        this.s3Call = s3Call;
    }

    @GET
    @Path("listBuckets")
    public Response listBuckets() {
        var listBuckets = this.s3Call.listBuckets();
        return Response.ok(listBuckets).build();
    }

    @GET
    @Path("listObjects")
    public Response listObjects() {
        var listBuckets = this.s3Call.listObjects();
        return Response.ok(listBuckets).build();
    }
}
