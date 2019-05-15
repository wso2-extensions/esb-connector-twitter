# Working with Users in Twitter

[[  Overview ]](#overview)  [[ Operation details ]](#operation-details)  [[  Sample configuration  ]](#sample-configuration)

### Overview 

The following operations allow you to work with users in Twitter. Click an operation name to see details on how to use it.
For a sample proxy service that illustrates how to work with users, see [Sample configuration](#sample-configuration).

| Operation        | Description |
| ------------- |-------------|
| [getMutesUsersIds](#Retrieving-IDs-of-muted-users)    | Retrieves an array of user IDs that the authenticating user has muted. |
| [getMutesUsersList](#Retrieving-a-list-of-muted-users)      | Retrieves an array of user objects that the authenticating user has muted. |
| [getUsersLookup](#Retrieving-user-information)      |Retrieves fully-hydrated user objects of up to 100 users per request. |
| [getUsersShow](#Retrieving information of a particular user)      |	Retrieves information about a specified user.|
| [getUsersSuggestions](#Retrieving-suggested-user-categories)      |	Retrieves the list of suggested user categories.|
| [createMutesUsers](#Muting-a-user)      |Mutes a specified user.|
| [destroyMutesUsers](#Un-muting-a-user)      |Un-mutes a specified user.|

### Operation details

This section provides further details on the operations.

#### Retrieving IDs of muted users
The getMutesUsersIds operation retrieves an array of numeric user IDs that the authenticating user has muted.

**getMutesUsersIds**
```xml
<twitter.getMutesUsersIds>
    <cursor>{$ctx:cursor}</cursor>
</twitter.getMutesUsersIds>
```

**Properties**
* cursor: The cursor ID of the response page to retrieve. If you do not specify a cursor, a value of -1 will be assumed, which is the first page.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getMutesUsersIds operation.

**Sample Request for getMutesUsersIds**
```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "cursor":"-1"
 }
```

**Sample Response**

```json
{
    "ids": [
        785972206132011008
    ],
    "next_cursor": 0,
    "next_cursor_str": "0",
    "previous_cursor": 0,
    "previous_cursor_str": "0",
    "total_count": null
}
```

**Related Twitter documentation**

https://dev.twitter.com/rest/reference/get/mutes/users/ids

####  Retrieving a list of muted users

The getMutesUsersList operation retrieves an array of user objects that the authenticating user has muted.

**getMutesUsersList**
```xml
<twitter.getMutesUsersList>
    <cursor>{$ctx:cursor}</cursor>
    <skipStatus>{$ctx:skipStatus}</skipStatus>
    <includeEntities>{$ctx:includeEntities}</includeEntities>
 </twitter.getMutesUsersList>
```

**Properties**
* cursor: The cursor ID of the response page to retrieve. If you do not specify a cursor, a value of -1 will be assumed, which is the first page.
* skipStatus: Set to either true, t or 1 if you do not want the status to be included in the returned user objects.
* includeEntities: Set to false if you do not want the entities node to be included in the returned user objects.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getMutesUsersList operation.


```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "cursor":"-1",
  "skipStatus":"false",
  "includeEntities":"true"
}
```

**Sample Response**

```json
{
    "users": [
        {
            "id": 785972206132011008,
            "id_str": "785972206132011008",
            "name": "test User",
            "screen_name": "TestUser",
            "location": "",
            "description": "",
            "url": null,
            "entities": {
                "description": {
                    "urls": []
                }
            },
            "protected": false,
            "followers_count": 24,
            "friends_count": 0,
            "listed_count": 0,
            "created_at": "Tue Oct 11 22:35:51 +0000 2016",
            "favourites_count": 0,
            "utc_offset": null,
            "time_zone": null,
            "geo_enabled": false,
            "verified": false,
            "statuses_count": 6,
            "lang": "en",
            "status": {
                "created_at": "Fri Jul 13 13:31:46 +0000 2018",
                "id": 1017763516659519489,
                "id_str": "1017763516659519489",
                "text": "Checkout this A4 Poster Mockup Free PSD #freepsd #psd #freebie https://t.co/0OLyVwfRks via @psd_graphics",
                "truncated": false,
                "entities": {
                    "hashtags": [
                        {
                            "text": "freepsd",
                            "indices": [
                                40,
                                48
                            ]
                        },
                        {
                            "text": "psd",
                            "indices": [
                                49,
                                53
                            ]
                        },
                        {
                            "text": "freebie",
                            "indices": [
                                54,
                                62
                            ]
                        }
                    ],
                    "symbols": [],
                    "user_mentions": [
                        {
                            "screen_name": "psd_graphics",
                            "name": "psd graphics",
                            "id": 4902253861,
                            "id_str": "4902253861",
                            "indices": [
                                91,
                                104
                            ]
                        }
                    ],
                    "urls": [
                        {
                            "url": "https://t.co/0OLyVwfRks",
                            "expanded_url": "https://psd.graphics/mockups/a4-poster-mockup-free-psd/",
                            "display_url": "psd.graphics/mockups/a4-pos…",
                            "indices": [
                                63,
                                86
                            ]
                        }
                    ]
                },
                "source": "<a href=\"http://twitter.com\" rel=\"nofollow\">Twitter Web Client</a>",
                "in_reply_to_status_id": null,
                "in_reply_to_status_id_str": null,
                "in_reply_to_user_id": null,
                "in_reply_to_user_id_str": null,
                "in_reply_to_screen_name": null,
                "geo": null,
                "coordinates": null,
                "place": null,
                "contributors": null,
                "is_quote_status": false,
                "retweet_count": 0,
                "favorite_count": 1,
                "favorited": false,
                "retweeted": false,
                "possibly_sensitive": false,
                "lang": "en"
            },
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
            "live_following": false,
            "follow_request_sent": false,
            "notifications": false,
            "muting": true,
            "blocking": true,
            "blocked_by": false,
            "translator_type": "none"
        }
    ],
    "next_cursor": 0,
    "next_cursor_str": "0",
    "previous_cursor": 0,
    "previous_cursor_str": "0",
    "total_count": null
}
```
**Related Twitter documentation**

https://dev.twitter.com/rest/reference/get/mutes/users/list

####  Retrieving user information

The getUsersLookup operation retrieves fully hydrated user objects based on the provided comma separated list of screen names or user IDs. You can retrieve up to 100 user objects per request.

**getUsersLookup**
```xml
<twitter.getUsersLookup>
    <userID>{$ctx:userID}</userID>
    <screenName>{$ctx:screenName}</screenName>
    <includeEntities>{$ctx:includeEntities}</includeEntities>
 </twitter.getUsersLookup>
```
**Properties**

* userID: The ID of the user.
* screenName: The screen name of the user.
* includeEntities:  Set to false if you do not want the entities node to be included.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getLists operation.

```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "screenName": "ayo32039237"
 }
```


**Sample Response**

```json
[
    {
        "id": 1126362726773731328,
        "id_str": "1126362726773731328",
        "name": "listA",
        "uri": "/ayo32039237/lists/lista2",
        "subscriber_count": 0,
        "member_count": 0,
        "mode": "public",
        "description": "list A",
        "slug": "lista2",
        "full_name": "@ayo32039237/lista2",
        "created_at": "Thu May 09 05:46:15 +0000 2019",
        "following": true,
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
            "favourites_count": 7,
            "utc_offset": null,
            "time_zone": null,
            "geo_enabled": false,
            "verified": false,
            "statuses_count": 38,
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
        }
    },
    {
        "id": 1126362725112848384,
        "id_str": "1126362725112848384",
        "name": "listA",
        "uri": "/ayo32039237/lists/lista1",
        "subscriber_count": 0,
        "member_count": 0,
        "mode": "public",
        "description": "",
        "slug": "lista1",
        "full_name": "@ayo32039237/lista1",
        "created_at": "Thu May 09 05:46:15 +0000 2019",
        "following": true,
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
            "favourites_count": 7,
            "utc_offset": null,
            "time_zone": null,
            "geo_enabled": false,
            "verified": false,
            "statuses_count": 38,
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
        }
    },
    {
        "id": 1126362198299828224,
        "id_str": "1126362198299828224",
        "name": "listA",
        "uri": "/ayo32039237/lists/lista",
        "subscriber_count": 0,
        "member_count": 0,
        "mode": "public",
        "description": "list A",
        "slug": "lista",
        "full_name": "@ayo32039237/lista",
        "created_at": "Thu May 09 05:44:09 +0000 2019",
        "following": true,
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
            "favourites_count": 7,
            "utc_offset": null,
            "time_zone": null,
            "geo_enabled": false,
            "verified": false,
            "statuses_count": 38,
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
        }
    }
]
```


**Related Twitter documentation**

https://dev.twitter.com/rest/reference/get/mutes/users/list

####  Retrieving user information

The getUsersLookup operation retrieves fully hydrated user objects based on the provided comma separated list of screen names or user IDs. You can retrieve up to 100 user objects per request.

**getUsersLookup**
```xml
<twitter.getUsersLookup>
    <userID>{$ctx:userID}</userID>
    <screenName>{$ctx:screenName}</screenName>
    <includeEntities>{$ctx:includeEntities}</includeEntities>
 </twitter.getUsersLookup>
```
**Properties**

* userID: A comma separated list of user IDs of users for whom you need to retrieve results. You can specify up to 100 comma separated user IDs in a single request.
* screenName: A comma separated list of screen names of users for whom you need to retrieve results. You can specify up to 100 comma separated screen names in a single request.
* includeEntities:  Set to false if you do not want the entities node to be included.
**Sample request**

Following is a sample REST/JSON request that can be handled by the getUsersLookup operation.


```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "screenName":"TestUser"
}
```

**Sample Response**

```json
[
    {
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
        "favourites_count": 7,
        "utc_offset": null,
        "time_zone": null,
        "geo_enabled": false,
        "verified": false,
        "statuses_count": 40,
        "lang": "en",
        "status": {
            "created_at": "Thu May 09 11:35:53 +0000 2019",
            "id": 1126450713574498305,
            "id_str": "1126450713574498305",
            "text": "1557401743464Maybe he'll finally find his own keys",
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
        },
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
        "translator_type": "none",
        "suspended": false,
        "needs_phone_verification": false
    }
]
```


**Related Twitter documentation**

https://dev.twitter.com/rest/reference/get/users/lookup

####  Retrieving information of a particular user

The getUsersShow operation retrieves information of a specified user. The specified user's most recent tweet will be returned in-line when possible.

**getUsersShow**
```xml
<twitter.getUsersShow>
    <userID>{$ctx:userID}</userID>
    <screenName>{$ctx:screenName}</screenName>
    <includeEntities>{$ctx:includeEntities}</includeEntities>
 </twitter.getUsersShow>
```
**Properties**

* userID: The ID of the user to retrieve results for.
* screenName: The screen name of the user to retrieve results for.
* includeEntities: Set to false if you do not want the entities node to be included.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getUsersShow operation.
```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "screenName":"TestUser"
}
```

**Sample Response**

```json
{
    "id": 1114072936665821184,
    "id_str": "1114072936665821184",
    "name": "ayo",
    "screen_name": "ayo32039237",
    "location": "",
    "profile_location": null,
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
    "favourites_count": 7,
    "utc_offset": null,
    "time_zone": null,
    "geo_enabled": false,
    "verified": false,
    "statuses_count": 40,
    "lang": "en",
    "status": {
        "created_at": "Thu May 09 11:35:53 +0000 2019",
        "id": 1126450713574498305,
        "id_str": "1126450713574498305",
        "text": "1557401743464Maybe he'll finally find his own keys",
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
    },
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
    "translator_type": "none",
    "suspended": false,
    "needs_phone_verification": false
}
```


**Related Twitter documentation**

https://dev.twitter.com/rest/reference/get/users/show

####  Retrieving suggested user categories

The getUsersSuggestions retrieves a list of suggested user categories.

**getUsersSuggestions**
```xml
<twitter.getUsersSuggestions>
    <lang>{$ctx:lang}</lang>
 </twitter.getUsersSuggestions>
```
**Properties**

* lang: If specified this restricts the suggested categories to the specified language. The language must be specified using the appropriate two letter ISO 639-1 representation.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getUsersSuggestions operation.
```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "lang":"en"
}
```

**Sample Response**

```json
[
    {
        "size": 16,
        "slug": "sports",
        "name": "Sports"
    },
    {
        "size": 13,
        "slug": "television",
        "name": "Television"
    },
    {
        "size": 15,
        "slug": "music",
        "name": "Music"
    },
    {
        "size": 15,
        "slug": "fashion",
        "name": "Fashion"
    },
    {
        "size": 14,
        "slug": "entertainment",
        "name": "Entertainment"
    },
    {
        "size": 12,
        "slug": "books",
        "name": "Books"
    },
    {
        "size": 15,
        "slug": "gaming",
        "name": "Gaming"
    },
    {
        "size": 9,
        "slug": "family",
        "name": "Family"
    },
    {
        "size": 17,
        "slug": "food-drink",
        "name": "Food & Drink"
    },
    {
        "size": 15,
        "slug": "funny",
        "name": "Funny"
    },
    {
        "size": 10,
        "slug": "business",
        "name": "Business"
    },
    {
        "size": 14,
        "slug": "government",
        "name": "Government"
    },
    {
        "size": 18,
        "slug": "news",
        "name": "News"
    }
]
```

**Related Twitter documentation**

https://dev.twitter.com/rest/reference/get/users/suggestions

####  Muting a user

The createMutesUsers operation mutes a specified user.

**createMutesUsers**
```xml
<twitter.createMutesUsers>
    <userID>{$ctx:userID}</userID>
    <screenName>{$ctx:screenName}</screenName>
 </twitter.createMutesUsers>
```
**Properties**

* userID: The ID of the user you need to mute.
* screenName: The screen name of the user you need to mute.

**Sample request**

Following is a sample REST/JSON request that can be handled by the createMutesUsers operation.
```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "screenName":"TestUser"
}
```

**Sample Response**

```json
{
    "id": 785972206132011008,
    "id_str": "785972206132011008",
    "name": "test User",
    "screen_name": "TestUser",
    "location": "",
    "description": "",
    "url": null,
    "entities": {
        "description": {
            "urls": []
        }
    },
    "protected": false,
    "followers_count": 24,
    "friends_count": 0,
    "listed_count": 0,
    "created_at": "Tue Oct 11 22:35:51 +0000 2016",
    "favourites_count": 0,
    "utc_offset": null,
    "time_zone": null,
    "geo_enabled": false,
    "verified": false,
    "statuses_count": 6,
    "lang": "en",
    "status": {
        "created_at": "Fri Jul 13 13:31:46 +0000 2018",
        "id": 1017763516659519489,
        "id_str": "1017763516659519489",
        "text": "Checkout this A4 Poster Mockup Free PSD #freepsd #psd #freebie https://t.co/0OLyVwfRks via @psd_graphics",
        "truncated": false,
        "entities": {
            "hashtags": [
                {
                    "text": "freepsd",
                    "indices": [
                        40,
                        48
                    ]
                },
                {
                    "text": "psd",
                    "indices": [
                        49,
                        53
                    ]
                },
                {
                    "text": "freebie",
                    "indices": [
                        54,
                        62
                    ]
                }
            ],
            "symbols": [],
            "user_mentions": [
                {
                    "screen_name": "psd_graphics",
                    "name": "psd graphics",
                    "id": 4902253861,
                    "id_str": "4902253861",
                    "indices": [
                        91,
                        104
                    ]
                }
            ],
            "urls": [
                {
                    "url": "https://t.co/0OLyVwfRks",
                    "expanded_url": "https://psd.graphics/mockups/a4-poster-mockup-free-psd/",
                    "display_url": "psd.graphics/mockups/a4-pos…",
                    "indices": [
                        63,
                        86
                    ]
                }
            ]
        },
        "source": "<a href=\"http://twitter.com\" rel=\"nofollow\">Twitter Web Client</a>",
        "in_reply_to_status_id": null,
        "in_reply_to_status_id_str": null,
        "in_reply_to_user_id": null,
        "in_reply_to_user_id_str": null,
        "in_reply_to_screen_name": null,
        "geo": null,
        "coordinates": null,
        "place": null,
        "contributors": null,
        "is_quote_status": false,
        "retweet_count": 0,
        "favorite_count": 1,
        "favorited": false,
        "retweeted": false,
        "possibly_sensitive": false,
        "lang": "en"
    },
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
    "muting": false,
    "translator_type": "none"
}
```

**Related Twitter documentation**
https://dev.twitter.com/rest/reference/post/mutes/users/create

####  Un-muting a user

The destroyMutesUsers operation un-mutes a specified user. 

**destroyMutesUsers**
```xml
<twitter.destroyMutesUsers>
    <userID>{$ctx:userID}</userID>
    <screenName>{$ctx:screenName}</screenName>
 </twitter.destroyMutesUsers>
```
**Properties**

* userID: The ID of the user you need to mute.
* screenName: The screen name of the user you need to mute.

**Sample request**

Following is a sample REST/JSON request that can be handled by the createMutesUsers operation.
```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "screenName":"TestUser"
}
```

**Sample Response**

```json
{
    "id": 785972206132011008,
    "id_str": "785972206132011008",
    "name": "test User",
    "screen_name": "TestUser",
    "location": "",
    "description": "",
    "url": null,
    "entities": {
        "description": {
            "urls": []
        }
    },
    "protected": false,
    "followers_count": 24,
    "friends_count": 0,
    "listed_count": 0,
    "created_at": "Tue Oct 11 22:35:51 +0000 2016",
    "favourites_count": 0,
    "utc_offset": null,
    "time_zone": null,
    "geo_enabled": false,
    "verified": false,
    "statuses_count": 6,
    "lang": "en",
    "status": {
        "created_at": "Fri Jul 13 13:31:46 +0000 2018",
        "id": 1017763516659519489,
        "id_str": "1017763516659519489",
        "text": "Checkout this A4 Poster Mockup Free PSD #freepsd #psd #freebie https://t.co/0OLyVwfRks via @psd_graphics",
        "truncated": false,
        "entities": {
            "hashtags": [
                {
                    "text": "freepsd",
                    "indices": [
                        40,
                        48
                    ]
                },
                {
                    "text": "psd",
                    "indices": [
                        49,
                        53
                    ]
                },
                {
                    "text": "freebie",
                    "indices": [
                        54,
                        62
                    ]
                }
            ],
            "symbols": [],
            "user_mentions": [
                {
                    "screen_name": "psd_graphics",
                    "name": "psd graphics",
                    "id": 4902253861,
                    "id_str": "4902253861",
                    "indices": [
                        91,
                        104
                    ]
                }
            ],
            "urls": [
                {
                    "url": "https://t.co/0OLyVwfRks",
                    "expanded_url": "https://psd.graphics/mockups/a4-poster-mockup-free-psd/",
                    "display_url": "psd.graphics/mockups/a4-pos…",
                    "indices": [
                        63,
                        86
                    ]
                }
            ]
        },
        "source": "<a href=\"http://twitter.com\" rel=\"nofollow\">Twitter Web Client</a>",
        "in_reply_to_status_id": null,
        "in_reply_to_status_id_str": null,
        "in_reply_to_user_id": null,
        "in_reply_to_user_id_str": null,
        "in_reply_to_screen_name": null,
        "geo": null,
        "coordinates": null,
        "place": null,
        "contributors": null,
        "is_quote_status": false,
        "retweet_count": 0,
        "favorite_count": 1,
        "favorited": false,
        "retweeted": false,
        "possibly_sensitive": false,
        "lang": "en"
    },
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
    "muting": false,
    "translator_type": "none"
}
```

**Related Twitter documentation**

https://dev.twitter.com/rest/reference/post/mutes/users/destroy

#### Sample configuration

Following is a sample proxy service that illustrates how to connect to Twitter with the init operation and use the getMutesUsersIds operation. The sample request for this proxy can be found in getMutesUsersIds sample request. You can use this sample as a template for using other operations in this category.
1. Create a sample proxy as below :

    **Sample Proxy**
    ```xml
   <proxy xmlns="http://ws.apache.org/ns/synapse"
          name="getMutesUsersIds"
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
            <property name="cursor" expression="json-eval($.cursor)"/>
            <twitter.init>
               <consumerKey>{$ctx:consumerKey}</consumerKey>
               <consumerSecret>{$ctx:consumerSecret}</consumerSecret>
               <accessToken>{$ctx:accessToken}</accessToken>
               <accessTokenSecret>{$ctx:accessTokenSecret}</accessTokenSecret>
            </twitter.init>
            <twitter.getMutesUsersIds>
               <cursor>{$ctx:cursor}</cursor>
            </twitter.getMutesUsersIds>
            <respond/>
         </inSequence>
         <outSequence>
            <send/>
         </outSequence>
      </target>
      <description/>
   </proxy>
    
    ```
2. Create a json file named getMutesUsersIds.json and copy the configurations given below to it:

    ```json
    {
      "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
      "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
      "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
      "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
      "cursor":"-1"
    }
    ```
3. Replace the credentials with your values.

4. Execute the following curl command:

    ```bash
    curl -X POST http://localhost:8280/services/getMutesUsersIds --header 'Content-Type: application/json' -d @getMutesUsersIds.json
    ```

5. Twitter returns a json response similar to the one shown below:
 
```json
{"ids": [785972206132011008],"next_cursor": 0,"next_cursor_str": "0","previous_cursor": 0,"previous_cursor_str": "0","total_count": null}

```
