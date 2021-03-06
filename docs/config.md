# Configuring Twitter Connector Operations

[[Prerequisites]](#Prerequisites) [[Initializing the connector]](#initializing-the-connector)

## Prerequisites

> NOTE: This connector uses application user authentication.

To use the Twitter API, you need the consumerKey, consumerSecret , accessToken and accessTokenSecret that is generated by registering an application at https://dev.twitter.com/apps with the Access permission level as Read, write, and direct messages.

To use the Twitter connector, add the <twitter.init> element in your configuration before carrying out any other Twitter operations.

## Initializing the Connector
Specify the init method as follows:

**init**
```xml
<twitter.init>
    <consumerKey>{$ctx:consumerKey}</consumerKey>
    <consumerSecret>{$ctx:consumerSecret}</consumerSecret>
    <accessToken>{$ctx:accessToken}</accessToken>
    <accessTokenSecret>{$ctx:accessTokenSecret}</accessTokenSecret>
</twitter.init>
```
**Properties**
* consumerKey: The consumer key of the Twitter account.
* consumerSecret: The consumer secret of the Twitter account.
* accessToken: The access token of the Twitter account.
* accessTokenSecret: The access token secret of the Twitter account.

Now that you have connected to Twitter, use the information in the following topics to perform various operations with the connector.

* To work with Twitter Accounts, See [Working with Accounts in Twitter](account.md)
* To work with Twitter Blocking, See [Working with Blocking in Twitter](blocks.md)
* To work with Twitter Direct Messages, See [Working with Direct Messages in Twitter](message.md)
* To work with Twitter Favourites, See [Working with Favorites in Twitter](favorite.md)
* To work with Twitter Friends and Followers, See [Working with Friends and Followers in Twitter](friends_and_followers.md)
* To work with Twitter Help, See [Working with Help in Twitter](help.md)
* To work with Twitter Lists, See [Working with Lists in Twitter](list.md)
* To work with Twitter Search, See [Working with Search in Twitter](search.md)
* To work with Twitter Statuses, See [Working with Statuses in Twitter](status.md)
* To work with Twitter Trends, See [Working with Trends in Twitter](trend.md)
* To work with Twitter Tweets, See [Working with Tweets in Twitter](tweet.md)
* To work with Twitter Users, See [Working with Users in Twitter](user.md)
