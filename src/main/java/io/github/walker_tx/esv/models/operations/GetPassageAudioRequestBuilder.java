/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package io.github.walker_tx.esv.models.operations;

import static io.github.walker_tx.esv.operations.Operations.RequestOperation;

import io.github.walker_tx.esv.SDKConfiguration;
import io.github.walker_tx.esv.operations.GetPassageAudioOperation;
import io.github.walker_tx.esv.utils.Utils;
import java.lang.Exception;
import java.lang.String;

public class GetPassageAudioRequestBuilder {

    private String query;
    private final SDKConfiguration sdkConfiguration;

    public GetPassageAudioRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
    }

    public GetPassageAudioRequestBuilder query(String query) {
        Utils.checkNotNull(query, "query");
        this.query = query;
        return this;
    }


    private GetPassageAudioRequest buildRequest() {

        GetPassageAudioRequest request = new GetPassageAudioRequest(query);

        return request;
    }

    public GetPassageAudioResponse call() throws Exception {
        
        RequestOperation<GetPassageAudioRequest, GetPassageAudioResponse> operation
              = new GetPassageAudioOperation( sdkConfiguration);
        GetPassageAudioRequest request = buildRequest();

        return operation.handleResponse(operation.doRequest(request));
    }
}
