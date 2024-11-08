def convert(l):
    if l == 'a':
        return 0

    if l == 'b':
        return 1

    if l == 'c':
        return 2

    if l == 'd':
        return 3

    if l == 'e':
        return 4

    if l == 'f':
        return 5

    if l == 'g':
        return 6

    if l == 'h':
        return 7

    if l == 'i':
        return 8

    if l == 'j':
        return 9

    if l == 'k':
        return 10

    if l == 'l':
        return 11

    if l == 'm':
        return 12

    if l == 'n':
        return 13

    if l == 'o':
        return 14

    if l == 'p':
        return 15

    if l == 'q':
        return 16

    if l == 'r':
        return 17

    if l == 's':
        return 18

    if l == 't':
        return 19

    if l == 'u':
        return 20

    if l == 'v':
        return 21

    if l == 'w':
        return 22

    if l == 'x':
        return 23

    if l == 'y':
        return 24

    if l == 'z':
        return 25

def designerPdfViewer(h, word):
    mh = 0

    for l in word:
        mh = max(mh, h[convert(l)])

    return mh * len(word)
