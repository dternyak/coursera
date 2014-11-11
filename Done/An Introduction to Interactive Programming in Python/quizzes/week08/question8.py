x = 1
count = set()
for i in range(1000):
    print x
    count.add(x)
    x = next(x)
    count.add(x)

print 'count: ', len(count)