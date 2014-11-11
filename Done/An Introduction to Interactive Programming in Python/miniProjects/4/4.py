#URL: http://www.codeskulptor.org/#user38_QdWnegLiL5nag3D_0.py
# Implementation of classic arcade game Pong
import simplegui
import random

# initialize globals - pos and vel encode vertical info for paddles
WIDTH = 600
HEIGHT = 400       
BALL_RADIUS = 20
PAD_WIDTH = 8
PAD_HEIGHT = 80
HALF_PAD_WIDTH = PAD_WIDTH / 2
HALF_PAD_HEIGHT = PAD_HEIGHT / 2


LEFT = False
RIGHT = True
PADDLE_SPEED = 8
BALL_POS = [0, 0]
BALL_VEL = [0, 0]
SCORE1 = SCORE2 = 0
PAD1POS = PAD2POS = HEIGHT / 2 - HALF_PAD_HEIGHT
PAD1VEL = PAD2VEL = 0


# initialize ball_pos and ball_vel for new bal in middle of table
# if direction is RIGHT, the ball's velocity is upper right, else upper left
def spawn_ball(direction):
    global BALL_POS, BALL_VEL

    BALL_POS = [WIDTH / 2 - 1, HEIGHT / 2 - 1]
    if direction == LEFT:
        BALL_VEL = [random.randrange(120, 240) / 60, -random.randrange(60, 180) / 60]
    elif direction == RIGHT:
        BALL_VEL = [-random.randrange(120, 240) / 60, -random.randrange(60, 180) / 60]
    
    
# define event handlers
def new_game():
    global PAD1POS, PAD2POS, PAD1VEL, PAD2VEL
    global SCORE1, SCORE2  

    SCORE1 = SCORE2 = 0
    PAD2POS = PAD2POS = HEIGHT / 2 - HALF_PAD_HEIGHT
    PAD1VEL = PAD2VEL = 0
    spawn_ball(random.choice([True, False]))



def draw(canvas):
    global SCORE1, SCORE2, PAD1POS, PAD2POS, BALL_POS, BALL_VEL
 
        
    # draw mid line and gutters
    canvas.draw_line([WIDTH / 2, 0],[WIDTH / 2, HEIGHT], 1, "White")
    canvas.draw_line([PAD_WIDTH, 0],[PAD_WIDTH, HEIGHT], 1, "White")
    canvas.draw_line([WIDTH - PAD_WIDTH, 0],[WIDTH - PAD_WIDTH, HEIGHT], 1, "White")
        
    # update ball
    BALL_POS[0] += BALL_VEL[0]
    BALL_POS[1] += BALL_VEL[1]
    
    if (BALL_POS[0] - BALL_RADIUS - PAD_WIDTH <= 0):
        if (BALL_POS[1] >= (PAD1POS - BALL_RADIUS) and BALL_POS[1] <= (PAD1POS + PAD_HEIGHT + BALL_RADIUS)):
            BALL_VEL[0] *= -1.1
            BALL_VEL[1] *= 1.1
        else:
            SCORE2 += 1
            spawn_ball(LEFT)
    elif (BALL_POS[0] + BALL_RADIUS + PAD_WIDTH >= WIDTH):
        if (BALL_POS[1] >= (PAD2POS - BALL_RADIUS) and BALL_POS[1] <= (PAD2POS + PAD_HEIGHT + BALL_RADIUS)):
            BALL_VEL[0] *= -1.1
            BALL_VEL[1] *= 1.1
        else:
            SCORE1 += 1
            spawn_ball(RIGHT)
    
    if (BALL_POS[1] - BALL_RADIUS <= 0) or (BALL_POS[1] + BALL_RADIUS >= HEIGHT):
        BALL_VEL[1] *= -1



    # draw ball
    canvas.draw_circle(BALL_POS, BALL_RADIUS - 1, 1, "White", "White")
    
    
    
    # update paddle's vertical position, keep paddle on the screen
    PAD1POS += PAD1VEL
    PAD2POS += PAD2VEL
    
    if PAD1POS <= 0:
        PAD1POS = 0
    
    if PAD1POS >= HEIGHT - PAD_HEIGHT:
        PAD1POS = HEIGHT - PAD_HEIGHT
    
    if PAD2POS <= 0:
        PAD2POS = 0
    
    if PAD2POS >= HEIGHT - PAD_HEIGHT:
        PAD2POS = HEIGHT - PAD_HEIGHT
   
    

    # draw paddles
    canvas.draw_polyline([(HALF_PAD_WIDTH, PAD1POS), (HALF_PAD_WIDTH, PAD1POS + PAD_HEIGHT)], PAD_WIDTH, 'White')
    canvas.draw_polyline([(WIDTH - HALF_PAD_WIDTH, PAD2POS), (WIDTH - HALF_PAD_WIDTH, PAD2POS + PAD_HEIGHT)], PAD_WIDTH, 'White')    
    
    # draw scores
    canvas.draw_text(str(SCORE1),(250, 50), 24, "White")
    canvas.draw_text(str(SCORE2),(337, 50), 24, "White")
    

#key down    
def keydown(key):
    global PAD1VEL, PAD2VEL, PADDLE_SPEED
     
    if key == simplegui.KEY_MAP['w']:
        PAD1VEL = -PADDLE_SPEED
    elif key == simplegui.KEY_MAP['s']:
        PAD1VEL = PADDLE_SPEED
    
    if key == simplegui.KEY_MAP["up"]:
        PAD2VEL = -PADDLE_SPEED
    elif key == simplegui.KEY_MAP["down"]:
        PAD2VEL = PADDLE_SPEED

# key up   
def keyup(key):
    global PAD1VEL, PAD2VEL
    
    if key == simplegui.KEY_MAP["up"]:
        PAD2VEL = 0
    elif key == simplegui.KEY_MAP["down"]:
        PAD2VEL = 0
        
    if key == simplegui.KEY_MAP["w"]:
        PAD1VEL = 0
    elif key == simplegui.KEY_MAP["s"]:
        PAD1VEL = 0

# create frame
frame = simplegui.create_frame("Pong", WIDTH, HEIGHT)

frame.add_label("Right paddle")
frame.add_label("w - up")
frame.add_label("s - down")
frame.add_label(" ")
frame.add_label("Left paddle")
frame.add_label("up - up")
frame.add_label("down - down")
frame.add_label("")
frame.add_button("Restart Game", new_game, 150)

frame.set_draw_handler(draw)
frame.set_keydown_handler(keydown)
frame.set_keyup_handler(keyup)


# start frame
new_game()
frame.start()