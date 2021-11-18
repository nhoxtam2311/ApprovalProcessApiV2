package com.iu.approval.api.graphql

import java.text.ParseException

import org.springframework.stereotype.Component

import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.JsonMappingException
import com.fasterxml.jackson.databind.ObjectMapper

import graphql.language.StringValue
import graphql.schema.Coercing
import graphql.schema.CoercingParseLiteralException
import graphql.schema.CoercingParseValueException
import graphql.schema.CoercingSerializeException
import graphql.schema.GraphQLScalarType

@Component
class DateTimeScalar extends GraphQLScalarType {
	public DateTimeScalar() {
		super("Date", "Compliant DateTime Scalar", new Coercing<Date, String>() {
			@Override
			public String serialize(Object dataFetcherResult) throws CoercingSerializeException {
				ObjectMapper mapper = new ObjectMapper()
				if(dataFetcherResult == null) {
					return ""
				}
				if(dataFetcherResult instanceof Date) {
					return mapper.getDateFormat().format((Date)dataFetcherResult)
				}
				else {
					throw new CoercingSerializeException(
					"Expected a 'String' or 'java.util.Date' but was '" + typeName(input) + "'."
					)
				}
			}

			@Override
			public Date parseValue(Object input) throws CoercingParseValueException {
				ObjectMapper mapper = new ObjectMapper()
				if(input == null) {
					return null
				}
				if(input instanceof String) {
					if(((String)dataFetcherResult).isEmpty()) {
						return null
					}
					return mapper.getDateFormat().parse((String)input)
				}else if(input instanceof Date) {
					return (Date)input
				}
				else {
					throw new CoercingSerializeException(
					"Expected a 'String' or 'java.util.Date' but was '" + typeName(input) + "'."
					)
				}
			}

			@Override
			public Date parseLiteral(Object input) throws CoercingParseLiteralException {
				if (!(input instanceof StringValue)) {
					throw new CoercingParseLiteralException(
					"Expected a 'StringValue' but was '" + typeName(input) + "'."
					)
				}

				if(((StringValue)input).getValue().isEmpty()) {
					return null
				}
				ObjectMapper mapper = new ObjectMapper()
				try {
					return mapper.getDateFormat().parse(((StringValue) input).getValue())
				}catch (ParseException e) {
					throw new CoercingParseLiteralException(
					"Invalid value : '" + ((StringValue) input).getValue() + "'. because of : '" + e.getMessage() + "'"
					)
				}
			}
		})
	}
}