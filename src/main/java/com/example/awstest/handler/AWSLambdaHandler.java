package com.example.awstest.handler;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringBootProxyHandlerBuilder;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.example.awstest.client.AWSTestApplication;
import com.example.awstest.model.MMTData;
import com.amazonaws.serverless.proxy.*;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
//import com.amazonaws.serverless.sample.spring.filter.CognitoIdentityFilter;
//import javax.servlet.DispatcherType;
//import javax.servlet.FilterRegistration;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.EnumSet;

public class AWSLambdaHandler implements RequestStreamHandler {
    private SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;

    public AWSLambdaHandler() throws ContainerInitializationException {
        handler = (SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse>) new SpringBootProxyHandlerBuilder()
                .springBootApplication(AWSTestApplication.class)
                .defaultProxy()
                .asyncInit()
                .buildAndInitialize();
    }

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context)
            throws IOException {
        handler.proxyStream(inputStream, outputStream, context);
    }
}

//public class AWSLambdaHandler implements RequestStreamHandler {
//    private static SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;
//    static {
//        try {
//            handler = SpringBootLambdaContainerHandler.getAwsProxyHandler(AWSTestApplication.class);
//        } catch (ContainerInitializationException e) {
//            // Re-throw the exception to force another cold start
//            e.printStackTrace();
//            throw new RuntimeException("Could not initialize Spring Boot application", e);
//        }
//    }
//    @Override
//    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
//        handler.proxyStream(inputStream, outputStream, context);
//        // just in case it wasn't closed by the mapper
//        outputStream.close();
//    }
//}