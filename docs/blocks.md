# Working with Blocking in Twitter

[[  Overview ]](#overview)  [[ Operation details ]](#operation-details)  [[  Sample configuration  ]](#sample-configuration)

### Overview 

The following operations allow you to work with blocking. Click an operation name to see details on how to use it.
For a sample proxy service that illustrates how to retrieve the user IDs that the authenticating user is blocking, see [Sample configuration](#sample-configuration).

| Operation        | Description |
| ------------- |-------------|
| [getBlockIds](#Retrieving-blocked-user-IDs)    | Retrieves blocked user IDs. |
| [getBlocksList](#Retrieving-a-list-of-blocked users)      | Retrieves authentication verification details. |
| [blockUser](#Blocking-a-user)      | Blocks a specified user. |
| [destroyBlock](#Unblocking-a-user)      | Unblocks a specified user.|

### Operation details

This section provides further details on the operations related to blocking.

#### Retrieving blocked user IDs
The getBlockIds operation retrieves the user IDs that the authenticating user is blocking.

**getBlockIds**
```xml
<twitter.getBlockIds>
    <stringifyIds>{$ctx:stringifyIds}</stringifyIds>
    <cursor>{$ctx:cursor}</cursor>
</twitter.getBlockIds>
```

**Properties**
* stringifyIds: Set this to true if you need to have the ids returned as strings.
* cursor: Specify this property if you want the list of IDs to be broken into pages of results. If a value is not specified, a default value of -1 will be assumed, which is the first page. When you specify this property the response from the API will include a previous_cursor and next_cursor to allow paging back and forth.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getBlockIds operation.

**Sample Request for getBlockIds**
```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "cursor":"-1",
  "stringifyIds":"true"
}
```

**Sample Response**

```json
{
"previous_cursor":0,
"next_cursor":0,
"previous_cursor_str":"0",
"total_count":null,
"ids":[],
"next_cursor_str":"0"
}

```

**Related Twitter documentation**

https://dev.twitter.com/rest/reference/get/blocks/ids

####  Retrieving a list of blocked users

The getBlocksList operation retrieves a collection of user objects that the authenticating user is blocking.

**getBlocksList**
```xml
<twitter.getBlocksList>
    <stringifyIds>{$ctx:stringifyIds}</stringifyIds>
    <cursor>{$ctx:cursor}</cursor>
</twitter.getBlocksList>
```

**Properties**
* stringifyIds: Set this to true if you need to have the ids returned as strings.
* cursor: Specify this property if you want the list of blocked users to be broken into pages of results. If a value is not specified, a default value of -1 will be assumed, which is the first page. When you specify this property the response from the API will include a previous_cursor and next_cursor to allow paging back and forth.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getBlocksList operation.

```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "cursor":"-1",
  "stringifyIds":"true"
}
```

**Sample Response**

```json
{
"previous_cursor":0,
"next_cursor":0,
"previous_cursor_str":"0",
"total_count":null,
"next_cursor_str":"0",
"users":[]
}

```
**Related Twitter documentation**

https://dev.twitter.com/rest/reference/get/blocks/list

####  Blocking a user

The blockUser operation blocks a specified user from following the authenticating user.

**blockUser**
```xml
<twitter.blockUser>
    <userID>{$ctx:userID}</userID>
    <screenName>{$ctx:screenName}</screenName>
    <skipStatus>{$ctx:skipStatus}</skipStatus>
    <includeEntities>{$ctx:includeEntities}</includeEntities>
 </twitter.blockUser>
```
**Properties**

* userID: The ID of the user to be blocked.
* screenName: The screen name of the user to be blocked.
* skipStatus: Set to either true, t or 1 if you do not want the status to be included in the returned user object.
* includeEntities: Set to false if you do not want the entities node to be included in the returned user object.

**Sample request**

Following is a sample REST/JSON request that can be handled by the blockUser operation.

```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "screenName":"TestUser",
  "skipStatus":"true",
  "includeEntities":"false"
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

https://dev.twitter.com/rest/reference/post/blocks/create

####  Unblocking a user

The destroyBlock operation unblocks a specified user for the authenticating user.

**destroyBlock**
```xml
<twitter.destroyBlock>
    <userID>{$ctx:userID}</userID>
    <screenName>{$ctx:screenName}</screenName>
    <skipStatus>{$ctx:skipStatus}</skipStatus>
    <includeEntities>{$ctx:includeEntities}</includeEntities>
 </twitter.destroyBlock>
```
**Properties**

* userID: The ID of the user to be unblocked.
* screenName: The screen name of the user to be unblocked.
* skipStatus: Set to either true, t or 1 if you do not want the status to be included in the returned user object.
* includeEntities: Set to false if you do not want the entities node to be included in the returned user object.

**Sample request**

Following is a sample REST/JSON request that can be handled by the destroyBlock operation.

```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "screenName":"TestUser",
  "skipStatus":"true",
  "includeEntities":"false"
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

https://dev.twitter.com/rest/reference/post/blocks/destroy

#### Sample configuration

Following is a sample proxy service that illustrates how to connect to Twitter with the init operation and use the getBlockIds operation. The sample request for this proxy can be found in getBlockIds sample request. You can use this sample as a template for using other operations in this category.

1. Create a sample proxy as below :

    **Sample Proxy**
    ```xml
    <proxy name="getBlockIds"
           startOnLoad="true"
           statistics="disable"
           trace="disable"
           transports="http,https"
           xmlns="http://ws.apache.org/ns/synapse">
        <target>
            <inSequence>
                <property expression="json-eval($.cursor)" name="cursor"/>
                <property expression="json-eval($.stringifyIds)" name="stringifyIds"/>
                <property expression="json-eval($.accessToken)" name="accessToken"/>
                <property expression="json-eval($.consumerKey)" name="consumerKey"/>
                <property expression="json-eval($.consumerSecret)" name="consumerSecret"/>
                <property expression="json-eval($.accessTokenSecret)" name="accessTokenSecret"/>
                <twitter.init>
                    <accessTokenSecret>{$ctx:accessTokenSecret}</accessTokenSecret>
                    <consumerSecret>{$ctx:consumerSecret}</consumerSecret>
                    <consumerKey>{$ctx:consumerKey}</consumerKey>
                    <accessToken>{$ctx:accessToken}</accessToken>
                </twitter.init>
                <twitter.getBlockIds>
                    <stringifyIds>{$ctx:stringifyIds}</stringifyIds>
                    <cursor>{$ctx:cursor}</cursor>
                </twitter.getBlockIds>
                <respond/>
            </inSequence>
            <outSequence/>
            <faultSequence/>
        </target>
    </proxy>
    ```
2. Create a json file named getBlockIds.json and copy the configurations given below to it:

    ```json
    {
      "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
      "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
      "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
      "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
      "cursor":"-1",
      "stringifyIds":"true"
    }
    ```
3. Replace the credentials with your values.

4. Execute the following curl command:

    ```bash
    curl -X POST http://localhost:8280/services/getBlockIds --header 'Content-Type: application/json' -d @getBlockIds.json
    ```

5. Twitter returns a json response similar to the one shown below:
 
```json
{"previous_cursor":0,"next_cursor":0,"previous_cursor_str":"0","total_count":null,"next_cursor_str":"0","users":[]}

```
