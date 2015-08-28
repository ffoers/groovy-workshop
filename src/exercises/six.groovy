import groovy.transform.ToString

//Delegate Handling

@ToString
class Stuff {
    Integer integer

    def integer(Integer i) {
        this.integer = i
    }
}

Stuff bla(Closure dsl) {
    def p = new Stuff() {}
    def code = dsl.rehydrate(p, this, this)
    code.delegate = p
    code()
    return p
}

Stuff createStuff() {
    Stuff stuff = bla {
//        word 'k',
        integer 2
    }

    assert stuff.integer == 2
    stuff
}

println createStuff()

//TODO: Create a DSL that has sensible defaults but can configure a server with hostname, port, useTls

//dynamic
//def
// MOP