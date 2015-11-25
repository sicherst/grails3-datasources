package datasources


import grails.test.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

@Integration
@Rollback
class MultipleDataSourceSpec extends Specification {

  def asiService

  void "Test multiple data sources"() {
    when: 
      new Audience(name: "Something").save(flush: true)
      new Asi(asiCode:"foo", asiName:"bar").save(flush:true)
      def asi = Asi.all//get(1)
      def url = Asi.withSession { session ->
      		session.connection()
      					.metaData
      					.URL
      					
      }
      def assUrl = asiService.serviceMethod()
    then:
      Audience.count() == 1
      Asi.count() == 1
      assUrl == "jdbc:h2:asiDb"
      asi != null
      url == "jdbc:h2:asiDb"

  }
}
