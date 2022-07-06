package com.aantivero.kafka.resource;

import com.aantivero.kafka.entity.Stock;
import io.smallrye.common.annotation.Blocking;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("/stock")
public class StockResource {

    /**
     * We uses classic Hibernate, so the API is blocking, so we need to use @Blocking.
     * @return the list of prices
     */
    @GET
    @Blocking
    public List<Stock> getAllStock(){
        return Stock.listAll();
    }
}
