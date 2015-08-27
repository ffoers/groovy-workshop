package exercises.three

import exercises.one.Datapoint
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

class JavaLike2Spec extends Specification {

    @Subject
    JavaLike2 javaLike2 = new JavaLike2()

    List dataSet = [[85837, 32], [9382, 17], [286261, 2625], [82537, 6], [7, 9], [-27236, 282619], [198326519883, 2], [7, 2], [-1, 653], [1, 1], [2, 86], [635, 3], [3637, 3], [3233, 35252], [215, 72835]]

    def setup() {
        dataSet.each {
            javaLike2.add(new Datapoint(it[0], it[1]))
        }
    }

    def 'allBetween should return empty list if boundaries are wrong'() {
        expect:
        javaLike2.allBetween(3, 2) == []
    }

    @Unroll
    def 'allBetween should return correct list if boundaries are correctly set'() {
        expect:
        javaLike2.allBetween(x, y) == result

        where:
        x     | y     | result
        1     | 10    | [new Datapoint(7, 9), new Datapoint(7, 2), new Datapoint(2, 86)]
        80000 | 90000 | [new Datapoint(85837, 32), new Datapoint(82537, 6)]
    }


    @Unroll
    def 'areAllGreaterThan should return correct result'() {
        expect:
        javaLike2.areAllGreaterThan(value) == result

        where:
        value | result
        10    | false
        0     | true
        1     | false
        -100  | true
    }

    def 'sum should return correct value'() {
        expect:
        javaLike2.sum() == 394145
    }

    def 'flipXandY should return correct result'(){
        given:
        JavaLike2 myJavaLike2 = new JavaLike2()
        dataSet.each{
            myJavaLike2.add(new Datapoint(it[1], it[0]))
        }

        when:
        javaLike2.flipXandY()

        then:
        javaLike2 == myJavaLike2
    }

    def 'split should return correct result'(){
        expect:
        javaLike2.split()==[x:[85837, 9382, 286261, 82537, 7, -27236, 198326519883, 7, -1, 1, 2, 635, 3637, 3233, 215], y:[32, 17, 2625, 6, 9, 282619, 2, 2, 653, 1, 86, 3, 3, 35252, 72835]]
    }
}
