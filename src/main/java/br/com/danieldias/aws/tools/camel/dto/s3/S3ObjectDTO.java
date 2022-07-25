package br.com.danieldias.aws.tools.camel.dto.s3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import software.amazon.awssdk.services.s3.model.S3Object;

import javax.json.bind.annotation.JsonbProperty;
import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class S3ObjectDTO implements Serializable {

    @JsonbProperty("key")
    private String key;
    @JsonbProperty("lastModified")
    private Instant lastModified;
    @JsonbProperty("eTag")
    private String eTag;
    @JsonbProperty("size")
    private Long size;
    @JsonbProperty("storageClass")
    private String storageClass;
    @JsonbProperty("ownerDisplayName")
    private String ownerDisplayName;

    public static S3ObjectDTO convertToDto(S3Object bucketObjetos) {

        return new S3ObjectDTO(bucketObjetos.key(),bucketObjetos.lastModified(),
                bucketObjetos.eTag(), bucketObjetos.size(),
                bucketObjetos.storageClassAsString(),bucketObjetos.owner().displayName());
    }
}
