def bonAppetit(bill, k, b):
    cost = 0

    for i in range(len(bill)):
        if (i == k):
            continue

        cost += bill[i]

    if int(cost / 2) != b:
        print(str(b - int(cost / 2)))
    else:
        print("Bon Appetit")
