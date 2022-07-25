package br.com.danieldias.aws.tools.camel.dto.kms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import software.amazon.awssdk.services.kms.model.KeyListEntry;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class KmsDTO implements Serializable {

    private String keyId;
    private String keyArn;

    public static KmsDTO convertToDto(KeyListEntry keyListEntry) {
        return new KmsDTO(keyListEntry.keyId(),keyListEntry.keyArn());
    }
}
