# 9.4 Write a program to read through the mbox-short.txt and figure out who has the sent the greatest number of mail messages. 
# The program looks for 'From ' lines and takes the second word of those lines as the person who sent the mail. 
# The program creates a Python dictionary that maps the sender's mail address to a count of the number of times they appear in the file. 
# After the dictionary is produced, the program reads through the dictionary using a maximum loop to find the most prolific committer.

name = raw_input("Enter file:")
if len(name) < 1 : name = "mbox-short.txt"
handle = open(name)
text = handle.read()
words = text.split()

dic = dict()
i = 0
for word in words:
    i=i+1
    if word.startswith("From:"):
        dic[words[i]] = dic.get(words[i],0)+1
        
#print dic.items()

bigcount = None
email = None
for key,value in dic.items():
    if bigcount==None or bigcount<value:
        bigcount = value
        email = key

print email, bigcount