package br.com.danieldias.aws.tools.camel.service;

import br.com.danieldias.aws.tools.camel.dto.s3.S3ObjectDTO;

import java.util.List;

public interface S3Call {

    public List<String> listBuckets();
    public List<S3ObjectDTO> listObjects();
}
