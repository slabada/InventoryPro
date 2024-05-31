package org.inventorypro.handler;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class Handlers {

    @GraphQlExceptionHandler({Exception.class})
    public GraphQLError globalHandlers(Exception ex){
        return GraphQLError.newError()
                .message(ex.getMessage())
                .build();
    }
}
