package com.gokhantamkoc.javabootcamp.odevhafta3.service;

import com.gokhantamkoc.javabootcamp.odevhafta3.model.Candle;
import com.gokhantamkoc.javabootcamp.odevhafta3.repository.CSVRepository;
import com.gokhantamkoc.javabootcamp.odevhafta3.util.chart.CandleStickChart;

import java.io.IOException;
import java.util.List;

public class ChartService {

    CSVRepository cryptoDataCSVRepository;

    public ChartService(CSVRepository cryptoDataCSVRepository) {
        this.cryptoDataCSVRepository = cryptoDataCSVRepository;
    }

    public CandleStickChart createChartFromCryptoData() {
        // Bu metodu doldurmanizi bekliyoruz.

        //create an CandleStickChart with the desired title.
        CandleStickChart c1 = new CandleStickChart("BTC/USDT Chart");

        List<Candle> candles = null;
        // read to .csv file
        try {
            candles = this.cryptoDataCSVRepository.readCSV("Binance_BTCUSDT_d.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Use the necessary data for CandleStickChart.
        for (Candle candle : candles) {
            c1.addCandle(candle.getTime(), candle.getOpen(), candle.getHigh(), candle.getLow(), candle.getClose(), candle.getVolume());
        }

        return c1;
    }
}
