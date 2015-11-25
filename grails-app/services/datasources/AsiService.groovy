package datasources

import grails.transaction.Transactional

@Transactional
class AsiService {

    static datasource = 'asi'
    def dataSource = 'asi'
    def asi

    def serviceMethod() {

        return dataSource.getConnection().getMetaData().URL

    }
}
