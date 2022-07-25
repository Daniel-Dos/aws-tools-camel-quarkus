package br.com.danieldias.aws.tools.camel.service.impl;


import br.com.danieldias.aws.tools.camel.dto.secretmanager.SecretListEntryDTO;
import br.com.danieldias.aws.tools.camel.service.SecretsManagerCall;
import br.com.danieldias.aws.tools.camel.util.GenericCamelTemplateProducer;
import org.apache.camel.FluentProducerTemplate;

import software.amazon.awssdk.services.secretsmanager.model.DescribeSecretResponse;
import software.amazon.awssdk.services.secretsmanager.model.ListSecretsResponse;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class SecretsManagerCallImpl implements SecretsManagerCall {

    final static String LIST_SECRETS = "direct:listSecrets";
    final static String GET_SECRETS = "direct:getSecret";
    final static String DESCRIBE_SECRETS = "direct:describeSecret";

    private FluentProducerTemplate fluentProducerTemplate;

    @Inject
    public SecretsManagerCallImpl(FluentProducerTemplate fluentProducerTemplate) {
        this.fluentProducerTemplate = fluentProducerTemplate;
    }

    @Override
    public List<SecretListEntryDTO> listSecrets() {


        ListSecretsResponse listSecretsResponse =
                GenericCamelTemplateProducer.getFluentProducerTemplateResponse(fluentProducerTemplate,LIST_SECRETS,
                        ListSecretsResponse.class);

        return listSecretsResponse.secretList().stream().map(SecretListEntryDTO::convertToDto).collect(Collectors.toList());
    }

    @Override
    public String getSecret() {

        String secret =
                GenericCamelTemplateProducer.getFluentProducerTemplateResponse(fluentProducerTemplate,GET_SECRETS,
                                                                               String.class);
        return secret;
    }

    @Override
    public SecretListEntryDTO describeSecret() {

        DescribeSecretResponse describeSecret =
                GenericCamelTemplateProducer.getFluentProducerTemplateResponse(fluentProducerTemplate,DESCRIBE_SECRETS,
                        DescribeSecretResponse.class);

        return new SecretListEntryDTO(describeSecret.arn(),describeSecret.name(),
                                      describeSecret.description(),describeSecret.kmsKeyId());
    }
}
