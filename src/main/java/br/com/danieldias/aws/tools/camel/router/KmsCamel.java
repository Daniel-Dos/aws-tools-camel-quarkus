package br.com.danieldias.aws.tools.camel.router;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.aws2.kms.KMS2Constants;
import org.eclipse.microprofile.config.inject.ConfigProperty;


import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class KmsCamel extends RouteBuilder {

    @ConfigProperty(name = "name.label")
    private String label;

    @ConfigProperty(name = "key.id.kms")
    private String keyId;

    @Override
    public void configure() throws Exception {

        from("direct:listKeys")
                .to("aws2-kms://"+label+"?kmsClient=#amazonKmsClient&operation=listKeys");

        from("direct:describeKey")
                .process(exchange -> exchange.getIn().setHeader(KMS2Constants.KEY_ID, keyId))
                .to("aws2-kms://"+label+"?kmsClient=#amazonKmsClient&operation=describeKey");
    }
}
