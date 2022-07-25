package br.com.danieldias.aws.tools.camel.client;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ecs.EcsClient;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.awssdk.services.lambda.LambdaClient;
import software.amazon.awssdk.services.rds.RdsClient;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
public class AWSClients {

    private final Region saoPaulo = Region.SA_EAST_1;

    @Named("amazonEcsClient")
    public EcsClient amazonEcsClient() {
        return EcsClient.builder()
                .region(saoPaulo)
                .build();
    }

    @Named("amazonS3Client")
    public S3Client amazonS3Client() {
        return S3Client.builder()
                       .region(saoPaulo)
                       .build();
    }

    @Named("amazonEc2Client")
    public Ec2Client amazonEc2Client() {
        return Ec2Client.builder()
                .region(saoPaulo)
                .build();
    }

    @Named("amazonRdsClient")
    public RdsClient amazonRdsClient() {
        return RdsClient.builder()
                .region(saoPaulo)
                .build();
    }

    @Named("amazonLambdaClient")
    public LambdaClient amazonLambdaClient() {
        return LambdaClient.builder()
                .region(saoPaulo)
                .build();
    }

    @Named("amazonKmsClient")
    public KmsClient amazonKmsClient() {
        return KmsClient.builder()
                .region(saoPaulo)
                .build();
    }

    @Named("amazonSecretsManagerClient")
    public SecretsManagerClient amazonSecretsManagerClient() {
        return SecretsManagerClient.builder()
                .region(saoPaulo)
                .build();
    }
}
