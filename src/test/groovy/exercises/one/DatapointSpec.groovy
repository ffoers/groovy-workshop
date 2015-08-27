package exercises.one

import exercises.one.Datapoint
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Specification for the Datapoint data type
 * It should have three properties x and y, both of which are of type BigInteger
 * Furthermore, it should
 * - have a meaningful toString method
 * - have a meaningful equals method
 * - have a meaningful hashCode method
 * - be immutable
 * - Be statically typed
 * - should evaluate to false if x and y are 0, true otherwise
 */
class DatapointSpec extends Specification {

    def 'should have a default constructor which defaults x and y to 0'() {
        expect:
        new Datapoint().y == 0
        new Datapoint().x == 0
    }

    def 'should have an explicit constructor which sets x and y'() {
        given:
        Datapoint datapoint = new Datapoint(new BigInteger(24), 29572856092)
        expect:
        datapoint.x == 24
        datapoint.y == 29572856092
    }

    def 'should have a meaningful toString method'() {
        expect:
        new Datapoint(3, 3).toString() == 'exercises.one.Datapoint(3, 3)'
    }

    def 'should have a meaningful equals method'() {
        expect:
        new Datapoint(1, 1) == new Datapoint(1, 1)
    }

    def 'should have a meaningful hashCode method'() {
        expect:
        new Datapoint(2, 8).hashCode() == new Datapoint(2, 8).hashCode()
    }

    @Unroll
    def 'should not be possible to mutate x or y'() {
        given:
        Datapoint datapoint = new Datapoint()

        when:
        datapoint.invokeMethod(method, 2)
        datapoint.y = 3

        then:
        thrown(MissingMethodException)

        where:
        method << ['setX', 'setY']
    }

    def 'new Datapoint(0,0) should be treated as false'() {
        expect:
        !new Datapoint(0, 0)
    }

    @Unroll
    def 'any Datapoint which does not equal new Datapoint(0,0) should be treated as true'() {
        expect:
        new Datapoint(x, y)

        where:
        x << [1, 83, 9270952, -26685926]
        y << [389285628, 0, 286236, -286538]
    }
}
