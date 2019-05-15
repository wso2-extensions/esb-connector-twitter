# Working with Accounts in Twitter

[[  Overview ]](#overview)  [[ Operation details ]](#operation-details)  [[  Sample configuration  ]](#sample-configuration)

### Overview 

The following operations allow you to work with accounts. Click an operation name to see details on how to use it.
For a sample proxy service that illustrates how to work with accounts, see [Sample configuration](#sample-configuration).

| Operation        | Description |
| ------------- |-------------|
| [getAccountSettings](#Retrieving-account-settings)    | Retrieves details of account settings. |
| [getAccountVerifyCredentials](#Retrieving-account-verification-details)      | Retrieves authentication verification details. |
| [setAccount](#Set-Account)      | Updates the authenticating user’s settings. |

### Operation details

This section provides further details on the operations related to accounts.

#### Retrieving account settings
The getAccountSettings operation retrieves details of the account settings.

**getAccountSettings**
```xml
<twitter.getAccountSettings/>
```
 
**Sample request**

Following is a sample REST/JSON request that can be handled by the getAccountSettings operation.

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
{
    "time_zone": {
        "name": "Pacific Time (US & Canada)",
        "utc_offset": -25200,
        "tzinfo_name": "America/Los_Angeles"
    },
    "protected": false,
    "screen_name": "ayo32039237",
    "always_use_https": true,
    "use_cookie_personalization": false,
    "sleep_time": {
        "enabled": false,
        "end_time": null,
        "start_time": null
    },
    "geo_enabled": false,
    "language": "en",
    "discoverable_by_email": true,
    "discoverable_by_mobile_phone": true,
    "display_sensitive_media": false,
    "allow_contributor_request": "all",
    "allow_dms_from": "following",
    "allow_dm_groups_from": "following",
    "translator_type": "none"
}
```

**Related Twitter documentation**

https://developer.twitter.com/en/docs/accounts-and-users/manage-account-settings/api-reference/get-account-settings

####  Retrieving account verification details

The getAccountVerifyCredentials operation retrieves account verification details.

**getAccountVerifyCredentials**
```xml
<twitter.getAccountVerifyCredentials>
   <includeUserEntities>{$ctx:includeUserEntities}</includeUserEntities>
   <skipStatus>{$ctx:skipStatus}</skipStatus>
   <includeEmail>{$ctx:includeEmail}</includeEmail>
</twitter.getAccountVerifyCredentials>
```

**Properties**
* includeUserEntities: Whether the user entities node should be returned in the user objector not. If set to false, the user entities node will not be returned.
* skipStatus: Whether the status should be returned in the user objector not. If set to either true, t or 1, the status will not be returned.
* includeEmail: Whether the email should be returned in the user objects as a string. If set to true, the email will be returned.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getAccountVerifyCredentials operation.

```json
{
    "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
    "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
    "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
    "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
    "includeUserEntities":"false",
    "skipStatus":"true",
    "includeEmail":"true"
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
    "url": null,
    "description": "",
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
    "statuses_count": 0,
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
    "translator_type": "none",
    "suspended": false,
    "needs_phone_verification": false
}
```


**Related Twitter documentation**

https://developer.twitter.com/en/docs/accounts-and-users/manage-account-settings/api-reference/get-account-verify_credentials

####  Set Account

The setAccount operation updates the authenticating user’s settings. 

**setAccount**
```xml
<twitter.setAccount>
    <sleepTimeEnabled>{$ctx:sleepTimeEnabled}</sleepTimeEnabled>
    <startSleepTime>{$ctx:startSleepTime}</startSleepTime>
    <endSleepTime>{$ctx:endSleepTime}</endSleepTime>
    <timeZone>{$ctx:timeZone}</timeZone>
</twitter.setAccount>
```
**Properties**

* sleepTimeEnabled: When set to true, t or 1, will enable sleep time for the user. Sleep time is the time when push or SMS notifications should not be sent to the user.
* startSleepTime: The hour that sleep time should begin if it is enabled. The value for this parameter should be provided in ISO8601 format (i.e. 00-23).
* endSleepTime: The hour that sleep time should end if it is enabled.
* timeZone: The timezone dates and times should be displayed in for the user(Eg:Europe, Copenhagen, etc).

**Sample request**

Following is a sample REST/JSON request that can be handled by the setAccount operation.

```json
{
    "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
    "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
    "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
    "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU",
    "sleepTimeEnabled":"true"
 }
```


**Sample Response**

```json
{
    "time_zone": {
        "name": "Pacific Time (US & Canada)",
        "utc_offset": -25200,
        "tzinfo_name": "America/Los_Angeles"
    },
    "protected": false,
    "screen_name": "ayo32039237",
    "always_use_https": true,
    "use_cookie_personalization": false,
    "sleep_time": {
        "enabled": true,
        "end_time": 0,
        "start_time": 0
    },
    "geo_enabled": false,
    "language": "en",
    "discoverable_by_email": true,
    "discoverable_by_mobile_phone": true,
    "display_sensitive_media": false,
    "allow_contributor_request": "all",
    "allow_dms_from": "following",
    "allow_dm_groups_from": "following",
    "translator_type": "none"
}
```


**Related Twitter documentation**

https://developer.twitter.com/en/docs/accounts-and-users/manage-account-settings/api-reference/post-account-settings

#### Sample configuration

Following is a sample proxy service that illustrates how to connect to Twitter with the init operation and use the getAccountSettings operation. The sample request for this proxy can be found in getAccountSettings sample request. You can use this sample as a template for using other operations in this category.

1. Create a sample proxy as below :

    **Sample Proxy**
    ```xml
    <proxy xmlns="http://ws.apache.org/ns/synapse"
           name="getAccountSettings"
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
             <twitter.init>
                 <consumerKey>{$ctx:consumerKey}</consumerKey>
                 <consumerSecret>{$ctx:consumerSecret}</consumerSecret>
                 <accessToken>{$ctx:accessToken}</accessToken>
                 <accessTokenSecret>{$ctx:accessTokenSecret}</accessTokenSecret>
             </twitter.init>     
             <twitter.getAccountSettings/>
             <respond/>
          </inSequence>
          <outSequence>
            <send/>
          </outSequence>
       </target>
       <description/>
    </proxy>
    
    ```
2. Create a json file named getAccountSettings.json and copy the configurations given below to it:

    ```json
    {
        "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
        "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
        "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
        "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU"
    }
    ```
3. Replace the credentials with your values.

4. Execute the following curl command:

    ```bash
    curl -X POST http://localhost:8280/services/getAccountSettings --header 'Content-Type: application/json' -d @getAccountSettings.json
    ```

5. Twitter returns a json response similar to the one shown below:
 
```json
{"time_zone":{"name":"Pacific Time (US & Canada)","utc_offset":-25200,"tzinfo_name":"America\/Los_Angeles"},"protected":false,"screen_name":"ayo32039237","always_use_https":true,"use_cookie_personalization":false,"sleep_time":{"enabled":false,"end_time":null,"start_time":null},"geo_enabled":false,"language":"en","discoverable_by_email":true,"discoverable_by_mobile_phone":true,"display_sensitive_media":false,"allow_contributor_request":"all","allow_dms_from":"following","allow_dm_groups_from":"following","translator_type":"none"}
```
