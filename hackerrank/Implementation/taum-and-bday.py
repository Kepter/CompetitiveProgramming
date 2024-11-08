def taumBday(b, w, bc, wc, z):
    mw = min(wc, bc + z)
    mb = min(bc, wc + z)

    return mw * w + mb * b
