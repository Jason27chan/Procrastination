# Procrastination

# Checks the dot product between the vector between the ball's position and the goal
# and the velocity vector
vector_to_goal = robocup.Point(0 - main.ball().pos.x, 0 - main.ball().pos.y)
return main.ball().vel.dot(vector_to_goal) > 0
