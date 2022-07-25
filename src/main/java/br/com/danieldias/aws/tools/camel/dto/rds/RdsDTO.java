package br.com.danieldias.aws.tools.camel.dto.rds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import software.amazon.awssdk.services.rds.model.DBInstance;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RdsDTO implements Serializable  {

    private String dbInstanceIdentifier;
    private String dbInstanceClass;
    private String engine;
    private String dbInstanceStatus;
    private String dbName;
    private EndpointDTO endpoint;
    private Boolean multiAZ;
    private String engineVersion;
    private String storageType;
    private Integer dbInstancePort;
    private String dbClusterIdentifier;
    private Boolean storageEncrypted;
    private String kmsKeyId;
    private String dbiResourceId;
    private String dbInstanceArn;


    public static RdsDTO convertToDto(DBInstance dBInstance) {

        return new RdsDTO(dBInstance.dbInstanceIdentifier(),dBInstance.dbInstanceClass(),
                          dBInstance.engine(),dBInstance.dbInstanceStatus(),dBInstance.dbName(),
                          EndpointDTO.convertToDto(dBInstance.endpoint()),dBInstance.multiAZ(),
                          dBInstance.engineVersion(),dBInstance.storageType(),
                          dBInstance.dbInstancePort(),dBInstance.dbClusterIdentifier(),dBInstance.storageEncrypted(),
                          dBInstance.kmsKeyId(), dBInstance.dbiResourceId(), dBInstance.dbInstanceArn());
    }
}
