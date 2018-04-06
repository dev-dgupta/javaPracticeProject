import com.google.gson.*;


import java.lang.reflect.Type;


import java.util.ArrayList;
import java.util.HashMap;

public class JSONExample {

    public static void main(String[] args) {

        String responseBody =
                "{\"status\":\"subscribed\",\"merges\":{\"EMAIL\":\"test@gmail.com\",\"FNAME\":\"Burton\",\"LNAME\":\"Rhodes\",\"DROPDWN\":\"Eggs\",\"GROUPINGS\":[{\"id\":4809,\"name\":\"MyGrouping\",\"groups\":\"Group1, Group2\"}]}}";


        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(SpecialHashMap.class, new SpecialHashMapDeserializer());
        Gson gson = gsonBuilder.create();
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse(responseBody).getAsJsonObject();

        EmailSubscriber emailSubscriber = gson.fromJson(jsonObject, EmailSubscriber.class);

        System.out.println(emailSubscriber);
    }


}


class EmailSubscriber {
    String status;
    // How can this handle mixed types??
    SpecialHashMap merges;
    // Getters & setters below...

    public String toString() {
        return ("Status: " + status + ", Merges: " + merges.toString());
    }
}

class Grouping {
    String id;
    String name;
    String groups;
    // Getters and setters below...

    public String toString() {
        return "Grouping: " + id + "  " + name + "  " + groups;

    }
}

class SpecialHashMap {

    HashMap<String, Object> m;

    SpecialHashMap(HashMap<String, Object> m) {
        this.m = m;

    }

    public HashMap get() {
        return m;

    }

    public String toString() {
        String s = "{";
        for (String s1 : m.keySet()) {
            if (s1.equals("GROUPINGS")) {
                s += "GROUPINGS: ";
                Grouping[] array = (Grouping[]) m.get(s1);
                for (Grouping g : array) {
                    s += g.toString();
                }
                s += " , ";
            } else
                s += s1 + ": " + m.get(s1) + " ,  ";


        }
        return s + "}";

    }
}

class SpecialHashMapDeserializer implements JsonDeserializer<SpecialHashMap> {
    public SpecialHashMap deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        ArrayList<Grouping> ar = new ArrayList<Grouping>();

        Gson gson = new Gson();
        SpecialHashMap shm = null;
        JsonObject jsonObject = (JsonObject) json;
        JsonPrimitive email = jsonObject.getAsJsonPrimitive("EMAIL");
        JsonPrimitive firstName = jsonObject.getAsJsonPrimitive("FNAME");
        JsonPrimitive lastName = jsonObject.getAsJsonPrimitive("LNAME");
        JsonPrimitive dropDwn = jsonObject.getAsJsonPrimitive("DROPDWN");
        JsonArray arr = jsonObject.getAsJsonArray("GROUPINGS");
        for (int j = 0; j < arr.size(); j++) {
            JsonElement jo = arr.get(j);
            Grouping g = gson.fromJson(jo, Grouping.class);
            ar.add(g);


        }

        Grouping[] array = new Grouping[ar.size()];
        for (int k = 0; k < ar.size(); k++) array[k] = ar.get(k);
        HashMap<String, Object> m = new HashMap<String, Object>();
        m.put("EMAIL", email.getAsString());
        m.put("FNAME", firstName.getAsString());
        m.put("LNAME", lastName.getAsString());
        m.put("GROUPINGS", array);


        shm = new SpecialHashMap(m);

        return shm;
    }


}