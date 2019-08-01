package com.vimeo.networking.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.Override;
import java.lang.SuppressWarnings;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class Document$TypeAdapter extends TypeAdapter<Document> {
  public static final TypeToken<Document> TYPE_TOKEN = TypeToken.get(com.vimeo.networking.model.Document.class);

  private final Gson mGson;

  public Document$TypeAdapter(Gson gson) {
    this.mGson = gson;
  }

  @Override
  public void write(JsonWriter writer, Document object) throws IOException {
    if (object == null) {
      writer.nullValue();
      return;
    }
    writer.beginObject();

    writer.name("html");
    if (object.html != null)  {
      com.google.gson.internal.bind.TypeAdapters.STRING.write(writer, object.html);
    }
    else {
      writer.nullValue();
    }

    writer.endObject();
  }

  @Override
  public Document read(JsonReader reader) throws IOException {
    com.google.gson.stream.JsonToken peek = reader.peek();
    if (com.google.gson.stream.JsonToken.NULL == peek) {
      reader.nextNull();
      return null;
    }
    if (com.google.gson.stream.JsonToken.BEGIN_OBJECT != peek) {
      reader.skipValue();
      return null;
    }
    reader.beginObject();
    com.vimeo.networking.model.Document object = new com.vimeo.networking.model.Document();
    while (reader.hasNext()) {
      String name = reader.nextName();
      switch (name) {
        case "html":
        	object.html = com.google.gson.internal.bind.TypeAdapters.STRING.read(reader);
        	break;
        default:
        reader.skipValue();
        break;
      }
    }
    reader.endObject();
    return object;
  }
}
