package br.com.danieldias.aws.tools.camel.dto.ecs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import software.amazon.awssdk.services.ecs.model.Cluster;

import javax.json.bind.annotation.JsonbProperty;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClusterDTO implements Serializable {

    @JsonbProperty("ClusterArn")
    private String clusterArn;

    @JsonbProperty("ClusterName")
    private String clusterName;

    @JsonbProperty("Status")
    private String status;

    @JsonbProperty("RegisteredContainerInstancesCount")
    private int registeredContainerInstancesCount;

    @JsonbProperty("RunningTasksCount")
    private int runningTasksCount;

    @JsonbProperty("PendingTasksCount")
    private int pendingTasksCount;

    @JsonbProperty("ActiveServicesCount")
    private int activeServicesCount;

    public static ClusterDTO convertToDto(Cluster cluster) {

        return new ClusterDTO(cluster.clusterArn(),cluster.clusterName(), cluster.status(),
                cluster.registeredContainerInstancesCount(), cluster.runningTasksCount(),
                cluster.pendingTasksCount(),cluster.activeServicesCount());
    }

}
