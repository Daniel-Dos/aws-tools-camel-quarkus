package br.com.danieldias.aws.tools.camel.service.impl;


import br.com.danieldias.aws.tools.camel.dto.kms.KmsDTO;
import br.com.danieldias.aws.tools.camel.dto.kms.KmsDescribeDTO;
import br.com.danieldias.aws.tools.camel.service.kmsCall;
import br.com.danieldias.aws.tools.camel.util.GenericCamelTemplateProducer;
import org.apache.camel.FluentProducerTemplate;

import software.amazon.awssdk.services.kms.model.DescribeKeyResponse;
import software.amazon.awssdk.services.kms.model.KeyMetadata;
import software.amazon.awssdk.services.kms.model.ListKeysResponse;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequestScoped
public class KmsCallImpl implements kmsCall {

    final static String LIST_KEY_KMS = "direct:listKeys";
    final static String DESCRIBE_KEY_KMS = "direct:describeKey";

    private FluentProducerTemplate fluentProducerTemplate;

    @Inject
    public KmsCallImpl(FluentProducerTemplate fluentProducerTemplate) {
        this.fluentProducerTemplate = fluentProducerTemplate;
    }

    @Override
    public List<KmsDTO> listKeys() {

        ListKeysResponse listKeysResponse =
                GenericCamelTemplateProducer.getFluentProducerTemplateResponse(fluentProducerTemplate,LIST_KEY_KMS,
                        ListKeysResponse.class);

        return listKeysResponse.keys().stream().map(KmsDTO::convertToDto).collect(Collectors.toList());
    }

    @Override
    public KmsDescribeDTO describeKey() {
        DescribeKeyResponse describeKeyResponse =
                GenericCamelTemplateProducer.getFluentProducerTemplateResponse(fluentProducerTemplate,DESCRIBE_KEY_KMS,
                        DescribeKeyResponse.class);

        Stream<KeyMetadata> keyMetadataStream = Stream.of(describeKeyResponse.keyMetadata());
        return keyMetadataStream.map(KmsDescribeDTO::convertToDto).findFirst().orElse(null);
    }
}