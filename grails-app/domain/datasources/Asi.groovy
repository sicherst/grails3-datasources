package datasources

class Asi {

  static mapping = {
    datasource 'asi'
    table 'my_view'
    asiName column: 'asi_name'
    asiCode column: 'asi_code'
  }

  String asiCode
  String asiName

  static constraints = {
    asiName nullable: true
    asiCode nullable: true
  }
}
