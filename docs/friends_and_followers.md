# Working with Friends and Followers in Twitter

[[  Overview ]](#overview)  [[ Operation details ]](#operation-details)  [[  Sample configuration  ]](#sample-configuration)

### Overview 

The following operations allow you to work with friends and followers in Twitter. Click an operation name to see details on how to use it.
For a sample proxy service that illustrates how to work with friends and followers, see [Sample configuration](#sample-configuration).

| Operation        | Description |
| ------------- |-------------|
| [getFriendsIds](#RRetrieving-friend-IDs)    | Retrieves a cursored collection of user IDs for every user that a specified user is following. |
| [getFriendsList](#Retrieving-a-friends-list)      | Retrieves a cursored collection of user objects for every user that a specified user is following. |
| [createFriendships](#Creating-friendships)      | Allows the authenticating user to follow a specified user. |
| [updateFriendships](#Updating-friendships)      | Allows to enable or disable retweets and device notifications from a specified user.|
| [destroyFriendships](#Destroying-friendships)      | Allows the authenticating user to unfollow a specified user.|
| [getFriendshipsIncoming](#Retrieving-incoming-friends)    | Retrieves the numeric IDs of every user who has a pending request to follow the authenticating user. |
| [getFriendshipsOutgoing](#Retrieving-outgoing-friends)      | Retrieves a collection of numeric IDs for every protected user for whom the authenticating user has a pending follow request. |
| [getFriendshipsShow](#Retrieving-friend-relationships)      | Retrieves detailed information about the relationship between two arbitrary users. |
| [getFriendshipsLookup](#Retrieving-friendship-lookup)      | Retrieves the relationship of the authenticating user to the users specified in the provided comma separated list. |
| [getFriendshipsNoRetweetsIds	](#Retrieving-no-retweets-friendship-IDs)      | Retrieves the user IDs of users that the authenticated user does not want to receive retweets from.|
| [getFollowersIds](#Retrieving-follower-Ids)      | Retrieves a cursored collection of user IDs for every user following a specified user.|
| [getFollowersList](#Retrieving-a-followers-list)      | Retrieves a cursored collection of user objects for every user following a specified user.|

### Operation details

This section provides further details on the operations related to working with friends and followers.

#### Retrieving friend IDs
The getFriendsIds operation retrieves the user IDs of every friend that a specified user is following. 

**getFriendsIds**
```xml
<twitter.getFriendsIds>
    <userID>{$ctx:userID}</userID>
    <screenName>{$ctx:screenName}</screenName>
    <cursor>{$ctx:cursor}</cursor>
    <stringifyIds>{$ctx:stringifyIds}</stringifyIds>
    <count>{$ctx:count}</count>
 </twitter.getFriendsIds>
```

**Properties**
* userID: The ID of the user for whom you need to retrieve the friend IDs.
* screenName: The screen name of the user for whom you need to retrieve the friend IDs.
* cursor: The cursor ID of the response page to retrieve. If you do not specify a cursor, a value of -1 will be assumed, which is the first page.
* stringifyIds:  Set this to true if you need to have the IDs returned as strings.
* count: The number of friend IDs to return per page. This can be set to a maximum of 200. The default value is 20.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getFriendsIds operation.

**Sample Request for getFriendsIds**
```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "screenName":"TestUser",
  "cursor":"-1",
  "count":"100"
}
```

**Sample Response**

```json
{
    "ids": [],
    "next_cursor": 0,
    "next_cursor_str": "0",
    "previous_cursor": 0,
    "previous_cursor_str": "0",
    "total_count": null
}
```

**Related Twitter documentation**

https://dev.twitter.com/rest/reference/get/friends/ids

####  Retrieving a friends list

The getFriendsList operation retrieves a collection of user objects representing every friend that a specified user is following. 

**getFriendsList**
```xml
<twitter.getFriendsList>
    <userID>{$ctx:userID}</userID>
    <screenName>{$ctx:screenName}</screenName>
    <cursor>{$ctx:cursor}</cursor>
    <count>{$ctx:count}</count>
    <skipStatus>{$ctx:skipStatus}</skipStatus>
    <includeEntities>{$ctx:includeEntities}</includeEntities>
 </twitter.getFriendsList>
```

**Properties**
* userID: The ID of the user for whom you need to retrieve the friends list.
* screenName: The screen name of the user for whom you need to retrieve the friends list.
* cursor: The cursor ID of the response page to retrieve. If you do not specify a cursor, a value of -1 will be assumed, which is the first page.
* count: The number of user objects to return per page. This can be set to a maximum of 200. The default value is 20.
* skipStatus: Set to either true, t or 1 statuses will not be included in the returned user objects.
* includeEntities: Set to false if you do not want the entities node to be included in the returned user objects.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getFriendsList operation.
```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "screenName":"TestUser",
  "cursor":"-1", 
  "count":"100"
 }
```

**Sample Response**

```json
{
    "users": [],
    "next_cursor": 0,
    "next_cursor_str": "0",
    "previous_cursor": 0,
    "previous_cursor_str": "0",
    "total_count": null
}
```
**Related Twitter documentation**

https://dev.twitter.com/rest/reference/get/friends/list

####  Creating friendships

The CreateFriendships operation creates a friend by allowing the authenticating user to follow a specified user.

**CreateFriendships**
```xml
<twitter.createFriendships>
    <userID>{$ctx:userID}</userID>
    <screenName>{$ctx:screenName}</screenName>
    <follow>{$ctx:follow}</follow>
</twitter.createFriendships>
```
**Properties**
* userID: The ID of the target user.
* screenName: The screen name of the target user.
* follow: Set to true if you need to enable notifications for the target user.

**Sample request**

Following is a sample REST/JSON request that can be handled by the CreateFriendships operation.

```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "screenName":"TestUser",
  "follow":"true"
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
    "followers_count": 25,
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
    "following": true,
    "follow_request_sent": false,
    "notifications": true,
    "muting": false,
    "translator_type": "none"
}
```

**Related Twitter documentation**

https://dev.twitter.com/rest/reference/post/friendships/create

####  Updating friendships

The updateFriendships operation allows one to enable or disable retweets and device notifications from a specified user.

**updateFriendships**
```xml
<twitter.updateFriendships>
    <userID>{$ctx:userID}</userID>
    <screenName>{$ctx:screenName}</screenName>
    <device>{$ctx:device}</device>
    <retweets>{$ctx:retweets}</retweets>
 </twitter.updateFriendships>
```

**Properties**
* userID: The ID of the target user .
* screenName: The screen name of the target user.
* device: Set to true to enable device notifications from the target user.
* retweets:  Set to true to enable retweets from the target user.

**Sample request**

Following is a sample REST/JSON request that can be handled by the updateFriendships operation.
```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "userID":"twitterapi",
  "screenName":"twitterapi",
  "retweets":"true"
}
```

**Sample Response**

```json
{
    "relationship": {
        "source": {
            "id": 1114072936665821184,
            "id_str": "1114072936665821184",
            "screen_name": "ayo32039237",
            "following": true,
            "followed_by": false,
            "live_following": false,
            "following_received": null,
            "following_requested": false,
            "notifications_enabled": true,
            "can_dm": false,
            "blocking": false,
            "blocked_by": false,
            "muting": false,
            "want_retweets": true,
            "all_replies": false,
            "marked_spam": false
        },
        "target": {
            "id": 785972206132011008,
            "id_str": "785972206132011008",
            "screen_name": "TestUser",
            "following": false,
            "followed_by": true,
            "following_received": false,
            "following_requested": null
        }
    }
}
```

**Related Twitter documentation**

https://dev.twitter.com/rest/reference/post/friendships/update

#### Destroying friendships

The destroyFriendships operation allows the authenticating user to unfollow a specified user.

**destroyFriendships**
```xml
<twitter.destroyFriendships>
    <userID>{$ctx:userID}</userID>
    <screenName>{$ctx:screenName}</screenName>
 </twitter.destroyFriendships>
```
**Properties**
* userID: The ID of the target user.
* screenName: The screen name of the target user.

**Sample request**

Following is a sample REST/JSON request that can be handled by the destroyFriendships operation.

```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "userID":"TestUser",
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

https://dev.twitter.com/rest/reference/post/friendships/destroy

#### Retrieving incoming friends
The getFriendshipsIncoming operation retrieves the numeric IDs of every user who has a pending request to follow the authenticating user.

**getFriendshipsIncoming**
```xml
<twitter.getFriendshipsIncoming>
    <cursor>{$ctx:cursor}</cursor>
    <stringifyIds>{$ctx:stringifyIds}</stringifyIds>
 </twitter.getFriendshipsIncoming>
```

**Properties**
* cursor: The cursor ID of the response page to retrieve. If you do not specify a cursor, a value of -1 will be assumed, which is the first page.
* stringifyIds:  Set this to true if you need to have the IDs returned as strings.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getFriendshipsIncoming operation.

**Sample Request for getFriendshipsIncoming**
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
    "ids": [],
    "next_cursor": 0,
    "next_cursor_str": "0",
    "previous_cursor": 0,
    "previous_cursor_str": "0",
    "total_count": null
}
```

**Related Twitter documentation**

https://dev.twitter.com/rest/reference/get/friendships/incoming

####  Retrieving outgoing friends

The getFriendshipsOutgoing operation retrieves a collection of numeric IDs for every protected user for whom the authenticating user has a pending follow request.

**getFriendshipsOutgoing**
```xml
<twitter.getFriendshipsOutgoing>
    <cursor>{$ctx:cursor}</cursor>
    <stringifyIds>{$ctx:stringifyIds}</stringifyIds>
 </twitter.getFriendshipsOutgoing>
```

**Properties**
* cursor: The cursor ID of the response page to retrieve. If you do not specify a cursor, a value of -1 will be assumed, which is the first page.
* stringifyIds:  Set this to true if you need to have the IDs returned as strings.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getFriendshipsOutgoing operation.
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
    "ids": [],
    "next_cursor": 0,
    "next_cursor_str": "0",
    "previous_cursor": 0,
    "previous_cursor_str": "0",
    "total_count": null
}
```
**Related Twitter documentation**

https://dev.twitter.com/rest/reference/get/friendships/outgoing

####  Retrieving friend relationships

The getFriendshipsShow operation retrieves information about the relationship between two arbitrary users.

**getFriendshipsShow**
```xml
<twitter.getFriendshipsShow>
    <sourceId>{$ctx:sourceId}</sourceId>
    <sourceScreenName>{$ctx:sourceScreenName}</sourceScreenName>
    <targetId>{$ctx:targetId}</targetId>
    <targetScreenName>{$ctx:targetScreenName}</targetScreenName>
 </twitter.getFriendshipsShow>
```
**Properties**
* sourceId: The user ID of the subject user.
* sourceScreenName: The screen name of the subject user.
* targetId: The user ID of the target user.
* targetScreenName: The screen name of the target user.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getFriendshipsShow operation.
```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "sourceScreenName":"TestUser1",
  "targetScreenName":"TestUser2"
}
```

**Sample Response**

```json
{
    "relationship": {
        "source": {
            "id": 3193724052,
            "id_str": "3193724052",
            "screen_name": "testuser1",
            "following": false,
            "followed_by": false,
            "live_following": false,
            "following_received": null,
            "following_requested": null,
            "notifications_enabled": null,
            "can_dm": false,
            "blocking": null,
            "blocked_by": null,
            "muting": null,
            "want_retweets": null,
            "all_replies": null,
            "marked_spam": null
        },
        "target": {
            "id": 9307202,
            "id_str": "9307202",
            "screen_name": "testuser2",
            "following": false,
            "followed_by": false,
            "following_received": null,
            "following_requested": null
        }
    }
}
```

**Related Twitter documentation**

https://dev.twitter.com/rest/reference/get/friendships/show

####  Retrieving friendship lookup

The getFriendshipsLookup operation retrieves the relationships of the authenticating user to the users specified in the provided comma separated list of screen names or user IDs. 

**getFriendshipsLookup**
```xml
<twitter.getFriendshipsLookup>
    <userID>{$ctx:userID}</userID>
    <screenName>{$ctx:screenName}</screenName>
 </twitter.getFriendshipsLookup>
```

**Properties**
* userID: A comma separated list of user IDs. You can specify up to 100 comma separated user IDs in a single request.
* screenName: A comma separated list of screen names. You can specify up to 100 comma separated screen names in a single request. 

**Sample request**

Following is a sample REST/JSON request that can be handled by getFriendshipsLookup operation.
```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "userID":"TestUser",
  "screenName":"TestUser"
}
```

**Sample Response**

```json
[
    {
        "name": "test User",
        "screen_name": "TestUser",
        "id": 785972206132011008,
        "id_str": "785972206132011008",
        "connections": [
            "following"
        ]
    }
]
```

**Related Twitter documentation**

https://dev.twitter.com/rest/reference/get/friendships/lookup

#### Retrieving no retweets friendship IDs

The getFriendshipsNoRetweetsIds operation retrieves the user IDs of users that the authenticated user does not want to receive retweets from.

**getFriendshipsNoRetweetsIds**
```xml
<twitter.getFriendshipsNoRetweetsIds>
    <stringifyIds>{$ctx:stringifyIds}</stringifyIds>
 </twitter.getFriendshipsNoRetweetsIds>
```
**Properties**
* stringifyIds: Set this to true if you need to have the IDs returned as strings.

**Sample request**

Following is a sample REST/JSON request that can be handled by getFriendshipsNoRetweetsIds operation.

```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU"
}
```

**Sample Response**

```json
[]
```

**Related Twitter documentation**

https://dev.twitter.com/rest/reference/get/friendships/no_retweets/ids

####  Retrieving friendship lookup

The getFriendshipsLookup operation retrieves the relationships of the authenticating user to the users specified in the provided comma separated list of screen names or user IDs. 

**getFriendshipsLookup**
```xml
<twitter.getFriendshipsLookup>
    <userID>{$ctx:userID}</userID>
    <screenName>{$ctx:screenName}</screenName>
 </twitter.getFriendshipsLookup>
```

**Properties**
* userID: A comma separated list of user IDs. You can specify up to 100 comma separated user IDs in a single request.
* screenName: A comma separated list of screen names. You can specify up to 100 comma separated screen names in a single request. 

**Sample request**

Following is a sample REST/JSON request that can be handled by getFriendshipsLookup operation.
```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "userID":"TestUser",
  "screenName":"TestUser"
}
```

**Sample Response**

```json
[
    {
        "name": "test User",
        "screen_name": "TestUser",
        "id": 785972206132011008,
        "id_str": "785972206132011008",
        "connections": [
            "following"
        ]
    }
]
```

**Related Twitter documentation**

https://dev.twitter.com/rest/reference/get/friendships/lookup

#### Retrieving follower Ids

The getFollowersIds operation retrieves the user IDs of every user following a specified user.

**getFollowersIds**
```xml
<twitter.getFollowersIds>
    <userID>{$ctx:userID}</userID>
    <screenName>{$ctx:screenName}</screenName>
    <cursor>{$ctx:cursor}</cursor>
    <count>{$ctx:count}</count>
    <stringifyIds>{$ctx:stringifyIds}</stringifyIds>
 </twitter.getFollowersIds>
```
**Properties**
* userID: The ID of the user for whom you need to retrieve followers.
* screenName: The screen name of the user for whom you need to retrieve followers.
* cursor: The cursor ID of the response page to retrieve. If you do not specify a cursor, a value of -1 will be assumed, which is the first page.
* count: The number of users IDs to return per page. This can be set to a maximum of 200. The default value is 20.
* stringifyIds: Set this to true if you need to have the IDs returned as strings.

**Sample request**

Following is a sample REST/JSON request that can be handled by getFollowersIds operation.
```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "userID":"TestUser1",
  "screenName":"TestUser1",
  "cursor":"-1",
  "count":"1024",
  "stringifyIds":"true"
 }
```

**Sample Response**

```json
{
    "ids": [
        "1114072936665821184",
        "941651480339083264",
        "1034059120159088641",
        "948197535042232320",
        "1026432827498409984",
        "776696211491389440",
        "1007597545386921984",
        "1036352870",
        "908934348757520384",
        "1034662769751019521",
        "1015825790481715200",
        "1025748994960502785",
        "1014372149312802816",
        "913902958596775937",
        "1015638455982927872",
        "735319608043917312",
        "1021115024096546816",
        "1034700012922359808",
        "951852895284101120",
        "1029941578058670080",
        "1034649665625456641",
        "1016151036782895104",
        "1029779898959900677",
        "834145078008492034",
        "831164616248029185"
    ],
    "next_cursor": 0,
    "next_cursor_str": "0",
    "previous_cursor": 0,
    "previous_cursor_str": "0",
    "total_count": null
}
```


**Related Twitter documentation**

https://dev.twitter.com/rest/reference/get/followers/ids

#### Retrieving a followers list

The getFollowersList operation retrieves a cursored collection of user objects for every user following a specified user.

**getFriendsList**
```xml
<twitter.getFollowersList>
    <userID>{$ctx:userID}</userID>
    <screenName>{$ctx:screenName}</screenName>
    <cursor>{$ctx:cursor}</cursor>
    <count>{$ctx:count}</count>
    <skipStatus>{$ctx:skipStatus}</skipStatus>
    <includeUserEntities>{$ctx:includeUserEntities}</includeUserEntities>
 </twitter.getFollowersList>
```
**Properties**
* userID: The ID of the user for whom you need to retrieve followers.
* screenName: The screen name of the user for whom you need to retrieve followers.
* cursor: The cursor ID of the response page to retrieve. If you do not specify a cursor, a value of -1 will be assumed, which is the first page.
* count: The number of users objects to return per page. This can be set to a maximum of 200. The default value is 20.
* skipStatus: Set to either true, t or 1, if you do not want the status to be included in the returned user objects.
* includeUserEntities: Set to false if you do not want the entities node to be included in the returned user objects.

**Sample request**

Following is a sample REST/JSON request that can be handled by getFollowersList operation.
```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "screenName":"SriMayu1",
  "cursor":"-1",   
  "count":"36",
  "includeUserEntities":"false"
 }
```

**Sample Response**

```json
{
    "users": [],
    "next_cursor": 0,
    "next_cursor_str": "0",
    "previous_cursor": 0,
    "previous_cursor_str": "0",
    "total_count": null
}
```


**Related Twitter documentation**

https://dev.twitter.com/rest/reference/get/followers/list

#### Sample configuration

Following is a sample proxy service that illustrates how to connect to Twitter with the init operation and use the getFriendsIds operation. The sample request for this proxy can be found in getFriendsIds sample request. You can use this sample as a template for using other operations in this category.

1. Create a sample proxy as below :

    **Sample Proxy**
    ```xml
   <proxy xmlns="http://ws.apache.org/ns/synapse"
          name="getFriendsIds"
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
            <twitter.getFriendsIds>
               <screenName>{$ctx:screenName}</screenName>
               <cursor>{$ctx:cursor}</cursor>
               <count>{$ctx:count}</count>
            </twitter.getFriendsIds>
            <respond/>
         </inSequence>
         <outSequence>
            <send/>
         </outSequence>
      </target>
      <description/>
   </proxy>
    
    ```
2. Create a json file named getFriendsIds.json and copy the configurations given below to it:

    ```json
    {
      "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
      "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
      "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
      "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
      "screenName":"TestUser",
      "cursor":"-1",
      "count":"100"
    }
    ```
3. Replace the credentials with your values.

4. Execute the following curl command:

    ```bash
    curl -X POST http://localhost:8280/services/getFriendsIds --header 'Content-Type: application/json' -d @getFriendsIds.json
    ```

5. Twitter returns a json response similar to the one shown below:
 
```json
{ "ids": [],"next_cursor": 0,"next_cursor_str": "0","previous_cursor": 0,"previous_cursor_str": "0","total_count": null}
```
