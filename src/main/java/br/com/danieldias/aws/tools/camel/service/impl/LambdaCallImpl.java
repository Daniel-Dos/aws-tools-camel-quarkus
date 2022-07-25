package br.com.danieldias.aws.tools.camel.service.impl;

import br.com.danieldias.aws.tools.camel.dto.lambda.FunctionConfigurationDTO;
import br.com.danieldias.aws.tools.camel.service.LambdaCall;
import br.com.danieldias.aws.tools.camel.util.GenericCamelTemplateProducer;
import org.apache.camel.FluentProducerTemplate;
import software.amazon.awssdk.services.lambda.model.GetFunctionResponse;
import software.amazon.awssdk.services.lambda.model.ListFunctionsResponse;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class LambdaCallImpl implements LambdaCall {

    final static String INVOKE_FUNCTION_LAMBDA ="direct:invokeFunction";
    final static String LIST_FUNCTIONS_LAMBDA = "direct:listFunctions";
    final static String GET_FUNCTIONS_LAMBDA = "direct:getFunction";

    FluentProducerTemplate fluentProducerTemplate;

    @Inject
    public LambdaCallImpl(FluentProducerTemplate fluentProducerTemplate) {
        this.fluentProducerTemplate = fluentProducerTemplate;
    }

    @Override
    public String invokeFunction(String funcao) {
          return fluentProducerTemplate.to(INVOKE_FUNCTION_LAMBDA)
                                       .withBody(funcao)
                                       .request(String.class);
        }

    @Override
    public List<FunctionConfigurationDTO> listFunctions() {

        ListFunctionsResponse listFunctions =
                GenericCamelTemplateProducer.getFluentProducerTemplateResponse(fluentProducerTemplate,
                                                                               LIST_FUNCTIONS_LAMBDA,
                                                                          ListFunctionsResponse.class);

        return  listFunctions.functions().stream()
                                         .map(FunctionConfigurationDTO::convertToDto)
                                         .collect(Collectors.toList());
    }

    @Override
    public FunctionConfigurationDTO getFunction() {

        GetFunctionResponse getFunctionResponse =
                GenericCamelTemplateProducer.getFluentProducerTemplateResponse(fluentProducerTemplate,
                                                                               GET_FUNCTIONS_LAMBDA,
                                                                               GetFunctionResponse.class);
        return FunctionConfigurationDTO.convertToDto(getFunctionResponse.configuration());
    }
}