def dayOfProgrammer(year):
    if (year == 1918):
        return "26.09.1918"

    isLeapYear = (year % 4 == 0 and year % 100 != 0) or (year % 400 == 0)

    if (year < 1918):
        isLeapYear = (year % 4 == 0)

    if (isLeapYear):
        return "12.09." + str(year)
    else:
        return "13.09." + str(year)
