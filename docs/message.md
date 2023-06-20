# Working with Direct Messages in Twitter

[[  Overview ]](#overview)  [[ Operation details ]](#operation-details)  [[  Sample configuration  ]](#sample-configuration)

### Overview 

The following operations allow you to work with direct messages in Twitter. 
To be authorized for the following endpoints, you will need an access token with the correct scopes. Please refer the https://developer.twitter.com/en/docs/authentication/guides/v2-authentication-mapping to get the required scopes for the access token.
Click an operation name to see details on how to use it.
For a sample proxy service that illustrates how to work with direct messages, see [Sample configuration](#sample-configuration).

| Operation                                                                 | Description                                                                                             |
|---------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------|
| [sendNewDirectMessage](#Sending-a-new-direct-message-to-a-specified-user) | Sends a new direct message to the specified user from the authenticating user.                          |
| [addDirectMessage](#Adding-a-direct-message-to-a-specified-conversation)  | Creates a Direct Message on behalf of an authenticated user, and adds it to the specified conversation. |
| [getDirectMessages](#Retrieving-direct-messages)                          | Returns a list of Direct Messages for the authenticated user, both sent and received.                   |

### Operation details

This section provides further details on the operations related to direct messages.

#### Sending a new direct message to a specified user
The sendNewDirectMessage operation sends a new direct message to the specified user from the authenticating user.

**sendNewDirectMessage**
```xml
<twitter.sendNewDirectMessage>
    <participant_id>{$ctx:participant_id}</participant_id>
    <attachments>{$ctx:attachments}</attachments>
    <text>{$ctx:text}</text>
</twitter.sendNewDirectMessage>
```

**Properties**
* participant_id : `Required` - `String` - The User ID of the account this one-to-one Direct Message is to be sent to.
* attachments : `Optional` - `Array` - A single Media ID being attached to the Direct Message. This field is required if text is not present. Currently, Twitter supports only 1 attachment.
* text : `Optional` - `String` - Text of the Direct Message being created. This field is required if attachments is not present. Text messages support up to 10,000 characters.

**Sample request**

Following is a sample REST/JSON request that can be handled by the sendNewDirectMessage operation.

**Sample Request for sendNewDirectMessage**
```json
{
   "accessToken":"MFpJRmFlbGJTZHVDdkNIbDN4WURTYTFiUmZtRV9HckdsUmlmd1ZxVjRvWHVUOjE2ODY1NDIwMjM5MTk6MTowOmF0OjE",
   "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
   "participant_id":"1668111685234708487",
   "text": "Test message!"
}
```

**Sample Response**

```json
{
   "data": {
      "dm_conversation_id": "1655515285577936899-1668111685234708487",
      "dm_event_id": "1668112397700067333"
   }
}
```

**Related Twitter documentation**
https://developer.twitter.com/en/docs/twitter-api/direct-messages/manage/api-reference/post-dm_conversations-with-participant_id-messages

#### Adding a direct message to a specified conversation
The addDirectMessage operation creates a Direct Message on behalf of an authenticated user, and adds it to the specified conversation.

**addDirectMessage**
```xml
<twitter.addDirectMessage>
    <dm_conversation_id>{$ctx:dm_conversation_id}</dm_conversation_id>
    <attachments>{$ctx:attachments}</attachments>
    <text>{$ctx:text}</text>
</twitter.addDirectMessage>
```

**Properties**
* dm_conversation_id : `Required` - `String` - The dm_conversation_id of the conversation to add the Direct Message to. Supports both 1-1 and group conversations.
* attachments : `Optional` - `Array` - A single Media ID being attached to the Direct Message. This field is required if text is not present. Currently, Twitter supports only 1 attachment.
* text : `Optional` - `String` - Text of the Direct Message being created. This field is required if attachments is not present. Text messages support up to 10,000 characters.

**Sample request**

Following is a sample REST/JSON request that can be handled by the addDirectMessage operation.

**Sample Request for addDirectMessage**
```json
{
   "accessToken":"MFpJRmFlbGJTZHVDdkNIbDN4WURTYTFiUmZtRV9HckdsUmlmd1ZxVjRvWHVUOjE2ODY1NDIwMjM5MTk6MTowOmF0OjE",
   "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
   "dm_conversation_id":"1655515285577936899-1668111685234708487",
   "text": "Second Test message!"
}
```

**Sample Response**

```json
{
   "data": {
      "dm_conversation_id": "1655515285577936899-1668111685234708487",
      "dm_event_id": "1668113164393672708"
   }
}
```

**Related Twitter documentation**
https://developer.twitter.com/en/docs/twitter-api/direct-messages/manage/api-reference/post-dm_conversations-dm_conversation_id-messages

#### Retrieving direct messages
The getDirectMessages operation retrives a list of Direct Messages for the authenticated user, both sent and received.

**getDirectMessages**
```xml
<twitter.getDirectMessages>
    <event_types>{$ctx:event_types}</event_types>
    <max_results>{$ctx:max_results}</max_results>
    <pagination_token>{$ctx:pagination_token}</pagination_token>
    <expansions>{$ctx:expansions}</expansions>
    <dm_event_fields>{$ctx:dm_event_fields}</dm_event_fields>
    <media_fields>{$ctx:media_fields}</media_fields>
    <tweet_fields>{$ctx:tweet_fields}</tweet_fields>
    <user_fields>{$ctx:user_fields}</user_fields>
</twitter.getDirectMessages>
```

**Properties**
* event_types : `Optional` - `Enum` - The type of Direct Message event to return. If not included, all types are returned. Valid values for this parameter are: `MessageCreate, ParticipantsJoin, ParticipantsLeave`.
* max_results: `Optional` - `Integer` - The maximum number of results to be returned in a page. Must be between 1 and 100. The default is 100.
* pagination_token : `Optional` - `String` - Contains either the next_token or previous_token value.
* expansions : `Optional` - `Enum` - Expansions enable you to request additional data objects that relate to the returned Direct Message conversation events. Submit a list of desired expansions in a comma-separated list without spaces. The IDs that represents the expanded data objects will be included directly in the event data object, and the expanded object metadata will be returned within the includes response object. Valid values for this parameter are: `attachments.media_keys, referenced_tweets.id, sender_id, participant_ids`.
* dm_event_fields : `Optional` - `Enum` - Extra fields to include in the event payload. id, and event_type are returned by default. The text value isn't included for ParticipantsJoin and ParticipantsLeave events. Valid values for this parameter are: `id, text, event_type, created_at, dm_conversation_id, sender_id, participant_ids, referenced_tweets, attachments`.
* media_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific media fields will be delivered in Direct Message 'MessageCreate' events. Specify the desired fields in a comma-separated list without spaces between commas and fields. While the media ID will be located in the event object, you will find this ID and all additional media fields in the includes data object. The event object will only include media fields if the Direct Message contains media and if you've also included the expansions=attachments.media_keys query parameter in your request. Valid values for this parameter are: `duration_ms, height, media_key, preview_image_url, type, url, width, public_metrics, alt_text, variants`.
* tweet_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific Tweet fields will be delivered in each returned Direct Message 'MessageCreate' event object that contains a Tweet reference. Specify the desired fields in a comma-separated list without spaces between commas and fields. While the Tweet ID will be in the event object, you will find this ID and all additional Tweet fields in the includes data object. The event object will include Tweet fields only if the Direct Message references a Tweet and the expansions=referenced_tweet.id query parameter is included in the request. Valid values for this parameter are: `attachments, author_id, context_annotations, conversation_id, created_at, edit_controls, entities, geo, id, in_reply_to_user_id, lang, public_metrics, possibly_sensitive, referenced_tweets, reply_settings, source, text, withheld`.
* user_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific user fields will be delivered for Direct Message conversation events that reference a sender or participant ID. Specify the desired fields in a comma-separated list without spaces between commas and fields. While the user ID will be located in the event object, you will find this ID and all additional user fields in the includes data object. Valid values for this parameter are: `created_at, description, entities, id, location, name, pinned_tweet_id, profile_image_url, protected, public_metrics, url, username, verified, withheld`.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getDirectMessages operation.

**Sample Request for getDirectMessages**
```json
{
   "accessToken":"MFpJRmFlbGJTZHVDdkNIbDN4WURTYTFiUmZtRV9HckdsUmlmd1ZxVjRvWHVUOjE2ODY1NDIwMjM5MTk6MTowOmF0OjE",
   "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
   "dm_event_fields":"event_type,sender_id",
   "expansions":"participant_ids",
   "user_fields":"created_at,username,id,name"
}
```

**Sample Response**

```json
{
   "data": [
      {
         "text": "Test message!",
         "id": "1668113164393672708",
         "sender_id": "1655515285577936899",
         "event_type": "MessageCreate"
      },
      {
         "text": "Test DM",
         "id": "1668112842107547653",
         "sender_id": "1655515285577936899",
         "event_type": "MessageCreate"
      }
   ],
   "meta": {
      "result_count": 2
   }
}
```

**Related Twitter documentation**
https://developer.twitter.com/en/docs/twitter-api/direct-messages/lookup/api-reference/get-dm_events

#### Sample configuration

Following is a sample proxy service that illustrates how to connect to Twitter with the init operation and use the getDirectMessages operation. The sample request for this proxy can be found in getDirectMessages sample request. You can use this sample as a template for using other operations in this category.

1. Create a sample proxy as below :

    **Sample Proxy**
    ```xml
    <proxy xmlns="http://ws.apache.org/ns/synapse"
           name="getDirectMessages"
           transports="https,http"
           statistics="disable"
           trace="disable"
           startOnLoad="true">
       <target>
           <inSequence onError="faultHandlerSeq">       
            <property name="clientId" expression="json-eval($.clientId)"/>
            <property name="accessToken" expression="json-eval($.accessToken)"/>
            <property name="expansions" expression="json-eval($.expansions)"/>
            <property name="dm_event_fields" expression="json-eval($.dm_event_fields)"/>
            <property name="user_fields" expression="json-eval($.user_fields)"/>
             <twitter.init>
                <clientId>{$ctx:clientId}</clientId>
                <accessToken>{$ctx:accessToken}</accessToken>
             </twitter.init>
            <twitter.getDirectMessages>
                <expansions>{$ctx:expansions}</expansions>
                <dm_event_fields>{$ctx:dm_event_fields}</dm_event_fields>
                <user_fields>{$ctx:user_fields}</user_fields>
            </twitter.getDirectMessages>
             <respond/>
          </inSequence>
          <outSequence>
             <send/>
          </outSequence>
       </target>
       <description/>
    </proxy>
    
    ```
2. Create a json file named getDirectMessages.json and copy the configurations given below to it:

    ```json
    {
   "accessToken":"MFpJRmFlbGJTZHVDdkNIbDN4WURTYTFiUmZtRV9HckdsUmlmd1ZxVjRvWHVUOjE2ODY1NDIwMjM5MTk6MTowOmF0OjE",
   "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
   "dm_event_fields":"event_type,sender_id",
   "expansions":"participant_ids",
   "user_fields":"created_at,username,id,name"
    }
    ```
3. Replace the credentials with your values.

4. Execute the following curl command:

    ```bash
    curl -X POST http://localhost:8280/services/getDirectMessages --header 'Content-Type: application/json' -d @getDirectMessages.json
    ```

5. Twitter returns a json response similar to the one shown below:
 
```json
{
    "data": [
        {
            "text": "Test message!",
            "id": "1668113164393672708",
            "sender_id": "1655515285577936899",
            "event_type": "MessageCreate"
        },
        {
            "text": "Test DM",
            "id": "1668112842107547653",
            "sender_id": "1655515285577936899",
            "event_type": "MessageCreate"
        }
    ],
    "meta": {
        "result_count": 2
    }
}
```
