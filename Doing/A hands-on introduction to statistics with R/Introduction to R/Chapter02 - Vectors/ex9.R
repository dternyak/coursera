# Poker winnings from Monday to Friday
poker_vector = c(140,-50,20,-120,240)
# Roulette winnings from Monday to Friday
roulette_vector = c(-24,-50,100,-350,10)

# Name poker and roulette
days_vector = c("Monday","Tuesday","Wednesday","Thursday","Friday")
names(roulette_vector) = days_vector
names(poker_vector) = days_vector

# Calculate total gains for poker and roulette
total_poker = sum(poker_vector)
total_roulette = sum(roulette_vector)

# Check if you realized higher total gains in poker than in roulette 
answer = total_poker > total_roulette
