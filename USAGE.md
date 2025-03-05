<!-- Start SDK Example Usage [usage] -->
```java
package hello.world;

import dev.walkertx.esv.Esv;
import dev.walkertx.esv.models.errors.Error;
import dev.walkertx.esv.models.operations.GetPassageHtmlRequest;
import dev.walkertx.esv.models.operations.GetPassageHtmlResponse;
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