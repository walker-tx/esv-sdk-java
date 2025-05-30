/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package io.github.walker_tx.esv;

import io.github.walker_tx.esv.utils.HTTPClient;
import io.github.walker_tx.esv.utils.RetryConfig;
import io.github.walker_tx.esv.utils.SpeakeasyHTTPClient;
import io.github.walker_tx.esv.utils.Utils;
import java.lang.String;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * ESV.org API: A convenient way to fetch content from ESV.org.
 * 
 * <p>The ESV API provides access to the ESV text, with a customizable presentation in  multiple formats.
 * 
 * <p>https://api.esv.org/ - ESV API Website
 */
public class Esv {


    /**
     * SERVERS contains the list of server urls available to the SDK.
     */
    public static final String[] SERVERS = {
        /**
         * Production server
         */
        "https://api.esv.org/v3/",
    };

    private final Passages passages;

    public Passages passages() {
        return passages;
    }

    private final SDKConfiguration sdkConfiguration;

    /**
     * The Builder class allows the configuration of a new instance of the SDK.
     */
    public static class Builder {

        private final SDKConfiguration sdkConfiguration = new SDKConfiguration();

        private Builder() {
        }

        /**
         * Allows the default HTTP client to be overridden with a custom implementation.
         *
         * @param client The HTTP client to use for all requests.
         * @return The builder instance.
         */
        public Builder client(HTTPClient client) {
            this.sdkConfiguration.defaultClient = client;
            return this;
        }
        /**
         * Configures the SDK security to use the provided secret.
         *
         * @param apiKey The secret to use for all requests.
         * @return The builder instance.
         */
        public Builder apiKey(String apiKey) {
            this.sdkConfiguration.securitySource = SecuritySource.of(io.github.walker_tx.esv.models.components.Security.builder()
              .apiKey(apiKey)
              .build());
            return this;
        }

        /**
         * Configures the SDK to use a custom security source.
         *
         * @param securitySource The security source to use for all requests.
         * @return The builder instance.
         */
        public Builder securitySource(SecuritySource securitySource) {
            this.sdkConfiguration.securitySource = securitySource;
            return this;
        }
        
        /**
         * Overrides the default server URL.
         *
         * @param serverUrl The server URL to use for all requests.
         * @return The builder instance.
         */
        public Builder serverURL(String serverUrl) {
            this.sdkConfiguration.serverUrl = serverUrl;
            return this;
        }

        /**
         * Overrides the default server URL  with a templated URL populated with the provided parameters.
         *
         * @param serverUrl The server URL to use for all requests.
         * @param params The parameters to use when templating the URL.
         * @return The builder instance.
         */
        public Builder serverURL(String serverUrl, Map<String, String> params) {
            this.sdkConfiguration.serverUrl = Utils.templateUrl(serverUrl, params);
            return this;
        }
        
        /**
         * Overrides the default server by index.
         *
         * @param serverIdx The server to use for all requests.
         * @return The builder instance.
         */
        public Builder serverIndex(int serverIdx) {
            this.sdkConfiguration.serverIdx = serverIdx;
            this.sdkConfiguration.serverUrl = SERVERS[serverIdx];
            return this;
        }
        
        /**
         * Overrides the default configuration for retries
         *
         * @param retryConfig The retry configuration to use for all requests.
         * @return The builder instance.
         */
        public Builder retryConfig(RetryConfig retryConfig) {
            this.sdkConfiguration.retryConfig = Optional.of(retryConfig);
            return this;
        }
        // Visible for testing, may be accessed via reflection in tests
        Builder _hooks(io.github.walker_tx.esv.utils.Hooks hooks) {
            sdkConfiguration.setHooks(hooks);  
            return this;  
        }
        
        // Visible for testing, may be accessed via reflection in tests
        Builder _hooks(Consumer<? super io.github.walker_tx.esv.utils.Hooks> consumer) {
            consumer.accept(sdkConfiguration.hooks());
            return this;    
        }
        
        /**
         * Builds a new instance of the SDK.
         *
         * @return The SDK instance.
         */
        public Esv build() {
            if (sdkConfiguration.defaultClient == null) {
                sdkConfiguration.defaultClient = new SpeakeasyHTTPClient();
            }
	        if (sdkConfiguration.securitySource == null) {
	    	    sdkConfiguration.securitySource = SecuritySource.of(null);
	        }
            if (sdkConfiguration.serverUrl == null || sdkConfiguration.serverUrl.isBlank()) {
                sdkConfiguration.serverUrl = SERVERS[0];
                sdkConfiguration.serverIdx = 0;
            }
            if (sdkConfiguration.serverUrl.endsWith("/")) {
                sdkConfiguration.serverUrl = sdkConfiguration.serverUrl.substring(0, sdkConfiguration.serverUrl.length() - 1);
            }
            return new Esv(sdkConfiguration);
        }
    }
    
    /**
     * Get a new instance of the SDK builder to configure a new instance of the SDK.
     *
     * @return The SDK builder instance.
     */
    public static Builder builder() {
        return new Builder();
    }

    private Esv(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
        this.passages = new Passages(sdkConfiguration);
        this.sdkConfiguration.initialize();
    }
}
