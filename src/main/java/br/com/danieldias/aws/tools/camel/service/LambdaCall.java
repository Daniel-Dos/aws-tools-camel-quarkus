package br.com.danieldias.aws.tools.camel.service;
import br.com.danieldias.aws.tools.camel.dto.lambda.FunctionConfigurationDTO;

import java.util.List;

public interface LambdaCall {

    public String invokeFunction(String funcao);
    public List<FunctionConfigurationDTO> listFunctions();
    public FunctionConfigurationDTO getFunction();
}
