package br.com.danieldias.aws.tools.camel.router;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.aws2.s3.AWS2S3Constants;
import org.apache.camel.component.aws2.s3.AWS2S3Operations;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class S3Camel extends RouteBuilder {

    @ConfigProperty(name = "bucket.name")
    private String bucketName;

    @Override
    public void configure() throws Exception {

        from("direct:listBuckets")
                .process(exchange ->  exchange.getIn().setHeader(AWS2S3Constants.S3_OPERATION, AWS2S3Operations.listBuckets))
                .to("aws2-s3://"+bucketName+"?deleteAfterRead=false&pojoRequest=true");

        from("direct:listObjects")
                .to("aws2-s3://"+bucketName+"?deleteAfterRead=false&operation=listObjects");
    }
}
