package singletonpattern.source

class DatabaseClient {

    fun create(tableName:String, data: Map<String, Any>): Int {
        return 0
    }

    fun read(tableName:String, conditions: Map<String, Any>): Int {
        return 0
    }

    fun update(tableName:String, data: Map<String, Any>, conditions: Map<String, Any>): Int {
        return 0
    }

    fun delete(tableName:String, conditions: Map<String, Any>): Int {
        return 0
    }

    companion object {
        var mInstance: DatabaseClient? = null
        fun getInstance(): DatabaseClient {
            if (mInstance == null) {
                mInstance = DatabaseClient()
            }
            return mInstance!!
        }
    }
}