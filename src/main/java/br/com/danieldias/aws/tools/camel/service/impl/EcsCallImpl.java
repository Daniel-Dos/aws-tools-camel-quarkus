package br.com.danieldias.aws.tools.camel.service.impl;


import br.com.danieldias.aws.tools.camel.dto.ecs.ClusterDTO;
import br.com.danieldias.aws.tools.camel.service.EcsCall;
import br.com.danieldias.aws.tools.camel.util.GenericCamelTemplateProducer;
import org.apache.camel.FluentProducerTemplate;

import software.amazon.awssdk.services.ecs.model.DescribeClustersResponse;
import software.amazon.awssdk.services.ecs.model.ListClustersResponse;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class EcsCallImpl implements EcsCall {

    final static String LIST_CLUSTERS_ECS ="direct:listClusters";
    final static String DESCRIBE_CLUSTER_ECS = "direct:describeCluster";

    private FluentProducerTemplate fluentProducerTemplate;

    @Inject
    public EcsCallImpl(FluentProducerTemplate fluentProducerTemplate) {
        this.fluentProducerTemplate = fluentProducerTemplate;
    }

    @Override
    public List<String> listECS() {

        ListClustersResponse listClustersResponse =
             GenericCamelTemplateProducer.getFluentProducerTemplateResponse(fluentProducerTemplate,LIST_CLUSTERS_ECS,
                                                                            ListClustersResponse.class);
        return listClustersResponse.clusterArns();
    }

    @Override
    public ClusterDTO describeCluster() {

        DescribeClustersResponse describeClustersResponse =
            GenericCamelTemplateProducer.getFluentProducerTemplateResponse(fluentProducerTemplate,DESCRIBE_CLUSTER_ECS,
                                                                           DescribeClustersResponse.class);

        return describeClustersResponse.clusters().stream()
                                                  .map(ClusterDTO::convertToDto)
                                                  .findFirst()
                                                  .orElse(null);
    }
}