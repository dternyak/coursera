# Ball motion with an implicit timer

import simplegui

# Initialize globals
p = [10, 20]
pv = [3, 0.7] # pixels per update (1/60 seconds)
WIDTH = 600
HEIGHT = 400
BALL_RADIUS = 2

# define event handlers
def draw(canvas):
    # Update point position
    p[0] += pv[0]
    p[1] += pv[1]
    canvas.draw_circle(p,1,2,"White")
    
    # Draw rectangle
    canvas.draw_polyline([[50,140],[50,50],[180,50],[180,140],[50,140]], 2, "Blue")
    
# create frame
frame = simplegui.create_frame("Motion", WIDTH, HEIGHT)

# register event handlers
frame.set_draw_handler(draw)

# start frame
frame.start()
