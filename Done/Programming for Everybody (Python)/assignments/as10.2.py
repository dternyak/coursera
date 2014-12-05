# 10.2 Write a program to read through the mbox-short.txt and figure out the distribution by hour of the day for each of the messages. 
# You can pull the hour out from the 'From ' line by finding the time and then splitting the string a second time using a colon.
# From stephen.marquard@uct.ac.za Sat Jan  5 09:14:16 2008
# Once you have accumulated the counts for each hour, print out the counts, sorted by hour as shown below. 
# Note that the autograder does not have support for the sorted() function.


name = raw_input("Enter file:")
if len(name) < 1 : name = "mbox-short.txt"
fh = open(name)

dic = dict()
i = 0
words =list()

for line in fh:
    if not line.rstrip().startswith("From "):
		continue
    line = line.rstrip()
    words = line.split()
    
    for word in words:
        if ':' in word:
            date = word.split(':')
            if len(date) == 3:
                hour = date[0]
                dic[hour] = dic.get(hour,0)+1
                #print date


for k,v in sorted(dic.items()):
    print k, v


