package com.gokhantamkoc.javabootcamp.odevhafta3.repository;

import java.io.*;
import java.util.*;

import com.gokhantamkoc.javabootcamp.odevhafta3.model.Candle;
import com.gokhantamkoc.javabootcamp.odevhafta3.util.TimeUtils;

public class CryptoDataCSVRepository implements CSVRepository {

    private final String COMMA_DELIMITER = ",";

    @Override
    public List<Candle> readCSV(String filename) throws FileNotFoundException, IOException {
        List<Candle> candles = new ArrayList<Candle>();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(filename);
        // Bu alandan itibaren kodunuzu yazabilirsiniz


        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String line;
            br.readLine();// this will read the first line

            while ((line = br.readLine()) != null) {


                String[] attributes = line.split(COMMA_DELIMITER);

                //price candleStick data series, including day, high, low, open, close, volume
                Candle candle = new Candle(Long.parseLong(attributes[0]), (Double.parseDouble(attributes[3])), (Double.parseDouble(attributes[4])), (Double.parseDouble(attributes[5])), (Double.parseDouble(attributes[6])), (Double.parseDouble(attributes[7])));
                candles.add(candle);

            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        // Bu alandan sonra kalan kod'a dokunmayiniz.


        return candles;
    }
}
