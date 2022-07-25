package br.com.danieldias.aws.tools.camel.router;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.aws2.ecs.ECS2Constants;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import software.amazon.awssdk.services.ecs.model.DescribeClustersRequest;
import software.amazon.awssdk.services.ecs.model.ListClustersRequest;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EcsCamel extends RouteBuilder {

    @ConfigProperty(name = "name.label")
    private String label;

    @ConfigProperty(name = "cluster.name")
    private String clusterName;

    @Override
    public void configure() throws Exception {

        from("direct:listClusters")
                .process(exchange ->  exchange.getIn().setBody(ListClustersRequest.builder().maxResults(10).build()))
                .to("aws2-ecs:/"+label+"?ecsClient=#amazonEcsClient&operation=listClusters&pojoRequest=true");

        from("direct:describeCluster")
                .process(exchange -> {
                         exchange.getIn().setHeader(ECS2Constants.CLUSTER_NAME, clusterName);
                         exchange.getIn().setBody(DescribeClustersRequest.builder().build());})
                .to("aws2-ecs://"+label+"?ecsClient=#amazonEcsClient&operation=describeCluster");

    }
}
