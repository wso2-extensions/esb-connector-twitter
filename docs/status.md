# Working with Statuses in Twitter

[[  Overview ]](#overview)  [[ Operation details ]](#operation-details)  [[  Sample configuration  ]](#sample-configuration)

### Overview 

The following operations allow you to work with statuses in Twitter. Click an operation name to see details on how to use it.
For a sample proxy service that illustrates how to work with statuses, see [Sample configuration](#sample-configuration).

| Operation        | Description |
| ------------- |-------------|
| [getStatusesHomeTimeline](#Retrieving-the-home-timeline-statuses)    | Retrieves a collection of the most recent tweets and retweets posted by the authenticating user and the users that the authenticating user is following. |
| [getStatusesUserTimeline](#Retrieving-the-user-timeline-statuses)      | Retrieves the most recent tweets and retweets of a specified user instead of the authenticating user. |
| [getStatusesMentionsTimeline](#Retrieving-the-most-recent-user-mentioned-tweets)      | Retrieves the most recent tweets that mention the authenticating user. |
| [getStatusesRetweetsOfMe](#Retrieving-authenticated-user-tweets-that-are-retweeted-by-others)      |Retrieves the most recent tweets authored by the authenticating user that have been retweeted by others.|
| [getStatusesLookup](#Retrieving-tweet-details)      |Retrieves tweet objects of up to 100 tweets per request.|
| [updateStatuses](#Update-statuses)      |Updates the authenticating user’s current status, also known as Tweeting.|

### Operation details

This section provides further details on the operations.

#### Retrieving the home timeline statuses
The getStatusesHomeTimeline operation retrieves a collection of the most recent tweets and retweets posted by the authenticating user, and the users that the authenticating user is following.

**getStatusesHomeTimeline**
```xml
<twitter.getStatusesHomeTimeline>
    <count>{$ctx:count}</count>
   <sinceId>{$ctx:sinceId}</sinceId>
    <maxId>{$ctx:maxId}</maxId>
    <trimUser>{$ctx:trimUser}</trimUser>
    <excludeReplies>{$ctx:excludeReplies}</excludeReplies>
    <contributorDetails>{$ctx:contributorDetails}</contributorDetails>
    <includeEntities>{$ctx:includeEntities}</includeEntities>
 </twitter.getStatusesHomeTimeline>
```

**Properties**
* count: The number of records to retrieve.
* sinceId:  If specified, retrieves tweets/retweets with an ID greater than the specified ID (i.e., more recent tweets). For example, if there have been more than 800 tweets/retweets since the specified sinceId, the sinceId will be forced to the oldest ID available.
* maxId: If specified, retrieves tweets/retweets with an ID less than (i.e., older tweets) or equal to the specified ID.
* trimUser: If set to either true, t or 1, each tweet returned in a timeline will include a user object including only the status author's user ID. Omit this property to retrieve the complete user object.
* excludeReplies:If set to true, this property will prevent replies from appearing in the returned timeline.
* contributorDetails:If set to true, this property enhances the contributors details in the status response to include the screen name of the contributor. By default only the user ID of the contributor is included.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getStatusesHomeTimeline operation.

**Sample Request for getStatusesHomeTimeline**
```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "count":"5",
  "sinceId":"12566",
  "maxId":"19566",
  "trimUser":"true",
  "contributorDetails":"false"
 }
```

**Sample Response**

```json
[
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
            "id_str": "1114072936665821184"
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
    },
    {
        "created_at": "Tue May 07 05:10:30 +0000 2019",
        "id": 1125628953438445568,
        "id_str": "1125628953438445568",
        "text": "aMaybe he'll finally find his keys",
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
            "id_str": "1114072936665821184"
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
    {
        "created_at": "Tue May 07 05:01:50 +0000 2019",
        "id": 1125626772433850368,
        "id_str": "1125626772433850368",
        "text": "bMaybe he'll finally find his keys",
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
            "id_str": "1114072936665821184"
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
]

```

**Related Twitter documentation**

https://dev.twitter.com/rest/reference/get/statuses/home_timeline

####  Retrieving the user timeline statuses

The getUserTimeline operation retrieves a collection of the most recent tweets posted by the specified user.

**getStatusesUserTimeline**
```xml
<twitter.getStatusesUserTimeline>
    <userID>{$ctx:userID}</userID>
    <screenName>{$ctx:screenName}</screenName>
    <sinceId>{$ctx:sinceId}</sinceId>
    <count>{$ctx:count}</count>
    <maxId>{$ctx:maxId}</maxId>
    <trimUser>{$ctx:trimUser}</trimUser>
    <excludeReplies>{$ctx:excludeReplies}</excludeReplies>
    <contributorDetails>{$ctx:contributorDetails}</contributorDetails>
    <includeRts>{$ctx:includeRts}</includeRts>
 </twitter.getStatusesUserTimeline>
```

**Properties**
* userID: The ID of the user for whom you need to retrieve the user timeline statuses.
* screenName: The screen name of the user for whom you need to retrieve the user timeline statuses.
* count: The number of records to retrieve.
* sinceId: If specified, retrieves tweets/retweets with an ID greater than the specified ID (i.e., more recent tweets). For example, if there have been more than 800 tweets/retweets since the specified sinceId, the sinceId will be forced to the oldest ID available.
* maxId: If specified, retrieves tweets/retweets with an ID less than (i.e., older tweets) or equal to the specified ID.
* stringifyIds: Set this to true if you need to have the ids returned as strings.
* cursor: Specify this property if you want the list of blocked users to be broken into pages of results. If a value is not specified, a default value of -1 will be assumed, which is the first page. When you specify this property the response from the API will include a previous_cursor and next_cursor to allow paging back and forth.
* trimUser: If set to either true, t or 1, each tweet returned in a timeline will include a user object including only the status author's user ID. Omit this property to retrieve the complete user object.
* excludeReplies:If set to true, this property will prevent replies from appearing in the returned timeline.
* contributorDetails:If set to true, this property enhances the contributor's details in the status response to include the screen name of the contributor. By default only the user ID of the contributor is included.
* includeRts: Specify whether the timeline should strip any native retweets or not. When set to false, the timeline will strip any native retweets.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getStatusesUserTimeline operation.


```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "screenName":"TestUser1",
  "count":"5",
  "sinceId":"12566",
  "MaxId":"19566",
  "trimUser":"true",
  "excludeReplies":"true",
  "contributorDetails":"true"
 }
```

**Sample Response**

```json
[
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
            "id_str": "1114072936665821184"
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
    },
    {
        "created_at": "Tue May 07 05:10:31 +0000 2019",
        "id": 1125628957666287616,
        "id_str": "1125628957666287616",
        "text": "RT @ayo32039237: aMaybe he'll finally find his keys",
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
            "id_str": "1114072936665821184"
        },
        "geo": null,
        "coordinates": null,
        "place": null,
        "contributors": null,
        "retweeted_status": {
            "created_at": "Tue May 07 05:10:30 +0000 2019",
            "id": 1125628953438445568,
            "id_str": "1125628953438445568",
            "text": "aMaybe he'll finally find his keys",
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
                "id_str": "1114072936665821184"
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
    },
    {
        "created_at": "Tue May 07 05:10:30 +0000 2019",
        "id": 1125628953438445568,
        "id_str": "1125628953438445568",
        "text": "aMaybe he'll finally find his keys",
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
            "id_str": "1114072936665821184"
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
    {
        "created_at": "Tue May 07 05:01:51 +0000 2019",
        "id": 1125626777546764288,
        "id_str": "1125626777546764288",
        "text": "RT @ayo32039237: bMaybe he'll finally find his keys",
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
            "id_str": "1114072936665821184"
        },
        "geo": null,
        "coordinates": null,
        "place": null,
        "contributors": null,
        "retweeted_status": {
            "created_at": "Tue May 07 05:01:50 +0000 2019",
            "id": 1125626772433850368,
            "id_str": "1125626772433850368",
            "text": "bMaybe he'll finally find his keys",
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
                "id_str": "1114072936665821184"
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
    },
    {
        "created_at": "Tue May 07 05:01:50 +0000 2019",
        "id": 1125626772433850368,
        "id_str": "1125626772433850368",
        "text": "bMaybe he'll finally find his keys",
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
            "id_str": "1114072936665821184"
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
]
```
**Related Twitter documentation**

https://dev.twitter.com/rest/reference/get/statuses/user_timeline

####  Retrieving the most recent user mentioned tweets

The getStatusesMentionsTimeline operation retrieves the 20 most recent tweets that mention the authenticating user.

**getStatusesMentionsTimeline**
```xml
<twitter.getStatusesMentionsTimeline>
    <count>{$ctx:count}</count>
    <sinceId>{$ctx:sinceId}</sinceId>
    <maxId>{$ctx:maxId}</maxId>
    <trimUser>{$ctx:trimUser}</trimUser>
    <excludeReplies>{$ctx:excludeReplies}</excludeReplies>
    <contributorDetails>{$ctx:contributorDetails}</contributorDetails>
 </twitter.getStatusesMentionsTimeline>
```
**Properties**

* count: The number of tweets to return per page. 
* sinceId: If specified, retrieves tweets/retweets with an ID greater than the specified ID (i.e., more recent tweets). For example, if there have been more than 800 tweets/retweets since the specified sinceId, the sinceId will be forced to the oldest ID available.
* maxId: If specified, retrieves tweets/retweets with an ID less than (i.e., older tweets) or equal to the specified ID.
* trimUser: If set to either true, t or 1, each tweet returned in a timeline will include a user object including only the status author's user ID. Omit this property to retrieve the complete user object.
* excludeReplies:If set to true, this property will prevent replies from appearing in the returned timeline.
* contributorDetails:If set to true, this property enhances the contributor's details in the status response to include the screen name of the contributor. By default only the user ID of the contributor is included.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getStatusesMentionsTimeline operation.

```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "count":"5",
  "sinceId":"12566",
  "MaxId":"19566",
  "trimUser":"true",
  "excludeReplies":"true",
  "contributorDetails":"false"
 }
```


**Sample Response**

```json
{
   "output": [] 
}
```


**Related Twitter documentation**

https://dev.twitter.com/rest/reference/get/statuses/mentions_timeline

####  Retrieving authenticated user tweets that are retweeted by others

Retrieving authenticated user tweets that are retweeted by others.

**getStatusesRetweetsOfMe**
```xml
<twitter.getStatusesRetweetsOfMe>
    <count>{$ctx:count}</count>
    <sinceId>{$ctx:sinceId}</sinceId>
    <maxId>{$ctx:maxId}</maxId>
    <trimUser>{$ctx:trimUser}</trimUser>
    <includeEntities>{$ctx:includeEntities}</includeEntities>
    <includeUserEntities>{$ctx:includeUserEntities}</includeUserEntities>
 </twitter.getStatusesRetweetsOfMe>
```
**Properties**

* count: The number of tweets to return per page. 
* sinceId: If specified, retrieves tweets/retweets with an ID greater than the specified ID (i.e., more recent tweets). For example, if there have been more than 800 tweets/retweets since the specified sinceId, the sinceId will be forced to the oldest ID available.
* maxId: If specified, retrieves tweets/retweets with an ID less than (i.e., older tweets) or equal to the specified ID.
* trimUser: If set to either true, t or 1, each tweet returned in a timeline will include a user object including only the status author's user ID. Omit this property to retrieve the complete user object.
* includeEntities: Set to false if you do not want the entities node to be included in the retrieved tweets.
* includeUserEntities: Set to false if you do not want the user entities node to be included in the retrieved tweets.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getStatusesRetweetsOfMe operation.
```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "count":"5",
  "sinceId":"12566",
  "MaxId":"19566",
  "trimUser":"true",
  "includeEntities":"false",
  "includeUserEntities":"false"
 }
```

**Sample Response**

```json
[
    {
        "created_at": "Tue May 07 05:10:30 +0000 2019",
        "id": 1125628953438445568,
        "id_str": "1125628953438445568",
        "text": "aMaybe he'll finally find his keys",
        "truncated": false,
        "source": "<a href=\"https://api.twitter.com\" rel=\"nofollow\">IntegrationESB</a>",
        "in_reply_to_status_id": null,
        "in_reply_to_status_id_str": null,
        "in_reply_to_user_id": null,
        "in_reply_to_user_id_str": null,
        "in_reply_to_screen_name": null,
        "user": {
            "id": 1114072936665821184,
            "id_str": "1114072936665821184"
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
    {
        "created_at": "Tue May 07 05:01:50 +0000 2019",
        "id": 1125626772433850368,
        "id_str": "1125626772433850368",
        "text": "bMaybe he'll finally find his keys",
        "truncated": false,
        "source": "<a href=\"https://api.twitter.com\" rel=\"nofollow\">IntegrationESB</a>",
        "in_reply_to_status_id": null,
        "in_reply_to_status_id_str": null,
        "in_reply_to_user_id": null,
        "in_reply_to_user_id_str": null,
        "in_reply_to_screen_name": null,
        "user": {
            "id": 1114072936665821184,
            "id_str": "1114072936665821184"
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
]
```


**Related Twitter documentation**

https://dev.twitter.com/rest/reference/get/statuses/retweets_of_me

####  Retrieving tweet details

The getStatusesLookup operation retrieves fully-hydrated tweet objects based on the provided comma separated list of tweet IDs. You can retrieve up to 100 tweets per request.

**getStatusesLookup**
```xml
<twitter.getStatusesLookup>
    <id>{$ctx:id}</id>
    <trimUser>{$ctx:trimUser}</trimUser>
    <includeEntities>{$ctx:includeEntities}</includeEntities>
    <map>{$ctx:map}</map>
 </twitter.getStatusesLookup>
```
**Properties**

* id: A comma separated list of tweet IDs of the tweets you need to retrieve details for. You can specify up to 100 comma separated tweet IDs in a single request.
* trimUser: If set to either true, t or 1, each tweet returned in a timeline will include a user object including only the status author's user ID. Omit this property to retrieve the complete user object.
* includeEntities:  Set to false if you do not want the entities node to be included in the retrieved tweets.
* map: Set to true if you want tweets that do not exist or cannot be viewed by the current user to still have their key represented but with an explicitly null value paired with it.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getStatusesLookup operation.
```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "id":"20,432656548536401920",
  "trimUser":"false",
  "includeEntities":"true",
  "map":"true"
 }
```

**Sample Response**

```json
{
    "id": []
}
```


**Related Twitter documentation**

https://dev.twitter.com/rest/reference/get/statuses/lookup

####  Update statuses

The updateStatus operation updates the authenticating user’s current status, also known as Tweeting.

**updateStatus**
```xml
<twitter.updateStatus>
    <status>{$ctx:status}</status>
   <inReplyToStatusId>{$ctx:inReplyToStatusId}</inReplyToStatusId>
    <possiblySensitive>{$ctx:possiblySensitive}</possiblySensitive>
    <latitude>{$ctx:latitude}</latitude>
    <longitude>{$ctx:longitude}</longitude>
    <placeId>{$ctx:placeId}</placeId>
    <displayCoordinates>{$ctx:displayCoordinates}</displayCoordinates>
    <trimUser>{$ctx:trimUser}</trimUser>
    <mediaIds>{$ctx:mediaIds}</mediaIds>
 </twitter.updateStatus>
```
**Properties**

* status: The status. Be sure to URL encode as necessary, and keep the message under 140 characters
* inReplyToStatusId:  The ID of an existing status that the update is in reply.
* possiblySensitive: If you upload Tweet media that might be considered sensitive content such as nudity, violence, or medical procedures, you should set this value to true.
* latitude:The latitude of the location this tweet refers to.
* longitude:The longitude of the location this tweet refers to.
* placeId: A place in the world.
* displayCoordinates: Whether or not to put a pin on the exact coordinates a tweet has been sent from.
* trimUser: When set to either true, t or 1, each Tweet returned in a timeline will include a user object including only the status authors numerical ID
* mediaIds: A list of media_ids to associate with the Tweet.

**Sample request**

Following is a sample REST/JSON request that can be handled by the updateStatus operation.
```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "status":"Maybe he'll finally find his keys. #peterfalk",
  "possiblySensitive":"true"
 }
```

**Sample Response**

```json
{
    "created_at": "Tue May 07 04:34:46 +0000 2019",
    "id": 1125619960288620546,
    "id_str": "1125619960288620546",
    "text": "Maybe he'll finally find his keyk",
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
        "statuses_count": 4,
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
https://dev.twitter.com/rest/reference/post/statuses/update

#### Sample configuration

Following is a sample proxy service that illustrates how to connect to Twitter the init operation and use the getStatusesUserTimeline operation. The sample request for this proxy can be found in getStatusesUserTimeline sample request. You can use this sample as a template for using other operations in this category.
1. Create a sample proxy as below :

    **Sample Proxy**
    ```xml
   <proxy xmlns="http://ws.apache.org/ns/synapse"
          name="getStatusesUserTimeline"
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
           <twitter.init>
               <consumerKey>{$ctx:consumerKey}</consumerKey>
               <consumerSecret>{$ctx:consumerSecret}</consumerSecret>
               <accessToken>{$ctx:accessToken}</accessToken>
               <accessTokenSecret>{$ctx:accessTokenSecret}</accessTokenSecret>
            </twitter.init>
            <twitter.getStatusesUserTimeline>
               <screenName>{$ctx:screenName}</screenName>
               <count>{$ctx:count}</count>
            </twitter.getStatusesUserTimeline>
            <respond/>
         </inSequence>
         <outSequence>
            <send/>
         </outSequence>
      </target>
      <description/>
   </proxy>
    
    ```
2. Create a json file named getStatusesUserTimeline.json and copy the configurations given below to it:

    ```json
    {
      "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
      "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
      "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
      "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
      "screenName":"TestUser1",
      "count":"5",
      "sinceId":"12566",
      "MaxId":"19566",
      "trimUser":"true",
      "excludeReplies":"true",
      "contributorDetails":"true"
     }
    ```
3. Replace the credentials with your values.

4. Execute the following curl command:

    ```bash
    curl -X POST http://localhost:8280/services/getStatusesUserTimeline --header 'Content-Type: application/json' -d @getStatusesUserTimeline.json
    ```

5. Twitter returns a json response similar to the one shown below:
 
```json
{"output": []}

```
