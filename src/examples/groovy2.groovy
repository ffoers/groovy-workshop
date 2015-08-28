
////////////////////////////////////////////////////////////////////////////////////////////////
// Closures
////////////////////////////////////////////////////////////////////////////////////////////////
assert { 2 + 2 }() == 4

assert { it + 1 }(2) == 3

assert { String aString -> aString.length() }('Hello World!') == 12

////////////////////////////////////////////////////////////
def executor1(Closure closure) {
    closure()
}

assert executor1({ 3 }) == 3
////////////////////////////////////////////////////////////
def executor2(Closure closure) {
    closure(1)
}

assert executor2 { it + it } == 2
////////////////////////////////////////////////////////////
def executor3(int i, Closure closure) {
    closure(i)
}

assert executor3(1) { it++ }
////////////////////////////////////////////////////////////

Closure incrementor(int by) {
    return { it + by }
}

Closure byOne = incrementor(1)
assert byOne(5) == 6
assert incrementor(1)(3)
//TODO: MORE

////////////////////////////////////////////////////////////

Closure helloWorldContains = 'Hello World!'.&contains
assert helloWorldContains('H')
assert !helloWorldContains('y')

////////////////////////////////////////////////////////////////////////////////////////////////
// Collection Magic
////////////////////////////////////////////////////////////////////////////////////////////////


assert [2, 3].reverse() == [3, 2]
assert [3, 6, 1].sort() == [1, 3, 6]
assert [1, 2].any { it == 2 }
assert [1, 2].any { it == 3 } == false
assert [2, 8, 4].collect { it + 3 } == [5, 11, 7]
assert [3, 1, 8].tail() == [1, 8]
assert [2, 3].permutations() == [[3, 2], [2, 3]] as Set
assert [2, 3, 4, 5, 6].find { it % 2 == 0 } == 2
assert [2, 3, 4, 5, 6].findAll { it % 2 == 0 } == [2, 4, 6]

assert [2, 3, 4].every { it > 2 } == false
assert [2, 3, 4].inject(5) { acc, val -> acc } == 5