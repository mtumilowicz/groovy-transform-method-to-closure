package comparator

/**
 * Created by mtumilowicz on 2018-11-17.
 */
class Comparators {
    static int reverse(int y, int x) {
        return (x < y) ? -1 : ((x == y) ? 0 : 1)
    }
}
