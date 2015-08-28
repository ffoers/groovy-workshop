import groovy.json.JsonSlurper
import groovy.transform.Immutable
import static groovy.json.JsonOutput.toJson
//pretty easy to handle JSON in groovy:

@Immutable
class SomeData{
    int x
    String y
    Map<String, String> translations
    SomeData otherData
}

SomeData someData = new SomeData(
        x: 3,
        y:'Hello World!',
        translations: ['de': 'Hallo Welt!', 'en': 'Hello World'],
        otherData: new SomeData()
)

println toJson(someData)



println new JsonSlurper().parseText(toJson(someData))