import comparator.Comparators
import spock.lang.Specification

/**
 * Created by mtumilowicz on 2018-11-17.
 */
class Transformation extends Specification {

    def "strategy pattern - sorting"() {
        given:
        def list = [1, 8, 2, 9, 10, 3, 5]
        def reverse = Comparators.&reverse

        when:
        list.sort reverse

        then:
        list == [10, 9, 8, 5, 3, 2, 1]
    }

    def "strategy pattern - injecting + currying"() {
        given:
        def joinWithComma = String.&join.curry(",")

        def list = ["a", "b", "c"]

        list.inject joinWithComma

        expect:
        "a,b,c" == list.inject(joinWithComma)
    }

    def "locally memoize function"() {
        given:
        def memoizedFunction = Transformation.&function.memoize()
        
        expect:
        memoizedFunction() == memoizedFunction()
    }

    static int function() {
        return Math.random().next()
    }
}