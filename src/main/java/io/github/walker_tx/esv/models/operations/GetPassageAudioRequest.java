/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package io.github.walker_tx.esv.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.walker_tx.esv.utils.SpeakeasyMetadata;
import io.github.walker_tx.esv.utils.Utils;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

public class GetPassageAudioRequest {

    /**
     * Bible passage reference (e.g., "John 3:16" or "43011016")
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=q")
    private String query;

    @JsonCreator
    public GetPassageAudioRequest(
            String query) {
        Utils.checkNotNull(query, "query");
        this.query = query;
    }

    /**
     * Bible passage reference (e.g., "John 3:16" or "43011016")
     */
    @JsonIgnore
    public String query() {
        return query;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * Bible passage reference (e.g., "John 3:16" or "43011016")
     */
    public GetPassageAudioRequest withQuery(String query) {
        Utils.checkNotNull(query, "query");
        this.query = query;
        return this;
    }

    
    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetPassageAudioRequest other = (GetPassageAudioRequest) o;
        return 
            Objects.deepEquals(this.query, other.query);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            query);
    }
    
    @Override
    public String toString() {
        return Utils.toString(GetPassageAudioRequest.class,
                "query", query);
    }
    
    public final static class Builder {
 
        private String query;
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * Bible passage reference (e.g., "John 3:16" or "43011016")
         */
        public Builder query(String query) {
            Utils.checkNotNull(query, "query");
            this.query = query;
            return this;
        }
        
        public GetPassageAudioRequest build() {
            return new GetPassageAudioRequest(
                query);
        }
    }
}
