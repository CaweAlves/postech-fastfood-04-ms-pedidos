package org.fiap.fastfoodpedidos.infrastructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

import java.net.URI;

@Configuration
public class SqsConfig {

  @Value("${spring.cloud.aws.endpoint}")
  private String endpoint;

  @Value("${spring.cloud.aws.region.static}")
  private String region;

  @Value("${spring.cloud.aws.credentials.access-key}")
  private String accessKey;

  @Value("${spring.cloud.aws.credentials.secret-key}")
  private String secretKey;

  @Value("${spring.cloud.aws.credentials.session-token}")
  private String sessionToken;

  @Bean
  public SqsAsyncClient sqsAsyncClient() {
    var builder =
        SqsAsyncClient.builder()
            .region(Region.of(region))
            .credentialsProvider(
                StaticCredentialsProvider.create(
                    AwsSessionCredentials.create(accessKey, secretKey, sessionToken)));

    if (endpoint != null && !endpoint.isBlank()) {
      builder.endpointOverride(URI.create(endpoint));
    }

    return builder.build();
  }
}
