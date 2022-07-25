package br.com.danieldias.aws.tools.camel.router;

import org.apache.camel.builder.RouteBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;


import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Ec2Camel extends RouteBuilder {

    @ConfigProperty(name = "name.label")
    private String label;

    @Override
    public void configure() throws Exception {

        from("direct:describeInstances")
                .to("aws2-ec2://"+label+"?amazonEc2Client=#amazonEc2Client&operation=describeInstances");
    }
}
