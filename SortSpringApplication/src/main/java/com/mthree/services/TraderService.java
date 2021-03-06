package com.mthree.services;

import com.mthree.models.Consumers;
import com.mthree.models.Exchange;
import com.mthree.models.Trader;
import com.mthree.repositories.ExchangeRepository;
import com.mthree.repositories.TraderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TraderService {

    @Autowired
    private TraderRepository traderRepo;

    @Autowired
    private ExchangeRepository exchangeRepoTrader;

    Logger logger = LoggerFactory.getLogger(TraderService.class);

    public String createTraders(Trader t, String excId){
        Optional<Exchange> exchangeObject = exchangeRepoTrader.findById(excId);
        String message = "Failed to add Trader !!!";
        if(exchangeObject.isPresent()){
            Exchange exObject = exchangeObject.get();
            t.setExchange(exObject);
            traderRepo.save(t);
            message = "Successfully added Trader !!!";
        }
        logger.trace(message);
        return message;
    }
}
