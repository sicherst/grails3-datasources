package datasources


import grails.test.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

@Integration
@Rollback
class MultipleDataSourceSpec extends Specification {

  void "Test multiple data sources"() {
    when: 
      new Audience(name: "Something").save(flush: true)
      new Asi(asiCode:"foo", asiName:"bar").save(flush:true)
      def asi = Asi.get(1)
      def url = Asi.withSession { session ->
      		session.connection()
      					.metaData
      					.URL
      					
      }
    then:
      Audience.count() == 1
      asi != null
      url == "jdbc:h2:asiDb"
  }
}
