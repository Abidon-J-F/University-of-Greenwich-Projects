# Reinforcement Learning in Artificial Intelligence Racing Car Game

Created an artificial intelligence racing car that drives around a custom racing track by itself using a reward system to complete the racing course as a group project.

Inspiration was based on [莫烦Python] : https://morvanzhou.github.io/tutorials/

### Contribution to this project:
- Abidon Jude Fernandes
- Catalin-Ionut Petcu
- Sean Daly
- Ronnelle Muia

## Coursework Project Tasks

Create a simple AI project using the Python programming language and the PyCharm IDE.

**Accomplishment:**
1. Developed an Actor class to control how to agents act and Critic class measure how good it actions are using the TensorFlow library.
2. Implemented a Memory class to store every action learned from training and evaluation.
3. Applied a collision class to give the car the ability to detect the object it has collided and restart from the beginning upon to collision.
4. Used the arrays in the NumPy library to create the racing track course for the racing car to traverse in the Car class.
5. Created the car in the Car class and assigned it with optimal sensors, speed, dimension, collision response, and the ability to learn from its mistake and reward itself if does not collide with any object when racing around the course.
6. Created a Viewer Class to give the user the power to observe the race and see if the AI car is learning to overcome its failure when driving around the racing track to become perfect or is it just exploiting the reward system for its own benefit by going around in circles.
7. Used the Pyglet library to physically draw the racing track course, screen background, and car on the screen.

**Fun Fact:** Actor class controls how your agents behave like a policy-based system. A Critic class measures how good the actions the actor has contributed are and this is a value-based system. They both work together and help improve one another. <br />

![Actor and Critic class](https://github.com/Abidon-J-F/University-of-Greenwich-Projects/blob/main/Y2/Reinforcement%20Learning%20in%20Artificial%20Intelligence%20Racing%20Car%20Game/Actor_and_Critic.png) <br />

## Experiments Conducted
The basis of our tests were to determine the fewest number of episodes required to explore with the most amount of steps before exploitation began. 

Each test conducted were under various environmental adaptations and
characteristic alterations, including:
- Exploration Rate
- Learning Rate
- Neural Network alterations
- Environment Manipulation

Changes to the environment included adding more obstacles to avoid.

Alterations made e.g. number of sensors, sensor length, speed of car etc. were made to affect the learning rate of the algorithm.

![Arduino Security Alarm System](https://github.com/Abidon-J-F/University-of-Greenwich-Projects/blob/main/Y1/Security%20Alarm%20System/Arduino.jpg) 

## Outcomes




## Result
This video here is the final product. <br />
![Project CARS](https://github.com/Abidon-J-F/University-of-Greenwich-Projects/blob/main/Y2/Reinforcement%20Learning%20in%20Artificial%20Intelligence%20Racing%20Car%20Game/Project_CARS.mp4) <br />


## Software
**Python programming language, the PyCharm IDE, and TensorFlow, Pyglet, NumPy libraries in this project.**
 
