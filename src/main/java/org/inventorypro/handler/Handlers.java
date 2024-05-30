package org.inventorypro.handler;

import graphql.GraphQLError;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class Handlers {

    @GraphQlExceptionHandler({RuntimeException.class})
    public GraphQLError notFound(Exception ex){
        return GraphQLError.newError().message(ex.getMessage()).build();
    }
}
