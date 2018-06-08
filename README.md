# ArrkTest
- ArrkTest is a test Repo meant for demonstration purpose.

# Requirements
- Android studio.


# Notes
- Application uses open API from "https://swapi.co/api/" and shows list of characters
  fetched from URL - "https://swapi.co/api/people/"
- The first screen shows the list of characters and detail screen shows info pertaining to selected character.
- Code is based on MVP & clean Architecture and Reactive programming
- Application uses Dependency injection using Dagger & view injection using Butter Knife.
- Based on clean Architecture principle - seperation of concerns, presenter uses a use case which
  interacts with repository to get list of star war characters.
- To make app reactive compliant RxJava is used.
- Views are mostly injected/bind using ButterKnife and Recycler View uses for displaying List.
- Junit Test cases based on Mockito are used for Presenter and Repository

