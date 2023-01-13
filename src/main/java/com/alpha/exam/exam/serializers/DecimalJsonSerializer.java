package com.alpha.exam.exam.serializers;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class DecimalJsonSerializer extends JsonSerializer<Double> {
  @Override
  public void serialize(Double value, JsonGenerator jgen, SerializerProvider provider)
          throws IOException, JsonProcessingException {
      // jgen.writeString( String.format("%.6f", value));
      jgen.writeNumber(BigDecimal.valueOf(value).setScale(6, RoundingMode.FLOOR ));
  }
}