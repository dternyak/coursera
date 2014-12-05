# Poker winnings from Monday to Friday
poker_vector = c(140,-50,20,-120,240)

# Roulette winnings from Monday to Friday
roulette_vector = c(-24,-50,100,-350,10)

# Create the variable days_vector that contains "Monday","Tuesday","Wednesday","Thursday","Friday"
days_vector =  c("Monday", "Tuesday", "Wednesday", "Thursday", "Friday")

#Assign the names of the day to the roulette and poker_vectors
names(poker_vector) =  days_vector
names(roulette_vector) = days_vector
