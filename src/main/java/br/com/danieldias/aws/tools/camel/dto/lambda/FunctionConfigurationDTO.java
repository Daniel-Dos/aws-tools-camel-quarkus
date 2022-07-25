package br.com.danieldias.aws.tools.camel.dto.lambda;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import software.amazon.awssdk.services.lambda.model.FunctionConfiguration;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FunctionConfigurationDTO implements Serializable {

    private String functionName;

    private String functionArn;

    private String runtime;

    private String description;

    private String state;

    private List<String> architectures;

    public static FunctionConfigurationDTO convertToDto(FunctionConfiguration functionConfiguration) {

        return new FunctionConfigurationDTO(functionConfiguration.functionName(),functionConfiguration.functionArn(),
                                            functionConfiguration.runtimeAsString(), functionConfiguration.description(),
                                            functionConfiguration.stateAsString(),
                                            functionConfiguration.architecturesAsStrings());
    }
}
