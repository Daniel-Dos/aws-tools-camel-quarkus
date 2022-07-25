package br.com.danieldias.aws.tools.camel.dto.secretmanager;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import software.amazon.awssdk.services.secretsmanager.model.SecretListEntry;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SecretListEntryDTO implements Serializable {

    private String arn;
    private String name;
    private String description;
    private String kmsKeyId;

    public static SecretListEntryDTO convertToDto(SecretListEntry secretListEntry) {

        return new SecretListEntryDTO(secretListEntry.arn(),secretListEntry.name(),
                                      secretListEntry.description(),secretListEntry.kmsKeyId());
    }
}
