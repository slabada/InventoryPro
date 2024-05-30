package org.inventorypro.configuration;

import graphql.scalars.ExtendedScalars;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
public class GraphqlConfiguration {

    @Bean
    public RuntimeWiringConfigurer Long() {
        return w -> w.scalar(ExtendedScalars.GraphQLLong);
    }
}
