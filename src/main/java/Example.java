import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;

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
            for (CSVRecord record : records) {
                String userName = record.get(0);
                String userLocation = record.get(1);
                String userDescription = record.get(2);
                String userCreated = record.get(3);
                String userFollowers = record.get(4);
                String userFriends = record.get(5);
                String userFavourites = record.get(6);
                boolean isVerified = Boolean.parseBoolean(record.get(7));
                String date = record.get(8);
                String text = record.get(9);
                String hashtags = record.get(10);
                String source = record.get(11);
                boolean isRetweet = Boolean.parseBoolean(record.get(12));

                System.out.println(userFollowers);
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        indexTweets();
    }
}
