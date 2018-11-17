# groovy-transform-method-to-closure
Method to closure transformation.

_Reference_: http://docs.groovy-lang.org/latest/html/documentation/#method-pointer-operator

# preface
`.&` is a method pointer operator

The method pointer operator `(.&)` call be used to 
store a reference to a method in a variable.

The type of such a method pointer is a `groovy.lang.Closure`, 
so it can be used in any place a closure would be used.
 
In particular, it is suitable to convert an existing method 
for the needs of the strategy pattern.

It is also valuable if we want to transform an existing method
to memoized closure. For memoization please refer my other
github project: https://github.com/mtumilowicz/groovy-memoization

# project description
We provide examples in `Transformation` class for mentioned above features:

* strategy pattern - sorting
    ```
    given:
    def list = [1, 8, 2, 9, 10, 3, 5]
    def reverse = Comparators.&reverse
    
    when:
    list.sort reverse
    
    then:
    list == [10, 9, 8, 5, 3, 2, 1]    
    ```
* strategy pattern - injecting + currying
    ```
    given:
    def joinWithComma = String.&join.curry(",")
    
    def list = ["a", "b", "c"]
    
    list.inject joinWithComma
    
    expect:
    "a,b,c" == list.inject(joinWithComma)
    ```
* locally memoize function
    ```
    given:
    def memoizedFunction = Transformation.&function.memoize()
    
    expect:
    memoizedFunction() == memoizedFunction()
    ```
    where:
    ```
    static int function() {
        return Math.random().next()
    }    
    ```