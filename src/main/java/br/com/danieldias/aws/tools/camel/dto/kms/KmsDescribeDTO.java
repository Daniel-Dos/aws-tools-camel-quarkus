package br.com.danieldias.aws.tools.camel.dto.kms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import software.amazon.awssdk.services.kms.model.KeyMetadata;

import java.io.Serializable;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class KmsDescribeDTO implements Serializable {

    private String awsAccountId;
    private String keyId;
    private String arn;
    private Instant creationDate;
    private Boolean enabled;
    private String description;
    private String keyUsage;
    private String keyState;
    private String keyManager;
    private String keySpec;


    public static KmsDescribeDTO convertToDto(KeyMetadata keyMetadata) {
        return new KmsDescribeDTO(keyMetadata.awsAccountId(),keyMetadata.keyId(),keyMetadata.arn(),
                                  keyMetadata.creationDate(),keyMetadata.enabled(),keyMetadata.description(),
                                  keyMetadata.keyUsageAsString(),keyMetadata.keyStateAsString(),
                                  keyMetadata.keyManagerAsString(),keyMetadata.keySpecAsString());
    }
}
