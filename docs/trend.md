# Working with Trends in Twitter

[[  Overview ]](#overview)  [[ Operation details ]](#operation-details)  [[  Sample configuration  ]](#sample-configuration)

### Overview 

The following operations allow you to work with trends. Click an operation name to see details on how to use it.
For a sample proxy service that illustrates how to work with trends, see [Sample configuration](#sample-configuration).

| Operation        | Description |
| ------------- |-------------|
| [getTrendsAvailable](#Retrieving-trend-locations)    | Retrieves locations for which trending topic information is available. |
| [getTrendsPlace](#Retrieving-top-trends-for-a-specific location)      | Retrieves the top 10 trending topics for a specific Yahoo! Where On Earth ID (WOEID). |
| [getTrendsClosest](#Retrieving-trend-locations-closest-to-a-specified-location)      | Retrieves closest location to a specified location of trend topic. |

### Operation details

This section provides details on the operations.

#### Retrieving-trend-locations
The getTrendsAvailable operation retrieves the locations for which trending topic information is available.

**getTrendsAvailable**
```xml
<twitter.getTrendsAvailable/>
```
 
**Sample request**

Following is a sample REST/JSON request that can be handled by the getTrendsAvailable operation.

```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
}

```

**Sample Response**

```json
[
    {
        "name": "Worldwide",
        "placeType": {
            "code": 19,
            "name": "Supername"
        },
        "url": "http://where.yahooapis.com/v1/place/1",
        "parentid": 0,
        "country": "",
        "woeid": 1,
        "countryCode": null
    },
    {
        "name": "Winnipeg",
        "placeType": {
            "code": 7,
            "name": "Town"
        },
        "url": "http://where.yahooapis.com/v1/place/2972",
        "parentid": 23424775,
        "country": "Canada",
        "woeid": 2972,
        "countryCode": "CA"
    },
    {
        "name": "Edmonton",
        "placeType": {
            "code": 7,
            "name": "Town"
        },
        "url": "http://where.yahooapis.com/v1/place/8676",
        "parentid": 23424775,
        "country": "Canada",
        "woeid": 8676,
        "countryCode": "CA"
    },
    {
        "name": "Calgary",
        "placeType": {
            "code": 7,
            "name": "Town"
        },
        "url": "http://where.yahooapis.com/v1/place/8775",
        "parentid": 23424775,
        "country": "Canada",
        "woeid": 8775,
        "countryCode": "CA"
    },
    {
        "name": "Vancouver",
        "placeType": {
            "code": 7,
            "name": "Town"
        },
        "url": "http://where.yahooapis.com/v1/place/9807",
        "parentid": 23424775,
        "country": "Canada",
        "woeid": 9807,
        "countryCode": "CA"
    },
    {
        "name": "Birmingham",
        "placeType": {
            "code": 7,
            "name": "Town"
        },
        "url": "http://where.yahooapis.com/v1/place/12723",
        "parentid": 23424975,
        "country": "United Kingdom",
        "woeid": 12723,
        "countryCode": "GB"
    },
    {
        "name": "Blackpool",
        "placeType": {
            "code": 7,
            "name": "Town"
        },
        "url": "http://where.yahooapis.com/v1/place/12903",
        "parentid": 23424975,
        "country": "United Kingdom",
        "woeid": 12903,
        "countryCode": "GB"
    },
    {
        "name": "Bournemouth",
        "placeType": {
            "code": 7,
            "name": "Town"
        },
        "url": "http://where.yahooapis.com/v1/place/13383",
        "parentid": 23424975,
        "country": "United Kingdom",
        "woeid": 13383,
        "countryCode": "GB"
    }
 ]
```

**Related Twitter documentation**

https://dev.twitter.com/rest/reference/get/trends/available

####  Retrieving top trends for a specific location

The getTrendsPlace operation retrieves the top 10 trending topics for a specific Yahoo! Where On Earth ID (WOEID), if trending information is available.

**getTrendsPlace**
```xml
<twitter.getTrendsPlace>
    <id>{$ctx:id}</id>
    <exclude>{$ctx:exclude}</exclude>
</twitter.getTrendsPlace>
```

**Properties**
* id: Required -The Yahoo! Where On Earth ID of the location for which you want to retrieve the top 10 trends. Global information can be retrieved by using 1 as the WOEID.
* exclude: Setting this equal to hashtags will remove all hashtags from the trends list.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getTrendsPlace operation.

```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "id":"1",
  "exclude":"events"
}
```

**Sample Response**

```json
[
    {
        "trends": [
            {
                "name": "#bucciovertimechallenge",
                "url": "http://twitter.com/search?q=%23bucciovertimechallenge",
                "promoted_content": null,
                "query": "%23bucciovertimechallenge",
                "tweet_volume": 10897
            },
            {
                "name": "#stlblues",
                "url": "http://twitter.com/search?q=%23stlblues",
                "promoted_content": null,
                "query": "%23stlblues",
                "tweet_volume": 31939
            },
            {
                "name": "Ben Bishop",
                "url": "http://twitter.com/search?q=%22Ben+Bishop%22",
                "promoted_content": null,
                "query": "%22Ben+Bishop%22",
                "tweet_volume": 14105
            },
            {
                "name": "Twittartiir Açıldı",
                "url": "http://twitter.com/search?q=%22Twittartiir+A%C3%A7%C4%B1ld%C4%B1%22",
                "promoted_content": null,
                "query": "%22Twittartiir+A%C3%A7%C4%B1ld%C4%B1%22",
                "tweet_volume": null
            },
            {
                "name": "園児の列",
                "url": "http://twitter.com/search?q=%E5%9C%92%E5%85%90%E3%81%AE%E5%88%97",
                "promoted_content": null,
                "query": "%E5%9C%92%E5%85%90%E3%81%AE%E5%88%97",
                "tweet_volume": 30917
            },
            {
                "name": "#GoStars",
                "url": "http://twitter.com/search?q=%23GoStars",
                "promoted_content": null,
                "query": "%23GoStars",
                "tweet_volume": 19072
            },
            {
                "name": "#LahoreBlast",
                "url": "http://twitter.com/search?q=%23LahoreBlast",
                "promoted_content": null,
                "query": "%23LahoreBlast",
                "tweet_volume": null
            },
            {
                "name": "#EliminaçãoPowerCouple",
                "url": "http://twitter.com/search?q=%23Elimina%C3%A7%C3%A3oPowerCouple",
                "promoted_content": null,
                "query": "%23Elimina%C3%A7%C3%A3oPowerCouple",
                "tweet_volume": 53750
            },
            {
                "name": "Game 7",
                "url": "http://twitter.com/search?q=%22Game+7%22",
                "promoted_content": null,
                "query": "%22Game+7%22",
                "tweet_volume": 31982
            },
            {
                "name": "Justin Turner",
                "url": "http://twitter.com/search?q=%22Justin+Turner%22",
                "promoted_content": null,
                "query": "%22Justin+Turner%22",
                "tweet_volume": null
            },
            {
                "name": "予約完了",
                "url": "http://twitter.com/search?q=%E4%BA%88%E7%B4%84%E5%AE%8C%E4%BA%86",
                "promoted_content": null,
                "query": "%E4%BA%88%E7%B4%84%E5%AE%8C%E4%BA%86",
                "tweet_volume": null
            },
            {
                "name": "Pat Maroon",
                "url": "http://twitter.com/search?q=%22Pat+Maroon%22",
                "promoted_content": null,
                "query": "%22Pat+Maroon%22",
                "tweet_volume": null
            },
            {
                "name": "PLAY GLORIA",
                "url": "http://twitter.com/search?q=%22PLAY+GLORIA%22",
                "promoted_content": null,
                "query": "%22PLAY+GLORIA%22",
                "tweet_volume": null
            },
            {
                "name": "Jhene",
                "url": "http://twitter.com/search?q=Jhene",
                "promoted_content": null,
                "query": "Jhene",
                "tweet_volume": 26152
            },
            {
                "name": "ウマ娘",
                "url": "http://twitter.com/search?q=%E3%82%A6%E3%83%9E%E5%A8%98",
                "promoted_content": null,
                "query": "%E3%82%A6%E3%83%9E%E5%A8%98",
                "tweet_volume": 28474
            },
            {
                "name": "Patrick Maroon",
                "url": "http://twitter.com/search?q=%22Patrick+Maroon%22",
                "promoted_content": null,
                "query": "%22Patrick+Maroon%22",
                "tweet_volume": null
            },
            {
                "name": "Pete Alonso",
                "url": "http://twitter.com/search?q=%22Pete+Alonso%22",
                "promoted_content": null,
                "query": "%22Pete+Alonso%22",
                "tweet_volume": null
            },
            {
                "name": "류현진",
                "url": "http://twitter.com/search?q=%EB%A5%98%ED%98%84%EC%A7%84",
                "promoted_content": null,
                "query": "%EB%A5%98%ED%98%84%EC%A7%84",
                "tweet_volume": 16495
            },
            {
                "name": "Faby",
                "url": "http://twitter.com/search?q=Faby",
                "promoted_content": null,
                "query": "Faby",
                "tweet_volume": 30872
            },
            {
                "name": "Robert Thomas",
                "url": "http://twitter.com/search?q=%22Robert+Thomas%22",
                "promoted_content": null,
                "query": "%22Robert+Thomas%22",
                "tweet_volume": null
            },
            {
                "name": "Benn",
                "url": "http://twitter.com/search?q=Benn",
                "promoted_content": null,
                "query": "Benn",
                "tweet_volume": null
            },
            {
                "name": "大津の事故",
                "url": "http://twitter.com/search?q=%E5%A4%A7%E6%B4%A5%E3%81%AE%E4%BA%8B%E6%95%85",
                "promoted_content": null,
                "query": "%E5%A4%A7%E6%B4%A5%E3%81%AE%E4%BA%8B%E6%95%85",
                "tweet_volume": 16096
            },
            {
                "name": "Mike Fiers",
                "url": "http://twitter.com/search?q=%22Mike+Fiers%22",
                "promoted_content": null,
                "query": "%22Mike+Fiers%22",
                "tweet_volume": null
            },
            {
                "name": "Double OT",
                "url": "http://twitter.com/search?q=%22Double+OT%22",
                "promoted_content": null,
                "query": "%22Double+OT%22",
                "tweet_volume": null
            },
            {
                "name": "#DALvsSTL",
                "url": "http://twitter.com/search?q=%23DALvsSTL",
                "promoted_content": null,
                "query": "%23DALvsSTL",
                "tweet_volume": null
            },
            {
                "name": "#あなたの良いところは",
                "url": "http://twitter.com/search?q=%23%E3%81%82%E3%81%AA%E3%81%9F%E3%81%AE%E8%89%AF%E3%81%84%E3%81%A8%E3%81%93%E3%82%8D%E3%81%AF",
                "promoted_content": null,
                "query": "%23%E3%81%82%E3%81%AA%E3%81%9F%E3%81%AE%E8%89%AF%E3%81%84%E3%81%A8%E3%81%93%E3%82%8D%E3%81%AF",
                "tweet_volume": null
            },
            {
                "name": "#TodosSonAsesinos",
                "url": "http://twitter.com/search?q=%23TodosSonAsesinos",
                "promoted_content": null,
                "query": "%23TodosSonAsesinos",
                "tweet_volume": null
            },
            {
                "name": "#BirVatandaşOlarak",
                "url": "http://twitter.com/search?q=%23BirVatanda%C5%9FOlarak",
                "promoted_content": null,
                "query": "%23BirVatanda%C5%9FOlarak",
                "tweet_volume": null
            },
            {
                "name": "#MyMum",
                "url": "http://twitter.com/search?q=%23MyMum",
                "promoted_content": null,
                "query": "%23MyMum",
                "tweet_volume": null
            },
            {
                "name": "#WednesdayWisdom",
                "url": "http://twitter.com/search?q=%23WednesdayWisdom",
                "promoted_content": null,
                "query": "%23WednesdayWisdom",
                "tweet_volume": 12256
            },
            {
                "name": "#SAElections2019",
                "url": "http://twitter.com/search?q=%23SAElections2019",
                "promoted_content": null,
                "query": "%23SAElections2019",
                "tweet_volume": 27179
            },
            {
                "name": "#triggered",
                "url": "http://twitter.com/search?q=%23triggered",
                "promoted_content": null,
                "query": "%23triggered",
                "tweet_volume": 19011
            },
            {
                "name": "#DataDarbar",
                "url": "http://twitter.com/search?q=%23DataDarbar",
                "promoted_content": null,
                "query": "%23DataDarbar",
                "tweet_volume": null
            },
            {
                "name": "#çarşamba",
                "url": "http://twitter.com/search?q=%23%C3%A7ar%C5%9Famba",
                "promoted_content": null,
                "query": "%23%C3%A7ar%C5%9Famba",
                "tweet_volume": null
            },
            {
                "name": "#WeAllBleedBlue",
                "url": "http://twitter.com/search?q=%23WeAllBleedBlue",
                "promoted_content": null,
                "query": "%23WeAllBleedBlue",
                "tweet_volume": 19506
            },
            {
                "name": "#TrumpTaxes",
                "url": "http://twitter.com/search?q=%23TrumpTaxes",
                "promoted_content": null,
                "query": "%23TrumpTaxes",
                "tweet_volume": 32595
            },
            {
                "name": "#Game7",
                "url": "http://twitter.com/search?q=%23Game7",
                "promoted_content": null,
                "query": "%23Game7",
                "tweet_volume": null
            },
            {
                "name": "#LetsGoBlues",
                "url": "http://twitter.com/search?q=%23LetsGoBlues",
                "promoted_content": null,
                "query": "%23LetsGoBlues",
                "tweet_volume": null
            },
            {
                "name": "#PuasaItuMudah",
                "url": "http://twitter.com/search?q=%23PuasaItuMudah",
                "promoted_content": null,
                "query": "%23PuasaItuMudah",
                "tweet_volume": null
            },
            {
                "name": "#WednesdayMotivation",
                "url": "http://twitter.com/search?q=%23WednesdayMotivation",
                "promoted_content": null,
                "query": "%23WednesdayMotivation",
                "tweet_volume": null
            },
            {
                "name": "#AllOutAteneo",
                "url": "http://twitter.com/search?q=%23AllOutAteneo",
                "promoted_content": null,
                "query": "%23AllOutAteneo",
                "tweet_volume": 46947
            },
            {
                "name": "#DemokrasiEmekİster",
                "url": "http://twitter.com/search?q=%23DemokrasiEmek%C4%B0ster",
                "promoted_content": null,
                "query": "%23DemokrasiEmek%C4%B0ster",
                "tweet_volume": null
            },
            {
                "name": "#Blues",
                "url": "http://twitter.com/search?q=%23Blues",
                "promoted_content": null,
                "query": "%23Blues",
                "tweet_volume": null
            },
            {
                "name": "#Gloria",
                "url": "http://twitter.com/search?q=%23Gloria",
                "promoted_content": null,
                "query": "%23Gloria",
                "tweet_volume": null
            },
            {
                "name": "#BillionDollarLoser",
                "url": "http://twitter.com/search?q=%23BillionDollarLoser",
                "promoted_content": null,
                "query": "%23BillionDollarLoser",
                "tweet_volume": 14767
            },
            {
                "name": "#STEMshooting",
                "url": "http://twitter.com/search?q=%23STEMshooting",
                "promoted_content": null,
                "query": "%23STEMshooting",
                "tweet_volume": 50777
            },
            {
                "name": "#unapololaparafritanga",
                "url": "http://twitter.com/search?q=%23unapololaparafritanga",
                "promoted_content": null,
                "query": "%23unapololaparafritanga",
                "tweet_volume": null
            },
            {
                "name": "#GesekanInternal",
                "url": "http://twitter.com/search?q=%23GesekanInternal",
                "promoted_content": null,
                "query": "%23GesekanInternal",
                "tweet_volume": null
            },
            {
                "name": "#QuererSinLimitesFinal",
                "url": "http://twitter.com/search?q=%23QuererSinLimitesFinal",
                "promoted_content": null,
                "query": "%23QuererSinLimitesFinal",
                "tweet_volume": null
            },
            {
                "name": "#SDLive",
                "url": "http://twitter.com/search?q=%23SDLive",
                "promoted_content": null,
                "query": "%23SDLive",
                "tweet_volume": 40047
            }
        ],
        "as_of": "2019-05-08T06:03:01Z",
        "created_at": "2019-05-08T05:56:42Z",
        "locations": [
            {
                "name": "Worldwide",
                "woeid": 1
            }
        ]
    }
]
```


**Related Twitter documentation**

https://dev.twitter.com/rest/reference/get/trends/place

####  Retrieving trend locations closest to a specified location

The getTrendsClosest operation retrieves the trending locations closest to a specific location (specified by the latitude-longitude coordinates).

**getTrendsClosest**
```xml
<twitter.getTrendsClosest>
    <lat>{$ctx:lat}</lat>
    <long>{$ctx:long}</long>
</twitter.getTrendsClosest>
```
**Properties**

* lat:Required - If specified with the long property, the available trend location will be sorted by distance, nearest to furthest to the coordinate pair. The valid range for latitude is -180.0 to +180.0 (West is negative, East is positive) inclusive.
* long:Required - If specified with the lat property the available trend location will be sorted by distance, nearest to furthest, to the co-ordinate pair. The valid range for longitude is -180.0 to +180.0 (West is negative, East is positive) inclusive.

**Sample request**

Following is a sample REST/JSON request that can be handled by the setAccount operation.

```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "latitude":"37.781157",
  "longitude":"-122.400612831116"
}
```


**Sample Response**

```json
[
    {
        "name": "Pakistan",
        "placeType": {
            "code": 12,
            "name": "Country"
        },
        "url": "http://where.yahooapis.com/v1/place/23424922",
        "parentid": 1,
        "country": "Pakistan",
        "woeid": 23424922,
        "countryCode": "PK"
    }
]
```


**Related Twitter documentation**

https://dev.twitter.com/rest/reference/get/trends/closest

#### Sample configuration

Following is a sample proxy service that illustrates how to connect to Twitter with the init operation and use the getTrendsAvailable operation. The sample request for this proxy can be found in getTrendsAvailable sample request. You can use this sample as a template for using other operations in this category.

1. Create a sample proxy as below :

    **Sample Proxy**
    ```xml
    <proxy xmlns="http://ws.apache.org/ns/synapse"
           name="getTrendsAvailable"
           transports="https,http"
           statistics="disable"
           trace="disable"
           startOnLoad="true">
       <target>
           <inSequence onError="faultHandlerSeq">       
             <property name="consumerKey" expression="json-eval($.consumerKey)"/>
             <property name="consumerSecret" expression="json-eval($.consumerSecret)"/>
             <property name="accessToken" expression="json-eval($.accessToken)"/>
             <property name="accessTokenSecret" expression="json-eval($.accessTokenSecret)"/>
             <twitter.init>
                <consumerKey>{$ctx:consumerKey}</consumerKey>
                <consumerSecret>{$ctx:consumerSecret}</consumerSecret>
                <accessToken>{$ctx:accessToken}</accessToken>
                <accessTokenSecret>{$ctx:accessTokenSecret}</accessTokenSecret>
             </twitter.init>
             <twitter.getTrendsAvailable/>
             <respond/>
          </inSequence>
          <outSequence>
             <send/>
          </outSequence>
       </target>
       <description/>
    </proxy>
    
    ```
2. Create a json file named getTrendsAvailable.json and copy the configurations given below to it:

    ```json
    {
        "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
        "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
        "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
        "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU"
    }
    ```
3. Replace the credentials with your values.

4. Execute the following curl command:

    ```bash
    curl -X POST http://localhost:8280/services/getTrendsAvailable --header 'Content-Type: application/json' -d @getTrendsAvailable.json
    ```

5. Twitter returns a json response similar to the one shown below:
 
```json
{"output":"[{\"name\":\"Worldwide\",\"placeType\":{\"code\":19,\"name\":\"Supername\"},\"url\":\"http:\\/\\/where.yahooapis.com\\/v1\\/place\\/1\",\"parentid\":0,\"country\":\"\",\"woeid\":1,\"countryCode\":null},{\"name\":\"Winnipeg\",\"placeType\":{\"code\":7,\"name\":\"Town\"},\"url\":\"http:\\/\\/where.yahooapis.com\\/v1\\/place\\/2972\",\"parentid\":23424775,\"country\":\"Canada\",\"woeid\":2972,\"countryCode\":\"CA\"},{\"name\":\"Ottawa\",\"placeType\":{\"code\":7,\"name\":\"Town\"},\"url\":\"http:\\/\\/where.yahooapis.com\\/v1\\/place\\/3369\",\"parentid\":23424775,\"country\":\"Canada\",\"woeid\":3369,\"countryCode\":\"CA\"},{\"name\":\"Quebec\",\"placeType\":{\"code\":7,\"name\":\"Town\"},\"url\":\"http:\\/\\/where.yahooapis.com\\/v1\\/place\\/3444\",\"parentid\":23424775,\"country\":\"Canada\",\"woeid\":3444,\"countryCode\":\"CA\"},{\"name\":\"Montreal\",\"placeType\":{\"code\":7,\"name\":\"Town\"},\"url\":\"http:\\/\\/where.yahooapis.com\\/v1\\/place\\/3534\",\"parentid\":23424775,\"country\":\"Canada\",\"woeid\":3534,\"countryCode\":\"CA\"},{\"name\":\"Toronto\",\"placeType\":{\"code\":7,\"name\":\"Town\"},\"url\":\"http:\\/\\/where.yahooapis.com\\/v1\\/place\\/4118\",\"parentid\":23424775,\"country\":\"Canada\",\"woeid\":4118,\"countryCode\":\"CA\"},{\"name\":\"Edmonton\",\"placeType\":{\"code\":7,\"name\":\"Town\"},\"url\":\"http:\\/\\/where.yahooapis.com\\/v1\\/place\\/8676\",\"parentid\":23424775,\"country\":\"Canada\",\"woeid\":8676,\"countryCode\":\"CA\"},{\"name\":\"Calgary\",\"placeType\":{\"code\":7,\"name\":\"Town\"},\"url\":\"http:\\/\\/where.yahooapis.com\\/v1\\/place\\/8775\",\"parentid\":23424775,\"country\":\"Canada\",\"woeid\":8775,\"countryCode\":\"CA\"},{\"name\":\"Vancouver\",\"placeType\":{\"code\":7,\"name\":\"Town\"},\"url\":\"http:\\/\\/where.yahooapis.com\\/v1\\/place\\/9807\",\"parentid\":23424775,\"country\":\"Canada\",\"woeid\":9807,\"countryCode\":\"CA\"}]"}
```
