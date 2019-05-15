# Working with Tweets in Twitter

[[  Overview ]](#overview)  [[ Operation details ]](#operation-details)  [[  Sample configuration  ]](#sample-configuration)

### Overview 

The following operations allow you to work with tweets. Click an operation name to see details on how to use it.
For a sample proxy service that illustrates how to work with tweets, see [Sample configuration](#sample-configuration).

| Operation        | Description |
| ------------- |-------------|
| [retweet](#Retweets-a-tweet.)    | Retweets a tweet. |
| [getStatusesRetweetsById](#Retrieving-the-statuses-of-the-retweet.)      | Retrieves the statuses of the retweet. |
| [showStatusesById](#Show-the-status)      | Returns a single specified tweet. |
| [destroyStatusById](#Delete-the-status)      | Deletes a single specified tweet.|

### Operation details

This section provides further details on the operations related to tweets.

#### Retweets a tweet.
The retweet operation retweets a specified tweet.

**retweet**
```xml
<twitter.retweet>
   <id>{$ctx:id}</id>
   <trimUser>{$ctx:trimUser}</trimUser>
</twitter.retweet>
```

**Properties**
* id: The numerical id of the desired status.
* trimUser: When set to either true, t or 1, each tweet returned in a timeline will include a user object including only the status authors numerical ID. Omit this parameter to receive the complete user object.

**Sample request**

Following is a sample REST/JSON request that can be handled by the  retweet  operation.

**Sample Request for retweet**
```json
{
    "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
    "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
    "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
    "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
    "id":"1024278510771134464"
}
```

**Sample Response**

```json
{
    "created_at": "Tue May 07 06:05:12 +0000 2019",
    "id": 1125642719924297728,
    "id_str": "1125642719924297728",
    "text": "RT @ayo32039237: Maybe he'll finally find his keyki",
    "truncated": false,
    "entities": {
        "hashtags": [],
        "symbols": [],
        "user_mentions": [
            {
                "screen_name": "ayo32039237",
                "name": "ayo",
                "id": 1114072936665821184,
                "id_str": "1114072936665821184",
                "indices": [
                    3,
                    15
                ]
            }
        ],
        "urls": []
    },
    "source": "<a href=\"https://api.twitter.com\" rel=\"nofollow\">IntegrationESB</a>",
    "in_reply_to_status_id": null,
    "in_reply_to_status_id_str": null,
    "in_reply_to_user_id": null,
    "in_reply_to_user_id_str": null,
    "in_reply_to_screen_name": null,
    "user": {
        "id": 1114072936665821184,
        "id_str": "1114072936665821184",
        "name": "ayo",
        "screen_name": "ayo32039237",
        "location": "",
        "description": "",
        "url": null,
        "entities": {
            "description": {
                "urls": []
            }
        },
        "protected": false,
        "followers_count": 0,
        "friends_count": 0,
        "listed_count": 0,
        "created_at": "Fri Apr 05 07:51:01 +0000 2019",
        "favourites_count": 0,
        "utc_offset": null,
        "time_zone": null,
        "geo_enabled": false,
        "verified": false,
        "statuses_count": 12,
        "lang": "en",
        "contributors_enabled": false,
        "is_translator": false,
        "is_translation_enabled": false,
        "profile_background_color": "F5F8FA",
        "profile_background_image_url": null,
        "profile_background_image_url_https": null,
        "profile_background_tile": false,
        "profile_image_url": "http://abs.twimg.com/sticky/default_profile_images/default_profile_normal.png",
        "profile_image_url_https": "https://abs.twimg.com/sticky/default_profile_images/default_profile_normal.png",
        "profile_link_color": "1DA1F2",
        "profile_sidebar_border_color": "C0DEED",
        "profile_sidebar_fill_color": "DDEEF6",
        "profile_text_color": "333333",
        "profile_use_background_image": true,
        "has_extended_profile": false,
        "default_profile": true,
        "default_profile_image": true,
        "following": false,
        "follow_request_sent": false,
        "notifications": false,
        "translator_type": "none"
    },
    "geo": null,
    "coordinates": null,
    "place": null,
    "contributors": null,
    "retweeted_status": {
        "created_at": "Tue May 07 05:23:31 +0000 2019",
        "id": 1125632230502563841,
        "id_str": "1125632230502563841",
        "text": "Maybe he'll finally find his keyki",
        "truncated": false,
        "entities": {
            "hashtags": [],
            "symbols": [],
            "user_mentions": [],
            "urls": []
        },
        "source": "<a href=\"https://api.twitter.com\" rel=\"nofollow\">IntegrationESB</a>",
        "in_reply_to_status_id": null,
        "in_reply_to_status_id_str": null,
        "in_reply_to_user_id": null,
        "in_reply_to_user_id_str": null,
        "in_reply_to_screen_name": null,
        "user": {
            "id": 1114072936665821184,
            "id_str": "1114072936665821184",
            "name": "ayo",
            "screen_name": "ayo32039237",
            "location": "",
            "description": "",
            "url": null,
            "entities": {
                "description": {
                    "urls": []
                }
            },
            "protected": false,
            "followers_count": 0,
            "friends_count": 0,
            "listed_count": 0,
            "created_at": "Fri Apr 05 07:51:01 +0000 2019",
            "favourites_count": 0,
            "utc_offset": null,
            "time_zone": null,
            "geo_enabled": false,
            "verified": false,
            "statuses_count": 12,
            "lang": "en",
            "contributors_enabled": false,
            "is_translator": false,
            "is_translation_enabled": false,
            "profile_background_color": "F5F8FA",
            "profile_background_image_url": null,
            "profile_background_image_url_https": null,
            "profile_background_tile": false,
            "profile_image_url": "http://abs.twimg.com/sticky/default_profile_images/default_profile_normal.png",
            "profile_image_url_https": "https://abs.twimg.com/sticky/default_profile_images/default_profile_normal.png",
            "profile_link_color": "1DA1F2",
            "profile_sidebar_border_color": "C0DEED",
            "profile_sidebar_fill_color": "DDEEF6",
            "profile_text_color": "333333",
            "profile_use_background_image": true,
            "has_extended_profile": false,
            "default_profile": true,
            "default_profile_image": true,
            "following": false,
            "follow_request_sent": false,
            "notifications": false,
            "translator_type": "none"
        },
        "geo": null,
        "coordinates": null,
        "place": null,
        "contributors": null,
        "is_quote_status": false,
        "retweet_count": 1,
        "favorite_count": 0,
        "favorited": false,
        "retweeted": true,
        "lang": "en"
    },
    "is_quote_status": false,
    "retweet_count": 1,
    "favorite_count": 0,
    "favorited": false,
    "retweeted": true,
    "lang": "en"
}

```

**Related Twitter documentation**

https://developer.twitter.com/en/docs/tweets/post-and-engage/api-reference/post-statuses-retweet-id

####  Retrieving the statuses of the retweet.

The getStatusesRetweetsById operation retrieves the statuses of a retweet.

**getStatusesRetweetsById**
```xml
<twitter.getStatusesRetweetsById>
   <id>{$ctx:id}</id>
   <trimUser>{$ctx:trimUser}</trimUser>
   <count>{$ctx:count}</count>
</twitter.getStatusesRetweetsById>
```

**Properties**
* id: The numerical id of the desired status.
* trimUser: When set to either true, t or 1, each tweet returned in a timeline will include a user object including only the status authors numerical ID. Omit this parameter to receive the complete user object.
* count: Specifies the number of records to retrieve. Must be less than or equal to 100.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getStatusesRetweetsById operation.

```json
{
    "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
    "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
    "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
    "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
    "id":"1047056678825463808"
 }
```

**Sample Response**

```json
[
    {
        "created_at": "Tue May 07 10:54:15 +0000 2019",
        "id": 1125715460291530752,
        "id_str": "1125715460291530752",
        "text": "RT @ayo32039237: Maybe he'll finally find his son3",
        "truncated": false,
        "entities": {
            "hashtags": [],
            "symbols": [],
            "user_mentions": [
                {
                    "screen_name": "ayo32039237",
                    "name": "ayo",
                    "id": 1114072936665821184,
                    "id_str": "1114072936665821184",
                    "indices": [
                        3,
                        15
                    ]
                }
            ],
            "urls": []
        },
        "source": "<a href=\"https://api.twitter.com\" rel=\"nofollow\">IntegrationESB</a>",
        "in_reply_to_status_id": null,
        "in_reply_to_status_id_str": null,
        "in_reply_to_user_id": null,
        "in_reply_to_user_id_str": null,
        "in_reply_to_screen_name": null,
        "user": {
            "id": 1114072936665821184,
            "id_str": "1114072936665821184",
            "name": "ayo",
            "screen_name": "ayo32039237",
            "location": "",
            "description": "",
            "url": null,
            "entities": {
                "description": {
                    "urls": []
                }
            },
            "protected": false,
            "followers_count": 0,
            "friends_count": 0,
            "listed_count": 0,
            "created_at": "Fri Apr 05 07:51:01 +0000 2019",
            "favourites_count": 0,
            "utc_offset": null,
            "time_zone": null,
            "geo_enabled": false,
            "verified": false,
            "statuses_count": 21,
            "lang": "en",
            "contributors_enabled": false,
            "is_translator": false,
            "is_translation_enabled": false,
            "profile_background_color": "F5F8FA",
            "profile_background_image_url": null,
            "profile_background_image_url_https": null,
            "profile_background_tile": false,
            "profile_image_url": "http://abs.twimg.com/sticky/default_profile_images/default_profile_normal.png",
            "profile_image_url_https": "https://abs.twimg.com/sticky/default_profile_images/default_profile_normal.png",
            "profile_link_color": "1DA1F2",
            "profile_sidebar_border_color": "C0DEED",
            "profile_sidebar_fill_color": "DDEEF6",
            "profile_text_color": "333333",
            "profile_use_background_image": true,
            "has_extended_profile": false,
            "default_profile": true,
            "default_profile_image": true,
            "following": false,
            "follow_request_sent": false,
            "notifications": false,
            "translator_type": "none"
        },
        "geo": null,
        "coordinates": null,
        "place": null,
        "contributors": null,
        "retweeted_status": {
            "created_at": "Tue May 07 10:45:40 +0000 2019",
            "id": 1125713299876847622,
            "id_str": "1125713299876847622",
            "text": "Maybe he'll finally find his son3",
            "truncated": false,
            "entities": {
                "hashtags": [],
                "symbols": [],
                "user_mentions": [],
                "urls": []
            },
            "source": "<a href=\"https://api.twitter.com\" rel=\"nofollow\">IntegrationESB</a>",
            "in_reply_to_status_id": null,
            "in_reply_to_status_id_str": null,
            "in_reply_to_user_id": null,
            "in_reply_to_user_id_str": null,
            "in_reply_to_screen_name": null,
            "user": {
                "id": 1114072936665821184,
                "id_str": "1114072936665821184",
                "name": "ayo",
                "screen_name": "ayo32039237",
                "location": "",
                "description": "",
                "url": null,
                "entities": {
                    "description": {
                        "urls": []
                    }
                },
                "protected": false,
                "followers_count": 0,
                "friends_count": 0,
                "listed_count": 0,
                "created_at": "Fri Apr 05 07:51:01 +0000 2019",
                "favourites_count": 0,
                "utc_offset": null,
                "time_zone": null,
                "geo_enabled": false,
                "verified": false,
                "statuses_count": 21,
                "lang": "en",
                "contributors_enabled": false,
                "is_translator": false,
                "is_translation_enabled": false,
                "profile_background_color": "F5F8FA",
                "profile_background_image_url": null,
                "profile_background_image_url_https": null,
                "profile_background_tile": false,
                "profile_image_url": "http://abs.twimg.com/sticky/default_profile_images/default_profile_normal.png",
                "profile_image_url_https": "https://abs.twimg.com/sticky/default_profile_images/default_profile_normal.png",
                "profile_link_color": "1DA1F2",
                "profile_sidebar_border_color": "C0DEED",
                "profile_sidebar_fill_color": "DDEEF6",
                "profile_text_color": "333333",
                "profile_use_background_image": true,
                "has_extended_profile": false,
                "default_profile": true,
                "default_profile_image": true,
                "following": false,
                "follow_request_sent": false,
                "notifications": false,
                "translator_type": "none"
            },
            "geo": null,
            "coordinates": null,
            "place": null,
            "contributors": null,
            "is_quote_status": false,
            "retweet_count": 1,
            "favorite_count": 0,
            "favorited": false,
            "retweeted": true,
            "lang": "en"
        },
        "is_quote_status": false,
        "retweet_count": 1,
        "favorite_count": 0,
        "favorited": false,
        "retweeted": true,
        "lang": "en"
    }
]

```
**Related Twitter documentation**

https://developer.twitter.com/en/docs/tweets/post-and-engage/api-reference/get-statuses-retweets-id

####  Show the status

The showStatusesById operation retrieves a single specified tweet

**showStatusesById**
```xml
<twitter.showStatusesById>                 
   <id>{$ctx:id}</id>
   <trimUser>{$ctx:trimUser}</trimUser>
   <includeEntities>{$ctx:includeEntities}</includeEntities>
   <includeMyRetweet>{$ctx:includeMyRetweet}</includeMyRetweet>
   <includeExtAltText>{$ctx:includeExtAltText}</includeExtAltText>
   <includeCardUri>{$ctx:includeCardUri}</includeCardUri>
<twitter.showStatusesById/>
```
**Properties**

* id: The numerical id of the desired status.
* trimUser: When set to either true, t or 1, each tweet returned in a timeline will include a user object including only the status authors numerical ID. Omit this parameter to receive the complete user object.
* includeEntities: The entities node will be excluded when set to false.
* includeMyRetweet: When set to either true, t or 1, any tweets returned that have been retweeted by the authenticating user will include an additional current_user_retweet node, containing the ID of the source status for the retweet.
* includeExtAltText:If alt text has been added to any attached media entities, this parameter will return an ext_alt_text value in the top-level key for the media entity. If no value has been set, this will be returned as null.
* includeCardUri:When set to either true , t or 1 , the retrieved Tweet will include a card_uri attribute when there is an ads card attached to the Tweet and when that card was attached using the card_uri value.

**Sample request**

Following is a sample REST/JSON request that can be handled by the blockUser operation.

```json
{
    "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
    "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
    "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
    "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
    "id":"1047056678825463808"
 }
```


**Sample Response**

```json
{
    "created_at": "Tue May 07 05:23:31 +0000 2019",
    "id": 1125632230502563841,
    "id_str": "1125632230502563841",
    "text": "Maybe he'll finally find his keyki",
    "truncated": false,
    "entities": {
        "hashtags": [],
        "symbols": [],
        "user_mentions": [],
        "urls": []
    },
    "source": "<a href=\"https://api.twitter.com\" rel=\"nofollow\">IntegrationESB</a>",
    "in_reply_to_status_id": null,
    "in_reply_to_status_id_str": null,
    "in_reply_to_user_id": null,
    "in_reply_to_user_id_str": null,
    "in_reply_to_screen_name": null,
    "user": {
        "id": 1114072936665821184,
        "id_str": "1114072936665821184",
        "name": "ayo",
        "screen_name": "ayo32039237",
        "location": "",
        "description": "",
        "url": null,
        "entities": {
            "description": {
                "urls": []
            }
        },
        "protected": false,
        "followers_count": 0,
        "friends_count": 0,
        "listed_count": 0,
        "created_at": "Fri Apr 05 07:51:01 +0000 2019",
        "favourites_count": 0,
        "utc_offset": null,
        "time_zone": null,
        "geo_enabled": false,
        "verified": false,
        "statuses_count": 20,
        "lang": "en",
        "contributors_enabled": false,
        "is_translator": false,
        "is_translation_enabled": false,
        "profile_background_color": "F5F8FA",
        "profile_background_image_url": null,
        "profile_background_image_url_https": null,
        "profile_background_tile": false,
        "profile_image_url": "http://abs.twimg.com/sticky/default_profile_images/default_profile_normal.png",
        "profile_image_url_https": "https://abs.twimg.com/sticky/default_profile_images/default_profile_normal.png",
        "profile_link_color": "1DA1F2",
        "profile_sidebar_border_color": "C0DEED",
        "profile_sidebar_fill_color": "DDEEF6",
        "profile_text_color": "333333",
        "profile_use_background_image": true,
        "has_extended_profile": false,
        "default_profile": true,
        "default_profile_image": true,
        "following": false,
        "follow_request_sent": false,
        "notifications": false,
        "translator_type": "none"
    },
    "geo": null,
    "coordinates": null,
    "place": null,
    "contributors": null,
    "is_quote_status": false,
    "retweet_count": 1,
    "favorite_count": 0,
    "favorited": false,
    "retweeted": true,
    "lang": "en"
}
```


**Related Twitter documentation**

https://developer.twitter.com/en/docs/tweets/post-and-engage/api-reference/get-statuses-show-id

####  Delete the status

The destroyStatusById operation deletes a single specified tweet

**destroyStatusById**
```xml
<twitter.destroyStatusById>
   <id>{$ctx:id}</id>
   <trimUser>{$ctx:trimUser}</trimUser>
</twitter.destroyStatusById>
```
**Properties**

* id: The numerical id of the desired status.
* trimUser: When set to either true, t or 1, each tweet returned in a timeline will include a user object including only the status authors numerical ID. Omit this parameter to receive the complete user object.

**Sample request**

Following is a sample REST/JSON request that can be handled by the destroyStatusById operation.

```json
{
    "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
    "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
    "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
    "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
    "id":"1047056678825463808"
 }
```


**Sample Response**

```json
{
    "created_at": "Tue May 07 07:02:26 +0000 2019",
    "id": 1125657123969433600,
    "id_str": "1125657123969433600",
    "text": "Maybe he'll finally find his keyki9",
    "truncated": false,
    "entities": {
        "hashtags": [],
        "symbols": [],
        "user_mentions": [],
        "urls": []
    },
    "source": "<a href=\"https://api.twitter.com\" rel=\"nofollow\">IntegrationESB</a>",
    "in_reply_to_status_id": null,
    "in_reply_to_status_id_str": null,
    "in_reply_to_user_id": null,
    "in_reply_to_user_id_str": null,
    "in_reply_to_screen_name": null,
    "user": {
        "id": 1114072936665821184,
        "id_str": "1114072936665821184",
        "name": "ayo",
        "screen_name": "ayo32039237",
        "location": "",
        "description": "",
        "url": null,
        "entities": {
            "description": {
                "urls": []
            }
        },
        "protected": false,
        "followers_count": 0,
        "friends_count": 0,
        "listed_count": 0,
        "created_at": "Fri Apr 05 07:51:01 +0000 2019",
        "favourites_count": 0,
        "utc_offset": null,
        "time_zone": null,
        "geo_enabled": false,
        "verified": false,
        "statuses_count": 10,
        "lang": "en",
        "contributors_enabled": false,
        "is_translator": false,
        "is_translation_enabled": false,
        "profile_background_color": "F5F8FA",
        "profile_background_image_url": null,
        "profile_background_image_url_https": null,
        "profile_background_tile": false,
        "profile_image_url": "http://abs.twimg.com/sticky/default_profile_images/default_profile_normal.png",
        "profile_image_url_https": "https://abs.twimg.com/sticky/default_profile_images/default_profile_normal.png",
        "profile_link_color": "1DA1F2",
        "profile_sidebar_border_color": "C0DEED",
        "profile_sidebar_fill_color": "DDEEF6",
        "profile_text_color": "333333",
        "profile_use_background_image": true,
        "has_extended_profile": false,
        "default_profile": true,
        "default_profile_image": true,
        "following": false,
        "follow_request_sent": false,
        "notifications": false,
        "translator_type": "none"
    },
    "geo": null,
    "coordinates": null,
    "place": null,
    "contributors": null,
    "is_quote_status": false,
    "retweet_count": 0,
    "favorite_count": 0,
    "favorited": false,
    "retweeted": false,
    "lang": "en"
}
```


**Related Twitter documentation**

https://developer.twitter.com/en/docs/tweets/post-and-engage/api-reference/post-statuses-destroy-id

#### Sample configuration

Following is a sample proxy service that illustrates how to connect to Twitter with the init operation and use the getStatusesRetweetsById operation. The sample request for this proxy can be found in getStatusesRetweetsById sample request. You can use this sample as a template for using other operations in this category.

1. Create a sample proxy as below :

    **Sample Proxy**
    ```xml
   <proxy xmlns="http://ws.apache.org/ns/synapse"
          name="getStatusesRetweetsById"
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
            <property name="id" expression="json-eval($.id)"/>
            <property name="count" expression="json-eval($.count)"/>
            <twitter.init>
                <consumerKey>{$ctx:consumerKey}</consumerKey>
                <consumerSecret>{$ctx:consumerSecret}</consumerSecret>
                <accessToken>{$ctx:accessToken}</accessToken>
                <accessTokenSecret>{$ctx:accessTokenSecret}</accessTokenSecret>
            </twitter.init>     
             <twitter.getStatusesRetweetsById>
                <id>{$ctx:id}</id>
                <trimUser>{$ctx:trimUser}</trimUser>
                <count>{$ctx:count}</count>
             </twitter.getStatusesRetweetsById>
            <respond/>
         </inSequence>
         <outSequence>
           <send/>
         </outSequence>
      </target>
      <description/>
   </proxy>
    
    ```
2. Create a json file named getStatusesRetweetsById.json and copy the configurations given below to it:

    ```json
    {
        "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
        "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
        "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
        "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
        "id":"1047056678825463808"
     }
    ```
3. Replace the credentials with your values.

4. Execute the following curl command:

    ```bash
    curl -X POST http://localhost:8280/services/getStatusesRetweetsById --header 'Content-Type: application/json' -d @getStatusesRetweetsById.json
    ```

5. Twitter returns a json response similar to the one shown below:
 
```json
[
    {
        "created_at": "Tue May 07 10:54:15 +0000 2019",
        "id": 1125715460291530752,
        "id_str": "1125715460291530752",
        "text": "RT @ayo32039237: Maybe he'll finally find his son3",
        "truncated": false,
        "entities": {
            "hashtags": [],
            "symbols": [],
            "user_mentions": [
                {
                    "screen_name": "ayo32039237",
                    "name": "ayo",
                    "id": 1114072936665821184,
                    "id_str": "1114072936665821184",
                    "indices": [
                        3,
                        15
                    ]
                }
            ],
            "urls": []
        },
        "source": "<a href=\"https://api.twitter.com\" rel=\"nofollow\">IntegrationESB</a>",
        "in_reply_to_status_id": null,
        "in_reply_to_status_id_str": null,
        "in_reply_to_user_id": null,
        "in_reply_to_user_id_str": null,
        "in_reply_to_screen_name": null,
        "user": {
            "id": 1114072936665821184,
            "id_str": "1114072936665821184",
            "name": "ayo",
            "screen_name": "ayo32039237",
            "location": "",
            "description": "",
            "url": null,
            "entities": {
                "description": {
                    "urls": []
                }
            },
            "protected": false,
            "followers_count": 0,
            "friends_count": 0,
            "listed_count": 0,
            "created_at": "Fri Apr 05 07:51:01 +0000 2019",
            "favourites_count": 0,
            "utc_offset": null,
            "time_zone": null,
            "geo_enabled": false,
            "verified": false,
            "statuses_count": 21,
            "lang": "en",
            "contributors_enabled": false,
            "is_translator": false,
            "is_translation_enabled": false,
            "profile_background_color": "F5F8FA",
            "profile_background_image_url": null,
            "profile_background_image_url_https": null,
            "profile_background_tile": false,
            "profile_image_url": "http://abs.twimg.com/sticky/default_profile_images/default_profile_normal.png",
            "profile_image_url_https": "https://abs.twimg.com/sticky/default_profile_images/default_profile_normal.png",
            "profile_link_color": "1DA1F2",
            "profile_sidebar_border_color": "C0DEED",
            "profile_sidebar_fill_color": "DDEEF6",
            "profile_text_color": "333333",
            "profile_use_background_image": true,
            "has_extended_profile": false,
            "default_profile": true,
            "default_profile_image": true,
            "following": false,
            "follow_request_sent": false,
            "notifications": false,
            "translator_type": "none"
        },
        "geo": null,
        "coordinates": null,
        "place": null,
        "contributors": null,
        "retweeted_status": {
            "created_at": "Tue May 07 10:45:40 +0000 2019",
            "id": 1125713299876847622,
            "id_str": "1125713299876847622",
            "text": "Maybe he'll finally find his son3",
            "truncated": false,
            "entities": {
                "hashtags": [],
                "symbols": [],
                "user_mentions": [],
                "urls": []
            },
            "source": "<a href=\"https://api.twitter.com\" rel=\"nofollow\">IntegrationESB</a>",
            "in_reply_to_status_id": null,
            "in_reply_to_status_id_str": null,
            "in_reply_to_user_id": null,
            "in_reply_to_user_id_str": null,
            "in_reply_to_screen_name": null,
            "user": {
                "id": 1114072936665821184,
                "id_str": "1114072936665821184",
                "name": "ayo",
                "screen_name": "ayo32039237",
                "location": "",
                "description": "",
                "url": null,
                "entities": {
                    "description": {
                        "urls": []
                    }
                },
                "protected": false,
                "followers_count": 0,
                "friends_count": 0,
                "listed_count": 0,
                "created_at": "Fri Apr 05 07:51:01 +0000 2019",
                "favourites_count": 0,
                "utc_offset": null,
                "time_zone": null,
                "geo_enabled": false,
                "verified": false,
                "statuses_count": 21,
                "lang": "en",
                "contributors_enabled": false,
                "is_translator": false,
                "is_translation_enabled": false,
                "profile_background_color": "F5F8FA",
                "profile_background_image_url": null,
                "profile_background_image_url_https": null,
                "profile_background_tile": false,
                "profile_image_url": "http://abs.twimg.com/sticky/default_profile_images/default_profile_normal.png",
                "profile_image_url_https": "https://abs.twimg.com/sticky/default_profile_images/default_profile_normal.png",
                "profile_link_color": "1DA1F2",
                "profile_sidebar_border_color": "C0DEED",
                "profile_sidebar_fill_color": "DDEEF6",
                "profile_text_color": "333333",
                "profile_use_background_image": true,
                "has_extended_profile": false,
                "default_profile": true,
                "default_profile_image": true,
                "following": false,
                "follow_request_sent": false,
                "notifications": false,
                "translator_type": "none"
            },
            "geo": null,
            "coordinates": null,
            "place": null,
            "contributors": null,
            "is_quote_status": false,
            "retweet_count": 1,
            "favorite_count": 0,
            "favorited": false,
            "retweeted": true,
            "lang": "en"
        },
        "is_quote_status": false,
        "retweet_count": 1,
        "favorite_count": 0,
        "favorited": false,
        "retweeted": true,
        "lang": "en"
    }
]

```
