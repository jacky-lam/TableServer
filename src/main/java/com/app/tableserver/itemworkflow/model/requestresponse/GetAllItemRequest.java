package com.app.tableserver.itemworkflow.model.requestresponse;


import com.app.tableserver.itemworkflow.ItemManager;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class GetAllItemRequest {

    public final String itemId;

    public GetAllItemRequest() {
        this.itemId = null;
    }

    public GetAllItemRequest(String itemId) {
        this.itemId = itemId;
    }

    public GetAllItemResponse process(ItemManager eventHandler) throws Exception{

        //call DB to get stuff
        List<String> items = new ArrayList<>();

        if(itemId == null){
            items.add("Bob");
            items.add("Jim");
            items.add("John");
        }
        else{
            items.add(itemId);
        }

        return new GetAllItemResponse(HttpStatus.OK, "completed request", items);
    }

    //Response
    public class GetAllItemResponse extends AbstractResponseEvent {

        public List<String> itemList;

        public GetAllItemResponse(HttpStatus httpStatus, String message
            , List<String> itemList) {
            super(httpStatus, message);

            this.itemList = itemList;
        }


    }
}
