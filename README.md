# EnerHack
This was a hackathon project so please excuse the lack of documentation and messy code base in general. :)
This was also one of our first android projects and we were both beginner programmers at the time so please don't be too judgemental ;)

## About the hackathon
Madison EnerHacks Hackathon was an energy themed Hackathon for UW - Madison undergraduate and graduate students hosted by the engineering department. The official webpage is here https://energyan.net/hackathon/. The website can do a lot better job of explaining the merits of the hackathon than I can. 
A research team at Madison had developed a highly-portable home energy system for use in places in the world with unreliable energy supply. Hackathon participants could build projects that would interact with an API that provides metrics on the current energy state of the home.

## Our project
We created an app that rewarded users for saving energy in their homes. We took inspiration from the fitbit incentive, where users receive arbitrary points for being active that they can use to compete and compare with friends. Our app would calculate how much energy a home was using, and what electronic appliances were currently being used. Our app would then compare this with American averages for the power consumption of the appliances being used. If the user's usage was better than the baseline average, the user would be rewarded with arbitrary points. 

## Our Stack
This repo contains the frontend android project for our app. Most of the logic happens here. There was a python script that periodically monitored the home energy API for metrics. A small PHP file served on an apache web server would then allow the android frontend to query the python script for data on the energy usage of the home. 
Unfortunetly, the PHP file and Python script are lost as I am now writing this readme a year and a half later :(

## Challenges
Neither of us knew Python, so learning Python on-the-go with a time crunch was a bit stressful. (I kept adding semicolons everywhere XD)
Most of the other teams consisted of grad students, so we were a bit intimidated at first. 

## What we're proud of
- Writing this readme a year and a half later, I now realize how little we knew about HTTP requests and networking in general, but I'm seriously impressed that our past selves were able to figure out something that actually worked. 
- Getting the full stack to work when we were so new to everything on the stack and new to programming outside of class in general.
- Winning 2nd place!!! 
