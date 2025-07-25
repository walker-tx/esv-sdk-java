# openapi

Developer-friendly & type-safe Java SDK specifically catered to leverage *openapi* API.

<div align="left">
    <a href="https://www.speakeasy.com/?utm_source=openapi&utm_campaign=java"><img src="https://custom-icon-badges.demolab.com/badge/-Built%20By%20Speakeasy-212015?style=for-the-badge&logoColor=FBE331&logo=speakeasy&labelColor=545454" /></a>
    <a href="https://mit-license.org/">
        <img src="https://img.shields.io/badge/License-MIT-blue.svg" style="width: 100px; height: 28px;" />
    </a>
</div>


<br /><br />
> [!IMPORTANT]
> This SDK is not yet ready for production use. To complete setup please follow the steps outlined in your [workspace](https://app.speakeasy.com/org/walker/esv). Delete this section before > publishing to a package manager.

<!-- Start Summary [summary] -->
## Summary

ESV.org API: A convenient way to fetch content from ESV.org.

The ESV API provides access to the ESV text, with a customizable presentation in  multiple formats. 

For more information about the API: [ESV API Website](https://api.esv.org/)
<!-- End Summary [summary] -->

<!-- Start Table of Contents [toc] -->
## Table of Contents
<!-- $toc-max-depth=2 -->
* [openapi](#openapi)
  * [SDK Installation](#sdk-installation)
  * [SDK Example Usage](#sdk-example-usage)
  * [Authentication](#authentication)
  * [Available Resources and Operations](#available-resources-and-operations)
  * [Pagination](#pagination)
  * [Error Handling](#error-handling)
  * [Server Selection](#server-selection)
* [Development](#development)
  * [Maturity](#maturity)
  * [Contributions](#contributions)

<!-- End Table of Contents [toc] -->

<!-- Start SDK Installation [installation] -->
## SDK Installation

### Getting started

JDK 11 or later is required.

The samples below show how a published SDK artifact is used:

Gradle:
```groovy
implementation 'io.github.walker-tx:esv:0.4.0'
```

Maven:
```xml
<dependency>
    <groupId>io.github.walker-tx</groupId>
    <artifactId>esv</artifactId>
    <version>0.4.0</version>
</dependency>
```

### How to build
After cloning the git repository to your file system you can build the SDK artifact from source to the `build` directory by running `./gradlew build` on *nix systems or `gradlew.bat` on Windows systems.

If you wish to build from source and publish the SDK artifact to your local Maven repository (on your filesystem) then use the following command (after cloning the git repo locally):

On *nix:
```bash
./gradlew publishToMavenLocal -Pskip.signing
```
On Windows:
```bash
gradlew.bat publishToMavenLocal -Pskip.signing
```

### Logging
A logging framework/facade has not yet been adopted but is under consideration.

For request and response logging (especially json bodies), call `enableHTTPDebugLogging(boolean)` on the SDK builder like so:
```java
SDK.builder()
    .enableHTTPDebugLogging(true)
    .build();
```
Example output:
```
Sending request: http://localhost:35123/bearer#global GET
Request headers: {Accept=[application/json], Authorization=[******], Client-Level-Header=[added by client], Idempotency-Key=[some-key], x-speakeasy-user-agent=[speakeasy-sdk/java 0.0.1 internal 0.1.0 org.openapis.openapi]}
Received response: (GET http://localhost:35123/bearer#global) 200
Response headers: {access-control-allow-credentials=[true], access-control-allow-origin=[*], connection=[keep-alive], content-length=[50], content-type=[application/json], date=[Wed, 09 Apr 2025 01:43:29 GMT], server=[gunicorn/19.9.0]}
Response body:
{
  "authenticated": true, 
  "token": "global"
}
```
__WARNING__: This should only used for temporary debugging purposes. Leaving this option on in a production system could expose credentials/secrets in logs. <i>Authorization</i> headers are redacted by default and there is the ability to specify redacted header names via `SpeakeasyHTTPClient.setRedactedHeaders`.

__NOTE__: This is a convenience method that calls `HTTPClient.enableDebugLogging()`. The `SpeakeasyHTTPClient` honors this setting. If you are using a custom HTTP client, it is up to the custom client to honor this setting.

Another option is to set the System property `-Djdk.httpclient.HttpClient.log=all`. However, this second option does not log bodies.
<!-- End SDK Installation [installation] -->

<!-- Start SDK Example Usage [usage] -->
## SDK Example Usage

### Example

```java
package hello.world;

import io.github.walker_tx.esv.Esv;
import io.github.walker_tx.esv.models.errors.Error;
import io.github.walker_tx.esv.models.operations.GetPassageHtmlRequest;
import io.github.walker_tx.esv.models.operations.GetPassageHtmlResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Error, Exception {

        Esv sdk = Esv.builder()
                .apiKey("<YOUR_API_KEY_HERE>")
            .build();

        GetPassageHtmlRequest req = GetPassageHtmlRequest.builder()
                .query("John 1:1")
                .build();

        GetPassageHtmlResponse res = sdk.passages().getHtml()
                .request(req)
                .call();

        if (res.passageResponse().isPresent()) {
            // handle response
        }
    }
}
```
<!-- End SDK Example Usage [usage] -->

<!-- Start Authentication [security] -->
## Authentication

### Per-Client Security Schemes

This SDK supports the following security scheme globally:

| Name     | Type   | Scheme  |
| -------- | ------ | ------- |
| `apiKey` | apiKey | API key |

To authenticate with the API the `apiKey` parameter must be set when initializing the SDK client instance. For example:
```java
package hello.world;

import io.github.walker_tx.esv.Esv;
import io.github.walker_tx.esv.models.errors.Error;
import io.github.walker_tx.esv.models.operations.GetPassageHtmlRequest;
import io.github.walker_tx.esv.models.operations.GetPassageHtmlResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Error, Exception {

        Esv sdk = Esv.builder()
                .apiKey("<YOUR_API_KEY_HERE>")
            .build();

        GetPassageHtmlRequest req = GetPassageHtmlRequest.builder()
                .query("John 1:1")
                .build();

        GetPassageHtmlResponse res = sdk.passages().getHtml()
                .request(req)
                .call();

        if (res.passageResponse().isPresent()) {
            // handle response
        }
    }
}
```
<!-- End Authentication [security] -->

<!-- Start Available Resources and Operations [operations] -->
## Available Resources and Operations

<details open>
<summary>Available methods</summary>


### [passages()](docs/sdks/passages/README.md)

* [getHtml](docs/sdks/passages/README.md#gethtml) - Get Bible passage HTML
* [search](docs/sdks/passages/README.md#search) - Search Bible passages
* [getAudio](docs/sdks/passages/README.md#getaudio) - Get Bible passage audio
* [getText](docs/sdks/passages/README.md#gettext) - Get Bible passage text

</details>
<!-- End Available Resources and Operations [operations] -->

<!-- Start Pagination [pagination] -->
## Pagination

Some of the endpoints in this SDK support pagination. To use pagination, you can make your SDK calls using the `callAsIterable` or `callAsStream` methods.
For certain operations, you can also use the `callAsStreamUnwrapped` method that streams individual page items directly.

Here's an example depicting the different ways to use pagination:


```java
package hello.world;

import io.github.walker_tx.esv.Esv;
import io.github.walker_tx.esv.models.errors.Error;
import io.github.walker_tx.esv.models.operations.SearchPassagesResponse;
import java.lang.Exception;
import java.lang.Iterable;

public class Application {

    public static void main(String[] args) throws Error, Exception {

        Esv sdk = Esv.builder()
                .apiKey("<YOUR_API_KEY_HERE>")
            .build();

        var b = sdk.passages().search()
                .query("<value>")
                .pageSize(20L)
                .page(1L);

        // Iterate through all pages using a traditional for-each loop
        // Each iteration returns a complete page response
        Iterable<SearchPassagesResponse> iterable = b.callAsIterable();
        for (SearchPassagesResponse page : iterable) {
            // handle page
        }

        // Stream through all pages and process individual items
        // callAsStreamUnwrapped() flattens pages into individual items

        // Stream through pages without unwrapping (each item is a complete page)
        b.callAsStream()
            .forEach((SearchPassagesResponse page) -> {
                // handle page
            });

    }
}
```
<!-- End Pagination [pagination] -->

<!-- Start Error Handling [errors] -->
## Error Handling

Handling errors in this SDK should largely match your expectations. All operations return a response object or raise an exception.

By default, an API error will throw a `models/errors/APIException` exception. When custom error responses are specified for an operation, the SDK may also throw their associated exception. You can refer to respective *Errors* tables in SDK docs for more details on possible exception types for each operation. For example, the `getHtml` method throws the following exceptions:

| Error Type                 | Status Code | Content Type     |
| -------------------------- | ----------- | ---------------- |
| models/errors/Error        | 400, 401    | application/json |
| models/errors/APIException | 4XX, 5XX    | \*/\*            |

### Example

```java
package hello.world;

import io.github.walker_tx.esv.Esv;
import io.github.walker_tx.esv.models.errors.Error;
import io.github.walker_tx.esv.models.operations.GetPassageHtmlRequest;
import io.github.walker_tx.esv.models.operations.GetPassageHtmlResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Error, Exception {

        Esv sdk = Esv.builder()
                .apiKey("<YOUR_API_KEY_HERE>")
            .build();

        GetPassageHtmlRequest req = GetPassageHtmlRequest.builder()
                .query("John 1:1")
                .build();

        GetPassageHtmlResponse res = sdk.passages().getHtml()
                .request(req)
                .call();

        if (res.passageResponse().isPresent()) {
            // handle response
        }
    }
}
```
<!-- End Error Handling [errors] -->

<!-- Start Server Selection [server] -->
## Server Selection

### Override Server URL Per-Client

The default server can be overridden globally using the `.serverURL(String serverUrl)` builder method when initializing the SDK client instance. For example:
```java
package hello.world;

import io.github.walker_tx.esv.Esv;
import io.github.walker_tx.esv.models.errors.Error;
import io.github.walker_tx.esv.models.operations.GetPassageHtmlRequest;
import io.github.walker_tx.esv.models.operations.GetPassageHtmlResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Error, Exception {

        Esv sdk = Esv.builder()
                .serverURL("https://api.esv.org/v3/")
                .apiKey("<YOUR_API_KEY_HERE>")
            .build();

        GetPassageHtmlRequest req = GetPassageHtmlRequest.builder()
                .query("John 1:1")
                .build();

        GetPassageHtmlResponse res = sdk.passages().getHtml()
                .request(req)
                .call();

        if (res.passageResponse().isPresent()) {
            // handle response
        }
    }
}
```
<!-- End Server Selection [server] -->

<!-- Placeholder for Future Speakeasy SDK Sections -->

# Development

## Maturity

This SDK is in beta, and there may be breaking changes between versions without a major version update. Therefore, we recommend pinning usage
to a specific package version. This way, you can install the same version each time without breaking changes unless you are intentionally
looking for the latest version.

## Contributions

While we value open-source contributions to this SDK, this library is generated programmatically. Any manual changes added to internal files will be overwritten on the next generation. 
We look forward to hearing your feedback. Feel free to open a PR or an issue with a proof of concept and we'll do our best to include it in a future release. 

### SDK Created by [Speakeasy](https://www.speakeasy.com/?utm_source=openapi&utm_campaign=java)
