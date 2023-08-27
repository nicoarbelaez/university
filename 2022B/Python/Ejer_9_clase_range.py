# range(start, stop, step)
for i in range(2, 100):
    primo = 1
    for j in range (2, i):
        if i % j == 0:
            primo = 0
    if primo:
        print(i, end=" ")