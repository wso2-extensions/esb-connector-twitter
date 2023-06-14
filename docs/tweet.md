# Working with Tweets in Twitter

[[  Overview ]](#overview)  [[ Operation details ]](#operation-details)  [[  Sample configuration  ]](#sample-configuration)

### Overview 

The following operations allow you to work with tweets. 
To be authorized for the following endpoints, you will need an access token with the correct scopes. Please refer the https://developer.twitter.com/en/docs/authentication/guides/v2-authentication-mapping to get the required scopes for the access token.
Click an operation name to see details on how to use it.
For a sample proxy service that illustrates how to work with tweets, see [Sample configuration](#sample-configuration).

| Operation                                                         | Description                                                                                       |
|-------------------------------------------------------------------|---------------------------------------------------------------------------------------------------|
| [createTweet](#Creating-a-Tweet)                                  | Creates a Tweet.                                                                                  |
| [deleteTweet](#Deleting-a-Tweet)                                  | Deletes a Tweet when given the Tweet ID.                                                          |
| [getTweetById](#Retrieving-information-of-a-Tweet-using-id)       | Retrieves information about a single Tweet specified by the requested ID.                         |
| [getTweetsLookup](#Retrieving-Tweet-information)                  | Retrieves information about one or more Tweets specified by the requested IDs.                    |
| [searchTweets](#Searching-Tweets)                                 | Retrieves a collection of tweets that meet the specified search criteria.                         |
| [likeTweet](#Liking-a-Tweet)                                      | Likes a tweet.                                                                                    |
| [unlikeTweet](#Unliking-a-Tweet)                                  | Unlikes a tweet.                                                                                  |
| [getLikedTweetsList](#Retrieving-a-list-of-liked-Tweets)          | Retrieves a list of liked Tweets of the specified user ID.                                        |
| [createRetweet](#Retweeting-a-Tweet)                              | Retweets a Tweet.                                                                                 |
| [getUserHomeTimeline](#Retrieving-the-user-home-timeline)         | Retrieves a collection of the most recent Tweets and Retweets posted by you and users you follow. |
| [getUserMentionsTimeline](#Retrieving-the-user-mentions-timeline) | Retrieves Tweets mentioning a single user specified by the requested user ID.                     |
| [getUserTweetsTimeline](#Retrieving-the-user-Tweets-timeline)     | Retrieves Tweets composed by a single user, specified by the requested user ID.                   |


### Operation details

This section provides further details on the operations related to tweets.

#### Creating a Tweet
The createTweet operation creates a Tweet.

**createTweet**
```xml
<twitter.createTweet>
    <text>{$ctx:text}</text>
    <direct_message_deep_link>{$ctx:direct_message_deep_link}</direct_message_deep_link>
    <for_super_followers_only>{$ctx:for_super_followers_only}</for_super_followers_only>
    <geo>{$ctx:geo}</geo>
    <media>{$ctx:media}</media>
    <poll>{$ctx:poll}</poll>
    <quote_tweet_id>{$ctx:quote_tweet_id}</quote_tweet_id>
    <reply>{$ctx:reply}</reply>
    <reply_settings>{$ctx:reply_settings}</reply_settings>
</twitter.createTweet>
```

**Properties**
* text : `Required` - `String` - The text of your Tweet. Up to 280 characters are permitted. This field is required if media.media_ids is not present.
* direct_message_deep_link : `Optional` - `String` - Tweets a link directly to a Direct Message conversation with an account.
* for_super_followers_only : `Optional` - `Boolean` - Allows you to Tweet exclusively for Super Followers.
* geo : `Optional` - `Object` - A JSON object that contains location information for a Tweet. You can only add a location to Tweets if you have geo enabled in your profile settings. If you don't have geo enabled, you can still add a location parameter in your request body, but it won't get attached to your Tweet.
* media : `Optional` - `Object` - A JSON object that contains media information being attached to created Tweet. This is mutually exclusive from Quote Tweet ID and Poll.
* poll : `Optional` - `Object` - A JSON object that contains options for a Tweet with a poll. This is mutually exclusive from Media and Quote Tweet ID.
* quote_tweet_id : `Optional` - `String` - Link to the Tweet being quoted.
* reply : `Optional` - `Object` - A JSON object that contains information of the Tweet being replied to.
* reply_settings : `Optional` - `String` - 	Settings to indicate who can reply to the Tweet. Options include "mentionedUsers" and "following". If the field isn’t specified, it will default to everyone.

**Sample request**

Following is a sample REST/JSON request that can be handled by the createTweet operation.

**Sample Request for createTweet**
```json
{
   "accessToken":"WmNNbTBVYmlDVUJzemNUZzVMa1dGclBJZ1d2d0RKQXk5MVk3NXM2cWRwbXZPOjE2ODYyODMzODg3NDk6MTowOmF0OjE",
   "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
   "text":"Hello World!",
   "poll": {"options": ["yes", "maybe", "no"], "duration_minutes": 120},
   "for_super_followers_only": false,
   "direct_message_deep_link": "https://twitter.com/messages/compose?recipient_id=2244994945",
   "geo": {"place_id": "5a110d312052166f"},
   "media": {"media_ids": ["1455952740635586573"], "tagged_user_ids": ["2244994945","6253282"]},
   "reply": {"in_reply_to_tweet_id": "1455953449422516226", "exclude_reply_user_ids": ["6253282"]},
   "reply_settings": "mentionedUsers"
}
```

**Sample Response**

```json
{
   "data": {
      "edit_history_tweet_ids": [
         "1667035675894640640"
      ],
      "id": "1667035675894640640",
      "text": "Hello World!"
   }
}
```

**Related Twitter documentation**
https://developer.twitter.com/en/docs/twitter-api/tweets/manage-tweets/api-reference/post-tweets

#### Deleting a Tweet
The deleteTweet operation deletes a Tweet when given the Tweet ID.

**deleteTweet**
```xml
<twitter.deleteTweet>
    <id>{$ctx:id}</id>
</twitter.deleteTweet>
```

**Properties**
* id : `Required` - `String` - The Tweet ID you are deleting.

**Sample request**

Following is a sample REST/JSON request that can be handled by the deleteTweet operation.

**Sample Request for deleteTweet**
```json
{
   "accessToken":"WmNNbTBVYmlDVUJzemNUZzVMa1dGclBJZ1d2d0RKQXk5MVk3NXM2cWRwbXZPOjE2ODYyODMzODg3NDk6MTowOmF0OjE",
   "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
   "id":"1667035675894640640"
}
```

**Sample Response**

```json
{
   "data": {
      "deleted": true
   }
}
```

**Related Twitter documentation**
https://developer.twitter.com/en/docs/twitter-api/tweets/manage-tweets/api-reference/delete-tweets-id

#### Retrieving information of a Tweet using id
The getTweetById operation retrieves information about a single Tweet specified by the requested ID.

**retweet**
```xml
<twitter.getTweetById>
    <id>{$ctx:id}</id>
    <expansions>{$ctx:expansions}</expansions>
    <media_fields>{$ctx:media_fields}</media_fields>
    <place_fields>{$ctx:place_fields}</place_fields>
    <poll_fields>{$ctx:poll_fields}</poll_fields>
    <tweet_fields>{$ctx:tweet_fields}</tweet_fields>
    <user_fields>{$ctx:user_fields}</user_fields>
</twitter.getTweetById>
```

**Properties**
* id: `Required` - `String` - Unique identifier of the Tweet to request.
* expansions : `Optional` - `Enum` - Expansions enable you to request additional data objects that relate to the originally returned Tweets. Submit a list of desired expansions in a comma-separated list without spaces. The ID that represents the expanded data object will be included directly in the Tweet data object, but the expanded object metadata will be returned within the includes response object, and will also include the ID so that you can match this data object to the original Tweet object. Valid values for this parameter are: `attachments.poll_ids, attachments.media_keys, author_id, edit_history_tweet_ids, entities.mentions.username, geo.place_id, in_reply_to_user_id, referenced_tweets.id, referenced_tweets.id.author_id`.
* media_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific media fields will deliver in each returned Tweet. Specify the desired fields in a comma-separated list without spaces between commas and fields. The Tweet will only return media fields if the Tweet contains media and if you've also included the expansions=attachments.media_keys query parameter in your request. While the media ID will be located in the Tweet object, you will find this ID and all additional media fields in the includes data object. Valid values for this parameter are: `duration_ms, height, media_key, preview_image_url, type, url, width, public_metrics, non_public_metrics, organic_metrics, promoted_metrics, alt_text, variants`.
* place_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific place fields will deliver in each returned Tweet. Specify the desired fields in a comma-separated list without spaces between commas and fields. The response will contain the selected fields only if you've also included the expansions=geo.place_id query parameter in your request. Valid values for this parameter are: `contained_within, country, country_code, full_name, geo, id, name, place_type`.
* poll_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific poll fields will deliver in each returned Tweet. Specify the desired fields in a comma-separated list without spaces between commas and fields. The Tweet will only return poll fields if the Tweet contains a poll and if you've also included the expansions=attachments.poll_ids query parameter in your request. While the poll ID will be located in the Tweet object, you will find this ID and all additional poll fields in the includes data object. Valid values for this parameter are: `duration_minutes, end_datetime, id, options, voting_status`.
* tweet_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific Tweet fields will deliver in each returned Tweet object. Specify the desired fields in a comma-separated list without spaces between commas and fields. You can also pass the expansions=referenced_tweets.id expansion to return the specified fields for both the original Tweet and any included referenced Tweets. The requested Tweet fields will display in both the original Tweet data object, as well as in the referenced Tweet expanded data object that will be located in the includes data object. Valid values for this parameter are: `attachments, author_id, context_annotations, conversation_id, created_at, edit_controls, entities, geo, id, in_reply_to_user_id, lang, non_public_metrics, public_metrics, organic_metrics, promoted_metrics, possibly_sensitive, referenced_tweets, reply_settings, source, text, withheld`.
* user_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific user fields will deliver in each returned Tweet. Specify the desired fields in a comma-separated list without spaces between commas and fields. While the user ID will be located in the original Tweet object, you will find this ID and all additional user fields in the includes data object. Valid values for this parameter are: `created_at, description, entities, id, location, name, pinned_tweet_id, profile_image_url, protected, public_metrics, url, username, verified, verified_type, withheld`.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getTweetById operation.

**Sample Request for getTweetById**
```json
{
   "accessToken":"WmNNbTBVYmlDVUJzemNUZzVMa1dGclBJZ1d2d0RKQXk5MVk3NXM2cWRwbXZPOjE2ODYyODMzODg3NDk6MTowOmF0OjE",
   "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
   "id":"1460323737035677698",
   "expansions":"attachments.media_keys,author_id",
   "media_fields":"duration_ms,media_key",
   "place_fields":"country",
   "tweet_fields":"lang",
   "user_fields":"username"
}
```

**Sample Response**

```json
{
   "data": {
      "lang": "en",
      "author_id": "2244994945",
      "text": "Introducing a new era for the Twitter Developer Platform! \n\n📣The Twitter API v2 is now the primary API and full of new features\n⏱Immediate access for most use cases, or apply to get more access for free\n📖Removed certain restrictions in the Policy\nhttps://t.co/Hrm15bkBWJ https://t.co/YFfCDErHsg",
      "attachments": {
         "media_keys": [
            "7_1460322142680072196"
         ]
      },
      "id": "1460323737035677698",
      "edit_history_tweet_ids": [
         "1460323737035677698"
      ]
   },
   "includes": {
      "media": [
         {
            "duration_ms": 11093,
            "media_key": "7_1460322142680072196",
            "type": "video"
         }
      ],
      "users": [
         {
            "id": "2244994945",
            "name": "Twitter Dev",
            "username": "TwitterDev"
         }
      ]
   }
}
```

**Related Twitter documentation**
https://developer.twitter.com/en/docs/twitter-api/tweets/lookup/api-reference/get-tweets-id

#### Retrieving Tweet information
The getTweetsLookup operation retrieves information about one or more Tweets specified by the requested IDs.

**retweet**
```xml
<twitter.getTweetsLookup>
    <ids>{$ctx:ids}</ids>
    <expansions>{$ctx:expansions}</expansions>
    <media_fields>{$ctx:media_fields}</media_fields>
    <place_fields>{$ctx:place_fields}</place_fields>
    <poll_fields>{$ctx:poll_fields}</poll_fields>
    <tweet_fields>{$ctx:tweet_fields}</tweet_fields>
    <user_fields>{$ctx:user_fields}</user_fields>
</twitter.getTweetsLookup>
```

**Properties**
* ids: `Required` - `String` - A comma separated list of Tweet IDs. Up to 100 are allowed in a single request. Make sure to not include a space between commas and fields.
* expansions : `Optional` - `Enum` - Expansions enable you to request additional data objects that relate to the originally returned Tweets. Submit a list of desired expansions in a comma-separated list without spaces. The ID that represents the expanded data object will be included directly in the Tweet data object, but the expanded object metadata will be returned within the includes response object, and will also include the ID so that you can match this data object to the original Tweet object. Valid values for this parameter are: `attachments.poll_ids, attachments.media_keys, author_id, edit_history_tweet_ids, entities.mentions.username, geo.place_id, in_reply_to_user_id, referenced_tweets.id, referenced_tweets.id.author_id`.
* media_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific media fields will deliver in each returned Tweet. Specify the desired fields in a comma-separated list without spaces between commas and fields. The Tweet will only return media fields if the Tweet contains media and if you've also included the expansions=attachments.media_keys query parameter in your request. While the media ID will be located in the Tweet object, you will find this ID and all additional media fields in the includes data object. Valid values for this parameter are: `duration_ms, height, media_key, preview_image_url, type, url, width, public_metrics, non_public_metrics, organic_metrics, promoted_metrics, alt_text, variants`.
* place_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific place fields will deliver in each returned Tweet. Specify the desired fields in a comma-separated list without spaces between commas and fields. The response will contain the selected fields only if you've also included the expansions=geo.place_id query parameter in your request. Valid values for this parameter are: `contained_within, country, country_code, full_name, geo, id, name, place_type`.
* poll_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific poll fields will deliver in each returned Tweet. Specify the desired fields in a comma-separated list without spaces between commas and fields. The Tweet will only return poll fields if the Tweet contains a poll and if you've also included the expansions=attachments.poll_ids query parameter in your request. While the poll ID will be located in the Tweet object, you will find this ID and all additional poll fields in the includes data object. Valid values for this parameter are: `duration_minutes, end_datetime, id, options, voting_status`.
* tweet_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific Tweet fields will deliver in each returned Tweet object. Specify the desired fields in a comma-separated list without spaces between commas and fields. You can also pass the expansions=referenced_tweets.id expansion to return the specified fields for both the original Tweet and any included referenced Tweets. The requested Tweet fields will display in both the original Tweet data object, as well as in the referenced Tweet expanded data object that will be located in the includes data object. Valid values for this parameter are: `attachments, author_id, context_annotations, conversation_id, created_at, edit_controls, entities, geo, id, in_reply_to_user_id, lang, non_public_metrics, public_metrics, organic_metrics, promoted_metrics, possibly_sensitive, referenced_tweets, reply_settings, source, text, withheld`.
* user_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific user fields will deliver in each returned Tweet. Specify the desired fields in a comma-separated list without spaces between commas and fields. While the user ID will be located in the original Tweet object, you will find this ID and all additional user fields in the includes data object. Valid values for this parameter are: `created_at, description, entities, id, location, name, pinned_tweet_id, profile_image_url, protected, public_metrics, url, username, verified, verified_type, withheld`.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getTweetsLookup operation.

**Sample Request for getTweetsLookup**
```json
{
   "accessToken":"WmNNbTBVYmlDVUJzemNUZzVMa1dGclBJZ1d2d0RKQXk5MVk3NXM2cWRwbXZPOjE2ODYyODMzODg3NDk6MTowOmF0OjE",
   "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
   "ids":"1460323737035677698,1519781379172495360,1519781381693353984",
   "expansions":"attachments.poll_ids,author_id",
   "poll_fields":"duration_minutes",
   "place_fields":"country",
   "tweet_fields":"lang",
   "user_fields":"username"
}
```

**Sample Response**

```json
{
   "data": [
      {
         "text": "Introducing a new era for the Twitter Developer Platform! \n\n📣The Twitter API v2 is now the primary API and full of new features\n⏱Immediate access for most use cases, or apply to get more access for free\n📖Removed certain restrictions in the Policy\nhttps://t.co/Hrm15bkBWJ https://t.co/YFfCDErHsg",
         "edit_history_tweet_ids": [
            "1460323737035677698"
         ],
         "id": "1460323737035677698",
         "lang": "en",
         "author_id": "2244994945"
      },
      {
         "text": "Our mission remains just as important as ever: to deliver an open platform that serves the public conversation. We’re continuing to innovate on the Twitter API v2 and invest in our developer community 🧵\n\nhttps://t.co/Rug1l46sUc",
         "edit_history_tweet_ids": [
            "1519781379172495360"
         ],
         "id": "1519781379172495360",
         "lang": "en",
         "author_id": "2244994945"
      },
      {
         "text": "Catch up on recent launches and build with the core elements of the Twitter experience:\n🔖 New Bookmarks endpoints\n💬 New Quote Tweets lookup endpoints\n🔼 New sort_order parameter on search endpoints, and improvements to the Likes and Retweets endpoints",
         "edit_history_tweet_ids": [
            "1519781381693353984"
         ],
         "id": "1519781381693353984",
         "lang": "en",
         "author_id": "2244994945"
      }
   ],
   "includes": {
      "users": [
         {
            "id": "2244994945",
            "name": "Twitter Dev",
            "username": "TwitterDev"
         }
      ]
   }
}
```

**Related Twitter documentation**
https://developer.twitter.com/en/docs/twitter-api/tweets/lookup/api-reference/get-tweets

#### Searching Tweets
The searchTweets operation retrieves a collection of tweets that meet the specified search criteria.

**searchTweets**
```xml
<twitter.searchTweets>
    <query>{$ctx:query}</query>
    <start_time>{$ctx:start_time}</start_time>
    <end_time>{$ctx:end_time}</end_time>
    <since_id>{$ctx:since_id}</since_id>
    <until_id>{$ctx:until_id}</until_id>
    <sort_order>{$ctx:sort_order}</sort_order>
    <max_results>{$ctx:max_results}</max_results>
    <next_token>{$ctx:next_token}</next_token>
    <expansions>{$ctx:expansions}</expansions>
    <media_fields>{$ctx:media_fields}</media_fields>
    <place_fields>{$ctx:place_fields}</place_fields>
    <poll_fields>{$ctx:poll_fields}</poll_fields>
    <tweet_fields>{$ctx:tweet_fields}</tweet_fields>
    <user_fields>{$ctx:user_fields}</user_fields>
</twitter.searchTweets>
```

**Properties**
* query: `Required` - `String` - One query for matching Tweets.
* start_time : `Optional` - `Date (ISO 8601)` - YYYY-MM-DDTHH:mm:ssZ (ISO 8601/RFC 3339). The oldest UTC timestamp (from most recent seven days) from which the Tweets will be provided. Timestamp is in second granularity and is inclusive (for example, 12:00:01 includes the first second of the minute). If included with the same request as a since_id parameter, only since_id will be used. By default, a request will return Tweets from up to seven days ago if you do not include this parameter.
* end_time : `Optional` - `Date (ISO 8601)` - YYYY-MM-DDTHH:mm:ssZ (ISO 8601/RFC 3339). The newest, most recent UTC timestamp to which the Tweets will be provided. Timestamp is in second granularity and is exclusive (for example, 12:00:01 excludes the first second of the minute). By default, a request will return Tweets from as recent as 30 seconds ago if you do not include this parameter.
* since_id : `Optional` - `String` - Returns results with a Tweet ID greater than (that is, more recent than) the specified ID. The ID specified is exclusive and responses will not include it. If included with the same request as a start_time parameter, only since_id will be used.
* until_id : `Optional` - `String` - Returns results with a Tweet ID less than (that is, older than) the specified ID. The ID specified is exclusive and responses will not include it.
* sort_order : `Optional` - `Enum` - This parameter is used to specify the order in which you want the Tweets returned. By default, a request will return the most recent Tweets first (sorted by recency). se object, and will also include the ID so that you can match this data object to the original Tweet object. Valid values for this parameter are: `recency, relevancy`
* max_results: `Optional` - `Integer` - The maximum number of results to be returned per page. This can be a number between 1 and the 1000. By default, each page will return 100 results.
* next_token : `Optional` - `String` - This parameter is used to get the next 'page' of results. The value used with the parameter is pulled directly from the response provided by the API, and should not be modified.
* expansions : `Optional` - `Enum` - Expansions enable you to request additional data objects that relate to the originally returned Tweets. Submit a list of desired expansions in a comma-separated list without spaces. The ID that represents the expanded data object will be included directly in the Tweet data object, but the expanded object metadata will be returned within the includes response object, and will also include the ID so that you can match this data object to the original Tweet object. Valid values for this parameter are: `attachments.poll_ids, attachments.media_keys, author_id, edit_history_tweet_ids, entities.mentions.username, geo.place_id, in_reply_to_user_id, referenced_tweets.id, referenced_tweets.id.author_id`.
* media_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific media fields will deliver in each returned Tweet. Specify the desired fields in a comma-separated list without spaces between commas and fields. The Tweet will only return media fields if the Tweet contains media and if you've also included the expansions=attachments.media_keys query parameter in your request. While the media ID will be located in the Tweet object, you will find this ID and all additional media fields in the includes data object. Valid values for this parameter are: `duration_ms, height, media_key, preview_image_url, type, url, width, public_metrics, non_public_metrics, organic_metrics, promoted_metrics, alt_text, variants`.
* place_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific place fields will deliver in each returned Tweet. Specify the desired fields in a comma-separated list without spaces between commas and fields. The response will contain the selected fields only if you've also included the expansions=geo.place_id query parameter in your request. Valid values for this parameter are: `contained_within, country, country_code, full_name, geo, id, name, place_type`.
* poll_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific poll fields will deliver in each returned Tweet. Specify the desired fields in a comma-separated list without spaces between commas and fields. The Tweet will only return poll fields if the Tweet contains a poll and if you've also included the expansions=attachments.poll_ids query parameter in your request. While the poll ID will be located in the Tweet object, you will find this ID and all additional poll fields in the includes data object. Valid values for this parameter are: `duration_minutes, end_datetime, id, options, voting_status`.
* tweet_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific Tweet fields will deliver in each returned Tweet object. Specify the desired fields in a comma-separated list without spaces between commas and fields. You can also pass the expansions=referenced_tweets.id expansion to return the specified fields for both the original Tweet and any included referenced Tweets. The requested Tweet fields will display in both the original Tweet data object, as well as in the referenced Tweet expanded data object that will be located in the includes data object. Valid values for this parameter are: `attachments, author_id, context_annotations, conversation_id, created_at, edit_controls, entities, geo, id, in_reply_to_user_id, lang, non_public_metrics, public_metrics, organic_metrics, promoted_metrics, possibly_sensitive, referenced_tweets, reply_settings, source, text, withheld`.
* user_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific user fields will deliver in each returned Tweet. Specify the desired fields in a comma-separated list without spaces between commas and fields. While the user ID will be located in the original Tweet object, you will find this ID and all additional user fields in the includes data object. Valid values for this parameter are: `created_at, description, entities, id, location, name, pinned_tweet_id, profile_image_url, protected, public_metrics, url, username, verified, verified_type, withheld`.

**Sample request**

Following is a sample REST/JSON request that can be handled by the searchTweets operation.

**Sample Request for searchTweets**
```json
{
   "accessToken":"WmNNbTBVYmlDVUJzemNUZzVMa1dGclBJZ1d2d0RKQXk5MVk3NXM2cWRwbXZPOjE2ODYyODMzODg3NDk6MTowOmF0OjE",
   "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
   "query": "(from:TwitterDev) new -is:retweet",
   "start_time": "2020-01-01T00:00:00Z",
   "max_results":10,
   "sort_order":"recency",
   "expansions":"author_id",
   "tweet_fields":"created_at,lang,conversation_id",
   "user_fields":"created_at,entities"
}
```

**Sample Response**

```json
{
   "data": [
      {
         "text": "Looking to get started with the Twitter API but new to APIs in general? @jessicagarson will walk you through everything you need to know in APIs 101 session. She’ll use examples using our v2 endpoints, Tuesday, March 23rd at 1 pm EST.nnJoin us on Twitchnhttps://t.co/GrtBOXyHmB",
         "author_id": "2244994945",
         "id": "1373001119480344583",
         "edit_history_tweet_ids": [
            "1373001119480344583"
         ],
         "lang": "en",
         "conversation_id": "1373001119480344583",
         "created_at": "2021-03-19T19:59:10.000Z"
      }
   ],
   "includes": {
      "users": [
         {
            "id": "2244994945",
            "entities": {
               "url": {
                  "urls": [
                     {
                        "start": 0,
                        "end": 23,
                        "url": "https://t.co/3ZX3TNiZCY",
                        "expanded_url": "https://developer.twitter.com/en/community",
                        "display_url": "developer.twitter.com/en/community"
                     }
                  ]
               },
               "description": {
                  "hashtags": [
                     {
                        "start": 17,
                        "end": 28,
                        "tag": "TwitterDev"
                     },
                     {
                        "start": 105,
                        "end": 116,
                        "tag": "TwitterAPI"
                     }
                  ]
               }
            },
            "created_at": "2013-12-14T04:35:55.000Z",
            "username": "TwitterDev",
            "name": "Twitter Dev"
         }
      ]
   },
   "meta": {
      "newest_id": "1373001119480344583",
      "oldest_id": "1373001119480344583",
      "result_count": 1
   }
}
```

**Related Twitter documentation**
https://developer.twitter.com/en/docs/twitter-api/tweets/search/api-reference/get-tweets-search-recent

#### Liking a Tweet
The likeTweet operation likes a tweet.

**likeTweet**
```xml
<twitter.likeTweet>
    <user_id>{$ctx:user_id}</user_id>
    <tweet_id>{$ctx:tweet_id}</tweet_id>
</twitter.likeTweet>
```

**Properties**
* user_id : `Required` - `String` - The user ID who you are liking a Tweet on behalf of.
* tweet_id : `Required` - `String` - The ID of the Tweet that you would like the user id to Like.

**Sample request**

Following is a sample REST/JSON request that can be handled by the likeTweet operation.

**Sample Request for likeTweet**
```json
{
   "accessToken":"NTFkWWlDdjVIV01YYlRDVGZJdGNRWVlMMU5NcmV1WlRHYW1oaFE2TEt1RWZkOjE2ODYyOTEzNzU1OTM6MToxOmF0OjE",
   "refreshToken":"",
   "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
   "user_id":"1655515285577936899",
   "tweet_id":"1521887626935947265"
}
```

**Sample Response**

```json
{
   "data": {
      "liked": true
   }
}
```

**Related Twitter documentation**
https://developer.twitter.com/en/docs/twitter-api/tweets/likes/api-reference/post-users-id-likes

#### Unliking a Tweet
The unlikeTweet operation unlikes a tweet.

**unlikeTweet**
```xml
<twitter.unlikeTweet>
    <user_id>{$ctx:user_id}</user_id>
    <tweet_id>{$ctx:tweet_id}</tweet_id>
</twitter.unlikeTweet>
```

**Properties**
* user_id : `Required` - `String` - The user ID who you are removing a Like of a Tweet on behalf of.
* tweet_id : `Required` - `String` - The ID of the Tweet that you would like the id to unlike.

**Sample request**

Following is a sample REST/JSON request that can be handled by the unlikeTweet operation.

**Sample Request for unlikeTweet**
```json
{
   "accessToken":"NTFkWWlDdjVIV01YYlRDVGZJdGNRWVlMMU5NcmV1WlRHYW1oaFE2TEt1RWZkOjE2ODYyOTEzNzU1OTM6MToxOmF0OjE",
   "refreshToken":"",
   "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
   "user_id":"1655515285577936899",
   "tweet_id":"1521887626935947265"
}
```

**Sample Response**

```json
{
   "data": {
      "liked": false
   }
}
```

**Related Twitter documentation**
https://developer.twitter.com/en/docs/twitter-api/tweets/likes/api-reference/delete-users-id-likes-tweet_id

#### Retrieving a list of liked Tweets
The getLikedTweetsList operation retrieves a list of liked Tweets of the specified user ID.

**getLikedTweetsList**
```xml
<twitter.getLikedTweetsList>
    <id>{$ctx:id}</id>
    <max_results>{$ctx:max_results}</max_results>
    <pagination_token>{$ctx:pagination_token}</pagination_token>
    <expansions>{$ctx:expansions}</expansions>
    <media_fields>{$ctx:media_fields}</media_fields>
    <place_fields>{$ctx:place_fields}</place_fields>
    <poll_fields>{$ctx:poll_fields}</poll_fields>
    <tweet_fields>{$ctx:tweet_fields}</tweet_fields>
    <user_fields>{$ctx:user_fields}</user_fields>
</twitter.getLikedTweetsList>
```

**Properties**
* id: `Required` - `String` - User ID of the user to request liked Tweets for.
* max_results: `Optional` - `Integer` - The maximum number of results to be returned per page. This can be a number between 10 and 100. By default, each page will return 100 results.
* pagination_token : `Optional` - `String` - Used to request the next page of results if all results weren't returned with the latest request, or to go back to the previous page of results. To return the next page, pass the next_token returned in your previous response. To go back one page, pass the previous_token returned in your previous response.
* expansions : `Optional` - `Enum` - Expansions enable you to request additional data objects that relate to the originally returned Tweets. Submit a list of desired expansions in a comma-separated list without spaces. The ID that represents the expanded data object will be included directly in the Tweet data object, but the expanded object metadata will be returned within the includes response object, and will also include the ID so that you can match this data object to the original Tweet object. Valid values for this parameter are: `attachments.poll_ids, attachments.media_keys, author_id, edit_history_tweet_ids, entities.mentions.username, geo.place_id, in_reply_to_user_id, referenced_tweets.id, referenced_tweets.id.author_id`.
* media_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific media fields will deliver in each returned Tweet. Specify the desired fields in a comma-separated list without spaces between commas and fields. The Tweet will only return media fields if the Tweet contains media and if you've also included the expansions=attachments.media_keys query parameter in your request. While the media ID will be located in the Tweet object, you will find this ID and all additional media fields in the includes data object. Valid values for this parameter are: `duration_ms, height, media_key, preview_image_url, type, url, width, public_metrics, non_public_metrics, organic_metrics, promoted_metrics, alt_text, variants`.
* place_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific place fields will deliver in each returned Tweet. Specify the desired fields in a comma-separated list without spaces between commas and fields. The response will contain the selected fields only if you've also included the expansions=geo.place_id query parameter in your request. Valid values for this parameter are: `contained_within, country, country_code, full_name, geo, id, name, place_type`.
* poll_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific poll fields will deliver in each returned Tweet. Specify the desired fields in a comma-separated list without spaces between commas and fields. The Tweet will only return poll fields if the Tweet contains a poll and if you've also included the expansions=attachments.poll_ids query parameter in your request. While the poll ID will be located in the Tweet object, you will find this ID and all additional poll fields in the includes data object. Valid values for this parameter are: `duration_minutes, end_datetime, id, options, voting_status`.
* tweet_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific Tweet fields will deliver in each returned Tweet object. Specify the desired fields in a comma-separated list without spaces between commas and fields. You can also pass the expansions=referenced_tweets.id expansion to return the specified fields for both the original Tweet and any included referenced Tweets. The requested Tweet fields will display in both the original Tweet data object, as well as in the referenced Tweet expanded data object that will be located in the includes data object. Valid values for this parameter are: `attachments, author_id, context_annotations, conversation_id, created_at, edit_controls, entities, geo, id, in_reply_to_user_id, lang, non_public_metrics, public_metrics, organic_metrics, promoted_metrics, possibly_sensitive, referenced_tweets, reply_settings, source, text, withheld`.
* user_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific user fields will deliver in each returned Tweet. Specify the desired fields in a comma-separated list without spaces between commas and fields. While the user ID will be located in the original Tweet object, you will find this ID and all additional user fields in the includes data object. Valid values for this parameter are: `created_at, description, entities, id, location, name, pinned_tweet_id, profile_image_url, protected, public_metrics, url, username, verified, verified_type, withheld`.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getLikedTweetsList operation.

**Sample Request for getLikedTweetsList**
```json
{
   "accessToken":"VXFrR0lsS2RtYnV5ZU9FYTNKOEZSaFhxZXAzQjBEVnNWSVo4Q25pWVFCUlM4OjE2ODYyOTIxNTM3MjU6MTowOmF0OjE",
   "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
   "id":"1655515285577936899",
   "max_results":"10"
}
```

**Sample Response**

```json
{
   "data": [
      {
         "edit_history_tweet_ids": [
            "1519781381693353984"
         ],
         "id": "1519781381693353984",
         "text": "Catch up on recent launches and build with the core elements of the Twitter experience:\n🔖 New Bookmarks endpoints\n💬 New Quote Tweets lookup endpoints\n🔼 New sort_order parameter on search endpoints, and improvements to the Likes and Retweets endpoints"
      },
      {
         "edit_history_tweet_ids": [
            "1519781379172495360"
         ],
         "id": "1519781379172495360",
         "text": "Our mission remains just as important as ever: to deliver an open platform that serves the public conversation. We’re continuing to innovate on the Twitter API v2 and invest in our developer community 🧵\n\nhttps://t.co/Rug1l46sUc"
      },
      {
         "edit_history_tweet_ids": [
            "1460323737035677698"
         ],
         "id": "1460323737035677698",
         "text": "Introducing a new era for the Twitter Developer Platform! \n\n📣The Twitter API v2 is now the primary API and full of new features\n⏱Immediate access for most use cases, or apply to get more access for free\n📖Removed certain restrictions in the Policy\nhttps://t.co/Hrm15bkBWJ https://t.co/YFfCDErHsg"
      }
   ],
   "meta": {
      "result_count": 3,
      "next_token": "7140dibdnow9c7btw482mq8hweo1bqos2tvjtvo5vftx2"
   }
}
```

**Related Twitter documentation**
https://developer.twitter.com/en/docs/twitter-api/tweets/likes/api-reference/get-users-id-liked_tweets

#### Retweeting a Tweet
The createRetweet operation retweets a Tweet.

**createRetweet**
```xml
<twitter.createRetweet>
    <user_id>{$ctx:user_id}</user_id>
    <tweet_id>{$ctx:tweet_id}</tweet_id>
</twitter.createRetweet>
```

**Properties**
* user_id : `Required` - `String` - The user ID who you are Retweeting a Tweet on behalf of.
* tweet_id : `Required` - `String` - The ID of the Tweet that you would like the user id to Retweet.

**Sample request**

Following is a sample REST/JSON request that can be handled by the createRetweet operation.

**Sample Request for createRetweet**
```json
{
   "accessToken":"ZGQ0elVkYXZud0xDN2dVcFg1cHB1Z09qVE45enlpTmtDU0hlVDA0ckxlcDJsOjE2ODYyOTg1MDIxODI6MTowOmF0OjE",
   "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
   "user_id":"1655515285577936899",
   "tweet_id":"1519781381693353984"
}
```

**Sample Response**

```json
{
   "data": {
      "retweeted": true
   }
}
```

**Related Twitter documentation**
https://developer.twitter.com/en/docs/twitter-api/tweets/likes/api-reference/post-users-id-likes

#### Retrieving the user home timeline
The getUserHomeTimeline operation retrieves a collection of the most recent Tweets and Retweets posted by you and users you follow.

**getUserHomeTimeline**
```xml
<twitter.getUserHomeTimeline>
    <id>{$ctx:id}</id>
    <start_time>{$ctx:start_time}</start_time>
    <end_time>{$ctx:end_time}</end_time>
    <since_id>{$ctx:since_id}</since_id>
    <until_id>{$ctx:until_id}</until_id>
    <sort_order>{$ctx:sort_order}</sort_order>
    <max_results>{$ctx:max_results}</max_results>
    <pagination_token>{$ctx:pagination_token}</pagination_token>
    <exclude>{$ctx:exclude}</exclude>
    <expansions>{$ctx:expansions}</expansions>
    <media_fields>{$ctx:media_fields}</media_fields>
    <place_fields>{$ctx:place_fields}</place_fields>
    <poll_fields>{$ctx:poll_fields}</poll_fields>
    <tweet_fields>{$ctx:tweet_fields}</tweet_fields>
    <user_fields>{$ctx:user_fields}</user_fields>
</twitter.getUserHomeTimeline>
```

**Properties**
* id: `Required` - `String` - Unique identifier of the user that is requesting their chronological home timeline.
* start_time : `Optional` - `Date (ISO 8601)` - YYYY-MM-DDTHH:mm:ssZ (ISO 8601/RFC 3339). The oldest UTC timestamp from which the Tweets will be provided. Timestamp is in second granularity and is inclusive (for example, 12:00:01 includes the first second of the minute).
* end_time : `Optional` - `Date (ISO 8601)` - YYYY-MM-DDTHH:mm:ssZ (ISO 8601/RFC 3339). The new UTC timestamp from which the Tweets will be provided. Timestamp is in second granularity and is inclusive (for example, 12:00:01 includes the first second of the minute).
* since_id : `Optional` - `String` - Returns results with a Tweet ID greater than (that is, more recent than) the specified 'since' Tweet ID. There are limits to the number of Tweets that can be accessed through the API. If the limit of Tweets has occurred since the since_id, the since_id will be forced to the oldest ID available.
* until_id : `Optional` - `String` - Returns results with a Tweet ID less than (that is, older than) the specified 'until' Tweet ID. There are limits to the number of Tweets that can be accessed through the API. If the limit of Tweets has occurred since the until_id, the until_id will be forced to the most recent ID available.
* sort_order : `Optional` - `Enum` - This parameter is used to specify the order in which you want the Tweets returned. By default, a request will return the most recent Tweets first (sorted by recency). se object, and will also include the ID so that you can match this data object to the original Tweet object. Valid values for this parameter are: `recency, relevancy`
* max_results: `Optional` - `Integer` - Specifies the number of Tweets to try and retrieve, up to a maximum of 100 per distinct request. By default, 100 results are returned if this parameter is not supplied. The minimum permitted value is 1. It is possible to receive less than the max_results per request throughout the pagination process.
* pagination_token : `Optional` - `String` - This parameter is used to move forwards or backwards through 'pages' of results, based on the value of the next_token or previous_token in the response. The value used with the parameter is pulled directly from the response provided by the API, and should not be modified.
* exclude : `Optional` - `Enum` - Comma-separated list of the types of Tweets to exclude from the response. Valid values for this parameter are: `retweets, replies`
* expansions : `Optional` - `Enum` - Expansions enable you to request additional data objects that relate to the originally returned Tweets. Submit a list of desired expansions in a comma-separated list without spaces. The ID that represents the expanded data object will be included directly in the Tweet data object, but the expanded object metadata will be returned within the includes response object, and will also include the ID so that you can match this data object to the original Tweet object. Valid values for this parameter are: `attachments.poll_ids, attachments.media_keys, author_id, edit_history_tweet_ids, entities.mentions.username, geo.place_id, in_reply_to_user_id, referenced_tweets.id, referenced_tweets.id.author_id`.
* media_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific media fields will deliver in each returned Tweet. Specify the desired fields in a comma-separated list without spaces between commas and fields. The Tweet will only return media fields if the Tweet contains media and if you've also included the expansions=attachments.media_keys query parameter in your request. While the media ID will be located in the Tweet object, you will find this ID and all additional media fields in the includes data object. Valid values for this parameter are: `duration_ms, height, media_key, preview_image_url, type, url, width, public_metrics, non_public_metrics, organic_metrics, promoted_metrics, alt_text, variants`.
* place_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific place fields will deliver in each returned Tweet. Specify the desired fields in a comma-separated list without spaces between commas and fields. The response will contain the selected fields only if you've also included the expansions=geo.place_id query parameter in your request. Valid values for this parameter are: `contained_within, country, country_code, full_name, geo, id, name, place_type`.
* poll_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific poll fields will deliver in each returned Tweet. Specify the desired fields in a comma-separated list without spaces between commas and fields. The Tweet will only return poll fields if the Tweet contains a poll and if you've also included the expansions=attachments.poll_ids query parameter in your request. While the poll ID will be located in the Tweet object, you will find this ID and all additional poll fields in the includes data object. Valid values for this parameter are: `duration_minutes, end_datetime, id, options, voting_status`.
* tweet_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific Tweet fields will deliver in each returned Tweet object. Specify the desired fields in a comma-separated list without spaces between commas and fields. You can also pass the expansions=referenced_tweets.id expansion to return the specified fields for both the original Tweet and any included referenced Tweets. The requested Tweet fields will display in both the original Tweet data object, as well as in the referenced Tweet expanded data object that will be located in the includes data object. Valid values for this parameter are: `attachments, author_id, context_annotations, conversation_id, created_at, edit_controls, entities, geo, id, in_reply_to_user_id, lang, non_public_metrics, public_metrics, organic_metrics, promoted_metrics, possibly_sensitive, referenced_tweets, reply_settings, source, text, withheld`.
* user_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific user fields will deliver in each returned Tweet. Specify the desired fields in a comma-separated list without spaces between commas and fields. While the user ID will be located in the original Tweet object, you will find this ID and all additional user fields in the includes data object. Valid values for this parameter are: `created_at, description, entities, id, location, name, pinned_tweet_id, profile_image_url, protected, public_metrics, url, username, verified, verified_type, withheld`.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getUserHomeTimeline operation.

**Sample Request for getUserHomeTimeline**
```json
{
   "accessToken":"ZGQ0elVkYXZud0xDN2dVcFg1cHB1Z09qVE45enlpTmtDU0hlVDA0ckxlcDJsOjE2ODYyOTg1MDIxODI6MTowOmF0OjE",
   "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
   "id": "1655515285577936899",
   "start_time": "2020-01-01T00:00:00Z",
   "max_results":10,
   "sort_order":"recency",
   "exclude":"replies",
   "expansions":"author_id",
   "tweet_fields":"created_at,lang,conversation_id",
   "user_fields":"created_at,entities"
}
```

**Sample Response**

```json
{
   "data": [
      {
         "created_at": "2022-05-12T17:00:00.000Z",
         "text": "Today marks the launch of Devs in the Details, a technical video series made for developers by developers building with the Twitter API.  🚀nnIn this premiere episode, @jessicagarson walks us through how she built @FactualCat #WelcomeToOurTechTalkn⬇️nnhttps://t.co/nGa8JTQVBJ",
         "author_id": "2244994945",
         "edit_history_tweet_ids": [
            "1524796546306478083"
         ],
         "id": "1524796546306478083"
      },
      {
         "created_at": "2022-05-11T19:16:40.000Z",
         "text": "📢 Join @jessicagarson @alanbenlee and @i_am_daniele tomorrow, May 12  | 5:30 ET / 2:30pm PT as they discuss the future of bots https://t.co/sQ2bIO1fz6",
         "author_id": "2244994945",
         "edit_history_tweet_ids": [
            "1524468552404668416"
         ],
         "id": "1524468552404668416"
      },
      {
         "created_at": "2022-05-09T20:12:01.000Z",
         "text": "Do you make bots with the Twitter API? 🤖nnJoin @jessicagarson @alanbenlee and @iamdaniele on Thursday, May 12  | 5:30 ET / 2:30pm PT as they discuss the future of bots and answer any questions you might have. 🎙📆⬇️nnhttps://t.co/2uVt7hCcdG",
         "author_id": "2244994945",
         "edit_history_tweet_ids": [
            "1523757705436958720"
         ],
         "id": "1523757705436958720"
      },
      {
         "created_at": "2022-05-06T18:19:54.000Z",
         "text": "If you’d like to apply, or would like to nominate someone else for the program, please feel free to fill out the following form:nnhttps://t.co/LUuWj24HLu",
         "author_id": "2244994945",
         "edit_history_tweet_ids": [
            "1522642324781633536"
         ],
         "id": "1522642324781633536"
      },
      {
         "created_at": "2022-05-06T18:19:53.000Z",
         "text": "We’ve gone into more detail on each Insider in our forum post. nnJoin us in congratulating the new additions! 🥳nnhttps://t.co/0r5maYEjPJ",
         "author_id": "2244994945",
         "edit_history_tweet_ids": [
            "1522642323535847424"
         ],
         "id": "1522642323535847424"
      }
   ],
   "includes": {
      "users": [
         {
            "created_at": "2013-12-14T04:35:55.000Z",
            "name": "Twitter Dev",
            "username": "TwitterDev",
            "id": "2244994945"
         }
      ]
   },
   "meta": {
      "result_count": 5,
      "newest_id": "1524796546306478083",
      "oldest_id": "1522642323535847424",
      "next_token": "7140dibdnow9c7btw421dyz6jism75z99gyxd8egarsc4"
   }
}
```

**Related Twitter documentation**
https://developer.twitter.com/en/docs/twitter-api/tweets/timelines/api-reference/get-users-id-reverse-chronological

#### Retrieving the user mentions timeline
The getUserMentionsTimeline operation retrieves Tweets mentioning a single user specified by the requested user ID.

**getUserMentionsTimeline**
```xml
<twitter.getUserMentionsTimeline>
    <id>{$ctx:id}</id>
    <start_time>{$ctx:start_time}</start_time>
    <end_time>{$ctx:end_time}</end_time>
    <since_id>{$ctx:since_id}</since_id>
    <until_id>{$ctx:until_id}</until_id>
    <sort_order>{$ctx:sort_order}</sort_order>
    <max_results>{$ctx:max_results}</max_results>
    <pagination_token>{$ctx:pagination_token}</pagination_token>
    <expansions>{$ctx:expansions}</expansions>
    <media_fields>{$ctx:media_fields}</media_fields>
    <place_fields>{$ctx:place_fields}</place_fields>
    <poll_fields>{$ctx:poll_fields}</poll_fields>
    <tweet_fields>{$ctx:tweet_fields}</tweet_fields>
    <user_fields>{$ctx:user_fields}</user_fields>
</twitter.getUserMentionsTimeline>
```

**Properties**
* id: `Required` - `String` -Unique identifier of the user for whom to return Tweets mentioning the user.
* start_time : `Optional` - `Date (ISO 8601)` - YYYY-MM-DDTHH:mm:ssZ (ISO 8601/RFC 3339). The oldest UTC timestamp from which the Tweets will be provided. Timestamp is in second granularity and is inclusive (for example, 12:00:01 includes the first second of the minute).
* end_time : `Optional` - `Date (ISO 8601)` - YYYY-MM-DDTHH:mm:ssZ (ISO 8601/RFC 3339). The new UTC timestamp from which the Tweets will be provided. Timestamp is in second granularity and is inclusive (for example, 12:00:01 includes the first second of the minute).
* since_id : `Optional` - `String` - Returns results with a Tweet ID greater than (that is, more recent than) the specified 'since' Tweet ID. There are limits to the number of Tweets that can be accessed through the API. If the limit of Tweets has occurred since the since_id, the since_id will be forced to the oldest ID available.
* until_id : `Optional` - `String` - Returns results with a Tweet ID less than (that is, older than) the specified 'until' Tweet ID. There are limits to the number of Tweets that can be accessed through the API. If the limit of Tweets has occurred since the until_id, the until_id will be forced to the most recent ID available.
* sort_order : `Optional` - `Enum` - This parameter is used to specify the order in which you want the Tweets returned. By default, a request will return the most recent Tweets first (sorted by recency). se object, and will also include the ID so that you can match this data object to the original Tweet object. Valid values for this parameter are: `recency, relevancy`
* max_results: `Optional` - `Integer` - Specifies the number of Tweets to try and retrieve, up to a maximum of 100 per distinct request. By default, 100 results are returned if this parameter is not supplied. The minimum permitted value is 1. It is possible to receive less than the max_results per request throughout the pagination process.
* pagination_token : `Optional` - `String` - This parameter is used to move forwards or backwards through 'pages' of results, based on the value of the next_token or previous_token in the response. The value used with the parameter is pulled directly from the response provided by the API, and should not be modified.
* expansions : `Optional` - `Enum` - Expansions enable you to request additional data objects that relate to the originally returned Tweets. Submit a list of desired expansions in a comma-separated list without spaces. The ID that represents the expanded data object will be included directly in the Tweet data object, but the expanded object metadata will be returned within the includes response object, and will also include the ID so that you can match this data object to the original Tweet object. Valid values for this parameter are: `attachments.poll_ids, attachments.media_keys, author_id, edit_history_tweet_ids, entities.mentions.username, geo.place_id, in_reply_to_user_id, referenced_tweets.id, referenced_tweets.id.author_id`.
* media_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific media fields will deliver in each returned Tweet. Specify the desired fields in a comma-separated list without spaces between commas and fields. The Tweet will only return media fields if the Tweet contains media and if you've also included the expansions=attachments.media_keys query parameter in your request. While the media ID will be located in the Tweet object, you will find this ID and all additional media fields in the includes data object. Valid values for this parameter are: `duration_ms, height, media_key, preview_image_url, type, url, width, public_metrics, non_public_metrics, organic_metrics, promoted_metrics, alt_text, variants`.
* place_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific place fields will deliver in each returned Tweet. Specify the desired fields in a comma-separated list without spaces between commas and fields. The response will contain the selected fields only if you've also included the expansions=geo.place_id query parameter in your request. Valid values for this parameter are: `contained_within, country, country_code, full_name, geo, id, name, place_type`.
* poll_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific poll fields will deliver in each returned Tweet. Specify the desired fields in a comma-separated list without spaces between commas and fields. The Tweet will only return poll fields if the Tweet contains a poll and if you've also included the expansions=attachments.poll_ids query parameter in your request. While the poll ID will be located in the Tweet object, you will find this ID and all additional poll fields in the includes data object. Valid values for this parameter are: `duration_minutes, end_datetime, id, options, voting_status`.
* tweet_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific Tweet fields will deliver in each returned Tweet object. Specify the desired fields in a comma-separated list without spaces between commas and fields. You can also pass the expansions=referenced_tweets.id expansion to return the specified fields for both the original Tweet and any included referenced Tweets. The requested Tweet fields will display in both the original Tweet data object, as well as in the referenced Tweet expanded data object that will be located in the includes data object. Valid values for this parameter are: `attachments, author_id, context_annotations, conversation_id, created_at, edit_controls, entities, geo, id, in_reply_to_user_id, lang, non_public_metrics, public_metrics, organic_metrics, promoted_metrics, possibly_sensitive, referenced_tweets, reply_settings, source, text, withheld`.
* user_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific user fields will deliver in each returned Tweet. Specify the desired fields in a comma-separated list without spaces between commas and fields. While the user ID will be located in the original Tweet object, you will find this ID and all additional user fields in the includes data object. Valid values for this parameter are: `created_at, description, entities, id, location, name, pinned_tweet_id, profile_image_url, protected, public_metrics, url, username, verified, verified_type, withheld`.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getUserMentionsTimeline operation.

**Sample Request for getUserMentionsTimeline**
```json
{
   "accessToken":"ZGQ0elVkYXZud0xDN2dVcFg1cHB1Z09qVE45enlpTmtDU0hlVDA0ckxlcDJsOjE2ODYyOTg1MDIxODI6MTowOmF0OjE",
   "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
   "id": "1655515285577936899",
   "start_time": "2020-01-01T00:00:00Z",
   "max_results":10,
   "expansions":"author_id",
   "tweet_fields":"created_at,lang,conversation_id",
   "user_fields":"created_at,entities"
}
```

**Sample Response**

```json
{
   "data": [
      {
         "author_id": "1034147061711679488",
         "text": "@LeBraat @TwitterDev @LeGuud There's enough @twitterdev love to go around, @LeBraat",
         "lang": "en",
         "conversation_id": "1375152449594523649",
         "edit_history_tweet_ids": [
            "1375152598945312768"
         ],
         "id": "1375152598945312768"
      },
      {
         "author_id": "199566737",
         "text": "Apparently I'm not the only one (of my test accounts) that loves @TwitterDev nn@LeStaache @LeGuud",
         "lang": "en",
         "conversation_id": "1375152449594523649",
         "edit_history_tweet_ids": [
            "1375152449594523649"
         ],
         "id": "1375152449594523649"
      },
      {
         "author_id": "930524282358325248",
         "text": "Can I join this @twitterdev love party?!",
         "lang": "en",
         "conversation_id": "1375152043455873027",
         "edit_history_tweet_ids": [
            "1375152043455873027"
         ],
         "id": "1375152043455873027"
      },
      {
         "author_id": "1034147061711679488",
         "text": "I love me some @twitterdev too!",
         "lang": "en",
         "conversation_id": "1375151947360174082",
         "edit_history_tweet_ids": [
            "1375151947360174082"
         ],
         "id": "1375151947360174082"
      },
      {
         "author_id": "199566737",
         "text": "This is a test, but also a good excuse to express my love for @TwitterDev 😍",
         "lang": "en",
         "conversation_id": "1375151827189137412",
         "edit_history_tweet_ids": [
            "1375151827189137412"
         ],
         "id": "1375151827189137412"
      }
   ],
   "includes": {
      "users": [
         {
            "name": "LeStache",
            "id": "1034147061711679488",
            "entities": {
               "url": {
                  "urls": [
                     {
                        "start": 0,
                        "end": 23,
                        "url": "https://t.co/7IDoW8iFLm",
                        "expanded_url": "https://twitter.com",
                        "display_url": "twitter.com"
                     }
                  ]
               },
               "description": {
                  "urls": [
                     {
                        "start": 21,
                        "end": 44,
                        "url": "https://t.co/v6nxjDjZR3",
                        "expanded_url": "https://google.com",
                        "display_url": "google.com"
                     }
                  ],
                  "hashtags": [
                     {
                        "start": 15,
                        "end": 20,
                        "tag": "test"
                     }
                  ],
                  "mentions": [
                     {
                        "start": 0,
                        "end": 8,
                        "username": "lebraat"
                     }
                  ],
                  "cashtags": [
                     {
                        "start": 9,
                        "end": 14,
                        "tag": "twtr"
                     }
                  ]
               }
            },
            "username": "LeStaache",
            "created_at": "2018-08-27T18:34:07.000Z"
         },
         {
            "name": "dan dale",
            "id": "199566737",
            "entities": {
               "description": {
                  "hashtags": [
                     {
                        "start": 30,
                        "end": 37,
                        "tag": "devrel"
                     }
                  ],
                  "mentions": [
                     {
                        "start": 18,
                        "end": 29,
                        "username": "twitterdev"
                     }
                  ]
               }
            },
            "username": "LeBraat",
            "created_at": "2010-10-07T05:36:28.000Z"
         },
         {
            "name": "LeGuud",
            "id": "930524282358325248",
            "entities": {
               "url": {
                  "urls": [
                     {
                        "start": 0,
                        "end": 23,
                        "url": "https://t.co/8IkCzClPCz",
                        "expanded_url": "https://developer.twitter.com",
                        "display_url": "developer.twitter.com"
                     }
                  ]
               }
            },
            "username": "LeGuud",
            "created_at": "2017-11-14T19:54:12.000Z"
         }
      ]
   },
   "meta": {
      "oldest_id": "1375151827189137412",
      "newest_id": "1375152598945312768",
      "result_count": 5,
      "next_token": "7140dibdnow9c7btw3w3y5b6jqjnk3k4g5zkmfkvqwa42"
   }
}
```

**Related Twitter documentation**
https://developer.twitter.com/en/docs/twitter-api/tweets/timelines/api-reference/get-users-id-mentions

#### Retrieving the user Tweets timeline
The getUserTweetsTimeline operation retrieves Tweets composed by a single user, specified by the requested user ID.

**getUserTweetsTimeline**
```xml
<twitter.getUserTweetsTimeline>
    <id>{$ctx:id}</id>
    <start_time>{$ctx:start_time}</start_time>
    <end_time>{$ctx:end_time}</end_time>
    <since_id>{$ctx:since_id}</since_id>
    <until_id>{$ctx:until_id}</until_id>
    <sort_order>{$ctx:sort_order}</sort_order>
    <max_results>{$ctx:max_results}</max_results>
    <pagination_token>{$ctx:pagination_token}</pagination_token>
    <expansions>{$ctx:expansions}</expansions>
    <media_fields>{$ctx:media_fields}</media_fields>
    <place_fields>{$ctx:place_fields}</place_fields>
    <poll_fields>{$ctx:poll_fields}</poll_fields>
    <tweet_fields>{$ctx:tweet_fields}</tweet_fields>
    <user_fields>{$ctx:user_fields}</user_fields>
</twitter.getUserTweetsTimeline>
```

**Properties**
* id: `Required` - `String` -Unique identifier of the user for whom to return Tweets mentioning the user.
* start_time : `Optional` - `Date (ISO 8601)` - YYYY-MM-DDTHH:mm:ssZ (ISO 8601/RFC 3339). The oldest UTC timestamp from which the Tweets will be provided. Timestamp is in second granularity and is inclusive (for example, 12:00:01 includes the first second of the minute).
* end_time : `Optional` - `Date (ISO 8601)` - YYYY-MM-DDTHH:mm:ssZ (ISO 8601/RFC 3339). The new UTC timestamp from which the Tweets will be provided. Timestamp is in second granularity and is inclusive (for example, 12:00:01 includes the first second of the minute).
* since_id : `Optional` - `String` - Returns results with a Tweet ID greater than (that is, more recent than) the specified 'since' Tweet ID. There are limits to the number of Tweets that can be accessed through the API. If the limit of Tweets has occurred since the since_id, the since_id will be forced to the oldest ID available.
* until_id : `Optional` - `String` - Returns results with a Tweet ID less than (that is, older than) the specified 'until' Tweet ID. There are limits to the number of Tweets that can be accessed through the API. If the limit of Tweets has occurred since the until_id, the until_id will be forced to the most recent ID available.
* sort_order : `Optional` - `Enum` - This parameter is used to specify the order in which you want the Tweets returned. By default, a request will return the most recent Tweets first (sorted by recency). se object, and will also include the ID so that you can match this data object to the original Tweet object. Valid values for this parameter are: `recency, relevancy`
* max_results: `Optional` - `Integer` - Specifies the number of Tweets to try and retrieve, up to a maximum of 100 per distinct request. By default, 100 results are returned if this parameter is not supplied. The minimum permitted value is 1. It is possible to receive less than the max_results per request throughout the pagination process.
* pagination_token : `Optional` - `String` - This parameter is used to move forwards or backwards through 'pages' of results, based on the value of the next_token or previous_token in the response. The value used with the parameter is pulled directly from the response provided by the API, and should not be modified.
* expansions : `Optional` - `Enum` - Expansions enable you to request additional data objects that relate to the originally returned Tweets. Submit a list of desired expansions in a comma-separated list without spaces. The ID that represents the expanded data object will be included directly in the Tweet data object, but the expanded object metadata will be returned within the includes response object, and will also include the ID so that you can match this data object to the original Tweet object. Valid values for this parameter are: `attachments.poll_ids, attachments.media_keys, author_id, edit_history_tweet_ids, entities.mentions.username, geo.place_id, in_reply_to_user_id, referenced_tweets.id, referenced_tweets.id.author_id`.
* media_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific media fields will deliver in each returned Tweet. Specify the desired fields in a comma-separated list without spaces between commas and fields. The Tweet will only return media fields if the Tweet contains media and if you've also included the expansions=attachments.media_keys query parameter in your request. While the media ID will be located in the Tweet object, you will find this ID and all additional media fields in the includes data object. Valid values for this parameter are: `duration_ms, height, media_key, preview_image_url, type, url, width, public_metrics, non_public_metrics, organic_metrics, promoted_metrics, alt_text, variants`.
* place_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific place fields will deliver in each returned Tweet. Specify the desired fields in a comma-separated list without spaces between commas and fields. The response will contain the selected fields only if you've also included the expansions=geo.place_id query parameter in your request. Valid values for this parameter are: `contained_within, country, country_code, full_name, geo, id, name, place_type`.
* poll_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific poll fields will deliver in each returned Tweet. Specify the desired fields in a comma-separated list without spaces between commas and fields. The Tweet will only return poll fields if the Tweet contains a poll and if you've also included the expansions=attachments.poll_ids query parameter in your request. While the poll ID will be located in the Tweet object, you will find this ID and all additional poll fields in the includes data object. Valid values for this parameter are: `duration_minutes, end_datetime, id, options, voting_status`.
* tweet_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific Tweet fields will deliver in each returned Tweet object. Specify the desired fields in a comma-separated list without spaces between commas and fields. You can also pass the expansions=referenced_tweets.id expansion to return the specified fields for both the original Tweet and any included referenced Tweets. The requested Tweet fields will display in both the original Tweet data object, as well as in the referenced Tweet expanded data object that will be located in the includes data object. Valid values for this parameter are: `attachments, author_id, context_annotations, conversation_id, created_at, edit_controls, entities, geo, id, in_reply_to_user_id, lang, non_public_metrics, public_metrics, organic_metrics, promoted_metrics, possibly_sensitive, referenced_tweets, reply_settings, source, text, withheld`.
* user_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific user fields will deliver in each returned Tweet. Specify the desired fields in a comma-separated list without spaces between commas and fields. While the user ID will be located in the original Tweet object, you will find this ID and all additional user fields in the includes data object. Valid values for this parameter are: `created_at, description, entities, id, location, name, pinned_tweet_id, profile_image_url, protected, public_metrics, url, username, verified, verified_type, withheld`.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getUserTweetsTimeline operation.

**Sample Request for getUserTweetsTimeline**
```json
{
   "accessToken":"ZGQ0elVkYXZud0xDN2dVcFg1cHB1Z09qVE45enlpTmtDU0hlVDA0ckxlcDJsOjE2ODYyOTg1MDIxODI6MTowOmF0OjE",
   "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
   "id": "1655515285577936899",
   "start_time": "2020-01-01T00:00:00Z",
   "max_results":"10",
   "expansions":"author_id",
   "tweet_fields":"created_at,lang,conversation_id",
   "user_fields":"created_at,entities"
}
```

**Sample Response**

```json
{
   "data": [
      {
         "public_metrics": {
            "retweet_count": 5,
            "reply_count": 2,
            "like_count": 22,
            "quote_count": 0
         },
         "text": "Live now! https://t.co/9BbWekeWq2",
         "author_id": "2244994945",
         "id": "1374405406261268481",
         "edit_history_tweet_ids": [
            "1374405406261268481"
         ],
         "created_at": "2021-03-23T16:59:18.000Z",
         "context_annotations": [
            {
               "domain": {
                  "id": "46",
                  "name": "Brand Category",
                  "description": "Categories within Brand Verticals that narrow down the scope of Brands"
               },
               "entity": {
                  "id": "781974596752842752",
                  "name": "Services"
               }
            },
            {
               "domain": {
                  "id": "47",
                  "name": "Brand",
                  "description": "Brands and Companies"
               },
               "entity": {
                  "id": "10045225402",
                  "name": "Twitter"
               }
            }
         ],
         "conversation_id": "1374405406261268481"
      },
      {
         "public_metrics": {
            "retweet_count": 7,
            "reply_count": 1,
            "like_count": 21,
            "quote_count": 2
         },
         "text": "Hope to see you tomorrow at 1 pm EST for APIs 101! nhttps://t.co/GrtBOXyHmB https://t.co/YyQfmgiLlL",
         "author_id": "2244994945",
         "id": "1374104599456534531",
         "edit_history_tweet_ids": [
            "1374104599456534531"
         ],
         "created_at": "2021-03-22T21:04:00.000Z",
         "context_annotations": [
            {
               "domain": {
                  "id": "46",
                  "name": "Brand Category",
                  "description": "Categories within Brand Verticals that narrow down the scope of Brands"
               },
               "entity": {
                  "id": "781974596752842752",
                  "name": "Services"
               }
            },
            {
               "domain": {
                  "id": "47",
                  "name": "Brand",
                  "description": "Brands and Companies"
               },
               "entity": {
                  "id": "10045225402",
                  "name": "Twitter"
               }
            }
         ],
         "conversation_id": "1374104599456534531"
      },
      {
         "public_metrics": {
            "retweet_count": 18,
            "reply_count": 3,
            "like_count": 92,
            "quote_count": 6
         },
         "text": "Looking to get started with the Twitter API but new to APIs in general? @jessicagarson will walk you through everything you need to know in APIs 101 session. She’ll use examples using our v2 endpoints, Tuesday, March 23rd at 1 pm EST.nnJoin us on Twitchnhttps://t.co/GrtBOXyHmB",
         "author_id": "2244994945",
         "id": "1373001119480344583",
         "edit_history_tweet_ids": [
            "1373001119480344583"
         ],
         "created_at": "2021-03-19T19:59:10.000Z",
         "context_annotations": [
            {
               "domain": {
                  "id": "46",
                  "name": "Brand Category",
                  "description": "Categories within Brand Verticals that narrow down the scope of Brands"
               },
               "entity": {
                  "id": "781974596752842752",
                  "name": "Services"
               }
            },
            {
               "domain": {
                  "id": "47",
                  "name": "Brand",
                  "description": "Brands and Companies"
               },
               "entity": {
                  "id": "10045225402",
                  "name": "Twitter"
               }
            }
         ],
         "conversation_id": "1373001119480344583"
      },
      {
         "public_metrics": {
            "retweet_count": 4,
            "reply_count": 0,
            "like_count": 21,
            "quote_count": 1
         },
         "text": "Thanks to everyone who joined and made today a great session! 🙌 nnIf weren't able to attend, we've got you covered. Academic researchers can now sign up for office hours for help using the new product track. See how you can sign up, here 👇nhttps://t.co/duIkd27lPx https://t.co/AP9YY4F8FG",
         "author_id": "2244994945",
         "id": "1372627771717869568",
         "edit_history_tweet_ids": [
            "1372627771717869568"
         ],
         "created_at": "2021-03-18T19:15:37.000Z",
         "context_annotations": [
            {
               "domain": {
                  "id": "46",
                  "name": "Brand Category",
                  "description": "Categories within Brand Verticals that narrow down the scope of Brands"
               },
               "entity": {
                  "id": "781974596752842752",
                  "name": "Services"
               }
            },
            {
               "domain": {
                  "id": "47",
                  "name": "Brand",
                  "description": "Brands and Companies"
               },
               "entity": {
                  "id": "10045225402",
                  "name": "Twitter"
               }
            }
         ],
         "conversation_id": "1372627771717869568"
      },
      {
         "public_metrics": {
            "retweet_count": 0,
            "reply_count": 0,
            "like_count": 1,
            "quote_count": 0
         },
         "text": "@geet_qcp @suhemparack Hey! We have good news, we just introduced Academic Research office hours. Hopefully, this lets you sign up for a day/time where you have flexibility:  https://t.co/duIkd27lPxnnWe do also have a resources page, which includes n code samples shared today https://t.co/0SfXa84EDO",
         "author_id": "2244994945",
         "id": "1372625612460810242",
         "edit_history_tweet_ids": [
            "1372625612460810242"
         ],
         "created_at": "2021-03-18T19:07:02.000Z",
         "context_annotations": [
            {
               "domain": {
                  "id": "46",
                  "name": "Brand Category",
                  "description": "Categories within Brand Verticals that narrow down the scope of Brands"
               },
               "entity": {
                  "id": "781974596752842752",
                  "name": "Services"
               }
            },
            {
               "domain": {
                  "id": "47",
                  "name": "Brand",
                  "description": "Brands and Companies"
               },
               "entity": {
                  "id": "10045225402",
                  "name": "Twitter"
               }
            }
         ],
         "conversation_id": "1371363033352638467"
      }
   ],
   "includes": {
      "users": [
         {
            "id": "2244994945",
            "name": "Twitter Dev",
            "username": "TwitterDev"
         }
      ]
   },
   "meta": {
      "oldest_id": "1372625612460810242",
      "newest_id": "1374405406261268481",
      "result_count": 5,
      "next_token": "7140dibdnow9c7btw3w3xyyhxcirw2ov9mjp7gczc93xu"
   }
}
```

**Related Twitter documentation**
https://developer.twitter.com/en/docs/twitter-api/tweets/timelines/api-reference/get-users-id-tweets

#### Sample configuration

Following is a sample proxy service that illustrates how to connect to Twitter with the init operation and use the getTweetById operation. The sample request for this proxy can be found in getTweetById sample request. You can use this sample as a template for using other operations in this category.

1. Create a sample proxy as below :

    **Sample Proxy**
    ```xml
   <proxy xmlns="http://ws.apache.org/ns/synapse"
          name="getTweetById"
          transports="https,http"
          statistics="disable"
          trace="disable"
          startOnLoad="true">
      <target>
         <inSequence onError="faultHandlerSeq">
            <property name="clientId" expression="json-eval($.clientId)"/>
            <property name="accessToken" expression="json-eval($.accessToken)"/>
            <property name="id" expression="json-eval($.id)"/>
            <property name="expansions" expression="json-eval($.expansions)"/>
            <property name="media_fields" expression="json-eval($.media_fields)"/>
            <property name="place_fields" expression="json-eval($.place_fields)"/>
            <property name="poll_fields" expression="json-eval($.poll_fields)"/>
            <property name="tweet_fields" expression="json-eval($.tweet_fields)"/>
            <property name="user_fields" expression="json-eval($.user_fields)"/>
            <twitter.init>
                <clientId>{$ctx:clientId}</clientId>
                <accessToken>{$ctx:accessToken}</accessToken>
            </twitter.init>     
             <twitter.getTweetById>
                <id>{$ctx:id}</id>
                <expansions>{$ctx:expansions}</expansions>
                <media_fields>{$ctx:media_fields}</media_fields>
                <place_fields>{$ctx:place_fields}</place_fields>
                <poll_fields>{$ctx:poll_fields}</poll_fields>
                <tweet_fields>{$ctx:tweet_fields}</tweet_fields>
                <user_fields>{$ctx:user_fields}</user_fields>
             </twitter.getTweetById>
            <respond/>
         </inSequence>
         <outSequence>
           <send/>
         </outSequence>
      </target>
      <description/>
   </proxy>
    
    ```
   2. Create a json file named getTweetById.json and copy the configurations given below to it:

       ```json
      {
        "accessToken":"WmNNbTBVYmlDVUJzemNUZzVMa1dGclBJZ1d2d0RKQXk5MVk3NXM2cWRwbXZPOjE2ODYyODMzODg3NDk6MTowOmF0OjE",
        "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
        "id":"1460323737035677698",
        "expansions":"attachments.media_keys,author_id",
        "media_fields":"duration_ms,media_key",
        "place_fields":"country",
        "tweet_fields":"lang",
        "user_fields":"username"
      }
       ```
3. Replace the credentials with your values.

4. Execute the following curl command:

    ```bash
    curl -X POST http://localhost:8280/services/getTweetById --header 'Content-Type: application/json' -d @getTweetById.json
    ```

5. Twitter returns a json response similar to the one shown below:
 
```json
{
   "data": {
      "lang": "en",
      "author_id": "2244994945",
      "text": "Introducing a new era for the Twitter Developer Platform! \n\n📣The Twitter API v2 is now the primary API and full of new features\n⏱Immediate access for most use cases, or apply to get more access for free\n📖Removed certain restrictions in the Policy\nhttps://t.co/Hrm15bkBWJ https://t.co/YFfCDErHsg",
      "attachments": {
         "media_keys": [
            "7_1460322142680072196"
         ]
      },
      "id": "1460323737035677698",
      "edit_history_tweet_ids": [
         "1460323737035677698"
      ]
   },
   "includes": {
      "media": [
         {
            "duration_ms": 11093,
            "media_key": "7_1460322142680072196",
            "type": "video"
         }
      ],
      "users": [
         {
            "id": "2244994945",
            "name": "Twitter Dev",
            "username": "TwitterDev"
         }
      ]
   }
}
```