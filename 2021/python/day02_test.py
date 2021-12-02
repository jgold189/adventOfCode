from day02 import solve

def test_solve():
    data = ["forward 5","down 5","forward 8","up 3","down 8","forward 2"]
    assert solve(data) == 900