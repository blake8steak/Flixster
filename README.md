# Project 2 - Flixster

**Name of your app** shows the latest movies currently playing in theaters. The app utilizes the Movie Database API to display images and basic information about these movies to the user.

Time spent: 14 hours spent in total

## User Stories

The following **required** functionality is completed:

* [X] User can **scroll through current movies** from the Movie Database API
* [X] Display a nice default [placeholder graphic](https://guides.codepath.org/android/Displaying-Images-with-the-Glide-Library#advanced-usage) for each image during loading
* [X] For each movie displayed, user can see the following details:
  * [X] Title, Poster Image, Overview (Portrait mode)
  * [X] Title, Backdrop Image, Overview (Landscape mode)
* [X] Allow user to view details of the movie including ratings within a separate activity

The following **stretch** features are implemented:

* [X] Improved the user interface by experimenting with styling and coloring.
* [X] Apply rounded corners for the poster or background images using [Glide transformations](https://guides.codepath.org/android/Displaying-Images-with-the-Glide-Library#transformations)
* [ ] Apply the popular [View Binding annotation library](http://guides.codepath.org/android/Reducing-View-Boilerplate-with-ViewBinding) to reduce boilerplate code.
* [X] Allow video trailers to be played in full-screen using the YouTubePlayerView from the details screen.

The following **additional** features are implemented:

* [X] Added some extra elements to the UI (5 star rating bar in MainActivity, exact score out of 10 in detail view, new color theme, other minor things)

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='https://github.com/blake8steak/Flixster/blob/master/landscape.gif' title='Video Walkthrough' width='' alt='Video Walkthrough Landscape' />
<img src='https://github.com/blake8steak/Flixster/blob/master/portraitSmaller.gif' title='Video Walkthrough' width='' alt='Video Walkthrough Portrait' />

GIF created with [Kap](https://getkap.co/).

## Notes

Nothing too crazy! It wasn't too too bad.

I have to say though that the Android Silulator on Mac in my experience has been really buggy. I've had a number of weird errors/other issues be resolved by restarting/wiping data from the simulator, and it just seems to run slow for me. In my experience with iOS development in Xcode, the iPhone silumator is much more responsive and doesn't have to constantly be wiped and rebooted the way the Android silumator does.

Other than that, the biggest challenge is mostly just that Android development is a new skill for me - this is the second Java Android app I've ever made (the first being the SimpleTodo) and I feel that now that i've learned a lot from this experience, I'll be able to do many of these things much easier moving forward now that I've learned them.

Excited for the next two projects!

## Open-source libraries used

- [Android Async HTTP](https://github.com/loopj/android-async-http) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Android
- [YouTube Player View](https://developers.google.com/youtube/android/player/downloads/) - Library for playing YouTube videos

## License

    Copyright 2021 Blake Herrera.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
