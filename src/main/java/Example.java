import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.elasticsearch.action.index.IndexRequest;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Example {
    public static void indexTweets() {
        try {
            /* File file = new File("data/covid19_tweets.csv");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            StringBuffer sb = new StringBuffer();

            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }*/

            Reader in = new FileReader("data/covid19_tweets.csv");
            Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
            int i = 0;

            for (CSVRecord record : records) {


                Map<String, Object> jsonMap = new HashMap<>();
                jsonMap.put("userName", record.get(0));
                jsonMap.put("userLocation", record.get(1));

                jsonMap.put("userDescription", record.get(2));
                jsonMap.put("userCreated", record.get(3));
                jsonMap.put("userFollowers", record.get(4));
                jsonMap.put("userFriends", record.get(5));
                jsonMap.put("userFavourites", record.get(6));
                jsonMap.put("isVerified", Boolean.parseBoolean(record.get(7)));
                jsonMap.put("date", record.get(8));
                jsonMap.put("text", record.get(9));
                jsonMap.put("hashtags", record.get(10));
                jsonMap.put("source", record.get(11));
                jsonMap.put("isRetweet", Boolean.parseBoolean(record.get(12)));

                IndexRequest indexRequest = new IndexRequest("covid").id(i + "").source(jsonMap);

                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        indexTweets();
    }
}
