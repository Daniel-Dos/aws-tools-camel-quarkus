package br.com.danieldias.aws.tools.camel.service;



import br.com.danieldias.aws.tools.camel.dto.kms.KmsDTO;
import br.com.danieldias.aws.tools.camel.dto.kms.KmsDescribeDTO;

import java.util.List;

public interface kmsCall {

    public List<KmsDTO> listKeys();
    public KmsDescribeDTO describeKey();
}
