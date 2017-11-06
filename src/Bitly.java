import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

public class Bitly
{
    private final String ACCESS_TOKEN = "b67d63a8e7ca97f75c63254fda3a94d60ae60c2e";
    private JsonElement json;

    public Bitly(String longUrl)
    {

        try
        {
            // Encode the user-supplied data to neutralize any special chars
            String encodedURL = URLEncoder.encode(longUrl, "utf-8");

            // Construct API URL
            String apiURL = "https://api-ssl.bitly.com/v3/shorten?access_token=" +
                    ACCESS_TOKEN + "&longURL=" + encodedURL;

            // Create URL object
            URL bitlyURL = new URL(apiURL);

            // Create InputStream Object
            InputStream is = bitlyURL.openStream();

            // Create InputStreamReader
            InputStreamReader isr = new InputStreamReader(is);

            // Parse input stream into a JsonElement
            JsonParser parser = new JsonParser();
            json = parser.parse(isr);
        }
        catch (java.net.MalformedURLException mue)
        {
            System.out.println("Malformed URL");
        }
        catch (java.io.IOException ioe)
        {
            System.out.println("IO Error");
        }

    }

    /**
     * Returns the short Bitly URL
     */
    public String getShortUrl()
    {
        return json.getAsJsonObject().get("data").getAsJsonObject().get("url").getAsString();
    }

    /**
     * Returns the hash portion of the short URL
     */
    public String getHash()
    {
        return json.getAsJsonObject().get("data").getAsJsonObject().get("hash").getAsString();
    }

    public static void main(String[] args)
    {
        Bitly b = new Bitly("https://www.amazon.com/Ambient-Weather-WS-2902-Professional-Monitoring/dp/B01N5TEHLI/ref=sr_1_4?ie=UTF8&qid=1509390319&sr=8-4&keywords=weather+station");
        String shortened = b.getShortUrl();
        System.out.println(shortened);

        String hash = b.getHash();
        System.out.println(hash);
    }
}