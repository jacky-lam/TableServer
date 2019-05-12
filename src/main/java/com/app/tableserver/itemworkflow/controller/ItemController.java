package com.app.tableserver.itemworkflow.controller;

import com.app.tableserver.itemworkflow.ItemManager;
import com.app.tableserver.itemworkflow.model.requestresponse.*;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/*
*
* Controller handling all APIs related to items
*
* */
@RestController("ItemController")
@RequestMapping("/api")
public class ItemController {

    public final static Logger logger = Logger.getLogger(ItemController.class);

    @Resource(name="ItemManager")
    ItemManager eventHandler;

    //@CrossOrigin(origins = "http://localhost:8081") //testing COR
    @GetMapping(value = "/getAllItem", produces = "application/json")
    public AbstractResponseEvent getAllItemRequest() {
        return getAllItemRequest(null);
    }

    @GetMapping(value = "/getAllItem/{itemId}", produces = "application/json")
    public AbstractResponseEvent getAllItemRequest(@Valid @PathVariable String itemId) {
        try {
            GetAllItemRequest request = new GetAllItemRequest(itemId); //parse into self-dispatch request object
            return request.process(eventHandler);
        }
        catch(Exception e) {
            String erMsg = "Problem occurred on server. Error: " + e.getMessage();
            logger.error(erMsg, e);
            return new ErrorExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR, erMsg);
        }
    }


    @GetMapping(value = "/getItemDetail/{itemId}", produces = "application/json")
    public AbstractResponseEvent getItemDetailRequest(@Valid @PathVariable String itemId
            , @RequestParam("field1") String field1
            , @RequestParam("field2") String field2
        ) {
        try {
            logger.info("Retrieved getItemDetail, field1: " + field1 + ", field:" + field2);
            GetItemDetailRequest request = new GetItemDetailRequest();
            return request.process(eventHandler);
        }
        catch(Exception e) {
            String erMsg = "Problem occurred on server. Error: " + e.getMessage();
            logger.error(erMsg, e);
            return new ErrorExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR, erMsg);
        }
    }
}
