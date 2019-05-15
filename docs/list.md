# Working with Lists in Twitter

[[  Overview ]](#overview)  [[ Operation details ]](#operation-details)  [[  Sample configuration  ]](#sample-configuration)

### Overview 

The following operations allow you to work with lists in Twitter. Click an operation name to see details on how to use it.
For a sample proxy service that illustrates how to work with lists, see [Sample configuration](#sample-configuration).

| Operation        | Description |
| ------------- |-------------|
| [getListsMemberships](#Retrieving-membership-lists)    | Retrieves the lists that a specified user has been added to. |
| [getListsOwnerships](#Retrieving-lists-owned-by-a-user)      | Retrieves the lists owned by a specified Twitter user. |
| [getLists](#Retrieving-all-lists)      | Retrieves all lists that the authenticating or specified user subscribes to, including the lists they own. |
| [createLists](#Creating-a-list)      |	Creates a new list for the authenticated user.|
| [updateLists](#Updating-a-list)      |Updates an existing list for the authenticated user.|
| [destroyLists](#Delets-a-list)      |Deletes a list for the authenticated user.|

### Operation details

This section provides further details on the operations.

#### Retrieving membership lists
The getListsMemberships operation retrieves the lists that the specified user has been added to.

**getListsMemberships**
```xml
<twitter.getListsMemberships>
    <userID>{$ctx:userID}</userID>
    <screenName>{$ctx:screenName}</screenName>
    <cursor>{$ctx:cursor}</cursor>
    <filterToOwnedLists>{$ctx:filterToOwnedLists}</filterToOwnedLists>
    <count>{$ctx:count}</count>
 </twitter.getListsMemberships>
```

**Properties**
* userID: The ID of the user.
* screenName: The screen name of the user.
* cursor: The cursor ID of the response page to retrieve. If you do not specify a cursor, a value of -1 will be assumed, which is the first page.
* filterToOwnedLists:  Set to true, t or 1, if you want to retrieve only the lists that the authenticating user owns, and the specified user is a member of.
* count: The number of lists to return per page. This can be set to a maximum of 200. The default value is 20.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getListsMembership operation.

**Sample Request for getListsMemberships**
```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "screenName": "TestUser",
  "count": "10"
 }
```

**Sample Response**

```json
{
    "next_cursor": 0,
    "next_cursor_str": "0",
    "previous_cursor": 0,
    "previous_cursor_str": "0",
    "lists": []
}
```

**Related Twitter documentation**

https://dev.twitter.com/rest/reference/get/lists/memberships

####  Retrieving  lists owned by a user

The getListsOwnerships operation retrieves the lists owned by a specified Twitter user.

**getListsOwnerships**
```xml
<twitter.getListsOwnerships>
    <userID>{$ctx:userID}</userID>
    <screenName>{$ctx:screenName}</screenName>
    <cursor>{$ctx:cursor}</cursor>
    <count>{$ctx:count}</count>
 </twitter.getListsOwnerships>
```

**Properties**
* userID: The ID of the user.
* screenName: The screen name of the user.
* cursor: The cursor ID of the response page to retrieve. If you do not specify a cursor, a value of -1 will be assumed, which is the first page.
* count: The number of lists to return per page. This can be set to a maximum of 200. The default value is 20.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getListsOwnerships operation.


```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "screenName": "TestUser",
  "count": "10"
 }
```

**Sample Response**

```json
{
    "next_cursor": 0,
    "next_cursor_str": "0",
    "previous_cursor": 0,
    "previous_cursor_str": "0",
    "lists": [
        {
            "id": 1126375216454754304,
            "id_str": "1126375216454754304",
            "name": "listA",
            "uri": "/ayo32039237/lists/lista5",
            "subscriber_count": 0,
            "member_count": 0,
            "mode": "public",
            "description": "",
            "slug": "lista5",
            "full_name": "@ayo32039237/lista5",
            "created_at": "Thu May 09 06:35:53 +0000 2019",
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
            "id": 1126375211669045250,
            "id_str": "1126375211669045250",
            "name": "listA",
            "uri": "/ayo32039237/lists/lista4",
            "subscriber_count": 0,
            "member_count": 0,
            "mode": "public",
            "description": "list A",
            "slug": "lista4",
            "full_name": "@ayo32039237/lista4",
            "created_at": "Thu May 09 06:35:52 +0000 2019",
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
            "id": 1126369035241783298,
            "id_str": "1126369035241783298",
            "name": "listA",
            "uri": "/ayo32039237/lists/lista3",
            "subscriber_count": 0,
            "member_count": 0,
            "mode": "public",
            "description": "list A",
            "slug": "lista3",
            "full_name": "@ayo32039237/lista3",
            "created_at": "Thu May 09 06:11:19 +0000 2019",
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
}
```
**Related Twitter documentation**

https://dev.twitter.com/rest/reference/get/lists/ownerships

####  Retrieving all lists

The getLists operation retrieves all lists that the authenticating or specified user subscribes to, including the lists they own. This operation returns a maximum of 100 results, and the subscribed lists are returned first, followed by owned lists.

**getLists**
```xml
<twitter.getLists>
    <userID>{$ctx:userID}</userID>
    <screenName>{$ctx:screenName}</screenName>
    <reverse>{$ctx:reverse}</reverse>
 </twitter.getListsList>
```
**Properties**

* userID: The ID of the user.
* screenName: The screen name of the user.
* reverse: Set this to true, if you need to retrieve the owned lists first. For example, if a user subscribes to 90 lists and owns 20 lists, the getLists operation returns 90 subscriptions and 10 owned lists. When you set this property to true, the getLists operation returns 20 owned lists and 80 subscriptions.

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

https://dev.twitter.com/rest/reference/get/lists/list

####  Creating a list

The createLists operation creates a new list for the authenticated user.

**createLists**
```xml
<twitter.createLists>
    <name>{$ctx:name}</name>
    <mode>{$ctx:mode}</mode>
    <description>{$ctx:description}</description>
 </twitter.createLists>
```
**Properties**

* name: Required -  The name for the list.
* mode: Whether the list is public or private. Possible values are public or private. If a mode is not specified, the list will be public by default.
* description:The description of the list.

**Sample request**

Following is a sample REST/JSON request that can be handled by the createLists operation.
```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "name": "listA",
  "description":"list A"
 }
```

**Sample Response**

```json
{
    "id": 1126392047504642048,
    "id_str": "1126392047504642048",
    "name": "listA",
    "uri": "/ayo32039237/lists/lista9",
    "subscriber_count": 0,
    "member_count": 0,
    "mode": "public",
    "description": "list A",
    "slug": "lista9",
    "full_name": "@ayo32039237/lista9",
    "created_at": "Thu May 09 07:42:46 +0000 2019",
    "following": false,
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
```


**Related Twitter documentation**

https://dev.twitter.com/rest/reference/post/lists/create

####  Updating a list

The getStatusesLookup operation retrieves fully-hydrated tweet objects based on the provided comma separated list of tweet IDs. You can retrieve up to 100 tweets per request.

**updateLists**
```xml
<twitter.updateLists>
    <listId>{$ctx:listId}</listId>
    <slug>{$ctx:slug}</slug>
    <name>{$ctx:name}</name>
    <mode>{$ctx:mode}</mode>
    <ownerScreenName>{$ctx:ownerScreenName}</ownerScreenName>
    <description>{$ctx:description}</description>
    <ownerId>{$ctx:ownerId}</ownerId>
 </twitter.updateLists>
```
**Properties**

* listId: The numerical id of the list.
* slug: Can identify a list by its slug.
* name: The name for the list.
* mode: Whether your list is public or private. Values can be public or private.
* ownerScreenName: The screen name of the user who owns the list being requested by a slug.
* trimUser: If set to either true, t or 1, each tweet returned in a timeline will include a user object including only the status author's user ID. Omit this property to retrieve the complete user object.
* description:  The description to give the list.
* ownerId: The user ID of the user who owns the list being requested by a slug.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getStatusesLookup operation.
```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "ownerId": "ayo32039237",
  "listId": "1126392047504642048"
 }
```

**Sample Response**

```json
{
    "id": 1126392047504642048,
    "id_str": "1126392047504642048",
    "name": "listA",
    "uri": "/ayo32039237/lists/lista9",
    "subscriber_count": 0,
    "member_count": 0,
    "mode": "public",
    "description": "list A",
    "slug": "lista9",
    "full_name": "@ayo32039237/lista9",
    "created_at": "Thu May 09 07:42:46 +0000 2019",
    "following": false,
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
```


**Related Twitter documentation**

https://dev.twitter.com/rest/reference/get/lists/list

####  Delets a list

The destroyLists operation creates a new list for the authenticated user.

**destroyLists**
```xml
<twitter.destroyLists>
    <ownerScreenName>{$ctx:ownerScreenName}</ownerScreenName>
    <ownerId>{$ctx:ownerId}</ownerId>
    <listId>{$ctx:listId}</listId>
    <slug>{$ctx:slug}</slug>
 </twitter.destroyLists>
```
**Properties**

* ownerScreenName: The ID of the user for whom to return results for.
* ownerId: The screen name of the user for whom to return results for.
* listId: IThe numerical id of the list.
* slug:You can identify a list by its slug instead of its numerical id. If you decide to do so,note that you’ll also have to specify the list owner using the owner_id or owner_screen_name parameters.

**Sample request**

Following is a sample REST/JSON request that can be handled by the updateStatus operation.
```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "ownerId": "ayo32039237",
  "listId": "1126371596032270337"
 }
```

**Sample Response**

```json
{
    "id": 1126371596032270337,
    "id_str": "1126371596032270337",
    "name": "listA",
    "uri": "/ayo32039237/lists/lista4",
    "subscriber_count": 0,
    "member_count": 0,
    "mode": "public",
    "description": "list A",
    "slug": "lista4",
    "full_name": "@ayo32039237/lista4",
    "created_at": "Thu May 09 06:21:30 +0000 2019",
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
```

**Related Twitter documentation**

https://dev.twitter.com/rest/reference/post/lists/create

#### Sample configuration

Following is a sample proxy service that illustrates how to connect to Twitter with the init operation and use the getListsMemberships operation. The sample request for this proxy can be found in getListsMemberships sample request. You can use this sample as a template for using other operations in this category.
1. Create a sample proxy as below :

    **Sample Proxy**
    ```xml
   <proxy xmlns="http://ws.apache.org/ns/synapse"
          name="getListsOwnerships"
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
            <property name="cursor" expression="json-eval($.cursor)"/>
            <property name="count" expression="json-eval($.count)"/>
            <twitter.init>
               <consumerKey>{$ctx:consumerKey}</consumerKey>
               <consumerSecret>{$ctx:consumerSecret}</consumerSecret>
               <accessToken>{$ctx:accessToken}</accessToken>
               <accessTokenSecret>{$ctx:accessTokenSecret}</accessTokenSecret>
            </twitter.init>
            <twitter.getListsOwnerships>
               <screenName>{$ctx:screenName}</screenName>
               <cursor>{$ctx:cursor}</cursor>
               <count>{$ctx:count}</count>
            </twitter.getListsOwnerships>
            <respond/>
         </inSequence>
         <outSequence>
            <send/>
         </outSequence>
      </target>
      <description/>
   </proxy>
    
    ```
2. Create a json file named getListsOwnerships.json and copy the configurations given below to it:

    ```json
    {
      "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
      "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
      "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
      "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
      "screenName": "TestUser",
      "count": "10"
     }
    ```
3. Replace the credentials with your values.

4. Execute the following curl command:

    ```bash
    curl -X POST http://localhost:8280/services/getListsOwnerships --header 'Content-Type: application/json' -d @getListsOwnerships.json
    ```

5. Twitter returns a json response similar to the one shown below:
 
```json
{"previous_cursor":0,"next_cursor":1127250189360611332,"previous_cursor_str":"0","lists":[{"description":"list A","created_at":"Mon May 13 05:16:38 +0000 2019","uri":"/ayo32039237/lists/listb7","mode":"public","full_name":"@ayo32039237/listb7","subscriber_count":0,"id_str":"1127804824299294720","following":true,"name":"listB","id":1127804824299294720,"member_count":0,"user":{"utc_offset":null,"friends_count":1,"profile_image_url_https":"https://abs.twimg.com/sticky/default_profile_images/default_profile_normal.png","listed_count":0,"profile_background_image_url":null,"default_profile_image":true,"favourites_count":7,"description":"","created_at":"Fri Apr 05 07:51:01 +0000 2019","is_translator":false,"profile_background_image_url_https":null,"protected":false,"screen_name":"ayo32039237","id_str":"1114072936665821184","profile_link_color":"1DA1F2","is_translation_enabled":false,"translator_type":"none","id":1114072936665821184,"geo_enabled":false,"profile_background_color":"F5F8FA","lang":"en","has_extended_profile":false,"profile_sidebar_border_color":"C0DEED","profile_text_color":"333333","verified":false,"profile_image_url":"http://abs.twimg.com/sticky/default_profile_images/default_profile_normal.png","time_zone":null,"url":null,"contributors_enabled":false,"profile_background_tile":false,"entities":{"description":{"urls":[]}},"statuses_count":53,"follow_request_sent":false,"followers_count":0,"profile_use_background_image":true,"default_profile":true,"following":false,"name":"ayo","location":"","profile_sidebar_fill_color":"DDEEF6","notifications":false},"slug":"listb7"},{"description":"","created_at":"Mon May 13 05:16:37 +0000 2019","uri":"/ayo32039237/lists/lista6","mode":"public","full_name":"@ayo32039237/lista6","subscriber_count":0,"id_str":"1127804820834754560","following":true,"name":"listA","id":1127804820834754560,"member_count":0,"user":{"utc_offset":null,"friends_count":1,"profile_image_url_https":"https://abs.twimg.com/sticky/default_profile_images/default_profile_normal.png","listed_count":0,"profile_background_image_url":null,"default_profile_image":true,"favourites_count":7,"description":"","created_at":"Fri Apr 05 07:51:01 +0000 2019","is_translator":false,"profile_background_image_url_https":null,"protected":false,"screen_name":"ayo32039237","id_str":"1114072936665821184","profile_link_color":"1DA1F2","is_translation_enabled":false,"translator_type":"none","id":1114072936665821184,"geo_enabled":false,"profile_background_color":"F5F8FA","lang":"en","has_extended_profile":false,"profile_sidebar_border_color":"C0DEED","profile_text_color":"333333","verified":false,"profile_image_url":"http://abs.twimg.com/sticky/default_profile_images/default_profile_normal.png","time_zone":null,"url":null,"contributors_enabled":false,"profile_background_tile":false,"entities":{"description":{"urls":[]}},"statuses_count":53,"follow_request_sent":false,"followers_count":0,"profile_use_background_image":true,"default_profile":true,"following":false,"name":"ayo","location":"","profile_sidebar_fill_color":"DDEEF6","notifications":false},"slug":"lista6"},{"description":"","created_at":"Sat May 11 16:41:50 +0000 2019","uri":"/ayo32039237/lists/lista5","mode":"public","full_name":"@ayo32039237/lista5","subscriber_count":0,"id_str":"1127252484475351040","following":true,"name":"listA","id":1127252484475351040,"member_count":0,"user":{"utc_offset":null,"friends_count":1,"profile_image_url_https":"https://abs.twimg.com/sticky/default_profile_images/default_profile_normal.png","listed_count":0,"profile_background_image_url":null,"default_profile_image":true,"favourites_count":7,"description":"","created_at":"Fri Apr 05 07:51:01 +0000 2019","is_translator":false,"profile_background_image_url_https":null,"protected":false,"screen_name":"ayo32039237","id_str":"1114072936665821184","profile_link_color":"1DA1F2","is_translation_enabled":false,"translator_type":"none","id":1114072936665821184,"geo_enabled":false,"profile_background_color":"F5F8FA","lang":"en","has_extended_profile":false,"profile_sidebar_border_color":"C0DEED","profile_text_color":"333333","verified":false,"profile_image_url":"http://abs.twimg.com/sticky/default_profile_images/default_profile_normal.png","time_zone":null,"url":null,"contributors_enabled":false,"profile_background_tile":false,"entities":{"description":{"urls":[]}},"statuses_count":53,"follow_request_sent":false,"followers_count":0,"profile_use_background_image":true,"default_profile":true,"following":false,"name":"ayo","location":"","profile_sidebar_fill_color":"DDEEF6","notifications":false},"slug":"lista5"},{"description":"list A","created_at":"Sat May 11 16:32:44 +0000 2019","uri":"/ayo32039237/lists/listb6","mode":"public","full_name":"@ayo32039237/listb6","subscriber_count":0,"id_str":"1127250194502787072","following":true,"name":"listB","id":1127250194502787072,"member_count":0,"user":{"utc_offset":null,"friends_count":1,"profile_image_url_https":"https://abs.twimg.com/sticky/default_profile_images/default_profile_normal.png","listed_count":0,"profile_background_image_url":null,"default_profile_image":true,"favourites_count":7,"description":"","created_at":"Fri Apr 05 07:51:01 +0000 2019","is_translator":false,"profile_background_image_url_https":null,"protected":false,"screen_name":"ayo32039237","id_str":"1114072936665821184","profile_link_color":"1DA1F2","is_translation_enabled":false,"translator_type":"none","id":1114072936665821184,"geo_enabled":false,"profile_background_color":"F5F8FA","lang":"en","has_extended_profile":false,"profile_sidebar_border_color":"C0DEED","profile_text_color":"333333","verified":false,"profile_image_url":"http://abs.twimg.com/sticky/default_profile_images/default_profile_normal.png","time_zone":null,"url":null,"contributors_enabled":false,"profile_background_tile":false,"entities":{"description":{"urls":[]}},"statuses_count":53,"follow_request_sent":false,"followers_count":0,"profile_use_background_image":true,"default_profile":true,"following":false,"name":"ayo","location":"","profile_sidebar_fill_color":"DDEEF6","notifications":false},"slug":"listb6"},{"description":"","created_at":"Sat May 11 16:32:43 +0000 2019","uri":"/ayo32039237/lists/lista4","mode":"public","full_name":"@ayo32039237/lista4","subscriber_count":0,"id_str":"1127250189360611332","following":true,"name":"listA","id":1127250189360611332,"member_count":0,"user":{"utc_offset":null,"friends_count":1,"profile_image_url_https":"https://abs.twimg.com/sticky/default_profile_images/default_profile_normal.png","listed_count":0,"profile_background_image_url":null,"default_profile_image":true,"favourites_count":7,"description":"","created_at":"Fri Apr 05 07:51:01 +0000 2019","is_translator":false,"profile_background_image_url_https":null,"protected":false,"screen_name":"ayo32039237","id_str":"1114072936665821184","profile_link_color":"1DA1F2","is_translation_enabled":false,"translator_type":"none","id":1114072936665821184,"geo_enabled":false,"profile_background_color":"F5F8FA","lang":"en","has_extended_profile":false,"profile_sidebar_border_color":"C0DEED","profile_text_color":"333333","verified":false,"profile_image_url":"http://abs.twimg.com/sticky/default_profile_images/default_profile_normal.png","time_zone":null,"url":null,"contributors_enabled":false,"profile_background_tile":false,"entities":{"description":{"urls":[]}},"statuses_count":53,"follow_request_sent":false,"followers_count":0,"profile_use_background_image":true,"default_profile":true,"following":false,"name":"ayo","location":"","profile_sidebar_fill_color":"DDEEF6","notifications":false},"slug":"lista4"}],"next_cursor_str":"1127250189360611332"}
```
