# Working with Direct Messages in Twitter

[[  Overview ]](#overview)  [[ Operation details ]](#operation-details)  [[  Sample configuration  ]](#sample-configuration)

### Overview 

The following operations allow you to work with direct messages in Twitter. Click an operation name to see details on how to use it.
For a sample proxy service that illustrates how to work with direct messages, see [Sample configuration](#sample-configuration).

| Operation        | Description |
| ------------- |-------------|
| [getDirectMessages](#Retrieving-incoming-direct-messages)    | Retrieves the most recent incoming direct messages. |
| [sendNewDirectMessages](#Sends-a-new-direct-message-to-a-specified user.)      | Retrieves authentication verification detailsSends a new direct message to a specified user. |

### Operation details

This section provides further details on the operations related to direct messages.

#### Retrieving incoming  direct messages
The getDirectMessages operation retrieves the most recent direct messages sent to the authenticating user.

**getDirectMessages**
```xml
<twitter.getDirectMessages>
    <count>{$ctx:count}</count>
    <cursor>{$ctx:cursor}</cursor>
</twitter.getDirectMessages>
```

**Properties**
* count: The number of messages to retrieve per page. The number of messages can go up to a maximum of 200. The default value is 20.
* cursor: For paging through result sets greater than 1 page, use the “next_cursor” property from the previous request.
 
**Sample request**

Following is a sample REST/JSON request that can be handled by the getDirectMessages operation.

```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "count": "10"
 }
```


**Related Twitter documentation**

https://developer.twitter.com/en/docs/direct-messages/sending-and-receiving/api-reference/list-events

####  Sending a new direct message

The sendNewDirectMessages operation sends a new direct message from the authenticating user to a specified user.

**sendNewDirectMessages**
```xml
<twitter.sendNewDirectMessages>
    <userID>{$ctx:userID}</userID>
    <text>{$ctx:text}</text>
 </twitter.sendNewDirectMessages>
```

**Properties**
* userID: The ID of the user.
* text:  The text of your direct message.

**Sample request**

Following is a sample REST/JSON request that can be handled by the sendNewDirectMessages operation.

```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
  "userID":"167834596012345",
  "text":"sample message"
}
```

**Sample Response**

```json
{
    "events": [
        {
            "type": "message_create",
            "id": "1127800165933338628",
            "created_timestamp": "1557723487729",
            "message_create": {
                "target": {
                    "recipient_id": "1114072936665821184"
                },
                "sender_id": "1114072936665821184",
                "source_app_id": "16297925",
                "message_data": {
                    "text": "sample message1",
                    "entities": {
                        "hashtags": [],
                        "symbols": [],
                        "user_mentions": [],
                        "urls": []
                    }
                }
            }
        },
        {
            "type": "message_create",
            "id": "1127798286394331140",
            "created_timestamp": "1557723039612",
            "message_create": {
                "target": {
                    "recipient_id": "1114072936665821184"
                },
                "sender_id": "1114072936665821184",
                "source_app_id": "16297925",
                "message_data": {
                    "text": "sample message1",
                    "entities": {
                        "hashtags": [],
                        "symbols": [],
                        "user_mentions": [],
                        "urls": []
                    }
                }
            }
        },
        {
            "type": "message_create",
            "id": "1127798284016160773",
            "created_timestamp": "1557723039045",
            "message_create": {
                "target": {
                    "recipient_id": "1114072936665821184"
                },
                "sender_id": "1114072936665821184",
                "source_app_id": "16297925",
                "message_data": {
                    "text": "sample message1",
                    "entities": {
                        "hashtags": [],
                        "symbols": [],
                        "user_mentions": [],
                        "urls": []
                    }
                }
            }
        },
        {
            "type": "message_create",
            "id": "1127798276390961164",
            "created_timestamp": "1557723037227",
            "message_create": {
                "target": {
                    "recipient_id": "1114072936665821184"
                },
                "sender_id": "1114072936665821184",
                "source_app_id": "16297925",
                "message_data": {
                    "text": "sample message1",
                    "entities": {
                        "hashtags": [],
                        "symbols": [],
                        "user_mentions": [],
                        "urls": []
                    }
                }
            }
        },
        {
            "type": "message_create",
            "id": "1127252758229176325",
            "created_timestamp": "1557592975562",
            "message_create": {
                "target": {
                    "recipient_id": "1114072936665821184"
                },
                "sender_id": "1114072936665821184",
                "source_app_id": "16297925",
                "message_data": {
                    "text": "Hello",
                    "entities": {
                        "hashtags": [],
                        "symbols": [],
                        "user_mentions": [],
                        "urls": []
                    }
                }
            }
        },
        {
            "type": "message_create",
            "id": "1127251591969435652",
            "created_timestamp": "1557592697504",
            "message_create": {
                "target": {
                    "recipient_id": "1114072936665821184"
                },
                "sender_id": "1114072936665821184",
                "source_app_id": "16297925",
                "message_data": {
                    "text": "Hello",
                    "entities": {
                        "hashtags": [],
                        "symbols": [],
                        "user_mentions": [],
                        "urls": []
                    }
                }
            }
        },
        {
            "type": "message_create",
            "id": "1127250473663193093",
            "created_timestamp": "1557592430879",
            "message_create": {
                "target": {
                    "recipient_id": "1114072936665821184"
                },
                "sender_id": "1114072936665821184",
                "source_app_id": "16297925",
                "message_data": {
                    "text": "Hello",
                    "entities": {
                        "hashtags": [],
                        "symbols": [],
                        "user_mentions": [],
                        "urls": []
                    }
                }
            }
        },
        {
            "type": "message_create",
            "id": "1127249183650410500",
            "created_timestamp": "1557592123316",
            "message_create": {
                "target": {
                    "recipient_id": "1114072936665821184"
                },
                "sender_id": "1114072936665821184",
                "source_app_id": "16297925",
                "message_data": {
                    "text": "Hello",
                    "entities": {
                        "hashtags": [],
                        "symbols": [],
                        "user_mentions": [],
                        "urls": []
                    }
                }
            }
        },
        {
            "type": "message_create",
            "id": "1127248050664001540",
            "created_timestamp": "1557591853191",
            "message_create": {
                "target": {
                    "recipient_id": "1114072936665821184"
                },
                "sender_id": "1114072936665821184",
                "source_app_id": "16297925",
                "message_data": {
                    "text": "Hello",
                    "entities": {
                        "hashtags": [],
                        "symbols": [],
                        "user_mentions": [],
                        "urls": []
                    }
                }
            }
        },
        {
            "type": "message_create",
            "id": "1127246842154983428",
            "created_timestamp": "1557591565060",
            "message_create": {
                "target": {
                    "recipient_id": "1114072936665821184"
                },
                "sender_id": "1114072936665821184",
                "source_app_id": "16297925",
                "message_data": {
                    "text": "Hello",
                    "entities": {
                        "hashtags": [],
                        "symbols": [],
                        "user_mentions": [],
                        "urls": []
                    }
                }
            }
        }
    ],
    "apps": {
        "16297925": {
            "id": "16297925",
            "name": "IntegrationESB",
            "url": "https://api.twitter.com"
        }
    },
    "next_cursor": "MTEyNzI0Njg0MjE1NDk4MzQyOA"
}
```

**Related Twitter documentation**

https://developer.twitter.com/en/docs/direct-messages/sending-and-receiving/api-reference/new-event

#### Sample configuration

Following is a sample proxy service that illustrates how to connect to Twitter with the init operation and use the sendNewDirectMessages operation. The sample request for this proxy can be found in sendNewDirectMessages sample request. You can use this sample as a template for using other operations in this category.

1. Create a sample proxy as below :

    **Sample Proxy**
    ```xml
    <proxy xmlns="http://ws.apache.org/ns/synapse"
           name="sendNewDirectMessages"
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
             <property name="userID" expression="json-eval($.userID)"/>
             <property name="text" expression="json-eval($.text)"/>
             <twitter.init>
                <consumerKey>{$ctx:consumerKey}</consumerKey>
                <consumerSecret>{$ctx:consumerSecret}</consumerSecret>
                <accessToken>{$ctx:accessToken}</accessToken>
                <accessTokenSecret>{$ctx:accessTokenSecret}</accessTokenSecret>
             </twitter.init>
             <twitter.sendNewDirectMessages>
                <userID>{$ctx:userID}</userID>
                <text>{$ctx:text}</text>
            </twitter.sendNewDirectMessages>
             <respond/>
          </inSequence>
          <outSequence>
             <send/>
          </outSequence>
       </target>
       <description/>
    </proxy>
    
    ```
2. Create a json file named sendNewDirectMessages.json and copy the configurations given below to it:

    ```json
    {
      "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
      "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
      "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
      "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
      "userID":"167834596012345",
      "text":"sample message"
    }
    ```
3. Replace the credentials with your values.

4. Execute the following curl command:

    ```bash
    curl -X POST http://localhost:8280/services/sendNewDirectMessages --header 'Content-Type: application/json' -d @sendNewDirectMessages.json
    ```

5. Twitter returns a json response similar to the one shown below:
 
```json
{"event":{"message_create":{"message_data":{"entities":{"urls":[],"hashtags":[],"user_mentions":[],"symbols":[]},"text":"Hello"},"sender_id":"1114072936665821184","target":{"recipient_id":"1114072936665821184"}},"created_timestamp":"1557730051026","id":"1127827694396235780","type":"message_create"}}
```
