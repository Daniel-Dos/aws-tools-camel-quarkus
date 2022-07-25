package br.com.danieldias.aws.tools.camel.dto.rds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import software.amazon.awssdk.services.rds.model.Endpoint;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EndpointDTO implements Serializable  {

    private String address;
    private Integer port;
    private String hostedZoneId;

    public static EndpointDTO convertToDto(Endpoint endpoint) {

        return new EndpointDTO(endpoint.address(),endpoint.port(),endpoint.hostedZoneId());
    }
}
