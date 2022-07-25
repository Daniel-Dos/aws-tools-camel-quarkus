package br.com.danieldias.aws.tools.camel.service;

import br.com.danieldias.aws.tools.camel.dto.rds.RdsDTO;

import java.util.List;

public interface RdsCall {
    public List<RdsDTO> describeDBInstances() throws Exception;
}
