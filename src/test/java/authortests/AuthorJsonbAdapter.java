package authortests;

import com.ibm.authors.Author;

// JSON-Binding
import javax.json.bind.adapter.JsonbAdapter;
import javax.json.JsonObject;
import javax.json.Json;

public class AuthorJsonbAdapter implements JsonbAdapter<Author, JsonObject> {
 
    @Override
    public JsonObject adaptToJson(final Author author) throws Exception {
        return Json.createObjectBuilder()
        .add("blog", author.getBlog())
        .add("name", author.getName())
        .add("pages", author.getTwitter()).build();
    }

    @Override
    public Author adaptFromJson(final JsonObject jsonObject) throws Exception {
        final Author author = new Author();
        author.setBlog(jsonObject.getString("blog"));
        author.setName(jsonObject.getString("name"));
        author.setTwitter(jsonObject.getString("twitter"));
        return author;
    }
}