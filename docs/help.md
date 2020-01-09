# Working with Help in Twitter

[[  Overview ]](#overview)  [[ Operation details ]](#operation-details)  [[  Sample configuration  ]](#sample-configuration)

### Overview 

The following operations allow you to work with help in Twitter. Click an operation name to see details on how to use it.
For a sample proxy service that illustrates how to work with help, see [Sample configuration](#sample-configuration).

| Operation        | Description |
| ------------- |-------------|
| [getApplicationRateLimitStatus](#Retrieving-rate-limit-status)    | Retrieves the current rate limits. |
| [getHelpConfiguration](#Retrieving-the-current-configuration)      | Retrieves the current configuration. |
| [getHelpLanguages](#Retrieving-supported-languages)      | Retrieves the list of languages supported. |
| [getHelpPrivacy](#Retrieving-Twitter's-privacy-policy)      | Retrieves Twitter’s privacy policy.|
| [getHelpTos](#Retrieving-Twitter's-terms-of-service)      | Retrieves the Twitter terms of service.|

### Operation details

This section provides further details on the operations.

#### Retrieving rate limit status
The getApplicationRateLimitStatus operation retrieves the current rate limits for methods belonging to the specified resource families.

**getApplicationRateLimitStatus**
```xml
<twitter.getApplicationRateLimitStatus>
    <resources>{$ctx:resources}</resources>
 </twitter.getApplicationRateLimitStatus>
```

**Properties**
* resources:A comma separated list of resource families for which you want to retrieve the current rate limit disposition.

**Sample request**

Following is a sample REST/JSON request that can be handled by the getApplicationRateLimitStatus operation.

**Sample Request for getApplicationRateLimitStatus**
```json
{
  "consumerKey":"KCHme1tyBln7L9E0zVte1PzFs",
  "consumerSecret":"zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a",
  "accessToken":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz",
  "accessTokenSecret":"56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU"
  "resources":"friends"
}
```

**Sample Response**

```json
{
    "rate_limit_context": {
        "access_token": "3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz"
    },
    "resources": {
        "friends": {
            "/friends/following/ids": {
                "limit": 15,
                "remaining": 15,
                "reset": 1557378650
            },
            "/friends/following/list": {
                "limit": 15,
                "remaining": 15,
                "reset": 1557378650
            },
            "/friends/list": {
                "limit": 15,
                "remaining": 15,
                "reset": 1557378650
            },
            "/friends/ids": {
                "limit": 15,
                "remaining": 15,
                "reset": 1557378650
            }
        }
    }
}
```

**Related Twitter documentation**

https://dev.twitter.com/rest/reference/get/application/rate_limit_status

####  Retrieving the current configuration

The getHelpConfiguration operation retrieves the current configuration used by Twitter including twitter.com slugs that are not usernames, maximum photo resolutions, and URL lengths.

**getHelpConfiguration**
```xml
<twitter.getHelpConfiguration/>
```

**Sample request**

Following is a sample REST/JSON request that can be handled by the getBlocksList operation.

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
    "dm_text_character_limit": 10000,
    "characters_reserved_per_media": 24,
    "max_media_per_upload": 1,
    "non_username_paths": [
        "about",
        "account",
        "accounts",
        "activity",
        "all",
        "announcements",
        "anywhere",
        "api_rules",
        "api_terms",
        "apirules",
        "apps",
        "auth",
        "badges",
        "blog",
        "business",
        "buttons",
        "contacts",
        "devices",
        "direct_messages",
        "download",
        "downloads",
        "edit_announcements",
        "faq",
        "favorites",
        "find_sources",
        "find_users",
        "followers",
        "following",
        "friend_request",
        "friendrequest",
        "friends",
        "goodies",
        "help",
        "home",
        "i",
        "im_account",
        "inbox",
        "invitations",
        "invite",
        "jobs",
        "list",
        "login",
        "logo",
        "logout",
        "me",
        "mentions",
        "messages",
        "mockview",
        "newtwitter",
        "notifications",
        "nudge",
        "oauth",
        "phoenix_search",
        "positions",
        "privacy",
        "public_timeline",
        "related_tweets",
        "replies",
        "retweeted_of_mine",
        "retweets",
        "retweets_by_others",
        "rules",
        "saved_searches",
        "search",
        "sent",
        "sessions",
        "settings",
        "share",
        "signup",
        "signin",
        "similar_to",
        "statistics",
        "terms",
        "tos",
        "translate",
        "trends",
        "tweetbutton",
        "twttr",
        "update_discoverability",
        "users",
        "welcome",
        "who_to_follow",
        "widgets",
        "zendesk_auth",
        "media_signup"
    ],
    "photo_size_limit": 3145728,
    "photo_sizes": {
        "thumb": {
            "h": 150,
            "resize": "crop",
            "w": 150
        },
        "small": {
            "h": 480,
            "resize": "fit",
            "w": 340
        },
        "medium": {
            "h": 1200,
            "resize": "fit",
            "w": 600
        },
        "large": {
            "h": 2048,
            "resize": "fit",
            "w": 1024
        }
    },
    "short_url_length": 23,
    "short_url_length_https": 23
}

```
**Related Twitter documentation**

https://dev.twitter.com/rest/reference/get/help/configuration

####  Retrieving supported languages

The getHelpLanguages operation retrieves the list of languages supported by Twitter along with the language code supported by Twitter.

**getHelpLanguages**
```xml
<twitter.getHelpLanguages/>
```

**Sample request**

Following is a sample REST/JSON request that can be handled by the getHelpPrivacy operation.

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
[
    {
        "code": "fr",
        "name": "French",
        "local_name": "français",
        "status": "production",
        "debug": false
    },
    {
        "code": "en",
        "name": "English",
        "local_name": "English",
        "status": "production",
        "debug": false
    },
    {
        "code": "ar",
        "name": "Arabic",
        "local_name": "العربية",
        "status": "production",
        "debug": false
    },
    {
        "code": "ja",
        "name": "Japanese",
        "local_name": "日本語",
        "status": "production",
        "debug": false
    },
    {
        "code": "es",
        "name": "Spanish",
        "local_name": "español",
        "status": "production",
        "debug": false
    },
    {
        "code": "de",
        "name": "German",
        "local_name": "Deutsch",
        "status": "production",
        "debug": false
    },
    {
        "code": "it",
        "name": "Italian",
        "local_name": "italiano",
        "status": "production",
        "debug": false
    },
    {
        "code": "id",
        "name": "Indonesian",
        "local_name": "Indonesia",
        "status": "production",
        "debug": false
    },
    {
        "code": "pt",
        "name": "Portuguese",
        "local_name": "português",
        "status": "production",
        "debug": false
    },
    {
        "code": "ko",
        "name": "Korean",
        "local_name": "한국어",
        "status": "production",
        "debug": false
    },
    {
        "code": "tr",
        "name": "Turkish",
        "local_name": "Türkçe",
        "status": "production",
        "debug": false
    },
    {
        "code": "ru",
        "name": "Russian",
        "local_name": "русский",
        "status": "production",
        "debug": false
    },
    {
        "code": "nl",
        "name": "Dutch",
        "local_name": "Nederlands",
        "status": "production",
        "debug": false
    },
    {
        "code": "fil",
        "name": "Filipino",
        "local_name": "Filipino",
        "status": "production",
        "debug": false
    },
    {
        "code": "msa",
        "name": "Malay",
        "local_name": "Melayu",
        "status": "production",
        "debug": false
    },
    {
        "code": "zh-tw",
        "name": "Traditional Chinese",
        "local_name": "繁體中文",
        "status": "production",
        "debug": false
    },
    {
        "code": "zh-cn",
        "name": "Simplified Chinese",
        "local_name": "简体中文",
        "status": "production",
        "debug": false
    },
    {
        "code": "hi",
        "name": "Hindi",
        "local_name": "हिन्दी",
        "status": "production",
        "debug": false
    },
    {
        "code": "no",
        "name": "Norwegian",
        "local_name": "norsk",
        "status": "production",
        "debug": false
    },
    {
        "code": "sv",
        "name": "Swedish",
        "local_name": "svenska",
        "status": "production",
        "debug": false
    },
    {
        "code": "fi",
        "name": "Finnish",
        "local_name": "suomi",
        "status": "production",
        "debug": false
    },
    {
        "code": "da",
        "name": "Danish",
        "local_name": "dansk",
        "status": "production",
        "debug": false
    },
    {
        "code": "pl",
        "name": "Polish",
        "local_name": "polski",
        "status": "production",
        "debug": false
    },
    {
        "code": "hu",
        "name": "Hungarian",
        "local_name": "magyar",
        "status": "production",
        "debug": false
    },
    {
        "code": "fa",
        "name": "Persian",
        "local_name": "فارسی",
        "status": "production",
        "debug": false
    },
    {
        "code": "he",
        "name": "Hebrew",
        "local_name": "עברית",
        "status": "production",
        "debug": false
    },
    {
        "code": "ur",
        "name": "Urdu",
        "local_name": "اردو",
        "status": "beta",
        "debug": false
    },
    {
        "code": "th",
        "name": "Thai",
        "local_name": "ไทย",
        "status": "production",
        "debug": false
    },
    {
        "code": "uk",
        "name": "Ukrainian",
        "local_name": "українська",
        "status": "production",
        "debug": false
    },
    {
        "code": "ca",
        "name": "Catalan",
        "local_name": "català",
        "status": "production",
        "debug": false
    },
    {
        "code": "ga",
        "name": "Irish",
        "local_name": "Gaeilge",
        "status": "beta",
        "debug": false
    },
    {
        "code": "el",
        "name": "Greek",
        "local_name": "Ελληνικά",
        "status": "production",
        "debug": false
    },
    {
        "code": "eu",
        "name": "Basque",
        "local_name": "euskara",
        "status": "beta",
        "debug": false
    },
    {
        "code": "cs",
        "name": "Czech",
        "local_name": "čeština",
        "status": "production",
        "debug": false
    },
    {
        "code": "gl",
        "name": "Galician",
        "local_name": "galego",
        "status": "beta",
        "debug": false
    },
    {
        "code": "ro",
        "name": "Romanian",
        "local_name": "română",
        "status": "production",
        "debug": false
    },
    {
        "code": "hr",
        "name": "Croatian",
        "local_name": "hrvatski",
        "status": "production",
        "debug": false
    },
    {
        "code": "en-gb",
        "name": "British English",
        "local_name": "British English",
        "status": "production",
        "debug": false
    },
    {
        "code": "vi",
        "name": "Vietnamese",
        "local_name": "Tiếng Việt",
        "status": "production",
        "debug": false
    },
    {
        "code": "bn",
        "name": "Bangla",
        "local_name": "বাংলা",
        "status": "production",
        "debug": false
    },
    {
        "code": "bg",
        "name": "Bulgarian",
        "local_name": "български",
        "status": "production",
        "debug": false
    },
    {
        "code": "sr",
        "name": "Serbian",
        "local_name": "српски",
        "status": "production",
        "debug": false
    },
    {
        "code": "sk",
        "name": "Slovak",
        "local_name": "slovenčina",
        "status": "production",
        "debug": false
    },
    {
        "code": "gu",
        "name": "Gujarati",
        "local_name": "ગુજરાતી",
        "status": "production",
        "debug": false
    },
    {
        "code": "mr",
        "name": "Marathi",
        "local_name": "मराठी",
        "status": "production",
        "debug": false
    },
    {
        "code": "ta",
        "name": "Tamil",
        "local_name": "தமிழ்",
        "status": "production",
        "debug": false
    },
    {
        "code": "kn",
        "name": "Kannada",
        "local_name": "ಕನ್ನಡ",
        "status": "production",
        "debug": false
    }
]
```


**Related Twitter documentation**

https://dev.twitter.com/rest/reference/get/help/languages

####  Retrieving Twitter's privacy policy

The getHelpPrivacy operation retrieves Twitter’s privacy policy.

**getHelpPrivacy**
```xml
<twitter.getHelpPrivacy/>
```

**Sample request**

Following is a sample REST/JSON request that can be handled by the getHelpPrivacy operation.

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
    "privacy": "We have made revisions to this Privacy Policy, effective June 18th, 2017. You can see the new Privacy Policy here. By continuing to use our services after June 18th, you agree to this new Privacy Policy. A summary of changes can be found on our Help Center.\n\nTwitter Privacy Policy\nOur Services instantly connect people everywhere to what's most meaningful to them. For example, any registered user of Twitter can send a Tweet, which is public by default, and can include a message of 140 characters or less and content like photos, videos, and links to other websites.\n\n\nWhat you share on Twitter may be viewed all around the world instantly. You are what you Tweet!\n\nThis Privacy Policy describes how and when we collect, use and share your information across our websites, SMS, APIs, email notifications, applications, buttons, widgets, ads, commerce services, and our other covered services that link to this Policy (collectively, the \"Services\"), and from our partners and other third parties. For example, you send us information when you use our Services on the web, via SMS, or from an application such as Twitter for Mac, Twitter for Android or TweetDeck. When using any of our Services you consent to the collection, transfer, storage, disclosure, and use of your information as described in this Privacy Policy. This includes any information you choose to provide that is deemed sensitive under applicable law.\n\nWhen this policy mentions \"we\" or \"us,\" it refers to the controller of your information under this policy. If you live in the United States, your information is controlled by Twitter, Inc., 1355 Market Street, Suite 900, San Francisco, CA 94103 U.S.A. If you live outside the United States, the data controller responsible for your information is Twitter International Company, an Irish company with its registered office at The Academy, 42 Pearse Street, Dublin 2, Ireland. Despite this, you alone control and are responsible for the posting of your Tweets and other content you submit through the Services, as provided in the Terms of Service and Twitter Rules.\n\nIrrespective of which country you live in, you authorize us to transfer, store, and use your information in the United States, Ireland, and any other country where we operate. In some of these countries, the privacy and data protection laws and rules regarding when government authorities may access data may vary from those in the country where you live.\n\nIf you have any questions or comments about this Privacy Policy, please submit a request through our form, available at https://support.twitter.com/forms/privacy.\nInformation Collection and Use\n\n\nWe collect and use your information below to provide, understand, and improve our Services.\n\nBasic Account Information: If you choose to create a Twitter account, you must provide us with some personal information, such as your name, username, password, email address, or phone number. On Twitter, your name and username are listed publicly, including on your profile page and in search results, and you can use either your real name or a pseudonym. You can create and manage multiple Twitter accounts. If you use Digits by Twitter, the contact information you provide to log in is not public. Some of our product features, such as searching and viewing public Twitter user profiles or watching a Periscope broadcast on Twitter, do not require you to create an account.\nContact Information: You may use your contact information, such as your email address or phone number, to customize your account or enable certain account features, for example, for login verification or Twitter via SMS. If you provide us with your phone number, you agree to receive text messages to that number from us. We may use your contact information to send you information about our Services, to market to you, to help prevent spam, fraud, or abuse, and to help others find your account, including through third-party services and client applications. You may use your settings for email and mobile notifications to control notifications you receive from Twitter. You may also unsubscribe from a notification by following the instructions contained within the notification or the instructions on our website. Your Discoverability privacy settings control whether others can find you on Twitter by your email address or phone number.\nAdditional Information: You may choose to provide us with additional information to help improve and personalize your experience across our Services. For example, you may choose to upload and sync your address book so that we can help you find and connect with users you know or help other users find and connect with you. We may later tailor content, such as making suggestions or showing user accounts and Tweets for you and other users, based on imported address book contacts. You can delete your imported address book contacts at any time by visiting your Contacts Dashboard in your privacy settings. If you email us, we may keep your message, email address and contact information to respond to your request. If you connect your account on our Services to your account on another service in order to cross-post between our Services and that service, the other service may send us your registration or profile information on that service and other information that you authorize. This information enables cross-posting, helps us improve the Services, and is deleted from our Services within a few weeks of your disconnecting from our Services your account on the other service.\nTweets, Following, Lists, Profile, and other Public Information: Twitter is primarily designed to help you share information with the world. Most of the information you provide us through Twitter is information you are asking us to make public. You may provide us with profile information to make public on Twitter, such as a short biography, your location, your website, date of birth, or a picture. Additionally, your public information includes the messages you Tweet; the metadata provided with Tweets, such as when you Tweeted and the client application you used to Tweet; information about your account, such as creation time, language, country, and time zone; and the lists you create, people you follow, and Tweets you Like or Retweet. Twitter broadly and instantly disseminates your public information to a wide range of users, customers, and services, including search engines, developers, and publishers that integrate Twitter content into their services, and organizations such as universities, public health agencies, and market research firms that analyze the information for trends and insights. When you share information or content like photos, videos, and links via the Services, you should think carefully about what you are making public. We may use this information to make inferences, like what topics you may be interested in. Our default is almost always to make the information you provide through the Services public for as long as you do not delete it, but we generally give you settings or features, like protected Tweets, to make the information more private if you want. For certain profile information fields we provide you with visibility settings to select who can see this information in your profile. If you provide us with profile information and you don't see a visibility setting, that information is public. You can change the language and time zone associated with your account at any time using your account settings, available at http://twitter.com/settings/account.\nDirect Messages and Non-Public Communications: We provide certain features that allow you to communicate more privately. For example, you can use Direct Messages to have private conversations with other Twitter users. When you privately communicate with others through our Services, such as by sending and receiving Direct Messages, we will store and process your communications, and information related to them. Please note that if you interact with public Twitter content shared with you via Direct Message, for instance by liking a Tweet shared via Direct Message, those interactions may be public. While features like Direct Messages are intended to be private, please remember that recipients may copy, store, and re-share the contents of your communications.\nLocation Information: We may receive information about your location. For example, you may choose to publish your location in your Tweets and in your Twitter profile. You may also tell us your location when you set your trend location on Twitter.com. We may also determine location by using other data from your device, such as precise location information from GPS, information about wireless networks or cell towers near your mobile device, or your IP address. We may use and store information about your location to provide features of our Services, such as Tweeting with your location, and to improve and customize the Services, for example, with more relevant content like local trends, stories, ads, and suggestions for people to follow. Learn more about our use of location here, and how to set your location preferences here.\nLinks:&nbsp;We may keep track of how you interact with links across our Services, including our email notifications, third-party services, and client applications, by redirecting clicks or through other means. We do this to help improve our Services, to provide more relevant advertising, and to be able to share aggregate click statistics such as how many times a particular link was clicked on. Links, Tweets, and non-public communications like Direct Messages shared on the Services will be processed and links shortened to a http://t.co link.\nCookies:&nbsp;Like many websites, we use cookies and similar technologies to collect additional website usage data and to improve our Services, but we do not require cookies for many parts of our Services such as searching and looking at public user profiles. A cookie is a small data file that is transferred to your computer or mobile device. We may use both session cookies and persistent cookies to better understand how you interact with our Services, to monitor aggregate usage by our users and web traffic routing on our Services, and to customize and improve our Services. Although most web browsers automatically accept cookies, some browsers' settings can be modified to decline cookies or alert you when a website is attempting to place a cookie on your computer. However, some Services may not function properly if you disable cookies. We honor the Do Not Track browser option to give you control over how your website visits are used to personalize your Twitter experience and ads. Learn more about our Do Not Track support here, and about how we use cookies and similar technologies here.\nUsing Our Services: We receive information when you interact with our Services, even if you have not created an account (\"Log Data\"). For example, when you visit our websites, sign into our Services, interact with our email notifications, use your account to authenticate to a third-party website, application, or service, or visit a third-party website, application, or service that includes a Twitter button or widget, we may receive information about you. This Log Data may include your IP address, browser type, operating system, the referring web page, pages visited, location, your mobile carrier, device information (including device and application IDs), search terms, or cookie information. We also receive Log Data when you click on, view or interact with links on our Services, including links to third-party applications, such as when you choose to install another application through Twitter. We use Log Data to make inferences, like what topics you may be interested in, and to customize the content we show you, including ads. We keep Log Data as needed for the purposes described in this Privacy Policy. We will either delete Log Data or remove any common account identifiers, such as your username, full IP address, email address, or phone number, after a maximum of 18 months, if not sooner as provided below for Widget Data.\nWidget Data:&nbsp;We may tailor the Services for you based on your visits to third-party websites that integrate Twitter buttons or widgets. When these websites first load our buttons or widgets for display, we receive Log Data that includes the web page you visited and a cookie that identifies your browser (\"Widget Data\"). After a maximum of 10 days, we start the process of deleting, de-identifying, or aggregating Widget Data, which is usually instantaneous but in some cases may take up to a week. We may use Widget Data to tailor content for you, such as suggestions for people to follow and other content you may be interested in. Tailored content is stored separately from other Widget Data such as page-visit information. You can control this feature from the Personalization Setting within your Privacy Settings, available at https://twitter.com/settings/safety.\nCommerce Services:&nbsp;You may provide your payment information, including your credit or debit card number, card expiration date, CVV code, and billing address (collectively, \"Payment Information\"), along with your shipping address, to complete a commerce transaction through our Services. To facilitate future purchases, we store your Payment Information (excluding CVV code) and shipping address, which you can remove from your account at any time using your account settings. We consider your Payment Information and shipping address private and do not make such information public. To facilitate order fulfillment, we collect and store information created by your purchases made through our Services (\"Transaction Data\"). Transaction Data may include the merchant's name and the date, time, and amount of the transaction.\nAdvertising: Our Services are supported by advertising. We may use the information described in this Privacy Policy to help make our advertising more relevant to you, to measure its effectiveness and to help recognize your devices to serve you ads on and off of Twitter. For example, when you interact with content in the Twitter for Android app, we may show content (including ads) about those same topics when you use Twitter on the web. We do not use the content you share privately in Direct Messages to serve you ads. Our Twitter Ads Policy also prohibits advertisers from targeting ads based on categories we consider sensitive, such as race, religion, politics, sex life, or health. If you prefer, you can uncheck the Promoted Content setting within your Privacy Settings so that your account will not be matched to information collected by ad partners, or by us directly on those partners' websites or apps, to tailor ads to you. Learn more about your privacy options for tailored ads here and about how ads work on our Services here.\nThird-Parties and Affiliates:&nbsp;We may receive information about you from third parties, such as other Twitter users, partners (including ad partners), or our corporate affiliates. For example, other users may share or disclose information about you, such as when they mention you, share a photo of you, or tag you in a photo. Your privacy settings control who can tag you in a photo. Our ad partners and affiliates may share information with us such as a browser cookie ID, mobile device ID, or cryptographic hash of a common account identifier (such as an email address), as well as demographic or interest data and content viewed or actions taken on a website or app. Our ad partners, particularly our advertisers, may enable us to collect similar information directly from their website or app by integrating our advertising technology.\nInformation Sharing and Disclosure\n\nWe do not disclose your private personal information except in the limited circumstances described here.\n\nUser Consent or Direction:&nbsp;We may share or disclose your information at your direction, such as when you authorize a third-party web client or application to access your account or when you direct us to share your feedback with a business. When you use Digits by Twitter to sign up for or log in to a third-party application, you are directing us to share your contact information, such as your phone number, with that application. If you've shared information, like Direct Messages or protected Tweets, with another user who accesses Twitter through a third-party service, keep in mind that the information may be shared with the third-party service.\nService Providers:&nbsp;We engage service providers to perform functions and provide services to us in the United States, Ireland, and other countries. For example, we use a variety of third-party services to help provide our Services, such as hosting our various blogs and wikis, and to help us understand and improve the use of our Services, such as Google Analytics. We may share your private personal information with such service providers subject to obligations consistent with this Privacy Policy and any other appropriate confidentiality and security measures, and on the condition that the third parties use your private personal data only on our behalf and pursuant to our instructions. We share your Payment Information with payment services providers to process payments; prevent, detect and investigate fraud or other prohibited activities; facilitate dispute resolution such as chargebacks or refunds; and for other purposes associated with the acceptance of credit or debit cards.\nCommerce Transactions:&nbsp;If you make a payment as part of a commerce transaction through our Services, we may provide the seller, commerce provider, marketplace, or charity with your name, email address, shipping address, Payment Information and Transaction Data to facilitate payment processing, order fulfillment, and dispute resolution (including payment and shipping disputes) and to help prevent, detect, and investigate fraud or other prohibited activities. Please refer to these third parties' privacy policies for information about their privacy practices.\nLaw and Harm:&nbsp;Notwithstanding anything to the contrary in this Privacy Policy, we may preserve or disclose your information if we believe that it is reasonably necessary to comply with a law, regulation, legal process, or governmental request; to protect the safety of any person; to address fraud, security or technical issues; or to protect our or our users' rights or property. However, nothing in this Privacy Policy is intended to limit any legal defenses or objections that you may have to a third party's, including a government's, request to disclose your information.\nBusiness Transfers and Affiliates: In the event that we are involved in a bankruptcy, merger, acquisition, reorganization or sale of assets, your information may be sold or transferred as part of that transaction. This Privacy Policy will apply to your information as transferred to the new entity. We may also disclose information about you to our corporate affiliates in order to help provide, understand, and improve our Services and our affiliates' services, including the delivery of ads.\nPublic or Non-Personal Information:&nbsp;We may share or disclose your public, aggregated or otherwise non-personal information, such as your public user profile information, public Tweets, the people you follow or that follow you, the number of times people engaged with a Tweet (for example, the number of users who clicked on a particular link or voted on a poll in a Tweet, even if only one did), or reports to advertisers about unique users who saw or clicked on their ads after we have removed any private personal information (such as your name or contact information). Remember: your privacy and visibility settings control whether your Tweets and certain profile information are made public. Other information, like your name and username, is always public on Twitter, unless you delete your account, as described below.\nAccessing and Modifying Your Personal Information\nIf you are a registered user of our Services, we provide you with tools and account settings to access, correct, delete, or modify the personal information you provided to us and associated with your account. You can download certain account information, including your Tweets, by following the instructions here and request access to additional information here.\nYou can also permanently delete your Twitter account. If you follow the instructions here, your account will be deactivated and then deleted.&nbsp;When deactivated, your account, including your name, username, and public profile, is not viewable on Twitter.com. For up to 30 days after deactivation it is still possible to restore your account if it was accidentally or wrongfully deactivated. Absent a separate arrangement between you and us to extend your deactivation period, after 30 days, we begin the process of deleting your account from our systems, which can take up to a week.\nKeep in mind that search engines and other third parties may still retain copies of your public information, like your user profile information and public Tweets, even after you have deleted the information from the Twitter Services or deactivated your account. Learn more here.\nOur Global Operations\nTo bring you the Services, we operate globally. Twitter, Inc. complies with the EU-US Privacy Shield principles (the \"Principles\") regarding the collection, use, sharing, and retention of personal information from the European Union, as described in our Privacy Shield certification.\n\nIf you have a Privacy Shield-related complaint, please contact us here. As part of our participation in Privacy Shield, if you have a dispute with us about our adherence to the Principles, we will seek to resolve it through our internal complaint resolution process, alternatively through the independent dispute resolution body JAMS, and under certain conditions, through the Privacy Shield arbitration process.\n\nPrivacy Shield participants are subject to the investigatory and enforcement powers of the US Federal Trade Commission and other authorized statutory bodies. Under certain circumstances, participants may be liable for the transfer of personal information from the EU to third parties outside the EU. Learn more about Privacy Shield here.\n\nAs described in this Privacy Policy, we may share information with our corporate affiliates and third parties and may be required to disclose information in response to valid governmental requests, including under applicable law enforcement or national security requirements. Learn more about our global operations and data transfer here.\n\nTwitter, Inc. also complies with the US-Swiss Safe Harbor Framework and principles, as described in our certification, and applies the Privacy Shield Principles to information from Switzerland.\nChanges to this Policy\nWe may revise this Privacy Policy from time to time. The most current version of the policy will govern our use of your information and will always be at https://twitter.com/privacy. If we make a change to this policy that, in our sole discretion, is material, we will notify you via an @Twitter update or email to the email address associated with your account. By continuing to access or use the Services after those changes become effective, you agree to be bound by the revised Privacy Policy.\nEffective: September 30, 2016\nArchive of Previous Privacy Policies\nThoughts or questions about this Privacy Policy?&nbsp;Please, let us know by contacting us here or writing to us at the appropriate address below.\n\nFor accounts based in the United States:\nTwitter, Inc.Attn: Privacy Policy Inquiry1355 Market Street, Suite 900San Francisco, CA 94103\n\nFor accounts outside the United States:\nTwitter International CompanyAttn: Privacy Policy InquiryOne Cumberland Place, Fenian StreetDublin 2, D02 AX07 IRELAND\n\n\n\n\n\n\n\nTwitter Privacy Policy\nEffective: June 18, 2017\n\nOur Services instantly connect people everywhere to what's most meaningful to them. For example, any registered user of Twitter can send a Tweet, which is public by default, and can include a message of 140 characters or less and content like photos, videos, and links to other websites.\n\n\nWhat you share on Twitter may be viewed all around the world instantly. You are what you Tweet!\n\nThis Privacy Policy describes how and when we collect, use, and share your information across our websites, SMS, APIs, email notifications, applications, buttons, embeds, ads, and our other covered services that link to this Policy (collectively, the \"Services\"), and from our partners and other third parties. For example, you send us information when you use our Services on the web, via SMS, or from an application such as Twitter for Mac, Twitter for Android, or TweetDeck. When using any of our Services you consent to the collection, transfer, storage, disclosure, and use of your information as described in this Privacy Policy. This includes any information you choose to provide that is deemed sensitive under applicable law.\n\nWhen this policy mentions \"we\" or \"us,\" it refers to the controller of your information under this policy. If you live in the United States, your information is controlled by Twitter, Inc., 1355 Market Street, Suite 900, San Francisco, CA 94103 U.S.A. If you live outside the United States, the data controller responsible for your information is Twitter International Company, an Irish company with its registered office at One Cumberland Place, Fenian Street, Dublin 2 D02 AX07 Ireland. Despite this, you alone control and are responsible for the posting of your Tweets and other content you submit through the Services, as provided in the Terms of Service and Twitter Rules.\n\nIrrespective of which country you live in, you authorize us to transfer, store, and use your information in the United States, Ireland, and any other country where we operate. In some of these countries, the privacy and data protection laws and rules regarding when government authorities may access data may vary from those in the country where you live. Learn more about our global operations and data transfer here.\n\nIf you have any questions or comments about this Privacy Policy, please submit a request through our form, available at https://support.twitter.com/forms/privacy.\nInformation Collection and Use\n\n\nWe collect and use your information below to provide, understand, and improve our Services.\n\nBasic Account Information: If you choose to create a Twitter account, you must provide us with some personal information, such as your name, username, password, email address, or phone number. On Twitter, your name and username are always listed publicly, including on your profile page and in search results, and you can use either your real name or a pseudonym. You can create and manage multiple Twitter accounts. If you use Digits by Twitter, the contact information you provide to log in is not public.&nbsp;Some of our product features, such as searching and viewing public Twitter user profiles or watching a broadcast on Periscope's website, do not require you to create an account.\nContact Information: You may use your contact information, such as your email address or phone number, to customize your account or enable certain account features, for example, for login verification or Twitter via SMS. If you provide us with your phone number, you agree to receive text messages to that number from us. We may use your contact information to send you information about our Services, to market to you, to help prevent spam, fraud, or abuse, and to help others find your account, including through third-party services and client applications. You may use your settings for email and mobile notifications to control notifications you receive from Twitter. You may also unsubscribe from a notification by following the instructions contained within the notification or the instructions on our website. Your Discoverability privacy settings control whether others can find you on Twitter by your email address or phone number.\nAdditional Information:&nbsp;You may choose to provide us with additional information to help improve and personalize your experience across our Services. For example, you may choose to upload and sync your address book so that we can help you find and connect with users you know or help other users find and connect with you. We may later personalize content, such as making suggestions or showing user accounts and Tweets for you and other users, based on imported address book contacts. You can delete your imported address book contacts at any time by visiting your Contacts Dashboard at https://twitter.com/settings/contacts_dashboard. If you email us, we may keep your message, email address, and contact information to respond to your request. If you connect your account on our Services to your account on another service, the other service may send us information that you authorize for use in the Services. This information may enable cross-posting or otherwise help us improve the Services, and is deleted from our Services within a few weeks of your disconnecting from our Services your account on the other service.\nTweets, Following, Lists, Profile, and Other Public Information:&nbsp;Twitter is primarily designed to help you share information with the world. Most of the information you provide us through Twitter is information you are asking us to make public. You may provide us with profile information such as a short biography, your location, your website, date of birth, or a picture. Additionally, your public information includes the messages you Tweet; the metadata provided with Tweets, such as when you Tweeted and the client application you used to Tweet; information about your account, such as creation time, language, country, and time zone; and the lists you create, people you follow, Tweets you Like or Retweet, and Periscope broadcasts you click or otherwise engage with (such as by commenting or hearting) on Twitter. Twitter broadly and instantly disseminates your public information to a wide range of users, customers, and services, including search engines, developers, and publishers that integrate Twitter content into their services, and organizations such as universities, public health agencies, and market research firms that analyze the information for trends and insights. When you share information or content like photos, videos, and links via the Services, you should think carefully about what you are making public. We may use this information to make inferences, like what topics you may be interested in. Our default is almost always to make the information you provide through the Services public for as long as you do not delete it, but we generally give you settings or features, like protected Tweets, to make the information more private if you want. For certain profile information fields we provide you with visibility settings to select who can see this information in your profile. If you provide us with profile information and you don't see a visibility setting, that information is public. You can change the language and time zone associated with your account at any time using your account settings, available at https://twitter.com/settings/account.\nDirect Messages and Non-Public Communications: We provide certain features that allow you to communicate more privately. For example, you can use Direct Messages to have private conversations with other Twitter users. When you privately communicate with others through our Services, such as by sending and receiving Direct Messages, we will store and process your communications, and information related to them. Please note that if you interact with public Twitter content shared with you via Direct Message, for instance by liking a Tweet shared via Direct Message, those interactions may be public.&nbsp;When you use features like Direct Messages to communicate privately, please remember that recipients may copy, store, and re-share the contents of your communications.\nLocation Information: We may receive information about your location. For example, you may choose to publish your location in your Tweets and in your Twitter profile. You may also tell us your location when you set your trend location on Twitter.com. We may also determine location by using other data from your device, such as precise location information from GPS, information about wireless networks or cell towers near your mobile device, or your IP address. We may use and store information about your location to provide features of our Services, such as allowing you to Tweet with your location, and to improve and customize the Services, for example, with more relevant content like local trends, stories, ads, and suggestions for people to follow.&nbsp;Learn more about our use of location here, and how to set your location preferences here.\nLinks:&nbsp;We may keep track of how you interact with links across our Services, including our email notifications, third-party services, and client applications, by redirecting clicks or through other means. We do this to help improve our Services, to provide more relevant advertising, and to be able to share aggregate click statistics such as how many times a particular link was clicked on. Links, Tweets, and non-public communications like Direct Messages shared on the Services will be processed and links shortened to a http://t.co link.\nCookies:&nbsp;Like many websites, we use cookies and similar technologies to collect additional website usage data and to improve our Services, but we do not require cookies for many parts of our Services such as searching and looking at public user profiles. A cookie is a small data file that is transferred to your computer or mobile device. We may use both session cookies and persistent cookies to better understand how you interact with our Services, to monitor aggregate usage by our users and web traffic routing on our Services, and to customize and improve our Services. Although most web browsers automatically accept cookies, some browsers' settings can be modified to decline cookies or alert you when a website is attempting to place a cookie on your computer. However, some Services may not function properly if you disable cookies.&nbsp;You can control how we personalize your Twitter experience and ads by using your Personalization and Data settings, which are available at https://twitter.com/personalization whether or not you have a Twitter account. We respond to these settings rather than the Do Not Track browser option, which we no longer support.&nbsp;Learn more about how we use cookies and similar technologies here.\nUsing Our Services:&nbsp;We receive information when you view content on or otherwise interact with our Services, even if you have not created an account (\"Log Data\"). For example, when you visit our websites, sign into our Services, interact with our email notifications, use your account to authenticate to a third-party website, application, or service, or visit a third-party website, application, or service that includes Twitter content, we may receive information about you. This Log Data may include your IP address, browser type, operating system, the referring web page, pages visited, location, your mobile carrier, device information (including device and application IDs), search terms, or cookie information. We also receive Log Data when you click on, view or interact with links on our Services, including links to third-party applications, such as when you choose to install another application through Twitter. We use Log Data to make inferences, like what topics you may be interested in, and to customize the content we show you, including ads. You can learn about the interests we have inferred about you from your activity on and off of Twitter in Your Twitter Data, available at https://twitter.com/your_twitter_data. We keep Log Data as needed for the purposes described in this Privacy Policy. We will either delete Log Data or remove any common account identifiers, such as your username, full IP address, email address, or phone number, after a maximum of 18 months, if not sooner.\n\nTwitter for Web Data:&nbsp;We may personalize the Services for you based on your visits to third-party websites that integrate Twitter content such as embedded timelines or Tweet buttons. When you view our content on these websites, we may receive Log Data that includes the web page you visited. We never associate this web browsing history with your name, email address, phone number, or Twitter handle, and we delete, obfuscate, or aggregate it after no longer than 30 days. We may use interests or other information that we derive from this data to improve our Services and personalize content for you, such as suggestions for people to follow, advertising, and other content you may be interested in. You can see and control interests that we use to personalize your experience in Your Twitter Data, available at https://twitter.com/your_twitter_data. You can also control whether we keep track of your visits to websites with Twitter content by using your Personalization and Data settings, available at https://twitter.com/personalization.\nAdvertising:&nbsp;Our Services are supported by advertising. We may use the information described in this Privacy Policy to help make our advertising more relevant to you, to measure its effectiveness, and to help recognize your devices to serve you ads on and off of Twitter. We do not use the content you share privately in Direct Messages to serve you ads. Our Twitter Ads Policy also prohibits advertisers from targeting ads based on categories we consider sensitive, such as race, religion, politics, sex life, or health. Twitter adheres to the Digital Advertising Alliance Self-Regulatory Principles for Online Behavioral Advertising (also referred to as \"interest-based advertising\"). If you prefer, you can opt out of interest-based advertising by unchecking Personalize Ads in your Personalization and Data settings, available at https://twitter.com/personalization or through the DAA's consumer choice tool at https://optout.aboutads.info. We will not use information from the browser (and for logged in users, the account) on which you opt out for interest-based advertising, and that browser or account will not be eligible to receive interest-based ads from Twitter. Learn more about your privacy options for interest-based ads here and about how ads work on our Services here.\nThird-Parties and Affiliates:&nbsp;We may receive information about you from third parties, such as other Twitter users, partners (including ad partners), or our corporate affiliates. For example, other users may share or disclose information about you, such as when they mention you, share a photo of you, or tag you in a photo. Your privacy settings control who can tag you in a photo. Our ad partners and affiliates may share information with us such as a browser cookie ID, mobile device ID, or cryptographic hash of an email address, as well as demographic or interest data and content viewed or actions taken on a website or app. Our ad partners, particularly our advertisers, may enable us to collect similar information directly from their website or app by integrating our advertising technology.\nPersonalizing Across Your Devices: When you log into your account with a browser or device, we will associate that browser or device with your account for purposes such as authentication and personalization. Depending on your settings, we may also personalize your experience on, and based on information from, other browsers or devices besides the ones you use to log into Twitter. For example, if you visit websites with sports content on your laptop, we may show you sports-related ads on Twitter for Android. You can control whether we link your account to browsers or devices other than the ones you use to log into Twitter (or if you're logged out, whether we link the browser or device you're currently using to any other devices) through your Personalization and Data settings, available at https://twitter.com/personalization.\n\nInformation Sharing and Disclosure\n\nWe do not disclose your private personal information except in the limited circumstances described here.\n\nUser Consent or Direction:&nbsp;We may share or disclose your information at your direction, such as when you authorize a third-party web client or application to access your account or when you direct us to share your feedback with a business. When you use Digits by Twitter to sign up for or log in to a third-party application, you are directing us to share your contact information, such as your phone number, with that application. If you've shared information, like Direct Messages or protected Tweets, with another user who accesses Twitter through a third-party service, keep in mind that the information may be shared with the third-party service.\nService Providers:&nbsp;We engage service providers to perform functions and provide services to us in the United States, Ireland, and other countries. For example, we use a variety of third-party services to help provide our Services, such as hosting our various blogs and wikis, and to help us understand and improve the use of our Services, such as Google Analytics. We may share your private personal information with such service providers subject to obligations consistent with this Privacy Policy and any other appropriate confidentiality and security measures, and on the condition that the third parties use your private personal data only on our behalf and pursuant to our instructions. We share your payment information, including your credit or debit card number, card expiration date, CVV code, and billing address with payment services providers to process payments; prevent, detect and investigate fraud or other prohibited activities; facilitate dispute resolution such as chargebacks or refunds; and for other purposes associated with the acceptance of credit or debit cards.\nLaw and Harm:&nbsp;Notwithstanding anything to the contrary in this Privacy Policy, we may preserve or disclose your information if we believe that it is reasonably necessary to comply with a law, regulation, legal process, or governmental request; to protect the safety of any person; to address fraud, security or technical issues; or to protect our or our users' rights or property. However, nothing in this Privacy Policy is intended to limit any legal defenses or objections that you may have to a third party's, including a government's, request to disclose your information.\nBusiness Transfers and Affiliates: In the event that we are involved in a bankruptcy, merger, acquisition, reorganization or sale of assets, your information may be sold or transferred as part of that transaction. This Privacy Policy will apply to your information as transferred to the new entity. We may also disclose information about you to our corporate affiliates in order to help provide, understand, and improve our Services and our affiliates' services, including the delivery of ads.\nPublic Information:&nbsp;We may share or disclose your public information, such as your public user profile information, public Tweets, or the people you follow or that follow you. Remember: your privacy and visibility settings control whether your Tweets and certain profile information are made public. Other information, like your name and username, is always public on Twitter, unless you delete your account, as described below.\n\nNon-Personal, Aggregated, or Device-Level Information: We may share or disclose non-personal, aggregated, or device-level information such as the total number of times people engaged with a Tweet, the number of users who clicked on a particular link or voted on a poll in a Tweet (even if only one did), the characteristics of a device or its user when it is available to receive an ad, the topics that people are Tweeting about in a particular location, or aggregated or device-level reports to advertisers about users who saw or clicked on their ads. This information does not include your name, email address, phone number, or Twitter handle. We may, however, share non-personal, aggregated, or device-level information through partnerships with entities that may use data in their possession (including data you may have given them) to link your name, email address, or other personal information to the information we provide them. These partnerships require that they get your consent before doing so. You can control whether Twitter shares your information under these partnerships by using your Personalization and Data settings, available at https://twitter.com/personalization.\nAccessing and Modifying Your Personal Information\nIf you are a registered user of our Services, we provide you with tools and account settings to access, correct, delete, or modify the personal information you provided to us and associated with your account. You can download certain account information, including your Tweets, by following the instructions here.&nbsp;You can learn more about the interests we have inferred about you in Your Twitter Data and request access to additional information here.\nYou can also permanently delete your Twitter account. If you follow the instructions here, your account will be deactivated and then deleted.&nbsp;When deactivated, your account, including your name, username, and public profile, is not viewable on Twitter.com. For up to 30 days after deactivation it is still possible to restore your account if it was accidentally or wrongfully deactivated. Absent a separate arrangement between you and us to extend your deactivation period, after 30 days, we begin the process of deleting your account from our systems, which can take up to a week.\nKeep in mind that search engines and other third parties may still retain copies of your public information, like your user profile information and public Tweets, even after you have deleted the information from the Twitter Services or deactivated your account. Learn more here.\nOur Global Operations\nTo bring you the Services, we operate globally. Twitter, Inc. complies with the EU-US and Swiss-US Privacy Shield principles (the \"Principles\") regarding the collection, use, sharing, and retention of personal information from the European Union and Switzerland, as described in our EU-US Privacy Shield certification and Swiss-US Privacy Shield certification.\n\nIf you have a Privacy Shield-related complaint, please contact us here. As part of our participation in Privacy Shield, if you have a dispute with us about our adherence to the Principles, we will seek to resolve it through our internal complaint resolution process, alternatively through the independent dispute resolution body JAMS, and under certain conditions, through the Privacy Shield arbitration process.\n\nPrivacy Shield participants are subject to the investigatory and enforcement powers of the US Federal Trade Commission and other authorized statutory bodies. Under certain circumstances, participants may be liable for the transfer of personal information from the EU or Switzerland to third parties outside the EU and Switzerland. Learn more about the EU-US Privacy Shield and Swiss-US Privacy Shield here.\nChanges to this Policy\nWe may revise this Privacy Policy from time to time. The most current version of the policy will govern our use of your information and will always be at https://twitter.com/privacy. If we make a change to this policy that, in our sole discretion, is material, we will notify you via an @Twitter update or email to the email address associated with your account. By continuing to access or use the Services after those changes become effective, you agree to be bound by the revised Privacy Policy.\nEffective: June 18, 2017\nArchive of Previous Privacy Policies\nThoughts or questions about this Privacy Policy?&nbsp;Please, let us know by contacting us here or writing to us at the appropriate address below.\n\nFor accounts based in the United States:\nTwitter, Inc.Attn: Privacy Policy Inquiry1355 Market Street, Suite 900San Francisco, CA 94103\n\nFor accounts outside the United States:\nTwitter International CompanyAttn: Privacy Policy InquiryOne Cumberland Place, Fenian StreetDublin 2, D02 AX07 IRELAND"
}
```


**Related Twitter documentation**

https://dev.twitter.com/rest/reference/get/help/privacy

#### Retrieving Twitter's terms of service

The getHelpTos operation retrieves Twitter's terms of service.

**getHelpTos**
```xml
<twitter.getHelpTos/>
```

**Sample request**

Following is a sample REST/JSON request that can be handled by the getHelpTos operation.

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
    "tos": "Download:&nbsp;TheTwitterUserAgreement.pdf\n\nIf you live in the United States, the Twitter User Agreement comprises these Terms of Service, our Privacy Policy, the Twitter Rules and all incorporated policies.\nIf you live in the European Union or otherwise outside the United States, the Twitter User Agreement comprises these Terms of Service, our Privacy Policy, the Twitter Rules and all incorporated policies.\n\nTwitter Terms of Service\n(if you live in the United States)\nThese Terms of Service (\"Terms\") govern your access to and use of our services, including our various websites, SMS, APIs, email notifications, applications, buttons, widgets, ads, commerce services, and our other covered services (https://support.twitter.com/articles/20172501) that link to these Terms (collectively, the \"Services\"), and any information, text, links, graphics, photos, videos, or other materials or arrangements of materials uploaded, downloaded or appearing on the Services (collectively referred to as \"Content\"). By using the Services you agree to be bound by these Terms.\n\n1. Who May Use the Services\n2. Privacy\n3. Content on the Services\n4. Using the Services\n5. Disclaimers and Limitations of Liability\n6. General\n\n1. Who May Use the Services\nYou may use the Services only if you agree to form a binding contract with Twitter and are not a person barred from receiving services under the laws of the applicable jurisdiction. In any case, you must be at least 13 years old to use the Services. If you are accepting these Terms and using the Services on behalf of a company, organization, government, or other legal entity, you represent and warrant that you are authorized to do so.\n\n2. Privacy\nOur Privacy Policy (https://www.twitter.com/privacy) describes how we handle the information you provide to us when you use our Services. You understand that through your use of the Services you consent to the collection and use (as set forth in the Privacy Policy) of this information, including the transfer of this information to the United States, Ireland, and/or other countries for storage, processing and use by Twitter and its affiliates.\n\n3. Content on the Services\nYou are responsible for your use of the Services and for any Content you provide, including compliance with applicable laws, rules, and regulations. You should only provide Content that you are comfortable sharing with others.\nAny use or reliance on any Content or materials posted via the Services or obtained by you through the Services is at your own risk. We do not endorse, support, represent or guarantee the completeness, truthfulness, accuracy, or reliability of any Content or communications posted via the Services or endorse any opinions expressed via the Services. You understand that by using the Services, you may be exposed to Content that might be offensive, harmful, inaccurate or otherwise inappropriate, or in some cases, postings that have been mislabeled or are otherwise deceptive. All Content is the sole responsibility of the person who originated such Content. We may not monitor or control the Content posted via the Services and, we cannot take responsibility for such Content.\nTwitter respects the intellectual property rights of others and expects users of the Services to do the same. We reserve the right to remove Content alleged to be infringing without prior notice, at our sole discretion, and without liability to you. We will respond to notices of alleged copyright infringement that comply with applicable law and are properly provided to us, as described in our Copyright policy (https://support.twitter.com/articles/15795). If you believe that your Content has been copied in a way that constitutes copyright infringement, please report this by visiting our Copyright reporting form (https://support.twitter.com/forms/dmca) or contacting our designated copyright agent at:\nTwitter, Inc.Attn: Copyright Agent1355 Market Street, Suite 900San Francisco, CA 94103Reports: https://support.twitter.com/forms/dmcaEmail: copyright@twitter.com\nYour Rights\nYou retain your rights to any Content you submit, post or display on or through the Services. What's yours is yours -- you own your Content (and your photos and videos are part of the Content).\nBy submitting, posting or displaying Content on or through the Services, you grant us a worldwide, non-exclusive, royalty-free license (with the right to sublicense) to use, copy, reproduce, process, adapt, modify, publish, transmit, display and distribute such Content in any and all media or distribution methods (now known or later developed). This license authorizes us to make your Content available to the rest of the world and to let others do the same. You agree that this license includes the right for Twitter to provide, promote, and improve the Services and to make Content submitted to or through the Services available to other companies, organizations or individuals for the syndication, broadcast, distribution, promotion or publication of such Content on other media and services, subject to our terms and conditions for such Content use. Such additional uses by Twitter, or other companies, organizations or individuals, may be made with no compensation paid to you with respect to the Content that you submit, post, transmit or otherwise make available through the Services.\nTwitter has an evolving set of rules for how ecosystem partners can interact with your Content on the Services. These rules exist to enable an open ecosystem with your rights in mind. You understand that we may modify or adapt your Content as it is distributed, syndicated, published, or broadcast by us and our partners and/or make changes to your Content in order to adapt the Content to different media. You represent and warrant that you have all the rights, power and authority necessary to grant the rights granted herein to any Content that you submit.\n\n4. Using the Services\nPlease review the Twitter Rules, which are part of the User Agreement and outline what is prohibited on the Services. You may use the Services only in compliance with these Terms and all applicable laws, rules and regulations.\nOur Services evolve constantly. As such, the Services may change from time to time, at our discretion. We may stop (permanently or temporarily) providing the Services or any features within the Services to you or to users generally. We also retain the right to create limits on use and storage at our sole discretion at any time. We may also remove or refuse to distribute any Content on the Services, suspend or terminate users, and reclaim usernames without liability to you.\nIn consideration for Twitter granting you access to and use of the Services, you agree that Twitter and its third-party providers and partners may place advertising on the Services or in connection with the display of Content or information from the Services whether submitted by you or others. You also agree not to misuse our Services, for example, by interfering with them or accessing them using a method other than the interface and the instructions that we provide. You may not do any of the following while accessing or using the Services: (i) access, tamper with, or use non-public areas of the Services, Twitter's computer systems, or the technical delivery systems of Twitter's providers; (ii) probe, scan, or test the vulnerability of any system or network or breach or circumvent any security or authentication measures; (iii) access or search or attempt to access or search the Services by any means (automated or otherwise) other than through our currently available, published interfaces that are provided by Twitter (and only pursuant to the applicable terms and conditions), unless you have been specifically allowed to do so in a separate agreement with Twitter (NOTE: crawling the Services is permissible if done in accordance with the provisions of the robots.txt file, however, scraping the Services without the prior consent of Twitter is expressly prohibited); (iv) forge any TCP/IP packet header or any part of the header information in any email or posting, or in any way use the Services to send altered, deceptive or false source-identifying information; or (v) interfere with, or disrupt, (or attempt to do so), the access of any user, host or network, including, without limitation, sending a virus, overloading, flooding, spamming, mail-bombing the Services, or by scripting the creation of Content in such a manner as to interfere with or create an undue burden on the Services. We also reserve the right to access, read, preserve, and disclose any information as we reasonably believe is necessary to (i) satisfy any applicable law, regulation, legal process or governmental request, (ii) enforce the Terms, including investigation of potential violations hereof, (iii) detect, prevent, or otherwise address fraud, security or technical issues, (iv) respond to user support requests, or (v) protect the rights, property or safety of Twitter, its users and the public. Twitter does not disclose personally-identifying information to third parties except in accordance with our Privacy Policy.\nIf you use developer features of the Services, including but not limited to Twitter for Websites (https://dev.twitter.com/web/overview), Twitter Cards (https://dev.twitter.com/cards/overview), Public API (https://dev.twitter.com/streaming/public), or Sign in with Twitter (https://dev.twitter.com/web/sign-in), you agree to our Developer Agreement (https://dev.twitter.com/overview/terms/agreement) and Developer Policy (https://dev.twitter.com/overview/terms/policy). If you want to reproduce, modify, create derivative works, distribute, sell, transfer, publicly display, publicly perform, transmit, or otherwise use the Services or Content on the Services, you must use the interfaces and instructions we provide, except as permitted through the Twitter Services, these Terms, or the terms provided on dev.twitter.com.\nIf you use advertising features of the Services, you must agree to our Twitter Master Services Agreement (https://ads.twitter.com/terms).\nIf you use commerce features of the Services that require credit or debit card information, such as our Buy Now feature, you agree to our Twitter Commerce Terms (https://support.twitter.com/articles/20171943).\nYour Account\nYou may need to create an account to use some of our Services. You are responsible for safeguarding your account, so use a strong password and limit its use to this account. We cannot and will not be liable for any loss or damage arising from your failure to comply with the above.\nYou can control most communications from the Services. We may need to provide you with certain communications, such as service announcements and administrative messages. These communications are considered part of the Services and your account, and you may not be able to opt-out from receiving them. If you added your phone number to your account and you later change or deactivate that phone number, you must update your account information to help prevent us from communicating with anyone who acquires your old number.\nYour License to Use the Services\nTwitter gives you a personal, worldwide, royalty-free, non-assignable and non-exclusive license to use the software provided to you as part of the Services. This license has the sole purpose of enabling you to use and enjoy the benefit of the Services as provided by Twitter, in the manner permitted by these Terms.\nThe Services are protected by copyright, trademark, and other laws of both the United States and foreign countries. Nothing in the Terms gives you a right to use the Twitter name or any of the Twitter trademarks, logos, domain names, and other distinctive brand features. All right, title, and interest in and to the Services (excluding Content provided by users) are and will remain the exclusive property of Twitter and its licensors. Any feedback, comments, or suggestions you may provide regarding Twitter, or the Services is entirely voluntary and we will be free to use such feedback, comments or suggestions as we see fit and without any obligation to you.\nEnding These Terms\nYou may end your legal agreement with Twitter at any time by deactivating your accounts and discontinuing your use of the Services. See http://support.twitter.com/articles/15358-how-to-deactivate-your-account for instructions on how to deactivate your account and the Privacy Policy for more information on what happens to your information.\nWe may suspend or terminate your account or cease providing you with all or part of the Services at any time for any or no reason, including, but not limited to, if we reasonably believe: (i) you have violated these Terms or the Twitter Rules, (ii) you create risk or possible legal exposure for us; (iii) your account should be removed due to prolonged inactivity; or (iv) our provision of the Services to you is no longer commercially viable. We will make reasonable efforts to notify you by the email address associated with your account or the next time you attempt to access your account, depending on the circumstances. In all such cases, the Terms shall terminate, including, without limitation, your license to use the Services, except that the following sections shall continue to apply: II, III, V, and VI.\n\n5. Disclaimers and Limitations of Liability\nThe Services are Available \"AS-IS\"\nYour access to and use of the Services or any Content are at your own risk. You understand and agree that the Services are provided to you on an \"AS IS\" and \"AS AVAILABLE\" basis. The \"Twitter Entities\" refers to Twitter, its parents, affiliates, related companies, officers, directors, employees, agents, representatives, partners, and licensors. Without limiting the foregoing, to the maximum extent permitted under applicable law, THE TWITTER ENTITIES DISCLAIM ALL WARRANTIES AND CONDITIONS, WHETHER EXPRESS OR IMPLIED, OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, OR NON-INFRINGEMENT. The Twitter Entities make no warranty or representation and disclaim all responsibility and liability for: (i) the completeness, accuracy, availability, timeliness, security or reliability of the Services or any Content; (ii) any harm to your computer system, loss of data, or other harm that results from your access to or use of the Services or any Content; (iii) the deletion of, or the failure to store or to transmit, any Content and other communications maintained by the Services; and (iv) whether the Services will meet your requirements or be available on an uninterrupted, secure, or error-free basis. No advice or information, whether oral or written, obtained from the Twitter Entities or through the Services, will create any warranty or representation not expressly made herein.\nLimitation of Liability\nTO THE MAXIMUM EXTENT PERMITTED BY APPLICABLE LAW, THE TWITTER ENTITIES SHALL NOT BE LIABLE FOR ANY INDIRECT, INCIDENTAL, SPECIAL, CONSEQUENTIAL OR PUNITIVE DAMAGES, OR ANY LOSS OF PROFITS OR REVENUES, WHETHER INCURRED DIRECTLY OR INDIRECTLY, OR ANY LOSS OF DATA, USE, GOOD-WILL, OR OTHER INTANGIBLE LOSSES, RESULTING FROM (i) YOUR ACCESS TO OR USE OF OR INABILITY TO ACCESS OR USE THE SERVICES; (ii) ANY CONDUCT OR CONTENT OF ANY THIRD PARTY ON THE SERVICES, INCLUDING WITHOUT LIMITATION, ANY DEFAMATORY, OFFENSIVE OR ILLEGAL CONDUCT OF OTHER USERS OR THIRD PARTIES; (iii) ANY CONTENT OBTAINED FROM THE SERVICES; OR (iv) UNAUTHORIZED ACCESS, USE OR ALTERATION OF YOUR TRANSMISSIONS OR CONTENT. IN NO EVENT SHALL THE AGGREGATE LIABILITY OF THE TWITTER ENTITIES EXCEED THE GREATER OF ONE HUNDRED U.S. DOLLARS (U.S. $100.00) OR THE AMOUNT YOU PAID TWITTER, IF ANY, IN THE PAST SIX MONTHS FOR THE SERVICES GIVING RISE TO THE CLAIM. THE LIMITATIONS OF THIS SUBSECTION SHALL APPLY TO ANY THEORY OF LIABILITY, WHETHER BASED ON WARRANTY, CONTRACT, STATUTE, TORT (INCLUDING NEGLIGENCE) OR OTHERWISE, AND WHETHER OR NOT THE TWITTER ENTITIES HAVE BEEN INFORMED OF THE POSSIBILITY OF ANY SUCH DAMAGE, AND EVEN IF A REMEDY SET FORTH HEREIN IS FOUND TO HAVE FAILED OF ITS ESSENTIAL PURPOSE.\n\n6. General\nWe may revise these Terms from time to time. The changes will not be retroactive, and the most current version of the Terms, which will always be at twitter.com/tos, will govern our relationship with you. We will try to notify you of material revisions, for example via a service notification or an email to the email associated with your account. By continuing to access or use the Services after those revisions become effective, you agree to be bound by the revised Terms.\nThe laws of the State of California, excluding its choice of law provisions, will govern these Terms and any dispute that arises between you and Twitter. All disputes related to these Terms or the Services will be brought solely in the federal or state courts located in San Francisco County, California, United States, and you consent to personal jurisdiction and waive any objection as to inconvenient forum.\nIf you are a federal, state, or local government entity in the United States using the Services in your official capacity and legally unable to accept the controlling law, jurisdiction or venue clauses above, then those clauses do not apply to you. For such U.S. federal government entities, these Terms and any action related thereto will be governed by the laws of the United States of America (without reference to conflict of laws) and, in the absence of federal law and to the extent permitted under federal law, the laws of the State of California (excluding choice of law).\nIn the event that any provision of these Terms is held to be invalid or unenforceable, then that provision will be limited or eliminated to the minimum extent necessary, and the remaining provisions of these Terms will remain in full force and effect. Twitter's failure to enforce any right or provision of these Terms will not be deemed a waiver of such right or provision.\nThese Terms are an agreement between you and Twitter, Inc., 1355 Market Street, Suite 900, San Francisco, CA 94103 U.S.A. If you have any questions about these Terms, please contact us.\n\n\nEffective: September 30, 2016\nArchive of Previous Terms\n\n\n\n\n\n\n\n\nTerms of Service\n(if you live outside of the US)\nThese Terms of Service (\"Terms\") govern your access to and use of our services, including our various websites, SMS, APIs, email notifications, applications, buttons, widgets, ads, commerce services, and our other covered services (https://support.twitter.com/articles/20172501) that link to these Terms (collectively, the \"Services\"), and any information, text, links, graphics, photos, videos, or other materials or arrangements of materials uploaded, downloaded or appearing on the Services (collectively referred to as \"Content\"). By using the Services you agree to be bound by these Terms.\n\n1. Who May Use the Services\n2. Privacy\n3. Content on the Services\n4. Using the Services\n5. Disclaimers and Limitations of Liability\n6. General\n\n\n1. Who May Use the Services\nYou may use the Services only if you agree to form a binding contract with Twitter and are not a person barred from receiving services under the laws of the applicable jurisdiction. If you are accepting these Terms and using the Services on behalf of a company, organization, government, or other legal entity, you represent and warrant that you are authorized to do so.\n\n2. Privacy\nOur Privacy Policy (https://www.twitter.com/privacy) describes how we handle the information you provide to us when you use our Services. You understand that through your use of the Services you consent to the collection and use (as set forth in the Privacy Policy) of this information, including the transfer of this information to the United States, Ireland, and/or other countries for storage, processing and use by Twitter and its affiliates.\n\n3. Content on the Services\nYou are responsible for your use of the Services and for any Content you provide, including compliance with applicable laws, rules, and regulations. You should only provide Content that you are comfortable sharing with others.\nAny use or reliance on any Content or materials posted via the Services or obtained by you through the Services is at your own risk. We do not endorse, support, represent or guarantee the completeness, truthfulness, accuracy, or reliability of any Content or communications posted via the Services or endorse any opinions expressed via the Services. You understand that by using the Services, you may be exposed to Content that might be offensive, harmful, inaccurate or otherwise inappropriate, or in some cases, postings that have been mislabeled or are otherwise deceptive. All Content is the sole responsibility of the person who originated such Content. We may not monitor or control the Content posted via the Services and, we cannot take responsibility for such Content.\nTwitter respects the intellectual property rights of others and expects users of the Services to do the same. We reserve the right to remove Content alleged to be infringing without prior notice, at our sole discretion, and without liability to you. We will respond to notices of alleged copyright infringement that comply with applicable law and are properly provided to us, as described in our Copyright policy (https://support.twitter.com/articles/15795). If you believe that your Content has been copied in a way that constitutes copyright infringement, please report this by visiting our Copyright reporting form (https://support.twitter.com/forms/dmca) or contacting our designated copyright agent at:\nTwitter, Inc.Attn: Copyright Agent1355 Market Street, Suite 900San Francisco, CA 94103Reports: https://support.twitter.com/forms/dmcaEmail: copyright@twitter.com\nYour Rights\nYou retain your rights to any Content you submit, post or display on or through the Services. What's yours is yours -- you own your Content (and your photos and videos are part of the Content).\nBy submitting, posting or displaying Content on or through the Services, you grant us a worldwide, non-exclusive, royalty-free license (with the right to sublicense) to use, copy, reproduce, process, adapt, modify, publish, transmit, display and distribute such Content in any and all media or distribution methods (now known or later developed). This license authorizes us to make your Content available to the rest of the world and to let others do the same. You agree that this license includes the right for Twitter to provide, promote, and improve the Services and to make Content submitted to or through the Services available to other companies, organizations or individuals for the syndication, broadcast, distribution, promotion or publication of such Content on other media and services, subject to our terms and conditions for such Content use. Such additional uses by Twitter, or other companies, organizations or individuals, may be made with no compensation paid to you with respect to the Content that you submit, post, transmit or otherwise make available through the Services.\nTwitter has an evolving set of rules for how ecosystem partners can interact with your Content on the Services. These rules exist to enable an open ecosystem with your rights in mind. You understand that we may modify or adapt your Content as it is distributed, syndicated, published, or broadcast by us and our partners and/or make changes to your Content in order to adapt the Content to different media. You represent and warrant that you have all the rights, power and authority necessary to grant the rights granted herein to any Content that you submit.\n\n4. Using the Services\nPlease review the Twitter Rules, which are part of the User Agreement and outline what is prohibited on the Services. You may use the Services only in compliance with these Terms and all applicable laws, rules and regulations.\nOur Services evolve constantly. As such, the Services may change from time to time, at our discretion. We may stop (permanently or temporarily) providing the Services or any features within the Services to you or to users generally. We also retain the right to create limits on use and storage at our sole discretion at any time. We may also remove or refuse to distribute any Content on the Services, suspend or terminate users, and reclaim usernames without liability to you.\nIn consideration for Twitter granting you access to and use of the Services, you agree that Twitter and its third-party providers and partners may place advertising on the Services or in connection with the display of Content or information from the Services whether submitted by you or others. You also agree not to misuse our Services, for example, by interfering with them or accessing them using a method other than the interface and the instructions that we provide. You may not do any of the following while accessing or using the Services: (i) access, tamper with, or use non-public areas of the Services, Twitter's computer systems, or the technical delivery systems of Twitter's providers; (ii) probe, scan, or test the vulnerability of any system or network or breach or circumvent any security or authentication measures; (iii) access or search or attempt to access or search the Services by any means (automated or otherwise) other than through our currently available, published interfaces that are provided by Twitter (and only pursuant to the applicable terms and conditions), unless you have been specifically allowed to do so in a separate agreement with Twitter (NOTE: crawling the Services is permissible if done in accordance with the provisions of the robots.txt file, however, scraping the Services without the prior consent of Twitter is expressly prohibited); (iv) forge any TCP/IP packet header or any part of the header information in any email or posting, or in any way use the Services to send altered, deceptive or false source-identifying information; or (v) interfere with, or disrupt, (or attempt to do so), the access of any user, host or network, including, without limitation, sending a virus, overloading, flooding, spamming, mail-bombing the Services, or by scripting the creation of Content in such a manner as to interfere with or create an undue burden on the Services. We also reserve the right to access, read, preserve, and disclose any information as we reasonably believe is necessary to (i) satisfy any applicable law, regulation, legal process or governmental request, (ii) enforce the Terms, including investigation of potential violations hereof, (iii) detect, prevent, or otherwise address fraud, security or technical issues, (iv) respond to user support requests, or (v) protect the rights, property or safety of Twitter, its users and the public. Twitter does not disclose personally-identifying information to third parties except in accordance with our Privacy Policy.\nIf you use developer features of the Services, including but not limited to Twitter for Websites (https://dev.twitter.com/web/overview), Twitter Cards (https://dev.twitter.com/cards/overview), Public API (https://dev.twitter.com/streaming/public), or Sign in with Twitter (https://dev.twitter.com/web/sign-in), you agree to our Developer Agreement (https://dev.twitter.com/overview/terms/agreement) and Developer Policy (https://dev.twitter.com/overview/terms/policy). If you want to reproduce, modify, create derivative works, distribute, sell, transfer, publicly display, publicly perform, transmit, or otherwise use the Services or Content on the Services, you must use the interfaces and instructions we provide, except as permitted through the Twitter Services, these Terms, or the terms provided on dev.twitter.com.\nIf you use advertising features of the Services, you must agree to our Twitter Master Services Agreement (https://ads.twitter.com/terms).\nIf you use commerce features of the Services that require credit or debit card information, such as our Buy Now feature, you agree to our Twitter Commerce Terms (https://support.twitter.com/articles/20171943).\nYour Account\nYou may need to create an account to use some of our Services. You are responsible for safeguarding your account, so use a strong password and limit its use to this account. We cannot and will not be liable for any loss or damage arising from your failure to comply with the above.\nYou can control most communications from the Services. We may need to provide you with certain communications, such as service announcements and administrative messages. These communications are considered part of the Services and your account, and you may not be able to opt-out from receiving them. If you added your phone number to your account and you later change or deactivate that phone number, you must update your account information to help prevent us from communicating with anyone who acquires your old number.\nYour License to Use the Services\nTwitter gives you a personal, worldwide, royalty-free, non-assignable and non-exclusive license to use the software provided to you as part of the Services. This license has the sole purpose of enabling you to use and enjoy the benefit of the Services as provided by Twitter, in the manner permitted by these Terms.\nThe Services are protected by copyright, trademark, and other laws of both the United States and foreign countries. Nothing in the Terms gives you a right to use the Twitter name or any of the Twitter trademarks, logos, domain names, and other distinctive brand features. All right, title, and interest in and to the Services (excluding Content provided by users) are and will remain the exclusive property of Twitter and its licensors. Any feedback, comments, or suggestions you may provide regarding Twitter, or the Services is entirely voluntary and we will be free to use such feedback, comments or suggestions as we see fit and without any obligation to you.\nEnding These Terms\nYou may end your legal agreement with Twitter at any time by deactivating your accounts and discontinuing your use of the Services. See http://support.twitter.com/articles/15358-how-to-deactivate-your-account for instructions on how to deactivate your account and the Privacy Policy for more information on what happens to your information.\nWe may suspend or terminate your account or cease providing you with all or part of the Services at any time for any or no reason, including, but not limited to, if we reasonably believe: (i) you have violated these Terms or the Twitter Rules, (ii) you create risk or possible legal exposure for us; (iii) your account should be removed due to prolonged inactivity; or (iv) our provision of the Services to you is no longer commercially viable. We will make reasonable efforts to notify you by the email address associated with your account or the next time you attempt to access your account, depending on the circumstances. In all such cases, the Terms shall terminate, including, without limitation, your license to use the Services, except that the following sections shall continue to apply: II, III, V, and VI.\n\n5. Disclaimers and Limitations of Liability\nThe Services are Available \"AS-IS\"\nYour access to and use of the Services or any Content are at your own risk. You understand and agree that the Services are provided to you on an \"AS IS\" and \"AS AVAILABLE\" basis. The \"Twitter Entities\" refers to Twitter, its parents, affiliates, related companies, officers, directors, employees, agents, representatives, partners, and licensors. Without limiting the foregoing, to the maximum extent permitted under applicable law, THE TWITTER ENTITIES DISCLAIM ALL WARRANTIES AND CONDITIONS, WHETHER EXPRESS OR IMPLIED, OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, OR NON-INFRINGEMENT. The Twitter Entities make no warranty or representation and disclaim all responsibility and liability for: (i) the completeness, accuracy, availability, timeliness, security or reliability of the Services or any Content; (ii) any harm to your computer system, loss of data, or other harm that results from your access to or use of the Services or any Content; (iii) the deletion of, or the failure to store or to transmit, any Content and other communications maintained by the Services; and (iv) whether the Services will meet your requirements or be available on an uninterrupted, secure, or error-free basis. No advice or information, whether oral or written, obtained from the Twitter Entities or through the Services, will create any warranty or representation not expressly made herein.\nLimitation of Liability\nTHE TWITTER ENTITIES SHALL NOT BE LIABLE FOR ANY INDIRECT, INCIDENTAL, SPECIAL, CONSEQUENTIAL OR PUNITIVE DAMAGES, OR ANY LOSS OF PROFITS OR REVENUES, WHETHER INCURRED DIRECTLY OR INDIRECTLY, OR ANY LOSS OF DATA, USE, GOOD-WILL, OR OTHER INTANGIBLE LOSSES, RESULTING FROM (i) YOUR ACCESS TO OR USE OF OR INABILITY TO ACCESS OR USE THE SERVICES; (ii) ANY CONDUCT OR CONTENT OF ANY THIRD PARTY ON THE SERVICES, INCLUDING WITHOUT LIMITATION, ANY DEFAMATORY, OFFENSIVE OR ILLEGAL CONDUCT OF OTHER USERS OR THIRD PARTIES; (iii) ANY CONTENT OBTAINED FROM THE SERVICES; OR (iv) UNAUTHORIZED ACCESS, USE OR ALTERATION OF YOUR TRANSMISSIONS OR CONTENT. THE LIMITATIONS OF THIS SUBSECTION SHALL APPLY TO ANY THEORY OF LIABILITY, WHETHER BASED ON WARRANTY, CONTRACT, STATUTE, TORT (INCLUDING NEGLIGENCE) OR OTHERWISE, AND WHETHER OR NOT THE TWITTER ENTITIES HAVE BEEN INFORMED OF THE POSSIBILITY OF ANY SUCH DAMAGE, AND EVEN IF A REMEDY SET FORTH HEREIN IS FOUND TO HAVE FAILED OF ITS ESSENTIAL PURPOSE.\nSOME JURISDICTIONS DO NOT ALLOW EXCLUSION OF IMPLIED WARRANTIES OR LIMITATIONS ON THE DURATION OF IMPLIED WARRANTIES, SO THE ABOVE DISCLAIMERS MAY NOT APPLY TO YOU IN THEIR ENTIRETIES, BUT WILL APPLY TO THE MAXIMUM EXTENT PERMITTED BY APPLICABLE LAW.\n\n6. General\nWe may revise these Terms from time to time. The changes will not be retroactive, and the most current version of the Terms, which will always be at twitter.com/tos, will govern our relationship with you. We will try to notify you of material revisions, for example via a service notification or an email to the email associated with your account. By continuing to access or use the Services after those revisions become effective, you agree to be bound by the revised Terms.\nIn the event that any provision of these Terms is held to be invalid or unenforceable, then that provision will be limited or eliminated to the minimum extent necessary, and the remaining provisions of these Terms will remain in full force and effect. Twitter's failure to enforce any right or provision of these Terms will not be deemed a waiver of such right or provision.\nThese Terms are an agreement between you and Twitter International Company, an Irish company with its registered office at The Academy, 42 Pearse Street, Dublin 2, Ireland. If you have any questions about these Terms, please contact us.\n\nEffective: September 30, 2016\nArchive of Previous Terms\n"
}
```


**Related Twitter documentation**

https://dev.twitter.com/rest/reference/get/help/tos

#### Sample configuration

Following is a sample proxy service that illustrates how to connect to Twitter with the init operation and use the getApplicationRateLimitStatus operation. The sample request for this proxy can be found in getApplicationRateLimitStatus sample request. You can use this sample as a template for using other operations in this category.

1. Create a sample proxy as below :

    **Sample Proxy**
    ```xml
   <proxy xmlns="http://ws.apache.org/ns/synapse"
          name="getApplicationRateLimitStatus"
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
            <twitter.getApplicationRateLimitStatus/>
            <respond/>
         </inSequence>
         <outSequence>
            <send/>
         </outSequence>
      </target>
      <description/>
   </proxy>
    
    ```
2. Create a json file named getApplicationRateLimitStatus.json and copy the configurations given below to it:

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
    curl -X POST http://localhost:8280/services/getApplicationRateLimitStatus --header 'Content-Type: application/json' -d @getApplicationRateLimitStatus.json
    ```

5. Twitter returns a json response similar to the one shown below:
 
```json
{"resources":{"friends":{"/friends/following/ids":{"limit":15,"reset":1557729597,"remaining":15},"/friends/list":{"limit":15,"reset":1557729597,"remaining":15},"/friends/ids":{"limit":15,"reset":1557729597,"remaining":15},"/friends/following/list":{"limit":15,"reset":1557729597,"remaining":15}}},"rate_limit_context":{"access_token":"3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz"}}

```
