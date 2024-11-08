def permutationEquation(p):
    s = []

    for i in range(len(p)):
        s.append(-1)

    for i in range(len(p)):
        s[p[p[i] - 1] - 1] = i + 1

    return s
