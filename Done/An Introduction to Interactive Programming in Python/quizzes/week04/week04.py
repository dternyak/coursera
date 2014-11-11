import math

my_list = ["This", "course", "is", "great"]

# Question 3
print my_list[1:3]

# Question 4
print my_list[: len(my_list) // 2]
print my_list[len(my_list) // 2 :]
print my_list[0 : len(my_list) // 2]
print my_list[len(my_list) // 2 : len(my_list)]

# Question 5
p0 = [4, 7]
p1 = [2, 9]
print math.sqrt((p0[0] - p1[0])**2 + (p0[1] - p1[1])**2) - 2

# Quiz b
# Question 3
point = [0, 0]

def function1():
    point[0] += 1
    point[1] += 2

def function2():
    point = [50, 50]
function1(); print point
function2(); print point
function1(); print point
function2(); print point

a = range(5)

def mutate(b):
    b[3] = 100

mutate(a)
print a[3]

position = [50, 50]
delta = [1, -2]
position = position + delta
print position

a = ["green", "blue", "white", "black"]
b = a
c = list(a)
d = c
a[3] = "red"
c[2] = a[1]
b = a[1 : 3]
b[1] = c[2]
print a, b, c, d