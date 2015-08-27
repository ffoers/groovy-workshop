package exercises.one

import spock.lang.Specification
import spock.lang.Unroll

class JavaLikeSpec extends Specification {
    def 'should have expected values if initialized with non-null string'() {
        when:
        JavaLike javaLike = new JavaLike('some string')

        then:
        javaLike.identifier == 'some string'
        javaLike.identifierLength == null
        javaLike == new JavaLike('some string')
        javaLike.hashCode() == 305659619
    }

    def 'should have expected values if initialized with null string'() {
        when:
        JavaLike javaLike = new JavaLike(null)

        then:
        javaLike.identifier == null
        javaLike.identifierLength == null
        javaLike == new JavaLike(null)
        javaLike.hashCode() == 0
    }

    def 'should have expected values if identifier is set to non-null string'() {
        given:
        JavaLike javaLike = new JavaLike(null)

        when:
        javaLike.identifier = 'another string'

        then:
        javaLike.identifier == 'another string'
        javaLike.identifierLength == 14
        javaLike != new JavaLike('another string')
        javaLike == new JavaLike(null).with { it.setIdentifier('another string'); it }
        javaLike.hashCode() == 1897304576
    }

    def 'should have expected values if identifier is set to non-null string and then to null-string'() {
        given:
        JavaLike javaLike = new JavaLike(null)

        when:
        javaLike.identifier = 'another string'
        javaLike.identifier = null

        then:
        then:
        javaLike.identifier == null
        javaLike.identifierLength == null
        javaLike == new JavaLike(null)
        javaLike.hashCode() == 0
    }

    @Unroll
    def 'should output the correct string on call to analyze'() {
        given:
        JavaLike javaLike = new JavaLike(initParam)

        expect:
        javaLike.analyze(input) == result

        where:
        initParam   | input          | result
        null        | null           | 'identifier: null \nlength: 0 hash: 0'
        'some text' | null           | 'identifier: some text \nlength: 0 hash: 0'
        null        | 'another text' | 'identifier: null \nlength: 12 hash: -700442582'
        'more'      | 'text'         | 'identifier: more \nlength: 4 hash: 3556653'
    }
}
