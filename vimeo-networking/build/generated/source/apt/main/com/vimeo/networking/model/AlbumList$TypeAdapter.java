package com.vimeo.networking.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.Override;
import java.lang.SuppressWarnings;
import java.util.ArrayList;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AlbumList$TypeAdapter extends TypeAdapter<AlbumList> {
  public static final TypeToken<AlbumList> TYPE_TOKEN = TypeToken.get(com.vimeo.networking.model.AlbumList.class);

  private final Gson mGson;

  private final TypeAdapter<Paging> mTypeAdapter0;

  private final TypeAdapter<Album> mTypeAdapter1;

  private final TypeAdapter<ArrayList<Album>> mTypeAdapter2;

  public AlbumList$TypeAdapter(Gson gson) {
    this.mGson = gson;
    this.mTypeAdapter0 = gson.getAdapter(com.vimeo.networking.model.Paging$TypeAdapter.TYPE_TOKEN);
    this.mTypeAdapter1 = gson.getAdapter(com.vimeo.networking.model.Album$TypeAdapter.TYPE_TOKEN);
    this.mTypeAdapter2 = new com.vimeo.stag.KnownTypeAdapters.ListTypeAdapter<com.vimeo.networking.model.Album,java.util.ArrayList<com.vimeo.networking.model.Album>>(mTypeAdapter1, new com.vimeo.stag.KnownTypeAdapters.ArrayListInstantiator<com.vimeo.networking.model.Album>());
  }

  @Override
  public void write(JsonWriter writer, AlbumList object) throws IOException {
    if (object == null) {
      writer.nullValue();
      return;
    }
    writer.beginObject();

    writer.name("total");
    writer.value(object.getTotal());

    writer.name("page");
    writer.value(object.getPage());

    writer.name("per_page");
    writer.value(object.getPerPage());

    writer.name("paging");
    if (object.getPaging() != null)  {
      mTypeAdapter0.write(writer, object.getPaging());
    }
    else {
      writer.nullValue();
    }

    writer.name("data");
    if (object.getData() != null)  {
      mTypeAdapter2.write(writer, object.getData());
    }
    else {
      writer.nullValue();
    }

    writer.endObject();
  }

  @Override
  public AlbumList read(JsonReader reader) throws IOException {
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
    com.vimeo.networking.model.AlbumList object = new com.vimeo.networking.model.AlbumList();
    while (reader.hasNext()) {
      String name = reader.nextName();
      switch (name) {
        case "total":
        	object.setTotal(com.vimeo.stag.KnownTypeAdapters.PrimitiveIntTypeAdapter.read(reader, object.getTotal()));
        	break;
        case "page":
        	object.setPage(com.vimeo.stag.KnownTypeAdapters.PrimitiveIntTypeAdapter.read(reader, object.getPage()));
        	break;
        case "per_page":
        	object.setPerPage(com.vimeo.stag.KnownTypeAdapters.PrimitiveIntTypeAdapter.read(reader, object.getPerPage()));
        	break;
        case "paging":
        	object.setPaging(mTypeAdapter0.read(reader));
        	break;
        case "data":
        	object.setData(mTypeAdapter2.read(reader));
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
