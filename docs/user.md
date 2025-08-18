# Working with Users in Twitter

[[  Overview ]](#overview)  [[ Operation details ]](#operation-details)  [[  Sample configuration  ]](#sample-configuration)

### Overview 

The following operations allow you to work with users in Twitter. 
To be authorized for the following endpoints, you will need an access token with the correct scopes. Please refer the https://developer.twitter.com/en/docs/authentication/guides/v2-authentication-mapping to get the required scopes for the access token.
Click an operation name to see details on how to use it.
For a sample proxy service that illustrates how to work with users, see [Sample configuration](#sample-configuration).

| Operation                                                             | Description                                                                    |
|-----------------------------------------------------------------------|--------------------------------------------------------------------------------|
| [getMe](#Retrieving-information-about-the-authorized-user)            | Retrieves information about the authorized user.                               |
| [getUserById](#Retrieving-information-of-a-user-using-id)             | Retrieves information about a single user specified by the requested ID.       |
| [getUserByUsername](#Retrieving-information-of-a-user-using-username) | Retrieves information about a single user specified by the requested username. |
| [getUsersLookup](#Retrieving-user-information)                        | Retrieves information about one or more users specified by the requested IDs.  |
| [followUser](#Following-a-user)                                       | Follows a specified user.                                                      |
| [getFollowingUsers](#Retrieving-a-list-of-following-users)            | Retrieves a list of users who are followed by the specified user ID.           |
| [getFollowers](#Retrieving-a-list-of-followers)                       | Retrieves a list of users who are followers of the specified user ID.          |
| [unfollowUser](#Unfollowing-a-user)                                   | Unfollows a specified user.                                                    |
| [blockUser](#Blocking-a-user)                                         | Blocks a specified user.                                                       |
| [getBlockedUsers](#Retrieving-a-list-of-blocked-users)                | Retrieves a list of users who are blocked by the specified user ID.            |
| [unblockUser](#Unblocking-a-user)                                     | Unblocks a specified user.                                                     |
| [muteUser](#Muting-a-user)                                            | Mutes a specified user.                                                        |
| [getMutedUsers](#Retrieving-a-list-of-muted-users)                    | Retrieves a list of users who are muted by the specified user ID.              |
| [unmuteUser](#Unmuting-a-user)                                        | Unmutes a specified user.                                                      |


### Operation details

This section provides further details on the operations.

#### Retrieving information about the authorized user
The getMe operation retrieves information about the authorized user.

**getMe**
```xml
<twitter.getMe>
    <expansions>{$ctx:expansions}</expansions>
    <tweet_fields>{$ctx:tweet_fields}</tweet_fields>
    <user_fields>{$ctx:user_fields}</user_fields>
</twitter.getMe>
```

**Properties**
* expansions : `Optional` - `Enum` - Expansions enable you to request additional data objects that relate to the originally returned users. The ID that represents the expanded data object will be included directly in the user data object, but the expanded object metadata will be returned within the includes response object, and will also include the ID so that you can match this data object to the original Tweet object. At this time, the only expansion available to endpoints that primarily return user objects is expansions=`pinned_tweet_id`. You will find the expanded Tweet data object living in the includes response object.
* tweet_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific Tweet fields will deliver in each returned pinned Tweet. Specify the desired fields in a comma-separated list without spaces between commas and fields. The Tweet fields will only return if the user has a pinned Tweet and if you've also included the expansions=pinned_tweet_id query parameter in your request. While the referenced Tweet ID will be located in the original Tweet object, you will find this ID and all additional Tweet fields in the includes data object. Valid values for this parameter are: `attachments, author_id, context_annotations, conversation_id, created_at, edit_controls, entities, geo, id, in_reply_to_user_id, lang, non_public_metrics, public_metrics, organic_metrics, promoted_metrics, possibly_sensitive, referenced_tweets, reply_settings, source, text, withheld`.
* user_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific user fields will deliver with each returned users objects. Specify the desired fields in a comma-separated list without spaces between commas and fields. These specified user fields will display directly in the user data objects. Valid values for this parameter are: `created_at, description, entities, id, location, name, pinned_tweet_id, profile_image_url, protected, public_metrics, url, username, verified, verified_type, withheld`.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getMe operation.

**Sample Request for getMe**
```json
{
   "accessToken":"ZGQ0elVkYXZud0xDN2dVcFg1cHB1Z09qVE45enlpTmtDU0hlVDA0ckxlcDJsOjE2ODYyOTg1MDIxODI6MTowOmF0OjE",
   "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
   "expansions":"pinned_tweet_id",
   "tweet_fields":"public_metrics",
   "user_fields":"created_at,username,id,name"
}
```

**Sample Response**

```json
{
   "data": {
      "name": "GrawKraken",
      "username": "GrawKraken",
      "pinned_tweet_id": "1667091290889256961",
      "id": "1655515285577936899",
      "created_at": "2023-05-08T10:09:55.000Z"
   },
   "includes": {
      "tweets": [
         {
            "public_metrics": {
               "retweet_count": 0,
               "reply_count": 0,
               "like_count": 0,
               "quote_count": 0,
               "bookmark_count": 0,
               "impression_count": 0
            },
            "edit_history_tweet_ids": [
               "1667091290889256961"
            ],
            "text": "Hi",
            "id": "1667091290889256961"
         }
      ]
   }
}
```

**Related Twitter documentation**
https://developer.twitter.com/en/docs/twitter-api/users/lookup/api-reference/get-users-me

#### Retrieving information of a user using id
The getUserById operation retrieves information about a single user specified by the requested ID.

**getUserById**
```xml
<twitter.getUserById>
    <id>{$ctx:id}</id>
    <expansions>{$ctx:expansions}</expansions>
    <tweet_fields>{$ctx:tweet_fields}</tweet_fields>
    <user_fields>{$ctx:user_fields}</user_fields>
</twitter.getUserById>
```

**Properties**
* id : `Required` - `String` - The ID of the user to lookup.
* expansions : `Optional` - `Enum` - Expansions enable you to request additional data objects that relate to the originally returned users. The ID that represents the expanded data object will be included directly in the user data object, but the expanded object metadata will be returned within the includes response object, and will also include the ID so that you can match this data object to the original Tweet object. At this time, the only expansion available to endpoints that primarily return user objects is expansions=`pinned_tweet_id`. You will find the expanded Tweet data object living in the includes response object.
* tweet_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific Tweet fields will deliver in each returned pinned Tweet. Specify the desired fields in a comma-separated list without spaces between commas and fields. The Tweet fields will only return if the user has a pinned Tweet and if you've also included the expansions=pinned_tweet_id query parameter in your request. While the referenced Tweet ID will be located in the original Tweet object, you will find this ID and all additional Tweet fields in the includes data object. Valid values for this parameter are: `attachments, author_id, context_annotations, conversation_id, created_at, edit_controls, entities, geo, id, in_reply_to_user_id, lang, non_public_metrics, public_metrics, organic_metrics, promoted_metrics, possibly_sensitive, referenced_tweets, reply_settings, source, text, withheld`.
* user_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific user fields will deliver with each returned users objects. Specify the desired fields in a comma-separated list without spaces between commas and fields. These specified user fields will display directly in the user data objects. Valid values for this parameter are: `created_at, description, entities, id, location, name, pinned_tweet_id, profile_image_url, protected, public_metrics, url, username, verified, verified_type, withheld`.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getUserById operation.

**Sample Request for getUserById**
```json
{
   "accessToken":"ZGQ0elVkYXZud0xDN2dVcFg1cHB1Z09qVE45enlpTmtDU0hlVDA0ckxlcDJsOjE2ODYyOTg1MDIxODI6MTowOmF0OjE",
   "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
   "id":"1655515285577936899",
   "expansions":"pinned_tweet_id",
   "tweet_fields":"public_metrics",
   "user_fields":"created_at,username,id,name"
}
```

**Sample Response**

```json
{
   "data": {
      "pinned_tweet_id": "1667091290889256961",
      "name": "GrawKraken",
      "id": "1655515285577936899",
      "created_at": "2023-05-08T10:09:55.000Z",
      "username": "GrawKraken"
   },
   "includes": {
      "tweets": [
         {
            "id": "1667091290889256961",
            "edit_history_tweet_ids": [
               "1667091290889256961"
            ],
            "public_metrics": {
               "retweet_count": 0,
               "reply_count": 0,
               "like_count": 0,
               "quote_count": 0,
               "bookmark_count": 0,
               "impression_count": 0
            },
            "text": "Hi"
         }
      ]
   }
}
```

**Related Twitter documentation**
https://developer.twitter.com/en/docs/twitter-api/users/lookup/api-reference/get-users-id

#### Retrieving information of a user using username
The getUserByUsername operation retrieves information about a single user specified by the requested username.

**getUserByUsername**
```xml
<twitter.getUserByUsername>
    <username>{$ctx:username}</username>
    <expansions>{$ctx:expansions}</expansions>
    <tweet_fields>{$ctx:tweet_fields}</tweet_fields>
    <user_fields>{$ctx:user_fields}</user_fields>
</twitter.getUserByUsername>
```

**Properties**
* username : `Required` - `String` - The Twitter username (handle) of the user.
* expansions : `Optional` - `Enum` - Expansions enable you to request additional data objects that relate to the originally returned users. The ID that represents the expanded data object will be included directly in the user data object, but the expanded object metadata will be returned within the includes response object, and will also include the ID so that you can match this data object to the original Tweet object. At this time, the only expansion available to endpoints that primarily return user objects is expansions=`pinned_tweet_id`. You will find the expanded Tweet data object living in the includes response object.
* tweet_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific Tweet fields will deliver in each returned pinned Tweet. Specify the desired fields in a comma-separated list without spaces between commas and fields. The Tweet fields will only return if the user has a pinned Tweet and if you've also included the expansions=pinned_tweet_id query parameter in your request. While the referenced Tweet ID will be located in the original Tweet object, you will find this ID and all additional Tweet fields in the includes data object. Valid values for this parameter are: `attachments, author_id, context_annotations, conversation_id, created_at, edit_controls, entities, geo, id, in_reply_to_user_id, lang, non_public_metrics, public_metrics, organic_metrics, promoted_metrics, possibly_sensitive, referenced_tweets, reply_settings, source, text, withheld`.
* user_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific user fields will deliver with each returned users objects. Specify the desired fields in a comma-separated list without spaces between commas and fields. These specified user fields will display directly in the user data objects. Valid values for this parameter are: `created_at, description, entities, id, location, name, pinned_tweet_id, profile_image_url, protected, public_metrics, url, username, verified, verified_type, withheld`.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getUserByUsername operation.

**Sample Request for getUserByUsername**
```json
{
   "accessToken":"ZGQ0elVkYXZud0xDN2dVcFg1cHB1Z09qVE45enlpTmtDU0hlVDA0ckxlcDJsOjE2ODYyOTg1MDIxODI6MTowOmF0OjE",
   "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
   "username":"GrawKraken",
   "expansions":"pinned_tweet_id",
   "tweet_fields":"public_metrics",
   "user_fields":"created_at,username,id,name"
}
```

**Sample Response**

```json
{
   "data": {
      "name": "GrawKraken",
      "username": "GrawKraken",
      "pinned_tweet_id": "1667091290889256961",
      "id": "1655515285577936899",
      "created_at": "2023-05-08T10:09:55.000Z"
   },
   "includes": {
      "tweets": [
         {
            "public_metrics": {
               "retweet_count": 0,
               "reply_count": 0,
               "like_count": 0,
               "quote_count": 0,
               "bookmark_count": 0,
               "impression_count": 0
            },
            "edit_history_tweet_ids": [
               "1667091290889256961"
            ],
            "text": "Hi",
            "id": "1667091290889256961"
         }
      ]
   }
}
```

**Related Twitter documentation**
https://developer.twitter.com/en/docs/twitter-api/users/lookup/api-reference/get-users-by-username-username

#### Retrieving user information
The getUsersLookup operation retrieves information about one or more users specified by the requested IDs.

**getUsersLookup**
```xml
<twitter.getUsersLookup>
    <ids>{$ctx:ids}</ids>
    <expansions>{$ctx:expansions}</expansions>
    <tweet_fields>{$ctx:tweet_fields}</tweet_fields>
    <user_fields>{$ctx:user_fields}</user_fields>
</twitter.getUsersLookup>
```

**Properties**
* ids : `Required` - `String` - A comma separated list of user IDs. Up to 100 are allowed in a single request. Make sure to not include a space between commas and fields.
* expansions : `Optional` - `Enum` - Expansions enable you to request additional data objects that relate to the originally returned users. The ID that represents the expanded data object will be included directly in the user data object, but the expanded object metadata will be returned within the includes response object, and will also include the ID so that you can match this data object to the original Tweet object. At this time, the only expansion available to endpoints that primarily return user objects is expansions=`pinned_tweet_id`. You will find the expanded Tweet data object living in the includes response object.
* tweet_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific Tweet fields will deliver in each returned pinned Tweet. Specify the desired fields in a comma-separated list without spaces between commas and fields. The Tweet fields will only return if the user has a pinned Tweet and if you've also included the expansions=pinned_tweet_id query parameter in your request. While the referenced Tweet ID will be located in the original Tweet object, you will find this ID and all additional Tweet fields in the includes data object. Valid values for this parameter are: `attachments, author_id, context_annotations, conversation_id, created_at, edit_controls, entities, geo, id, in_reply_to_user_id, lang, non_public_metrics, public_metrics, organic_metrics, promoted_metrics, possibly_sensitive, referenced_tweets, reply_settings, source, text, withheld`.
* user_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific user fields will deliver with each returned users objects. Specify the desired fields in a comma-separated list without spaces between commas and fields. These specified user fields will display directly in the user data objects. Valid values for this parameter are: `created_at, description, entities, id, location, name, pinned_tweet_id, profile_image_url, protected, public_metrics, url, username, verified, verified_type, withheld`.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getUsersLookup operation.

**Sample Request for getUsersLookup**
```json
{
   "accessToken":"ZGQ0elVkYXZud0xDN2dVcFg1cHB1Z09qVE45enlpTmtDU0hlVDA0ckxlcDJsOjE2ODYyOTg1MDIxODI6MTowOmF0OjE",
   "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
   "ids":"1655515285577936899,15594932",
   "expansions":"pinned_tweet_id",
   "tweet_fields":"created_at",
   "user_fields":"username,id,name"
}
```

**Sample Response**

```json
{
   "data": [
      {
         "pinned_tweet_id": "1667091290889256961",
         "username": "GrawKraken",
         "name": "GrawKraken",
         "id": "1655515285577936899"
      },
      {
         "username": "wso2",
         "name": "WSO2",
         "id": "15594932"
      }
   ],
   "includes": {
      "tweets": [
         {
            "edit_history_tweet_ids": [
               "1667091290889256961"
            ],
            "text": "Hi",
            "created_at": "2023-06-09T08:48:31.000Z",
            "id": "1667091290889256961"
         }
      ]
   }
}
```

**Related Twitter documentation**
https://developer.twitter.com/en/docs/twitter-api/users/lookup/api-reference/get-users

#### Following a user
The followUser operation follows a specified user.

**followUser**
```xml
<twitter.followUser>
    <id>{$ctx:id}</id>
    <target_user_id>{$ctx:target_user_id}</target_user_id>
</twitter.followUser>
```

**Properties**
* id : `Required` - `String` - The authenticated user ID of whom you would like to initiate the following on behalf. You must pass the Access Tokens that relate to this user when authenticating the request.
* target_user_id : `Required` - `String` - The user ID of the user that you would like to follow.

**Sample request**

Following is a sample REST/JSON request that can be handled by the followUser operation.

**Sample Request for followUser**
```json
{
   "accessToken":"YTJxTmFUdUM4ZnlpZlYtWnNqN3JFR3VRMmhSaFFZOGZQa3I1eFVpcmQ3RjhjOjE2ODYzMDIzNTAxMTA6MTowOmF0OjE",
   "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
   "id":"1655515285577936899",
   "target_user_id":"15594932"
}
```

**Sample Response**

```json
{
   "data": {
      "following": true,
      "pending_follow": false
   }
}
```

**Related Twitter documentation**
https://developer.twitter.com/en/docs/twitter-api/users/follows/api-reference/post-users-source_user_id-following

#### Retrieving a list of following users
The getFollowingUsers operation retrieves a list of users who are followed by the specified user ID.

**getFollowingUsers**
```xml
<twitter.getFollowingUsers>
    <id>{$ctx:id}</id>
    <max_results>{$ctx:max_results}</max_results>
    <pagination_token>{$ctx:pagination_token}</pagination_token>
    <expansions>{$ctx:expansions}</expansions>
    <tweet_fields>{$ctx:tweet_fields}</tweet_fields>
    <user_fields>{$ctx:user_fields}</user_fields>
</twitter.getFollowingUsers>
```

**Properties**
* id : `Required` - `String` - The user ID whose following you would like to retrieve.
* max_results: `Optional` - `Integer` - The maximum number of results to be returned per page. This can be a number between 1 and the 1000. By default, each page will return 100 results.
* pagination_token : `Optional` - `String` - Used to request the next page of results if all results weren't returned with the latest request, or to go back to the previous page of results. To return the next page, pass the next_token returned in your previous response. To go back one page, pass the previous_token returned in your previous response.
* expansions : `Optional` - `Enum` - Expansions enable you to request additional data objects that relate to the originally returned users. The ID that represents the expanded data object will be included directly in the user data object, but the expanded object metadata will be returned within the includes response object, and will also include the ID so that you can match this data object to the original Tweet object. At this time, the only expansion available to endpoints that primarily return user objects is expansions=`pinned_tweet_id`. You will find the expanded Tweet data object living in the includes response object.
* tweet_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific Tweet fields will deliver in each returned pinned Tweet. Specify the desired fields in a comma-separated list without spaces between commas and fields. The Tweet fields will only return if the user has a pinned Tweet and if you've also included the expansions=pinned_tweet_id query parameter in your request. While the referenced Tweet ID will be located in the original Tweet object, you will find this ID and all additional Tweet fields in the includes data object. Valid values for this parameter are: `attachments, author_id, context_annotations, conversation_id, created_at, edit_controls, entities, geo, id, in_reply_to_user_id, lang, non_public_metrics, public_metrics, organic_metrics, promoted_metrics, possibly_sensitive, referenced_tweets, reply_settings, source, text, withheld`.
* user_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific user fields will deliver with each returned users objects. Specify the desired fields in a comma-separated list without spaces between commas and fields. These specified user fields will display directly in the user data objects. Valid values for this parameter are: `created_at, description, entities, id, location, name, pinned_tweet_id, profile_image_url, protected, public_metrics, url, username, verified, verified_type, withheld`.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getFollowingUsers operation.

**Sample Request for getFollowingUsers**
```json
{
   "accessToken":"YTJxTmFUdUM4ZnlpZlYtWnNqN3JFR3VRMmhSaFFZOGZQa3I1eFVpcmQ3RjhjOjE2ODYzMDIzNTAxMTA6MTowOmF0OjE",
   "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
   "id":"1655515285577936899",
   "max_results":"5",
   "pagination_token":"",
   "expansions":"pinned_tweet_id",
   "tweet_fields":"attachments,author_id",
   "user_fields":"created_at,description"
}
```

**Sample Response**

```json
{
   "data": [
      {
         "pinned_tweet_id": "1293595870563381249",
         "id": "6253282",
         "username": "TwitterAPI",
         "name": "Twitter API"
      },
      {
         "pinned_tweet_id": "1293593516040269825",
         "id": "2244994945",
         "username": "TwitterDev",
         "name": "Twitter Dev"
      },
      {
         "id": "783214",
         "username": "Twitter",
         "name": "Twitter"
      },
      {
         "pinned_tweet_id": "1271186240323432452",
         "id": "95731075",
         "username": "TwitterSafety",
         "name": "Twitter Safety"
      },
      {
         "id": "3260518932",
         "username": "TwitterMoments",
         "name": "Twitter Moments"
      },
      {
         "pinned_tweet_id": "1293216056274759680",
         "id": "373471064",
         "username": "TwitterMusic",
         "name": "Twitter Music"
      },
      {
         "id": "791978718",
         "username": "OfficialPartner",
         "name": "Twitter Official Partner"
      },
      {
         "pinned_tweet_id": "1289000334497439744",
         "id": "17874544",
         "username": "TwitterSupport",
         "name": "Twitter Support"
      },
      {
         "pinned_tweet_id": "1283543147444711424",
         "id": "234489024",
         "username": "TwitterComms",
         "name": "Twitter Comms"
      },
      {
         "id": "1526228120",
         "username": "TwitterData",
         "name": "Twitter Data"
      }
   ],
   "includes": {
      "tweets": [
         {
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
               },
               {
                  "domain": {
                     "id": "65",
                     "name": "Interests and Hobbies Vertical",
                     "description": "Top level interests and hobbies groupings, like Food or Travel"
                  },
                  "entity": {
                     "id": "848920371311001600",
                     "name": "Technology",
                     "description": "Technology and computing"
                  }
               },
               {
                  "domain": {
                     "id": "66",
                     "name": "Interests and Hobbies Category",
                     "description": "A grouping of interests and hobbies entities, like Novelty Food or Destinations"
                  },
                  "entity": {
                     "id": "848921413196984320",
                     "name": "Computer programming",
                     "description": "Computer programming"
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
            "id": "1293595870563381249",
            "text": "Twitter API v2: Early Access releasednnToday we announced Early Access to the first endpoints of the new Twitter API!nn#TwitterAPI #EarlyAccess #VersionBump https://t.co/g7v3aeIbtQ"
         },
         {
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
               },
               {
                  "domain": {
                     "id": "65",
                     "name": "Interests and Hobbies Vertical",
                     "description": "Top level interests and hobbies groupings, like Food or Travel"
                  },
                  "entity": {
                     "id": "848920371311001600",
                     "name": "Technology",
                     "description": "Technology and computing"
                  }
               },
               {
                  "domain": {
                     "id": "66",
                     "name": "Interests and Hobbies Category",
                     "description": "A grouping of interests and hobbies entities, like Novelty Food or Destinations"
                  },
                  "entity": {
                     "id": "848921413196984320",
                     "name": "Computer programming",
                     "description": "Computer programming"
                  }
               }
            ],
            "id": "1293593516040269825",
            "text": "It’s finally here! 🥁 Say hello to the new #TwitterAPI.nnWe’re rebuilding the Twitter API v2 from the ground up to better serve our developer community. And today’s launch is only the beginning.nnhttps://t.co/32VrwpGaJw https://t.co/KaFSbjWUA8"
         },
         {
            "id": "1271186240323432452",
            "text": "We’re disclosing new state-linked information operations to our public archive — the only one of its kind in the industry. Originating from the People’s Republic of China (PRC), Russia, and Turkey, all associated accounts and content have been removed. https://t.co/obRqr96iYm"
         },
         {
            "id": "1293216056274759680",
            "text": "say howdy to your new yeehaw king @orvillepeck—our #ArtistToFollow this month 🤠 https://t.co/3pk9fYcPHb"
         },
         {
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
            "id": "1289000334497439744",
            "text": "We’ve significantly limited access to our internal tools and systems. Until we can safely resume normal operations, our response times to some support needs and reports will be slower. Thank you for your patience as we work through this."
         },
         {
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
            "id": "1283543147444711424",
            "text": "Follow @TwitterSupport for the latest on the security incident ⬇️ https://t.co/7FKKksJqxV"
         }
      ],
      "meta": {
         "result_count": 10,
         "next_token": "DFEDBNRFT3MHCZZZ"
      }
   }
}
```

**Related Twitter documentation**
https://developer.twitter.com/en/docs/twitter-api/users/follows/api-reference/get-users-id-following

#### Retrieving a list of followers
The getFollowers operation retrieves a list of users who are followers of the specified user ID.

**getFollowers**
```xml
<twitter.getFollowers>
    <id>{$ctx:id}</id>
    <max_results>{$ctx:max_results}</max_results>
    <pagination_token>{$ctx:pagination_token}</pagination_token>
    <expansions>{$ctx:expansions}</expansions>
    <tweet_fields>{$ctx:tweet_fields}</tweet_fields>
    <user_fields>{$ctx:user_fields}</user_fields>
</twitter.getFollowers>
```

**Properties**
* id : `Required` - `String` - The user ID whose followers you would like to retrieve.
* max_results: `Optional` - `Integer` - The maximum number of results to be returned per page. This can be a number between 1 and the 1000. By default, each page will return 100 results.
* pagination_token : `Optional` - `String` - Used to request the next page of results if all results weren't returned with the latest request, or to go back to the previous page of results. To return the next page, pass the next_token returned in your previous response. To go back one page, pass the previous_token returned in your previous response.
* expansions : `Optional` - `Enum` - Expansions enable you to request additional data objects that relate to the originally returned users. The ID that represents the expanded data object will be included directly in the user data object, but the expanded object metadata will be returned within the includes response object, and will also include the ID so that you can match this data object to the original Tweet object. At this time, the only expansion available to endpoints that primarily return user objects is expansions=`pinned_tweet_id`. You will find the expanded Tweet data object living in the includes response object.
* tweet_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific Tweet fields will deliver in each returned pinned Tweet. Specify the desired fields in a comma-separated list without spaces between commas and fields. The Tweet fields will only return if the user has a pinned Tweet and if you've also included the expansions=pinned_tweet_id query parameter in your request. While the referenced Tweet ID will be located in the original Tweet object, you will find this ID and all additional Tweet fields in the includes data object. Valid values for this parameter are: `attachments, author_id, context_annotations, conversation_id, created_at, edit_controls, entities, geo, id, in_reply_to_user_id, lang, non_public_metrics, public_metrics, organic_metrics, promoted_metrics, possibly_sensitive, referenced_tweets, reply_settings, source, text, withheld`.
* user_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific user fields will deliver with each returned users objects. Specify the desired fields in a comma-separated list without spaces between commas and fields. These specified user fields will display directly in the user data objects. Valid values for this parameter are: `created_at, description, entities, id, location, name, pinned_tweet_id, profile_image_url, protected, public_metrics, url, username, verified, verified_type, withheld`.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getFollowers operation.

**Sample Request for getFollowers**
```json
{
   "accessToken":"YTJxTmFUdUM4ZnlpZlYtWnNqN3JFR3VRMmhSaFFZOGZQa3I1eFVpcmQ3RjhjOjE2ODYzMDIzNTAxMTA6MTowOmF0OjE",
   "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
   "id":"1655515285577936899"
}
```

**Sample Response**

```json
{
   "data": [
      {
         "id": "6253282",
         "name": "Twitter API",
         "username": "TwitterAPI"
      },
      {
         "id": "2244994945",
         "name": "Twitter Dev",
         "username": "TwitterDev"
      },
      {
         "id": "783214",
         "name": "Twitter",
         "username": "Twitter"
      },
      {
         "id": "95731075",
         "name": "Twitter Safety",
         "username": "TwitterSafety"
      },
      {
         "id": "3260518932",
         "name": "Twitter Moments",
         "username": "TwitterMoments"
      },
      {
         "id": "373471064",
         "name": "Twitter Music",
         "username": "TwitterMusic"
      },
      {
         "id": "791978718",
         "name": "Twitter Official Partner",
         "username": "OfficialPartner"
      },
      {
         "id": "17874544",
         "name": "Twitter Support",
         "username": "TwitterSupport"
      },
      {
         "id": "234489024",
         "name": "Twitter Comms",
         "username": "TwitterComms"
      },
      {
         "id": "1526228120",
         "name": "Twitter Data",
         "username": "TwitterData"
      }
   ],
   "meta": {
      "result_count": 10,
      "next_token": "DFEDBNRFT3MHCZZZ"
   }
}
```

**Related Twitter documentation**
https://developer.twitter.com/en/docs/twitter-api/users/follows/api-reference/get-users-id-followers

#### Unfollowing a user
The unfollowUser operation unfollows a specified user.

**unfollowUser**
```xml
<twitter.unfollowUser>
    <id>{$ctx:id}</id>
    <target_user_id>{$ctx:target_user_id}</target_user_id>
</twitter.unfollowUser>
```

**Properties**
* id : `Required` - `String` - The authenticated user ID who you would like to initiate the unfollow on behalf of.
* target_user_id : `Required` - `String` - The user ID of the user that you would like the id to unfollow.

**Sample request**

Following is a sample REST/JSON request that can be handled by the unfollowUser operation.

**Sample Request for unfollowUser**
```json
{
   "accessToken":"YTJxTmFUdUM4ZnlpZlYtWnNqN3JFR3VRMmhSaFFZOGZQa3I1eFVpcmQ3RjhjOjE2ODYzMDIzNTAxMTA6MTowOmF0OjE",
   "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
   "id":"1655515285577936899",
   "target_user_id":"15594932"
}
```

**Sample Response**

```json
{
   "data": {
      "following": false
   }
}
```

**Related Twitter documentation**
https://developer.twitter.com/en/docs/twitter-api/users/follows/api-reference/delete-users-source_id-following

#### Blocking a user
The blockUser operation blocks a specified user.

**blockUser**
```xml
<twitter.blockUser>
    <id>{$ctx:id}</id>
    <target_user_id>{$ctx:target_user_id}</target_user_id>
</twitter.blockUser>
```

**Properties**
* id : `Required` - `String` - The authenticated user ID who you would like to initiate the block on behalf of.
* target_user_id : `Required` - `String` - The user ID of the user that you would like to block.

**Sample request**

Following is a sample REST/JSON request that can be handled by the blockUser operation.

**Sample Request for blockUser**
```json
{
   "accessToken":"Zk1HejRPZjROSXBLVUNEajFsdEJRbm5KVl9xUGl4SVd3Q0I1c1FrWkNyNXpOOjE2ODYzMDM5MzkxMTU6MTowOmF0OjE",
   "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
   "id":"1655515285577936899",
   "target_user_id":"15594932"
}
```

**Sample Response**

```json
{
   "data": {
      "blocking": true
   }
}
```

**Related Twitter documentation**
https://developer.twitter.com/en/docs/twitter-api/users/blocks/api-reference/post-users-user_id-blocking

#### Retrieving a list of blocked users
The getBlockedUsers operation retrieves a list of users who are blocked by the specified user ID.

**getBlockedUsers**
```xml
<twitter.getBlockedUsers>
    <id>{$ctx:id}</id>
    <max_results>{$ctx:max_results}</max_results>
    <pagination_token>{$ctx:pagination_token}</pagination_token>
    <expansions>{$ctx:expansions}</expansions>
    <tweet_fields>{$ctx:tweet_fields}</tweet_fields>
    <user_fields>{$ctx:user_fields}</user_fields>
</twitter.getBlockedUsers>
```

**Properties**
* id : `Required` - `String` - The user ID whose blocked users you would like to retrieve.
* max_results: `Optional` - `Integer` - The maximum number of results to be returned per page. This can be a number between 1 and the 1000. By default, each page will return 100 results.
* pagination_token : `Optional` - `String` - Used to request the next page of results if all results weren't returned with the latest request, or to go back to the previous page of results. To return the next page, pass the next_token returned in your previous response. To go back one page, pass the previous_token returned in your previous response.
* expansions : `Optional` - `Enum` - Expansions enable you to request additional data objects that relate to the originally returned users. The ID that represents the expanded data object will be included directly in the user data object, but the expanded object metadata will be returned within the includes response object, and will also include the ID so that you can match this data object to the original Tweet object. At this time, the only expansion available to endpoints that primarily return user objects is expansions=`pinned_tweet_id`. You will find the expanded Tweet data object living in the includes response object.
* tweet_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific Tweet fields will deliver in each returned pinned Tweet. Specify the desired fields in a comma-separated list without spaces between commas and fields. The Tweet fields will only return if the user has a pinned Tweet and if you've also included the expansions=pinned_tweet_id query parameter in your request. While the referenced Tweet ID will be located in the original Tweet object, you will find this ID and all additional Tweet fields in the includes data object. Valid values for this parameter are: `attachments, author_id, context_annotations, conversation_id, created_at, edit_controls, entities, geo, id, in_reply_to_user_id, lang, non_public_metrics, public_metrics, organic_metrics, promoted_metrics, possibly_sensitive, referenced_tweets, reply_settings, source, text, withheld`.
* user_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific user fields will deliver with each returned users objects. Specify the desired fields in a comma-separated list without spaces between commas and fields. These specified user fields will display directly in the user data objects. Valid values for this parameter are: `created_at, description, entities, id, location, name, pinned_tweet_id, profile_image_url, protected, public_metrics, url, username, verified, verified_type, withheld`.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getBlockedUsers operation.

**Sample Request for getBlockedUsers**
```json
{
   "accessToken":"Zk1HejRPZjROSXBLVUNEajFsdEJRbm5KVl9xUGl4SVd3Q0I1c1FrWkNyNXpOOjE2ODYzMDM5MzkxMTU6MTowOmF0OjE",
   "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
   "id":"1655515285577936899",
   "max_results":"5",
   "expansions":"pinned_tweet_id",
   "tweet_fields":"attachments,author_id",
   "user_fields":"created_at,description"
}
```

**Sample Response**

```json
{
   "data": [
      {
         "id": "1065249714214457345",
         "created_at": "2018-11-21T14:24:58.000Z",
         "name": "Spaces",
         "pinned_tweet_id": "1389270063807598594",
         "description": "Twitter Spaces is where live audio conversations happen.",
         "username": "TwitterSpaces"
      },
      {
         "id": "783214",
         "created_at": "2007-02-20T14:35:54.000Z",
         "name": "Twitter",
         "description": "What's happening?!",
         "username": "Twitter"
      },
      {
         "id": "1526228120",
         "created_at": "2013-06-17T23:57:45.000Z",
         "name": "Twitter Data",
         "description": "Data-driven insights about notable moments and conversations from Twitter, Inc., plus tips and tricks to help you get the most out of Twitter data.",
         "username": "TwitterData"
      },
      {
         "id": "2244994945",
         "created_at": "2013-12-14T04:35:55.000Z",
         "name": "Twitter Dev",
         "pinned_tweet_id": "1354143047324299264",
         "description": "The voice of the #TwitterDev team and your official source for updates, news, and events, related to the #TwitterAPI.",
         "username": "TwitterDev"
      },
      {
         "id": "6253282",
         "created_at": "2007-05-23T06:01:13.000Z",
         "name": "Twitter API",
         "pinned_tweet_id": "1293595870563381249",
         "description": "Tweets about changes and service issues. Follow @TwitterDev for more.",
         "username": "TwitterAPI"
      }
   ],
   "includes": {
      "tweets": [
         {
            "id": "1389270063807598594",
            "text": "now, everyone with 600 or more followers can host a Space.nnbased on what we've learned, these accounts are likely to have a good experience hosting because of their existing audience. before bringing the ability to create a Space to everyone, we’re focused on a few things. 🧵"
         },
         {
            "id": "1354143047324299264",
            "text": "Academics are one of the biggest groups using the #TwitterAPI to research what’s happening. Their work helps make the world (&amp; Twitter) a better place, and now more than ever, we must enable more of it. nIntroducing 🥁 the Academic Research product track!nhttps://t.co/nOFiGewAV2"
         },
         {
            "id": "1293595870563381249",
            "text": "Twitter API v2: Early Access releasednnToday we announced Early Access to the first endpoints of the new Twitter API!nn#TwitterAPI #EarlyAccess #VersionBump https://t.co/g7v3aeIbtQ"
         }
      ]
   }
}
```

**Related Twitter documentation**
https://developer.twitter.com/en/docs/twitter-api/users/blocks/api-reference/get-users-blocking

#### Unblocking a user
The unblockUser operation unblocks a specified user.

**unblockUser**
```xml
<twitter.unblockUser>
    <id>{$ctx:id}</id>
    <target_user_id>{$ctx:target_user_id}</target_user_id>
</twitter.unblockUser>
```

**Properties**
* id : `Required` - `String` - The authenticated user ID who you would like to initiate the unblock on behalf of.
* target_user_id : `Required` - `String` - The user ID of the user that you would like the id to unblock.

**Sample request**

Following is a sample REST/JSON request that can be handled by the unblockUser operation.

**Sample Request for unblockUser**
```json
{
   "accessToken":"Zk1HejRPZjROSXBLVUNEajFsdEJRbm5KVl9xUGl4SVd3Q0I1c1FrWkNyNXpOOjE2ODYzMDM5MzkxMTU6MTowOmF0OjE",
   "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
   "id":"1655515285577936899",
   "target_user_id":"15594932"
}
```

**Sample Response**

```json
{
   "data": {
      "blocking": false
   }
}
```

**Related Twitter documentation**
https://developer.twitter.com/en/docs/twitter-api/users/blocks/api-reference/delete-users-user_id-blocking

#### Muting a user
The muteUser operation mutes a specified user.

**muteUser**
```xml
<twitter.muteUser>
    <id>{$ctx:id}</id>
    <target_user_id>{$ctx:target_user_id}</target_user_id>
</twitter.muteUser>
```

**Properties**
* id : `Required` - `String` - The authenticated user ID who you would like to initiate the mute on behalf of.
* target_user_id : `Required` - `String` - The user ID of the user that you would like the id to mute.

**Sample request**

Following is a sample REST/JSON request that can be handled by the muteUser operation.

**Sample Request for muteUser**
```json
{
   "accessToken":"dnBaOUhWbjZWcWJ1WWhFVEtpRDIyUVFOMG5kU015RTMwdGs5SWhEaHR2UDdtOjE2ODYzMDQyNzkxMDE6MTowOmF0OjE",
   "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
   "id":"1655515285577936899",
   "target_user_id":"15594932"
}
```

**Sample Response**

```json
{
   "data": {
      "muting": true
   }
}
```

**Related Twitter documentation**
https://developer.twitter.com/en/docs/twitter-api/users/mutes/api-reference/post-users-user_id-muting

#### Retrieving a list of muted users
The getMutedUsers operation retrieves a list of users who are muted by the specified user ID.

**getMutedUsers**
```xml
<twitter.getMutedUsers>
    <id>{$ctx:id}</id>
    <max_results>{$ctx:max_results}</max_results>
    <pagination_token>{$ctx:pagination_token}</pagination_token>
    <expansions>{$ctx:expansions}</expansions>
    <tweet_fields>{$ctx:tweet_fields}</tweet_fields>
    <user_fields>{$ctx:user_fields}</user_fields>
</twitter.getMutedUsers>
```

**Properties**
* id : `Required` - `String` - The user ID whose muted users you would like to retrieve.
* max_results: `Optional` - `Integer` - The maximum number of results to be returned per page. This can be a number between 1 and the 1000. By default, each page will return 100 results.
* pagination_token : `Optional` - `String` - Used to request the next page of results if all results weren't returned with the latest request, or to go back to the previous page of results. To return the next page, pass the next_token returned in your previous response. To go back one page, pass the previous_token returned in your previous response.
* expansions : `Optional` - `Enum` - Expansions enable you to request additional data objects that relate to the originally returned users. The ID that represents the expanded data object will be included directly in the user data object, but the expanded object metadata will be returned within the includes response object, and will also include the ID so that you can match this data object to the original Tweet object. At this time, the only expansion available to endpoints that primarily return user objects is expansions=`pinned_tweet_id`. You will find the expanded Tweet data object living in the includes response object.
* tweet_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific Tweet fields will deliver in each returned pinned Tweet. Specify the desired fields in a comma-separated list without spaces between commas and fields. The Tweet fields will only return if the user has a pinned Tweet and if you've also included the expansions=pinned_tweet_id query parameter in your request. While the referenced Tweet ID will be located in the original Tweet object, you will find this ID and all additional Tweet fields in the includes data object. Valid values for this parameter are: `attachments, author_id, context_annotations, conversation_id, created_at, edit_controls, entities, geo, id, in_reply_to_user_id, lang, non_public_metrics, public_metrics, organic_metrics, promoted_metrics, possibly_sensitive, referenced_tweets, reply_settings, source, text, withheld`.
* user_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific user fields will deliver with each returned users objects. Specify the desired fields in a comma-separated list without spaces between commas and fields. These specified user fields will display directly in the user data objects. Valid values for this parameter are: `created_at, description, entities, id, location, name, pinned_tweet_id, profile_image_url, protected, public_metrics, url, username, verified, verified_type, withheld`.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getMutedUsers operation.

**Sample Request for getMutedUsers**
```json
{
   "accessToken":"dnBaOUhWbjZWcWJ1WWhFVEtpRDIyUVFOMG5kU015RTMwdGs5SWhEaHR2UDdtOjE2ODYzMDQyNzkxMDE6MTowOmF0OjE",
   "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
   "id":"1655515285577936899",
   "max_results":"5",
   "expansions":"pinned_tweet_id",
   "tweet_fields":"attachments,author_id",
   "user_fields":"created_at,description"
}
```

**Sample Response**

```json
{
   "data": [
      {
         "username": "TwitterDev",
         "created_at": "2013-12-14T04:35:55.000Z",
         "id": "2244994945",
         "name": "Twitter Dev",
         "pinned_tweet_id": "1430984356139470849"
      }
   ],
   "includes": {
      "tweets": [
         {
            "created_at": "2021-08-26T20:03:51.000Z",
            "id": "1430984356139470849",
            "text": "Help us build a better Twitter Developer Platform!n nTake the annual developer survey &gt;&gt;&gt; https://t.co/9yTbEKlJHH https://t.co/fYIwKPzqua"
         }
      ]
   },
   "meta": {
      "result_count": 1
   }
}
```

**Related Twitter documentation**
https://developer.twitter.com/en/docs/twitter-api/users/mutes/api-reference/get-users-muting

#### Unmuting a user
The unmuteUser operation unmutes a specified user.

**unmuteUser**
```xml
<twitter.unmuteUser>
    <id>{$ctx:id}</id>
    <target_user_id>{$ctx:target_user_id}</target_user_id>
</twitter.unmuteUser>
```

**Properties**
* id : `Required` - `String` - The authenticated user ID who you would like to initiate the unmute on behalf of.
* target_user_id : `Required` - `String` - The user ID of the user that you would like the id to unmute.

**Sample request**

Following is a sample REST/JSON request that can be handled by the unmuteUser operation.

**Sample Request for unmuteUser**
```json
{
   "accessToken":"dnBaOUhWbjZWcWJ1WWhFVEtpRDIyUVFOMG5kU015RTMwdGs5SWhEaHR2UDdtOjE2ODYzMDQyNzkxMDE6MTowOmF0OjE",
   "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
   "id":"1655515285577936899",
   "target_user_id":"15594932"
}
```

**Sample Response**

```json
{
   "data": {
      "muting": false
   }
}
```

**Related Twitter documentation**
https://developer.twitter.com/en/docs/twitter-api/users/mutes/api-reference/delete-users-user_id-muting


#### Sample configuration

Following is a sample proxy service that illustrates how to connect to Twitter the init operation and use the getUserById operation. The sample request for this proxy can be found in getUserById sample request. You can use this sample as a template for using other operations in this category.
1. Create a sample proxy as below :

    **Sample Proxy**
    ```xml
   <proxy xmlns="http://ws.apache.org/ns/synapse"
          name="getUserById"
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
            <property name="tweet_fields" expression="json-eval($.tweet_fields)"/>
            <property name="user_fields" expression="json-eval($.user_fields)"/>
           <twitter.init>
               <clientId>{$ctx:clientId}</clientId>
               <accessToken>{$ctx:accessToken}</accessToken>
            </twitter.init>
            <twitter.getUserById>
                <id>{$ctx:id}</id>
                <expansions>{$ctx:expansions}</expansions>
                <tweet_fields>{$ctx:tweet_fields}</tweet_fields>
                <user_fields>{$ctx:user_fields}</user_fields>
            </twitter.getUserById>
            <respond/>
         </inSequence>
         <outSequence>
            <send/>
         </outSequence>
      </target>
      <description/>
   </proxy>
    
    ```
   2. Create a json file named getUserById.json and copy the configurations given below to it:

       ```json
      {
        "accessToken":"ZGQ0elVkYXZud0xDN2dVcFg1cHB1Z09qVE45enlpTmtDU0hlVDA0ckxlcDJsOjE2ODYyOTg1MDIxODI6MTowOmF0OjE",
        "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
        "id":"1655515285577936899",
        "expansions":"pinned_tweet_id",
        "tweet_fields":"public_metrics",
        "user_fields":"created_at,username,id,name"
      }
       ```
3. Replace the credentials with your values.

4. Execute the following curl command:

    ```bash
    curl -X POST http://localhost:8280/services/getUserById --header 'Content-Type: application/json' -d @getUserById.json
    ```

5. Twitter returns a json response similar to the one shown below:
 
```json
{
   "data": {
      "pinned_tweet_id": "1667091290889256961",
      "name": "GrawKraken",
      "id": "1655515285577936899",
      "created_at": "2023-05-08T10:09:55.000Z",
      "username": "GrawKraken"
   },
   "includes": {
      "tweets": [
         {
            "id": "1667091290889256961",
            "edit_history_tweet_ids": [
               "1667091290889256961"
            ],
            "public_metrics": {
               "retweet_count": 0,
               "reply_count": 0,
               "like_count": 0,
               "quote_count": 0,
               "bookmark_count": 0,
               "impression_count": 0
            },
            "text": "Hi"
         }
      ]
   }
}
```
