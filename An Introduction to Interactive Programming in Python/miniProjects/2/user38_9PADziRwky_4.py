# template for "Guess the number" mini-project
# input will come from buttons and an input field
# all output for the game will be printed in the console
import simplegui
import random
import math

n_guesses = 0
low = 0 
high= 0
secret_number = 0


# helper function to start and restart the game
def new_game():
    # initialize global variables used in your code here
    global secret_number, n_guesses, low, high
    
    secret_number = random.randrange(low,high)
    #print "secret number:" + str(secret_number)
    
    n_guesses = int(math.ceil(math.log((high - low + 1), 2)))
    print "New game. Range is from " + str(low) + " to " + str(high)
    print "Number of remaining guesses is " + str(n_guesses)
    print
    
    # remove this when you add your code    
    #pass


# define event handlers for control panel
def range100():
    # button that changes the range to [0,100) and starts a new game 
    global n_guesses, high
    #n_guesses = 7
    high = 100
    new_game()
    # remove this when you add your code    
    #pass

def range1000():
    # button that changes the range to [0,1000) and starts a new game     
    global n_guesses, high
    #n_guesses = 10
    high = 1000
    new_game()
    #pass
    
def input_guess(guess):
    # main game logic goes here	
    global n_guesses, secret_number, high
    
    
    
    player_guess = int(guess) 
    print "Guess was "+ guess
    
    n_guesses = n_guesses - 1
    print "Number of remaining guesses: "+ str(n_guesses)

        
    if n_guesses == 0 and player_guess != secret_number:
        print "You ran out of guesses. The number was " + str(secret_number)
        print
        new_game()
    elif player_guess == secret_number:
        print "Correct!"
        print
        new_game()
    elif player_guess < secret_number:
        print "Higher"
        print
    elif player_guess > secret_number:
        print "Lower"
        print
    # remove this when you add your code
    #pass

    
# create frame
f = simplegui.create_frame("Guess the number", 200, 200)

# register event handlers for control elements and start frame
f.add_button("Range is [0, 100]", range100, 200)
f.add_button("Range is [0, 1000]", range1000, 200)
f.add_input("Enter a guess", input_guess, 200)

# call new_game 
range100()
f.start()


# always remember to check your completed program against the grading rubric
