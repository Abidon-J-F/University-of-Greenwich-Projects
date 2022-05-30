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

**Fun Fact:** Actor class controls how your agent behave like a policy-based system. A Critic class measures how good the actions the actor has contributed are and this is a value-based system. They both work together and help improve one another. <br />

Here is the mathematical formula: <br />

![Actor and Critic class](https://github.com/Abidon-J-F/University-of-Greenwich-Projects/blob/main/Y2/Reinforcement%20Learning%20in%20Artificial%20Intelligence%20Racing%20Car%20Game/Actor_and_Critic.png) <br />

## Experiments Conducted
The basis of our tests were to determine the fewest number of episodes required to explore with the most amount of steps before exploitation began. 

Each test conducted were under various environmental adaptations and characteristic alterations, including:
- Exploration Rate
- Learning Rate
- Neural Network alterations
- Environment Manipulation

Changes to the environment included adding more obstacles to avoid.

Alterations made e.g. number of sensors, sensor length, speed of car etc. were made to affect the learning rate of the algorithm.


## Outcomes
![Exploration value of in base environment](https://github.com/Abidon-J-F/University-of-Greenwich-Projects/blob/main/Y2/Reinforcement%20Learning%20in%20Artificial%20Intelligence%20Racing%20Car%20Game/Exploration%20value%20base%20env%20Graph.jpeg) <br />
Depreciating exploration value of initial environment. Exploitation began after 50 episodes and maximised after 137 episodes. <br />

![Exploration value of in final environment (200+ep)](https://github.com/Abidon-J-F/University-of-Greenwich-Projects/blob/main/Y2/Reinforcement%20Learning%20in%20Artificial%20Intelligence%20Racing%20Car%20Game/Exploration%20in%20final%20env%20Episode%20200%2B%20Graph.png) <br />
Depreciating exploration value of final environment (parameters are consistent). Exploitation began after 45 episodes and maximised after 149 episodes. <br />

![Exploration value of in final environment (Optimised speed)](https://github.com/Abidon-J-F/University-of-Greenwich-Projects/blob/main/Y2/Reinforcement%20Learning%20in%20Artificial%20Intelligence%20Racing%20Car%20Game/Exploration%20in%20Final%20env%20Graph%20Optimised%20Speed.jpeg) <br />
Depreciating exploration value of final environment (Car’s travelling speed was set to an optimal learning rate). Exploitation began after 48 episodes and maximised after 113 episodes. <br />

![Exploration value of in final environment (Increased sensors)](https://github.com/Abidon-J-F/University-of-Greenwich-Projects/blob/main/Y2/Reinforcement%20Learning%20in%20Artificial%20Intelligence%20Racing%20Car%20Game/Exploration%20in%20Final%20env%20Graph%20Increased%20Sensors.jpeg) <br />
Depreciating exploration value of final environment (Number of car sensors increased to 15). Exploitation began after 58 episodes and maximised after 200 episodes. <br />

## Result
The video link to the final product is here. <br />
![Project CARS](https://user-images.githubusercontent.com/106085589/170594727-c9f79cc5-f7d5-4c18-870e-785ed0335358.MP4) <br />


## Software
**Utilised Python programming language, the PyCharm IDE, and TensorFlow, Pyglet, NumPy libraries in this project.** 
