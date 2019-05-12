package com.app.tableserver.itemworkflow.model.requestresponse;


import com.app.tableserver.itemworkflow.ItemManager;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class SetEditItemRequest {

    //private final String itemId;

    public SetEditItemRequest(String itemId) {
    //    this.itemId = itemId;
    }
/*
    public String getItemId() {
        return itemId;
    }
*/
    public SetEditItemResponse process(ItemManager eventHandler) throws Exception{

        //call DB to get stuff

        List<String> items = new ArrayList<>();
        items.add("Bob");
        items.add("Jim");
        items.add("John");

        return new SetEditItemResponse(HttpStatus.OK, "completed request", items);
    }

    //Response
    public class SetEditItemResponse extends AbstractResponseEvent {

        private List<String> itemList;

        public SetEditItemResponse(HttpStatus httpStatus, String message
            , List<String> itemList) {
            super(httpStatus, message);

            this.itemList = itemList;
        }


    }
}
