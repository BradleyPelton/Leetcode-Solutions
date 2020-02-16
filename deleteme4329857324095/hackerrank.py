text = "X-DSPAM-Confidence:    0.8475"

mylist = text.split(" ")
try:
    for word in mylist:
        print(float(word))
    except:
        pass