# template for "Stopwatch: The Game"

import simplegui

# define global variables
ticker = 0
stops = 0
on_targets = 0

# define helper function format that converts time
# in tenths of seconds into formatted string A:BC.D
def format(t):
    tenths = t % 10
    secOne = (t // 10) % 10
    secTwo = (t // 100) % 6
    minutes = (t // 100) // 6
    return str(minutes) + ":" + str(secTwo) + str(secOne) + "." + str(tenths)
    
# define event handlers for buttons; "Start", "Stop", "Reset"
def click_start():
    timer.start()
    
def click_stop():
    global ticker, stops, on_targets
    if timer.is_running():
        timer.stop()
        stops += 1
        if ticker % 10 == 0:
            on_targets += 1
        else:
            pass
    else:
        pass
            
    
def click_reset():
    global ticker, stops, on_targets
    timer.stop()
    ticker = 0
    stops = 0
    on_targets = 0

def score():
    global stops, on_targets
    return str(on_targets) + "/" + str(stops)
    
# define event handler for timer with 0.1 sec interval
def time_count():
    global ticker
    ticker += 1

# define draw handler
def draw(canvas):
    canvas.draw_text(format(ticker), [75, 85], 25, "Yellow")
    canvas.draw_text(score(), [170, 20], 20, "Black")

# create frame
frame = simplegui.create_frame("Game", 200, 150)
frame.set_canvas_background("Gray")
frame.set_draw_handler(draw)

# register event handlers
button1 = frame.add_button("Start", click_start)
button2 = frame.add_button("Stop", click_stop)
button3 = frame.add_button("Reset", click_reset)
timer = simplegui.create_timer(100, time_count)

# start frame
frame.start()

# Please remember to review the grading rubric
