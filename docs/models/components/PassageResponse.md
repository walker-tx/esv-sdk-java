# PassageResponse


## Fields

| Field                                                        | Type                                                         | Required                                                     | Description                                                  |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| `query`                                                      | *Optional\<String>*                                          | :heavy_minus_sign:                                           | The passage reference that was requested                     |
| `canonical`                                                  | *Optional\<String>*                                          | :heavy_minus_sign:                                           | The canonical version of the passage reference               |
| `parsed`                                                     | List\<List\\<*long*>>                                        | :heavy_minus_sign:                                           | Array of parsed passage references                           |
| `passageMeta`                                                | List\<[PassageMeta](../../models/components/PassageMeta.md)> | :heavy_minus_sign:                                           | N/A                                                          |
| `passages`                                                   | List\<*String*>                                              | :heavy_minus_sign:                                           | Array of formatted passage text                              |