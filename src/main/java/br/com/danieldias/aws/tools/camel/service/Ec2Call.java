package br.com.danieldias.aws.tools.camel.service;


import br.com.danieldias.aws.tools.camel.dto.ec2.Ec2DTO;

public interface Ec2Call {

    public Ec2DTO describeInstances();
}
