# Filter Discord Bot [![CircleCI](https://circleci.com/gh/KabirKwatra/Discord-Hack-Week-Submission.svg?style=svg)](https://circleci.com/gh/KabirKwatra/Discord-Hack-Week-Submission)

| Title             | Filter          					                                              |
|-------------------|-------------------------------------------------------------------------|
| Short Desc        | A bot that filters text, images, and video based on user-defined tags.  |
| Members Committed | Kabir Kwatra, Ivar Rydstrom, Raymond Wong, Aditya Dhir                  |


Filter is a revolutionary moderation bot.
Filter allows admins to add filters for their server.
These filters are stored in Google Cloud Firestore.
On the database all servers' identities is encrypted with AES 256 to protect user data.
When anyone sends an image, it is categorized by a Machine Learning model trained and hosted by Google's Cloud Vision.
If any of the labels match any of the added filters, the message is deleted.
