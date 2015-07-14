val list = List(1, 2, 3, 4, 5)

// flapMap() for nested data structures
def nestedData(y: Int): List[Int] = List(y, y * y, y * y * y)

//list.map(nestedData(_))
list.flatMap(nestedData(_)) // list.map(nestedData(_)).flatten