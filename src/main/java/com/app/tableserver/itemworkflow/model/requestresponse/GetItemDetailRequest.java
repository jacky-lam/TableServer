package com.app.tableserver.itemworkflow.model.requestresponse;

import com.app.tableserver.itemworkflow.ItemManager;
import org.springframework.http.HttpStatus;

public class GetItemDetailRequest {

    public GetItemDetailRequest(){

    }

    public GetItemDetailResponse process(ItemManager handler){

        return new GetItemDetailResponse(HttpStatus.OK, "Completed item detail request");
    }

    public class GetItemDetailResponse extends AbstractResponseEvent{

        public GetItemDetailResponse(HttpStatus httpStatus, String message) {
            super(httpStatus, message);
        }
    }
}
