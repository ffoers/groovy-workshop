try {
    assert true == false
}catch(Throwable a ){
    assert a.getClass() == org.codehaus.groovy.runtime.powerassert.PowerAssertionError
}