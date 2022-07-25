package br.com.danieldias.aws.tools.camel.service;

import br.com.danieldias.aws.tools.camel.dto.ecs.ClusterDTO;


import java.util.List;

public interface EcsCall {

   public List<String> listECS();
   public ClusterDTO describeCluster();
}
