package br.com.danieldias.aws.tools.camel.router;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.aws.secretsmanager.SecretsManagerConstants;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SecretManagerCamel extends RouteBuilder {

    @ConfigProperty(name = "name.label")
    private String label;

    @ConfigProperty(name = "id.secret")
    private String idSecret;

    @Override
    public void configure() throws Exception {

        from("direct:listSecrets")
                .to("aws-secrets-manager://"+label+"?operation=listSecrets");

        from("direct:getSecret")
                .process(exchange -> exchange.getIn().setHeader(SecretsManagerConstants.SECRET_ID, idSecret))
                .to("aws-secrets-manager://"+label+"?operation=getSecret");

        from("direct:describeSecret")
                .process(exchange -> exchange.getIn().setHeader(SecretsManagerConstants.SECRET_ID, idSecret))
                .to("aws-secrets-manager://"+label+"?operation=describeSecret");
    }
}
