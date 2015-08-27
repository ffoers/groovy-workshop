// this exercise tests your knowledge of collections

//TODO: replace null with groovy collection code so that the assertions work
def x = null
assert x == new ArrayList<String>().with { list ->
    list.add('c')
    list.add('a')
    list
}

def y = null
assert y == new HashMap<String, Integer>().with { Map<String, Integer> map -> map.put('x', 1); map }

def z = null
assert z.d == 7

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// collection methods
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

List<Integer> list = [3, 6, 38, 66]

//TODO sum all up
assert 113 == null

//TODO: check if all items are positive
assert true == null

//TODO: find all even items
assert [6, 38, 66] == null

//TODO: print all items

//TODO: increment all items by 3
assert [6, 9, 41, 69] == null

//TODO: find out if any item is greater than 50
assert false