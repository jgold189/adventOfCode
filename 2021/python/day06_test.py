from day06 import solve

def test_solve():
    input = [3,4,3,1,2]
    assert solve(input, 18) == 26
    assert solve(input, 80) == 5934
    assert solve(input, 256) == 26984457539