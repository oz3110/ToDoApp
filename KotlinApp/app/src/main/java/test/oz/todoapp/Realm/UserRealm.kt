package test.oz.todoapp.Realm

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class UserRealm : RealmObject() {
    @PrimaryKey
    var id : Int = 0
    var userEmail : String = ""
    var rememberToken : String = ""
}