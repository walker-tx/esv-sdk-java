# Passages
(*passages()*)

## Overview

### Available Operations

* [getHtml](#gethtml) - Get Bible passage HTML
* [search](#search) - Search Bible passages
* [getAudio](#getaudio) - Get Bible passage audio
* [getText](#gettext) - Get Bible passage text

## getHtml

Returns Bible passage text with HTML formatting

Esv.org API Docs for `/v3/passages/html`
<https://api.esv.org/docs/passage-html/>

### Example Usage

<!-- UsageSnippet language="java" operationID="getPassageHtml" method="get" path="/passage/html/" -->
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
                .apiKey(System.getenv().getOrDefault("API_KEY", ""))
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

### Parameters

| Parameter                                                                 | Type                                                                      | Required                                                                  | Description                                                               |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `request`                                                                 | [GetPassageHtmlRequest](../../models/operations/GetPassageHtmlRequest.md) | :heavy_check_mark:                                                        | The request object to use for the request.                                |

### Response

**[GetPassageHtmlResponse](../../models/operations/GetPassageHtmlResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/Error        | 400, 401                   | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## search

Returns search results for Bible passages based on the provided query

Esv.org API Docs for `/v3/passage/search`
<https://api.esv.org/docs/passage-search/>

### Example Usage

<!-- UsageSnippet language="java" operationID="searchPassages" method="get" path="/passage/search/" -->
```java
package hello.world;

import io.github.walker_tx.esv.Esv;
import io.github.walker_tx.esv.models.errors.Error;
import io.github.walker_tx.esv.models.operations.SearchPassagesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Error, Exception {

        Esv sdk = Esv.builder()
                .apiKey(System.getenv().getOrDefault("API_KEY", ""))
            .build();

        sdk.passages().search()
                .query("<value>")
                .pageSize(20L)
                .page(1L)
                .callAsStream()
                .forEach((SearchPassagesResponse item) -> {
                   // handle page
                });

    }
}
```

### Parameters

| Parameter                            | Type                                 | Required                             | Description                          |
| ------------------------------------ | ------------------------------------ | ------------------------------------ | ------------------------------------ |
| `query`                              | *String*                             | :heavy_check_mark:                   | The text to search for               |
| `pageSize`                           | *long*                               | :heavy_check_mark:                   | Number of results to return per page |
| `page`                               | *long*                               | :heavy_check_mark:                   | Page number to return                |

### Response

**[SearchPassagesResponse](../../models/operations/SearchPassagesResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/Error        | 400, 401                   | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## getAudio

Returns audio file for Bible passages based on the provided query

Esv.org API Docs for `/v3/passage/audio`
<https://api.esv.org/docs/passage-audio/>

### Example Usage

<!-- UsageSnippet language="java" operationID="getPassageAudio" method="get" path="/passage/audio/" -->
```java
package hello.world;

import io.github.walker_tx.esv.Esv;
import io.github.walker_tx.esv.models.errors.Error;
import io.github.walker_tx.esv.models.operations.GetPassageAudioResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Error, Exception {

        Esv sdk = Esv.builder()
                .apiKey(System.getenv().getOrDefault("API_KEY", ""))
            .build();

        GetPassageAudioResponse res = sdk.passages().getAudio()
                .query("John 1:1")
                .call();

        if (res.responseStream().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                 | Type                                                      | Required                                                  | Description                                               |
| --------------------------------------------------------- | --------------------------------------------------------- | --------------------------------------------------------- | --------------------------------------------------------- |
| `query`                                                   | *String*                                                  | :heavy_check_mark:                                        | Bible passage reference (e.g., "John 3:16" or "43011016") |

### Response

**[GetPassageAudioResponse](../../models/operations/GetPassageAudioResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/Error        | 400, 401                   | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## getText

Returns Bible passage text based on the provided query parameters

Esv.org API Docs for `/v3/passages/text`
<https://api.esv.org/docs/passage-text/>

### Example Usage

<!-- UsageSnippet language="java" operationID="getPassageText" method="get" path="/passage/text/" -->
```java
package hello.world;

import io.github.walker_tx.esv.Esv;
import io.github.walker_tx.esv.models.errors.Error;
import io.github.walker_tx.esv.models.operations.GetPassageTextRequest;
import io.github.walker_tx.esv.models.operations.GetPassageTextResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Error, Exception {

        Esv sdk = Esv.builder()
                .apiKey(System.getenv().getOrDefault("API_KEY", ""))
            .build();

        GetPassageTextRequest req = GetPassageTextRequest.builder()
                .query("John 1:1")
                .build();

        GetPassageTextResponse res = sdk.passages().getText()
                .request(req)
                .call();

        if (res.passageResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                 | Type                                                                      | Required                                                                  | Description                                                               |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `request`                                                                 | [GetPassageTextRequest](../../models/operations/GetPassageTextRequest.md) | :heavy_check_mark:                                                        | The request object to use for the request.                                |

### Response

**[GetPassageTextResponse](../../models/operations/GetPassageTextResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/Error        | 400, 401                   | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |