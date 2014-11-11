# template for "Stopwatch: The Game"
import simplegui

# define global variables
t = 0
t_text = '0:00.0'
t_stops = 0
t_success = 0


# define helper function format that converts time
# in tenths of seconds into formatted string A:BC.D
def format(t):
    global t_text
    decimal = t%10
    sec = int(t%600/10)
    min = int(t/600)%10
    if sec < 10:
        sec_text = '0' + str(sec)
    else:
        sec_text = str(sec)
    t_text = str(min) + ':' + sec_text + '.' + str(decimal)
    return t_text

    
# define event handlers for buttons; "Start", "Stop", "Reset"
def start():
    timer.start()

def stop():
    global t_stops, t_success

    if timer.is_running():
        timer.stop()
        t_stops += 1

        if t%10 == 0:
            t_success +=1
    
def reset():
    global t, t_success, t_stops

    if timer.is_running():
        timer.stop()
        t_success = 0; 
        t_stops = 0

    t = 0; 
    format(t)
    t_success = 0; 
    t_stops = 0


# define event handler for timer with 0.1 sec interval
def timer_handler():
    global t
    t += 1
    format(t)
    
# define draw handler
def draw(canvas):
    canvas.draw_text(t_text,[55,120],70,"White")
    canvas.draw_text(str(t_success)+'/'+str(t_stops),[220,30],20,"White")
   
    
# create frame
frame = simplegui.create_frame("Stopwatch: The Game", 300, 200)

# register event handlers
frame.set_draw_handler(draw)
frame.add_button("Start", start, 100)
frame.add_button("Stop", stop, 100)
frame.add_button("Reset", reset, 100)
timer = simplegui.create_timer(100, timer_handler)

# start frame
frame.start()

# Please remember to review the grading rubric
# print format(9) #'0:00.9'
# print format(11) # '0:01.1'
# print format(321) # '0:32.1'
# print format(613) # '1:01.3'
# print format(6000) # '0:00.0'
# print format(6011) # '0:01.1'
# print format(6613) # '1:01.3'
# print format(12000) # '0:00.0'
# print format(0) # '0:00.0'