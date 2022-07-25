package br.com.danieldias.aws.tools.camel.router;

import org.apache.camel.builder.RouteBuilder;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import software.amazon.awssdk.services.lambda.model.GetFunctionRequest;
import software.amazon.awssdk.services.lambda.model.ListFunctionsRequest;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LambdaCamel extends RouteBuilder {

    @ConfigProperty(name = "name.function")
    private String nomeFuncao;

    @Override
    public void configure() throws Exception {

        ListFunctionsRequest.Builder builder = ListFunctionsRequest.builder();

        from("direct:invokeFunction").process(exchange ->
                exchange.getIn()
                        .setBody(exchange.getIn().getBody().toString()))
                .to("aws2-lambda://"+nomeFuncao+"?operation=invokeFunction");

        from("direct:listFunctions")
                .process(exchange -> exchange.getIn().setBody(ListFunctionsRequest.builder().maxItems(10).build()))
                .to("aws2-lambda://"+nomeFuncao+"?operation=listFunctions&pojoRequest=true");

        from("direct:getFunction")
                .process(exchange -> exchange.getIn().setBody(GetFunctionRequest.builder().functionName(nomeFuncao)
                                                                                          .build()))
                .to("aws2-lambda://"+nomeFuncao+"?operation=getFunction&pojoRequest=true");
    }
}
