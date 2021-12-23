package com.order.config;

import java.io.IOException;
import java.io.Reader;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.CharStreams;
import com.order.exception.BusinessException;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.var;
@Component
public class ClientErrorDecoder implements ErrorDecoder {

	public Exception decode(String methodKey, Response response) {
	try {
	Reader reader = response.body().asReader();
	String result = CharStreams.toString(reader);
	reader.close();
	ObjectMapper mapper = new ObjectMapper();
	mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	final var error = mapper.readValue(result, BusinessException.class);
	return new BusinessException(error.getMessage());
	//return new BusinessException(error.getMessage());
	
	
	} catch (IOException ex) {
	//log.error(Constants.LOG_ERROR_DEFAULT_WITHOUT_HTTP_CODE, "decode", Constants.EXCEPTION, ex.getMessage(),
//	ex.getCause());
	}
	return new Default().decode(methodKey, response);
	}
	

}
