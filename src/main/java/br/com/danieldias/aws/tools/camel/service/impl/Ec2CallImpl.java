package br.com.danieldias.aws.tools.camel.service.impl;


import br.com.danieldias.aws.tools.camel.dto.ec2.Ec2DTO;
import br.com.danieldias.aws.tools.camel.service.Ec2Call;
import br.com.danieldias.aws.tools.camel.util.GenericCamelTemplateProducer;
import org.apache.camel.FluentProducerTemplate;

import software.amazon.awssdk.services.ec2.model.DescribeInstancesResponse;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class Ec2CallImpl implements Ec2Call {

    final static String DESCRIBE_EC2 = "direct:describeInstances";

    private FluentProducerTemplate fluentProducerTemplate;

    @Inject
    public Ec2CallImpl(FluentProducerTemplate fluentProducerTemplate) {
        this.fluentProducerTemplate = fluentProducerTemplate;
    }

    @Override
    public Ec2DTO describeInstances() {

        DescribeInstancesResponse describeInstancesResponse =
                GenericCamelTemplateProducer.getFluentProducerTemplateResponse(fluentProducerTemplate,DESCRIBE_EC2,
                        DescribeInstancesResponse.class);

        return describeInstancesResponse.reservations().stream()
                                                       .map(Ec2DTO::convertToDto)
                                                       .findFirst()
                                                       .get();
    }
}
