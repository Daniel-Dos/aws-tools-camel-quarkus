package br.com.danieldias.aws.tools.camel.dto.ec2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import software.amazon.awssdk.services.ec2.model.Instance;
import software.amazon.awssdk.services.ec2.model.Reservation;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ec2DTO implements Serializable {

    private String imageId;
    private String instanceId;
    private String instanceType;
    private String keyName;
    private String platform;
    private String privateDnsName;
    private String privateIpAddress;
    private String publicDnsName;
    private String publicIpAddress;

    public static Ec2DTO convertToDto(Reservation reservation) {
        var returno = reservation.instances().stream()
                                             .map(Ec2DTO::getInstancetoDTO)
                                             .findFirst();
        return returno.orElse(null);

    }

    private static Ec2DTO getInstancetoDTO(Instance ec2) {

        return new Ec2DTO(ec2.imageId(),ec2.instanceId(),ec2.instanceTypeAsString(),ec2.keyName(),
                ec2.platformAsString(),ec2.privateDnsName(),ec2.privateIpAddress(),ec2.publicDnsName(),
                ec2.publicIpAddress());
    }
}
