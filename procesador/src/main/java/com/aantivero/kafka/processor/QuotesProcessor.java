package com.aantivero.kafka.processor;

import java.util.Random;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import com.aantivero.kafka.entity.Stock;
import com.aantivero.kafka.model.Quote;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.smallrye.reactive.messaging.annotations.Blocking;

/**
 * A bean consuming data from the "quote-requests" Kafka topic (mapped to "requests" channel) and giving out a random quote.
 * The result is pushed to the "quotes" Kafka topic.
 */
@ApplicationScoped
public class QuotesProcessor {

    private Random random = new Random();

    @Incoming("requests")
    @Outgoing("quotes")
    @Blocking
    @Transactional
    public Quote process(String quoteRequest) throws InterruptedException {
        // simulate some hard working task
        Thread.sleep(200);
        Quote quote = new Quote(quoteRequest, random.nextInt(100));
        Stock stock = new Stock();
        stock.code = quote.id;
        stock.price = quote.price;
        stock.persist();
        return quote;
    }
}
