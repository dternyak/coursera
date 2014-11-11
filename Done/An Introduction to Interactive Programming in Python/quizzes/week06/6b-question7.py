#6b
def cenas():
    n =1000
    results = []
    numbers = range(2, n ,1)
    while numbers != []:
        results.append(numbers[0])
        numbers = [n for n in numbers if n % numbers[0] != 0]
        print results
    print len(results)

cenas()



