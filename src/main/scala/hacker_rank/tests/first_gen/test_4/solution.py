# index of first element that is smaller than next one
def first_increasing_index(a):
    size = len(a)
    if size == 1:
        return -1

    for i in range(1, size):
        # print("%s. %s < %s == %s" % (i-1, a[i-1], a[i], a[i-1] < a[i]))
        if a[i-1] < a[i]:
            return i-1

    return -1


# noinspection PyPep8Naming
def maxDifference(a):
    i = first_increasing_index(a)
    if i < 0:
        return -1

    min_x = a[0]  # best x for all nex maxes
    max_x = a[1]  # best x for all prev mins
    last_result = max_x - min_x
    best_result = last_result

    for x in a:
        if x > max_x:
            max_x = x
            best_result = max(best_result, max_x - min_x)
        elif x < min_x:
            min_x = x
            max_x = x

    return best_result
