package br.com.danieldias.aws.tools.camel.service.impl;



import br.com.danieldias.aws.tools.camel.dto.rds.RdsDTO;
import br.com.danieldias.aws.tools.camel.service.RdsCall;
import software.amazon.awssdk.services.rds.RdsClient;
import software.amazon.awssdk.services.rds.model.DBInstance;
import software.amazon.awssdk.services.rds.model.DescribeDbInstancesResponse;
import software.amazon.awssdk.services.rds.model.RdsException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class RdsCallImpl implements RdsCall {

    private RdsClient rdsClient;

    @Inject
    public RdsCallImpl(RdsClient rdsClient) {
        this.rdsClient = rdsClient;
    }

    @Override
    public List<RdsDTO> describeDBInstances() throws Exception {

        try {
            DescribeDbInstancesResponse response = rdsClient.describeDBInstances();
            List<DBInstance> instanceList = response.dbInstances();

            return instanceList.stream().map(RdsDTO::convertToDto).collect(Collectors.toList());

        } catch (RdsException e) {
            throw new Exception(e.getMessage());

        }
    }
}

