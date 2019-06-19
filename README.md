[![Build Status](https://travis-ci.org/SolaceTraining/solace-simple-guaranteed-pubsub.svg?branch=master)](https://travis-ci.org/SolaceTraining/solace-simple-guaranteed-pubsub)

# Solace Simple Guaranteed PubSub
## Solace Messaging API for Java (JCSMP)

The "Getting Started" tutorials will get you up to speed and sending messages with Solace technology as quickly as possible. There are three ways you can get started:

- Follow [these instructions](https://cloud.solace.com/learn/group_getting_started/ggs_signup.html) to quickly spin up a cloud-based Solace messaging service for your applications.
- Follow [these instructions](https://docs.solace.com/Solace-SW-Broker-Set-Up/Setting-Up-SW-Brokers.htm) to start Solace PubSub+ in leading Clouds, Container Platforms or Hypervisors. 
- If your company has Solace message routers deployed, contact your middleware team to obtain the host name or IP address of a Solace message router to test against, a username and password to access it, and a VPN in which you can produce and consume messages.

## Contents

This repository contains code for a guaranteed Solace producer and consumer. This code accompanies this YouTube video.

## Prerequisites

This tutorial requires the Solace Java API library. Download the Java API library to your computer from [here](http://solace.com/downloads/).

## Build the Samples

Just clone and build. For example:

  1. clone this GitHub repository
```
git clone https://github.com/SolaceTraining/solace-simple-guaranteed-pubsub
cd solace-simple-guaranteed-pubsub
```
  2. `./gradlew assemble`

## Running the Samples

To try individual samples, fill out the connection details to your Solace instance, build the project from source and then run samples like the following:

    ./build/staged/bin/guaranteedProducer

The individual tutorials linked above provide full details which can walk you through the samples, what they do, and how to correctly run them to explore Solace messaging.

## Exploring the Samples

### Setting up your preferred IDE

Using a modern Java IDE provides cool productivity features like auto-completion, on-the-fly compilation, assisted refactoring and debugging which can be useful when you're exploring the samples and even modifying the samples. Follow the steps below for your preferred IDE.

#### Using Eclipse

To generate Eclipse metadata (.classpath and .project files), do the following:

    ./gradlew eclipse

Once complete, you may then import the projects into Eclipse as usual:

 *File -> Import -> Existing projects into workspace*

Browse to the *'solace-simple-guaranteed-pubsub'* root directory. All projects should import
free of errors.

#### Using IntelliJ IDEA

To generate IDEA metadata (.iml and .ipr files), do the following:

    ./gradlew idea

## Contributing

Please read [CONTRIBUTING.md](CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests to us.

## Authors

See the list of [contributors](https://github.com/SolaceTraining/solace-simple-guaranteed-pusub/contributors) who participated in this project.

## License

This project is licensed under the Apache License, Version 2.0. - See the [LICENSE](LICENSE) file for details.

## Resources

For more information try these resources:

- The [Solace Developer Portal](http://solace.com/developers)
- Get a better understanding of [Solace technology](http://solace.com/tech/)
- Check out the [Solace blog](http://solace.com/blog/) for other interesting discussions around Solace technology
- Ask the [Solace community.](https://solace.community/)
