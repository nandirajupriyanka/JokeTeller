# Joke Teller
In this project, Gradle is used to build a joke-telling app, factoring functionality into libraries and flavors to keep the build simple. Google Cloud Endpoints development server is also configured to supply the jokes which are displayed via an Activity from the Android Library.

Used in a Udacity course in the Android Developer Nanodegree.

# Pre-requisites
- Android SDK v25
- Android Build Tools v24.0.3
- Android Support Repository v25.3.1

# Getting started
This sample uses the Gradle build system. To build this project, use the "gradlew build" command or use "Import Project" in Android Studio.

# Features
- Java library for supplying jokes.
- An Android library with an activity that displays jokes passed to it as intent extras.
- A Google Cloud Endpoints module that supplies jokes from the Java library.
- Connected tests to verify that the async task which loaded jokes from GCE module is indeed loading jokes.
- Build Flavors - paid/free. The paid flavor has no ads, and no unnecessary dependencies.
- Free app variant displays interstitial ads between the main activity and the joke-displaying activity.
- Gradle task that starts the GCE dev server, runs all the Android tests, and shuts down the dev server.

# Support
Google+ Community: https://plus.google.com/communities/105153134372062985968

Stack Overflow: http://stackoverflow.com/questions/tagged/android

# License

Copyright 2016 The Android Open Source Project, Inc.

Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements. See the NOTICE file distributed with this work for additional information regarding copyright ownership. The ASF licenses this file to you under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
