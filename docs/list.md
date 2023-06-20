# Working with Lists in Twitter

[[  Overview ]](#overview)  [[ Operation details ]](#operation-details)  [[  Sample configuration  ]](#sample-configuration)

### Overview 

The following operations allow you to work with lists in Twitter. 
To be authorized for the following endpoints, you will need an access token with the correct scopes. Please refer the https://developer.twitter.com/en/docs/authentication/guides/v2-authentication-mapping to get the required scopes for the access token.
Click an operation name to see details on how to use it.
For a sample proxy service that illustrates how to work with lists, see [Sample configuration](#sample-configuration).

| Operation                                                                  | Description                                                                                 |
|----------------------------------------------------------------------------|---------------------------------------------------------------------------------------------|
| [createList](#Creating-a-list)                                             | 	Creates a new list for the authenticated user.                                             |
| [updateList](#Updating-a-list)                                             | Updates an existing list for the authenticated user.                                        |
| [deleteList](#Deleting-a-list)                                             | Deletes a list for the authenticated user.                                                  |
| [getListById](#Retrieving-information-of-a-list-using-id)                  | Retrieves information about a single list specified by the requested ID.                    |
| [getFollowingLists](#Retrieving-lists-the-specified-user-is-following)     | Retrieves all lists the authenticating or specified user is following, including their own. |
| [getListsMemberships](#Retrieving-lists-the-specified-user-is-a-member-of) | Retrieves all Lists a specified user is a member of.                                        |

### Operation details

This section provides further details on the operations.

#### Creating a list
The createList operation creates a new list for the authenticated user.

**createList**
```xml
<twitter.createList>
    <name>{$ctx:name}</name>
    <description>{$ctx:description}</description>
    <private>{$ctx:private}</private>
</twitter.createList>
```

**Properties**
* name : `Required` - `String` - The name of the List you wish to create.
* description : `Optional` - `String` - Description of the List.
* private : `Optional` - `Boolean` - Determine whether the List should be private.

**Sample request**

Following is a sample REST/JSON request that can be handled by the createList operation.

**Sample Request for createList**
```json
{
   "accessToken":"UnY3dE9NQWc3OHhFdVlqaUp3Sm1neE1sRjVFWldNaDRQZkxYQUJCMzV1aUxSOjE2ODYzMDgyOTIxMjM6MTowOmF0OjE",
   "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
   "name":"test list",
   "description":"list for testing",
   "private":true
}
```

**Sample Response**

```json
{
   "data": {
      "id": "1667124005638397955",
      "name": "test list"
   }
}
```

**Related Twitter documentation**
https://developer.twitter.com/en/docs/twitter-api/lists/manage-lists/api-reference/post-lists

#### Updating a list
The updateList operation updates an existing list for the authenticated user.

**updateList**
```xml
<twitter.updateList>
    <id>{$ctx:id}</id>
    <name>{$ctx:name}</name>
    <description>{$ctx:description}</description>
    <private>{$ctx:private}</private>
</twitter.updateList>
```

**Properties**
* id : `Required` - `String` - The ID of the List to be updated.
* name : `Optional` - `String` - The new name of the List you wish to update.
* description : `Optional` - `String` - Description of the List.
* private : `Optional` - `Boolean` - Determine whether the List should be private.

**Sample request**

Following is a sample REST/JSON request that can be handled by the updateList operation.

**Sample Request for updateList**
```json
{
   "accessToken":"UnY3dE9NQWc3OHhFdVlqaUp3Sm1neE1sRjVFWldNaDRQZkxYQUJCMzV1aUxSOjE2ODYzMDgyOTIxMjM6MTowOmF0OjE",
   "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
   "id":"1667124005638397955",
   "name":"test list",
   "description":"list for editing and testing",
   "private":true
}
```

**Sample Response**

```json
{
   "data": {
      "updated": true
   }
}
```

**Related Twitter documentation**
https://developer.twitter.com/en/docs/twitter-api/lists/manage-lists/api-reference/put-lists-id

#### Deleting a list
The deleteList operation deletes a list for the authenticated user.

**deleteList**
```xml
<twitter.deleteList>
    <id>{$ctx:id}</id>
</twitter.deleteList>
```

**Properties**
* id : `Required` - `String` - The ID of the List to be deleted.

**Sample request**

Following is a sample REST/JSON request that can be handled by the deleteList operation.

**Sample Request for deleteList**
```json
{
   "accessToken":"UnY3dE9NQWc3OHhFdVlqaUp3Sm1neE1sRjVFWldNaDRQZkxYQUJCMzV1aUxSOjE2ODYzMDgyOTIxMjM6MTowOmF0OjE",
   "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
   "id":"1667124005638397955"
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
https://developer.twitter.com/en/docs/twitter-api/lists/manage-lists/api-reference/delete-lists-id

#### Retrieving information of a list using id
The getListById operation retrieves information about a single list specified by the requested ID.

**getListById**
```xml
<twitter.getListById>
    <id>{$ctx:id}</id>
    <expansions>{$ctx:expansions}</expansions>
    <list_fields>{$ctx:list_fields}</list_fields>
    <user_fields>{$ctx:user_fields}</user_fields>
</twitter.getListById>
```

**Properties**
* id : `Required` - `String` - The ID of the List to lookup.
* expansions : `Optional` - `Enum` - Expansions enable you to request additional data objects that relate to the originally returned List. The ID that represents the expanded data object will be included directly in the List data object, but the expanded object metadata will be returned within the includes response object, and will also include the ID so that you can match this data object to the original user object. At this time, the only expansion available to endpoints that primarily return List objects is expansions=`owner_id`. You will find the expanded user data object living in the includes response object.
* list_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific List fields will deliver with each returned List objects. Specify the desired fields in a comma-separated list without spaces between commas and fields. These specified List fields will display directly in the List data objects. Valid values for this parameter are: `created_at, follower_count, member_count, private, description, owner_id`.
* user_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific user fields will deliver with the users object. Specify the desired fields in a comma-separated list without spaces between commas and fields. The user fields will only be returned if you have included expansions=owner_id query parameter in your request. You will find this ID and all additional user fields in the included data object. Valid values for this parameter are: `created_at, description, entities, id, location, name, pinned_tweet_id, profile_image_url, protected, public_metrics, url, username, verified, withheld`.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getListById operation.

**Sample Request for getListById**
```json
{
   "accessToken":"MFpJRmFlbGJTZHVDdkNIbDN4WURTYTFiUmZtRV9HckdsUmlmd1ZxVjRvWHVUOjE2ODY1NDIwMjM5MTk6MTowOmF0OjE",
   "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
   "id":"1667124005638397955",
   "expansions":"owner_id",
   "list_fields":"description",
   "user_fields":"created_at,username,id,name"
}
```

**Sample Response**

```json
{
   "data": {
      "id": "1667124005638397955",
      "name": "test list",
      "owner_id": "1655515285577936899"
   },
   "includes": {
      "users": [
         {
            "id": "1655515285577936899",
            "name": "GrawKraken",
            "username": "GrawKraken"
         }
      ]
   }
}
```

**Related Twitter documentation**
https://developer.twitter.com/en/docs/twitter-api/lists/list-lookup/api-reference/get-lists-id

#### Retrieving lists the specified user is following
The getFollowingLists operation retrieves all lists the authenticating or specified user is following, including their own.

**getFollowingLists**
```xml
<twitter.getFollowingLists>
    <id>{$ctx:id}</id>
    <max_results>{$ctx:max_results}</max_results>
    <pagination_token>{$ctx:pagination_token}</pagination_token>
    <expansions>{$ctx:expansions}</expansions>
    <list_fields>{$ctx:list_fields}</list_fields>
    <user_fields>{$ctx:user_fields}</user_fields>
</twitter.getFollowingLists>
```

**Properties**
* id : `Required` - `String` - The user ID whose followed Lists you would like to retrieve.
* max_results: `Optional` - `Integer` - The maximum number of results to be returned per page. This can be a number between 1 and 100. By default, each page will return 100 results.
* pagination_token : `Optional` - `String` - Used to request the next page of results if all results weren't returned with the latest request, or to go back to the previous page of results. To return the next page, pass the next_token returned in your previous response. To go back one page, pass the previous_token returned in your previous response.
* expansions : `Optional` - `Enum` - Expansions enable you to request additional data objects that relate to the originally returned List. The ID that represents the expanded data object will be included directly in the List data object, but the expanded object metadata will be returned within the includes response object, and will also include the ID so that you can match this data object to the original user object. At this time, the only expansion available to endpoints that primarily return List objects is expansions=`owner_id`. You will find the expanded user data object living in the includes response object.
* list_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific List fields will deliver with each returned List objects. Specify the desired fields in a comma-separated list without spaces between commas and fields. These specified List fields will display directly in the List data objects. Valid values for this parameter are: `created_at, follower_count, member_count, private, description, owner_id`.
* user_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific user fields will deliver with the users object. Specify the desired fields in a comma-separated list without spaces between commas and fields. The user fields will only be returned if you have included expansions=owner_id query parameter in your request. You will find this ID and all additional user fields in the included data object. Valid values for this parameter are: `created_at, description, entities, id, location, name, pinned_tweet_id, profile_image_url, protected, public_metrics, url, username, verified, withheld`.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getFollowingLists operation.

**Sample Request for getFollowingLists**
```json
{
   "accessToken":"MFpJRmFlbGJTZHVDdkNIbDN4WURTYTFiUmZtRV9HckdsUmlmd1ZxVjRvWHVUOjE2ODY1NDIwMjM5MTk6MTowOmF0OjE",
   "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
   "id":"1655515285577936899",
   "expansions":"owner_id",
   "max_results":10,
   "list_fields":"description",
   "user_fields":"created_at,username,id,name"
}
```

**Sample Response**

```json
{
   "data": [
      {
         "follower_count": 123,
         "id": "1630685563471",
         "name": "Test List",
         "owner_id": "1324848235714736129"
      }
   ],
   "includes": {
      "users": [
         {
            "username": "alanbenlee",
            "id": "1324848235714736129",
            "created_at": "2009-08-28T18:30:45.000Z",
            "name": "Alan Lee"
         }
      ]
   },
   "meta": {
      "result_count": 1
   }
}
```

**Related Twitter documentation**
https://developer.twitter.com/en/docs/twitter-api/lists/list-follows/api-reference/get-users-id-followed_lists


#### Retrieving lists the specified user is a member of
The getListsMemberships operation retrieves all Lists a specified user is a member of.

**getListsMemberships**
```xml
<twitter.getListsMemberships>
    <id>{$ctx:id}</id>
    <max_results>{$ctx:max_results}</max_results>
    <pagination_token>{$ctx:pagination_token}</pagination_token>
    <expansions>{$ctx:expansions}</expansions>
    <list_fields>{$ctx:list_fields}</list_fields>
    <user_fields>{$ctx:user_fields}</user_fields>
</twitter.getListsMemberships>
```

**Properties**
* id : `Required` - `String` - The user ID whose List memberships you would like to retrieve.
* max_results: `Optional` - `Integer` - The maximum number of results to be returned per page. This can be a number between 1 and 100. By default, each page will return 100 results.
* pagination_token : `Optional` - `String` - Used to request the next page of results if all results weren't returned with the latest request, or to go back to the previous page of results. To return the next page, pass the next_token returned in your previous response. To go back one page, pass the previous_token returned in your previous response.
* expansions : `Optional` - `Enum` - Expansions enable you to request additional data objects that relate to the originally returned List. The ID that represents the expanded data object will be included directly in the List data object, but the expanded object metadata will be returned within the includes response object, and will also include the ID so that you can match this data object to the original user object. At this time, the only expansion available to endpoints that primarily return List objects is expansions=`owner_id`. You will find the expanded user data object living in the includes response object.
* list_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific List fields will deliver with each returned List objects. Specify the desired fields in a comma-separated list without spaces between commas and fields. These specified List fields will display directly in the List data objects. Valid values for this parameter are: `created_at, follower_count, member_count, private, description, owner_id`.
* user_fields : `Optional` - `Enum` - This fields parameter enables you to select which specific user fields will deliver with the users object. Specify the desired fields in a comma-separated list without spaces between commas and fields. The user fields will only be returned if you have included expansions=owner_id query parameter in your request. You will find this ID and all additional user fields in the included data object. Valid values for this parameter are: `created_at, description, entities, id, location, name, pinned_tweet_id, profile_image_url, protected, public_metrics, url, username, verified, withheld`.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getListsMemberships operation.

**Sample Request for getListsMemberships**
```json
{
   "accessToken":"MFpJRmFlbGJTZHVDdkNIbDN4WURTYTFiUmZtRV9HckdsUmlmd1ZxVjRvWHVUOjE2ODY1NDIwMjM5MTk6MTowOmF0OjE",
   "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
   "id":"1655515285577936899",
   "expansions":"owner_id",
   "max_results":10,
   "list_fields":"description",
   "user_fields":"created_at,username,id,name"
}
```

**Sample Response**

```json
{
   "data": [
      {
         "description": "list for editing and testing",
         "id": "1667130158023860224",
         "name": "test listss",
         "owner_id": "1655515285577936899"
      }
   ],
   "includes": {
      "users": [
         {
            "id": "1655515285577936899",
            "name": "GrawKraken",
            "username": "GrawKraken",
            "created_at": "2023-05-08T10:09:55.000Z"
         }
      ]
   },
   "meta": {
      "result_count": 1
   }
}
```

**Related Twitter documentation**
https://developer.twitter.com/en/docs/twitter-api/lists/list-members/api-reference/get-users-id-list_memberships

#### Sample configuration

Following is a sample proxy service that illustrates how to connect to Twitter with the init operation and use the getListById operation. The sample request for this proxy can be found in getListById sample request. You can use this sample as a template for using other operations in this category.
1. Create a sample proxy as below :

    **Sample Proxy**
    ```xml
   <proxy xmlns="http://ws.apache.org/ns/synapse"
          name="getListById"
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
            <property name="list_fields" expression="json-eval($.list_fields)"/>
            <property name="user_fields" expression="json-eval($.user_fields)"/>
            <twitter.init>
               <clientId>{$ctx:clientId}</clientId>
               <accessToken>{$ctx:accessToken}</accessToken>
            </twitter.init>
            <twitter.getListById>
                <id>{$ctx:id}</id>
                <expansions>{$ctx:expansions}</expansions>
                <list_fields>{$ctx:list_fields}</list_fields>
                <user_fields>{$ctx:user_fields}</user_fields>
            </twitter.getListById>
            <respond/>
         </inSequence>
         <outSequence>
            <send/>
         </outSequence>
      </target>
      <description/>
   </proxy>
    
    ```
   2. Create a json file named getListById.json and copy the configurations given below to it:

       ```json
      {
      "accessToken":"MFpJRmFlbGJTZHVDdkNIbDN4WURTYTFiUmZtRV9HckdsUmlmd1ZxVjRvWHVUOjE2ODY1NDIwMjM5MTk6MTowOmF0OjE",
      "clientId":"ZW82OS1rYkJnOEhmUUpjSDNnS246MTpjaQ",
      "id":"1667124005638397955",
      "expansions":"owner_id",
      "list_fields":"description",
      "user_fields":"created_at,username,id,name"
      }
    ```
3. Replace the credentials with your values.

4. Execute the following curl command:

    ```bash
    curl -X POST http://localhost:8280/services/getListById --header 'Content-Type: application/json' -d @getListById.json
    ```

5. Twitter returns a json response similar to the one shown below:
 
```json
{
   "data": {
      "id": "1667124005638397955",
      "name": "test list",
      "owner_id": "1655515285577936899"
   },
   "includes": {
      "users": [
         {
            "id": "1655515285577936899",
            "name": "GrawKraken",
            "username": "GrawKraken"
         }
      ]
   }
}
```
