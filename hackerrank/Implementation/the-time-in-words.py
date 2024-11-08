def convert(t):
    if t == 1:
        return "one"

    if t == 2:
        return "two"

    if t == 3:
        return "three"

    if t == 4:
        return "four"

    if t == 5:
        return "five"

    if t == 6:
        return "six"

    if t == 7:
        return "seven"

    if t == 8:
        return "eight"

    if t == 9:
        return "nine"

    if t == 10:
        return "ten"

    if t == 11:
        return "eleven"

    if t == 12:
        return "twelve"

    if t == 13:
        return "thirteen"

    if t == 14:
        return "fourteen"

    if t == 15:
        return "quarter"

    if t == 16:
        return "sixteen"

    if t == 17:
        return "seventeen"

    if t == 18:
        return "eighteen"

    if t == 19:
        return "nineteen"

    if t == 20:
        return "twenty"

    if t == 21:
        return "twenty one"

    if t == 22:
        return "twenty two"

    if t == 23:
        return "twenty three"

    if t == 24:
        return "twenty four"

    if t == 25:
        return "twenty five"

    if t == 26:
        return "twenty six"

    if t == 27:
        return "twenty seven"

    if t == 28:
        return "twenty eight"

    if t == 29:
        return "twenty nine"

    if t == 30:
        return "half"

def minutes(t):
    if t == 1:
        return " minute"

    if t != 15 and t != 30 and t != 45:
        return " minutes"

    return ""

def timeInWords(h, m):
    if m == 0:
        return convert(h) +" o' clock"

    if m <= 30:
        return convert(m) + minutes(m) + " past " + convert(h)

    if m > 30:
        return convert(30 - (m - 30)) + minutes(m) + " to " + convert((h+1)%12)
