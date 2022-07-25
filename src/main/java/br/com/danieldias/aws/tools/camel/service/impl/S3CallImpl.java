package br.com.danieldias.aws.tools.camel.service.impl;


import br.com.danieldias.aws.tools.camel.dto.s3.S3ObjectDTO;
import br.com.danieldias.aws.tools.camel.service.S3Call;
import br.com.danieldias.aws.tools.camel.util.GenericCamelTemplateProducer;
import org.apache.camel.FluentProducerTemplate;

import software.amazon.awssdk.services.s3.model.Bucket;
import software.amazon.awssdk.services.s3.model.S3Object;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class S3CallImpl implements S3Call {

    final static String List_BUCKETS_S3 = "direct:listBuckets";
    final static String LIST_OBJETCTS_S3 = "direct:listObjects";

    private FluentProducerTemplate fluentProducerTemplate;

    @Inject
    public S3CallImpl(FluentProducerTemplate fluentProducerTemplate) {
        this.fluentProducerTemplate = fluentProducerTemplate;
    }

    @Override
    public List<String> listBuckets() {

        List<Bucket> listBuckets =
                GenericCamelTemplateProducer.getFluentProducerTemplateResponse(fluentProducerTemplate,List_BUCKETS_S3,
                        List.class);

        return listBuckets.stream().map(Bucket::name).collect(Collectors.toList());
    }

    @Override
    public List<S3ObjectDTO> listObjects() {

        List<S3Object> listObjects =
                GenericCamelTemplateProducer.getFluentProducerTemplateResponse(fluentProducerTemplate,LIST_OBJETCTS_S3,
                        List.class);

        return listObjects.stream().map(S3ObjectDTO::convertToDto).collect(Collectors.toList());
    }
}
