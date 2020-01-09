# Working with Favorites in Twitter

[[  Overview ]](#overview)  [[ Operation details ]](#operation-details)  [[  Sample configuration  ]](#sample-configuration)

### Overview 

The following operations allow you to work with favorites in Twitter.  Click an operation name to see details on how to use it.
For a sample proxy service that illustrates how to work with favorites, see [Sample configuration](#sample-configuration).

| Operation        | Description |
| ------------- |-------------|
| [getFavoritesList](#Retrieving-the-most-recent-favorites-list)    | Retrieves the 20 most recent favorite tweets. |
| [createFavorites](#Setting-a-tweet-as-a-favorite)      | Sets a tweet as a favorite. |
| [destroyFavorites](#Destroying-a-favorite)      | Unfavorites a favorite tweet. |

### Operation details

This section provides details on the operations.

#### Retrieving the most recent favorites list
The  getFavoritesList operation retrieves the 20 most recent tweets set as a favorite by the authenticating or specified user.

**getFavoritesList**
```xml
<twitter.getFavoritesList>
    <userID>{$ctx:userID}</userID>
    <screenName>{$ctx:screenName}</screenName>
    <sinceId>{$ctx:sinceId}</sinceId>
    <count>{$ctx:count}</count>
    <maxId>{$ctx:maxId}</maxId>
    <includeEntities>{$ctx:includeEntities}</includeEntities>
 </twitter.getFavoritesList>
```
 
 **Properties**
* userID: The ID of the user.
* screenName: The screen name of the user.
* sinceId: Returns results with an ID greater than (i.e., more recent than) the specified ID. For example, If there have been more than 800 tweets set as favorite since the specified ID, sinceId will be forced to the oldest ID available.
* count: The number of records to retrieve.
* maxId:  Returns results with an ID less than (i.e., older than) or equal to the specified ID.
* includeEntities: Set to false if you do not want the entities node to be included.
 
**Sample request**

Following is a sample REST/JSON request that can be handled by the getFavoritesList operation.

```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "screenName":"TestUser",
  "sinceId":"12562",
  "maxId":"52456",
  "includeEntities":"false"
}
```

**Sample Response**

```json
[
    {
        "created_at": "Wed May 08 09:42:06 +0000 2019",
        "id": 1126059692961214464,
        "id_str": "1126059692961214464",
        "text": "1557308524832Maybe he'll finally find his own keys",
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
            "favourites_count": 8,
            "utc_offset": null,
            "time_zone": null,
            "geo_enabled": false,
            "verified": false,
            "statuses_count": 35,
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
        "favorite_count": 1,
        "favorited": true,
        "retweeted": false,
        "lang": "en"
    },
    {
        "created_at": "Wed May 08 09:26:26 +0000 2019",
        "id": 1126055748964892672,
        "id_str": "1126055748964892672",
        "text": "1557307583842Maybe he'll finally find his own keys",
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
            "favourites_count": 8,
            "utc_offset": null,
            "time_zone": null,
            "geo_enabled": false,
            "verified": false,
            "statuses_count": 35,
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
        "favorite_count": 1,
        "favorited": true,
        "retweeted": false,
        "lang": "en"
    }
  ]
```

**Related Twitter documentation**

https://dev.twitter.com/rest/reference/get/favorites/list

####  Setting a tweet as a favorite

The createFavorites operation favorites a tweet specified in the ID parameter as the authenticating user. 

**createFavorites**
```xml
<twitter.createFavorites>
    <id>{$ctx:id}</id>
    <includeEntities>{$ctx:includeEntities}</includeEntities>
 </twitter.createFavorites>
```

**Properties**
* id: Required - The numerical ID of the tweet to be set as a favorite.
* includeEntities: Set to false if you do not want the entities node to be included.

**Sample request**

Following is a sample REST/JSON request that can be handled by the createFavorites operation.

```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "id":"123",
  "includeEntities":"false"
}
```

**Sample Response**

```json
{
    "created_at": "Wed May 08 08:46:45 +0000 2019",
    "id": 1126045763090382848,
    "id_str": "1126045763090382848",
    "text": "Maybe he'll finally find his sonjj",
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
        "favourites_count": 4,
        "utc_offset": null,
        "time_zone": null,
        "geo_enabled": false,
        "verified": false,
        "statuses_count": 27,
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
    "favorite_count": 1,
    "favorited": true,
    "retweeted": false,
    "lang": "en"
}
```


**Related Twitter documentation**

https://dev.twitter.com/rest/reference/post/favorites/create

####  Destroying a favorite

The destroyFavorites operation unfavorites a tweet specified in the ID parameter as the authenticating user.

**createContacts**
```xml
<twitter.destroyFavorites>
    <id>{$ctx:id}</id>
    <includeEntities>{$ctx:includeEntities}</includeEntities>
 </twitter.destroyFavorites>
```
**Properties**

* id: Required - The numerical ID of the tweet to unfavorite.
* includeEntities: Set to false if you do not want the entities node to be included.


**Sample request**

Following is a sample REST/JSON request that can be handled by the destroyFavorites operation.

```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "id":"123",
  "includeEntities":"false"
}
```


**Sample Response**

```json
{
    "created_at": "Wed May 08 08:46:45 +0000 2019",
    "id": 1126045763090382848,
    "id_str": "1126045763090382848",
    "text": "Maybe he'll finally find his sonjj",
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
        "favourites_count": 8,
        "utc_offset": null,
        "time_zone": null,
        "geo_enabled": false,
        "verified": false,
        "statuses_count": 36,
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

https://dev.twitter.com/rest/reference/post/favorites/destroy

#### Sample configuration

Following is a sample proxy service that illustrates how to connect to Twitter with the init operation and use the getFavoritesList operation. The sample request for this proxy can be found in getFavoritesList sample request. You can use this sample as a template for using other operations in this category.

1. Create a sample proxy as below :

    **Sample Proxy**
    ```xml
    <proxy xmlns="http://ws.apache.org/ns/synapse"
           name="getFavoritesList"
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
             <property name="screenName" expression="json-eval($.screenName)"/>
             <property name="count" expression="json-eval($.count)"/>
             <property name="includeEntities" expression="json-eval($.includeEntities)"/>
             <twitter.init>
                <consumerKey>{$ctx:consumerKey}</consumerKey>
                <consumerSecret>{$ctx:consumerSecret}</consumerSecret>
                <accessToken>{$ctx:accessToken}</accessToken>
                <accessTokenSecret>{$ctx:accessTokenSecret}</accessTokenSecret>
             </twitter.init>
             <twitter.getFavoritesList>
                <screenName>{$ctx:screenName}</screenName>
                <count>{$ctx:count}</count>
                <includeEntities>{$ctx:includeEntities}</includeEntities>
             </twitter.getFavoritesList>
             <respond/>
          </inSequence>
          <outSequence>
             <send/>
          </outSequence>
       </target>
       <description/>
    </proxy>
    
    ```
2. Create a json file named getFavoritesList.json and copy the configurations given below to it:

    ```json
    {
      "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
      "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
      "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
      "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
      "screenName":"TestUser",
      "sinceId":"12562",
      "maxId":"52456",
      "includeEntities":"false"
    }
    ```
3. Replace the credentials with your values.

4. Execute the following curl command:

    ```bash
    curl -X POST http://localhost:8280/services/getFavoritesList --header 'Content-Type: application/json' -d @getFavoritesList.json
    ```

5. Twitter returns a json response similar to the one shown below:
 
```json
[
    {
        "created_at": "Wed May 08 09:42:06 +0000 2019",
        "id": 1126059692961214464,
        "id_str": "1126059692961214464",
        "text": "1557308524832Maybe he'll finally find his own keys",
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
            "favourites_count": 8,
            "utc_offset": null,
            "time_zone": null,
            "geo_enabled": false,
            "verified": false,
            "statuses_count": 35,
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
        "favorite_count": 1,
        "favorited": true,
        "retweeted": false,
        "lang": "en"
    },
    {
        "created_at": "Wed May 08 09:26:26 +0000 2019",
        "id": 1126055748964892672,
        "id_str": "1126055748964892672",
        "text": "1557307583842Maybe he'll finally find his own keys",
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
            "favourites_count": 8,
            "utc_offset": null,
            "time_zone": null,
            "geo_enabled": false,
            "verified": false,
            "statuses_count": 35,
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
        "favorite_count": 1,
        "favorited": true,
        "retweeted": false,
        "lang": "en"
    }
  ]
```
