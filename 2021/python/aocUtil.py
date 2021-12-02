def getInputs(dayString):
    fin = open("inputs/{}.txt".format(dayString), "r")
    data = [x.strip() for x in fin.readlines()]
    fin.close()
    return data

def getIntInputs(dayString):
    return [int(x) for x in getInputs(dayString)]