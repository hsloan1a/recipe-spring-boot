package com.recipeexample.demo.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.node.TextNode;
import com.recipeexample.demo.model.AmountCatagory;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class AmountCatagorySerializer {
    public static class AmountCatagoryJsonSerializer extends JsonSerializer<AmountCatagory> {

        @Override
        public void serialize(AmountCatagory amountCatagory, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeString(amountCatagory.name());
        }
    }

    public static class AmountCatagoryJsonDeserializer extends JsonDeserializer<AmountCatagory> {

        @Override
        public AmountCatagory deserialize(JsonParser jsonParser,
                                          DeserializationContext deserializationContext)
                throws IOException {

            TreeNode treeNode = jsonParser.getCodec().readTree(jsonParser);
            return AmountCatagory.fromValue(((TextNode) treeNode).asText());
        }
    }
}
